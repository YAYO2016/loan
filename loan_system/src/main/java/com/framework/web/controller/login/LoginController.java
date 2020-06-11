package com.framework.web.controller.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.core.controller.BaseController;
import com.framework.core.entity.AjaxJson;
import com.framework.core.entity.SessionBean;
import com.framework.core.utils.Cache;
import com.framework.core.utils.CacheManager;
import com.framework.core.utils.CommonUtils;
import com.framework.core.utils.GlobalConst;
import com.framework.web.service.intf.login.LoginService;


/**
 * 登录
 * @author ljw
 *
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(LoginController.class);
	 
	@Resource
    private LoginService loginService;

	
	
	@RequestMapping("logout")
	@ResponseBody
	public AjaxJson logout(HttpServletRequest request) throws Exception {
		AjaxJson aj = new AjaxJson();
		try {
			CacheManager.clearOnly(request.getSession().getId());
			SessionBean sessionBean = (SessionBean)request.getSession().getAttribute(GlobalConst.SESSION_KEY);
			aj.setStatus(sessionBean.getLogin());
			request.getSession().setAttribute(GlobalConst.SESSION_KEY, null);
			request.getSession().invalidate();
		} catch (Exception e) {
			aj.setSuccess(false);
			logger.error(CommonUtils.getLogInfoTemp(e.getMessage()));
		}
		return aj;
	}
	
	/**
	 * 操作员登录
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson login(HttpServletRequest request) throws Exception {
		AjaxJson aj = new AjaxJson();
		String userId = request.getParameter("userId");
		Cache cache = CacheManager.getCacheInfo(userId);
		SessionBean session=null;
		if(cache==null){
			session= loginService.getSessionBean(userId);
			if(session==null){
				aj.setMsg("用户不存在！");
				aj.setSuccess(false);
			}else{
				cache = new Cache();
				session.setLogin("login");//登录方式
				session.setLocalAddr(request.getLocalAddr());
				session.setLocalPort(request.getLocalPort());
				session.setLocalName(request.getLocalName());
				cache.setSessionBean(session);
				CacheManager.putCache(userId, cache);  
				request.getSession().setAttribute(GlobalConst.SESSION_KEY, cache.getSessionBean());
				logger.info(CommonUtils.getLogInfoTemp("userId:"+userId+",login success..."));
			}
		}else{
			request.getSession().setAttribute(GlobalConst.SESSION_KEY, cache.getSessionBean());
		}
		return aj;
	}
	
	
    public static void getMaxSeqFromTxt(HttpServletRequest request) throws IOException {
		String temp = "";
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			// 文件路径
			String filepath= request.getSession().getServletContext().getRealPath(GlobalConst.HELP_DOCUMENT_PATH+"MaxSeq.txt");
			File file = new File(filepath);
			// 将文件读入输入流
			isr = new InputStreamReader(new FileInputStream(file),"utf-8");
			br = new BufferedReader(isr);
			
			// 读取第一行
			for (int j = 1; (temp = br.readLine()) != null; j++) {
				if(j == 1){
					CacheManager.put("seq", temp);
				}
			}
		} catch (IOException e1) {
			throw e1;
		} finally {
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
		}
	}

	/**
	 * 获得用户远程地址
	 * Description:
	 * @param request
	 * @return
	 * @author: fandecai
	 * @date: 2016-5-10
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        
        if (remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) {
        	remoteAddr = request.getRemoteAddr();
			if (remoteAddr.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					logger.error(CommonUtils.getLogInfoTemp(e.getMessage()));
				}
				remoteAddr = inet.getHostAddress();
			}
		}
		
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (remoteAddr != null && remoteAddr.length() > 15) { // "***.***.***.***".length()
			if (remoteAddr.indexOf(",") > 0) {
				remoteAddr = remoteAddr.substring(0, remoteAddr.indexOf(","));
			}
		}
        if("0:0:0:0:0:0:0:1".equals(remoteAddr)){
        	remoteAddr = "127.0.0.1";
		}
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

}
