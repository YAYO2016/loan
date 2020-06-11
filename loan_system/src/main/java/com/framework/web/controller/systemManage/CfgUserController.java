package com.framework.web.controller.systemManage;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.core.entity.AjaxJson;
import com.framework.mybatis.mysql.pojo.CfgUser;
import com.framework.web.service.intf.systemManage.CfgUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 系统管理用户管理
 * @author lenovo
 *
 */
@Controller
@RequestMapping("cfgUser")
public class CfgUserController {

	@Resource
    private CfgUserService cfgUserService;
	/**
	 * 跳转页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cfgCustInfoIndex")
	public String cfgUserInedx(ModelMap model) throws Exception {
		return "systemmanager/cfgUserIndex";
	}
	
	
	/**
	 * 员工信息分页查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCfgUserList",method = RequestMethod.POST)
	@ResponseBody
	public Object getCfgUserList(HttpServletRequest request) throws Exception {
		//获取查询条件参数
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("userId", userId);
		queryMap.put("userName", userName);
		
		int pageNum = Integer.parseInt(request.getParameter("page")); //获取当前页码
	    int pageSize = Integer.parseInt(request.getParameter("rows")); //获取每页显示多少行
	    //分页查询
	    Page<Object> page=PageHelper.startPage(pageNum,pageSize,true);
	    List<Map<String,Object>> list=cfgUserService.queryList(queryMap);
	    Map<String, Object> returnMap=new HashMap<String, Object>();
	    returnMap.put("total", page.getTotal());
	    returnMap.put("rows", list);
        return returnMap;
	}
	

	/**
	 * 新增保存
	 * @param request
	 * @return
	 */
	@RequestMapping("doSaveCfgUser")
	@ResponseBody
	public AjaxJson  doSaveCfgUser(HttpServletRequest request ){
		AjaxJson json=new AjaxJson();
		String  user_id=request.getParameter("user_id");
		String  user_name=request.getParameter("user_name");
		String  user_pw=request.getParameter("user_pw");
		String  org_id=request.getParameter("org_id");
		String  innet_date=request.getParameter("innet_date");
		String  m_phone=request.getParameter("m_phone");
		String  l_phone=request.getParameter("l_phone");
		String  email_address=request.getParameter("email_address");
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		CfgUser record=new CfgUser();
		
		try {
			record.setEmailAddress(email_address);
			record.setInnetDate(sd.parse(innet_date));
			record.setlPhone(l_phone);
			record.setmPhone(m_phone);
			record.setOrgId(org_id);
			record.setUserId(user_id);
			record.setUserName(user_name);
			record.setUserPw(user_pw);
			cfgUserService.doSaveCfgUser(record);
			json.setSuccess(true);
			json.setMsg("保存成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("保存失败："+e.getMessage());
		}
		
		return json;
	}
	

}
