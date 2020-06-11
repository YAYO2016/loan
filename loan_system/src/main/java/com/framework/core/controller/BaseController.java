package com.framework.core.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.framework.core.entity.LogInfo;
import com.framework.core.entity.SessionBean;
import com.framework.core.entity.SplitPage;
import com.framework.core.utils.GlobalConst;

public abstract class BaseController {
	
	
	/**获取session信息**/
	public SessionBean getSessionBean() {
		return (SessionBean) getRequest().getSession().getAttribute(GlobalConst.SESSION_KEY);
    }
	/**获取当前操作人**/
	public String getUserId() {
		if(getSessionBean()!=null){
			return getSessionBean().getUserId();
		}
		return null;
	}
	/**获取当前操作人姓名**/
	public String getUserName() {
		if(getSessionBean()!=null){
			return getSessionBean().getUserName();
		}
		return null;
	}
	/**获取当前操作人所属地市**/
	public String getAreaId() {
		if(getSessionBean()!=null){
			return getSessionBean().getAreaId();
		}
		return null;
	}
	/**获取当前操作人所属组织机构**/
	public String getOrgId() {
		if(getSessionBean()!=null){
			return getSessionBean().getOrgId();
		}
		return null;
	}
	/**获取当前操作人手机号码**/
	public String getMsisdn() {
		if(getSessionBean()!=null){
			return getSessionBean().getMsisdn();
		}
		return null;
	}
	/**分页**/
	public SplitPage getSplitPage(){
		SplitPage splitPage = new SplitPage();
		String page = this.getRequest().getParameter("page");
		if(page==null){
			page = "1";
		}
		String rows = this.getRequest().getParameter("rows");
		if(rows==null||"NaN".equals(rows)){
			rows = String.valueOf(GlobalConst.NUMBERS_PER_PAGE);
		}
		splitPage.setOrderBy(this.getRequest().getParameter("sort"), this.getRequest().getParameter("order"));
		splitPage.setCurrentPage(Integer.parseInt(page));
		splitPage.setPageSize(Integer.parseInt(rows));
		splitPage.setStart((Integer.parseInt(page) - 1) * Integer.parseInt(rows));
		return splitPage;
	}
	/**日志**/
	public LogInfo getLogInfo() throws Exception {
        try {
        	LogInfo info = new LogInfo();
            info.setOperId(this.getUserId());
            info.setContentId(this.getRequest().getParameter("contentId"));
            return info;
        } catch (Exception e) {
            throw e;
        }
    }
	/**获取request**/
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**生产ID**/
	public String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**生产16位ID**/
	public String getUUID16Byte(){
		 int hashCodeV = UUID.randomUUID().toString().hashCode();
         if(hashCodeV < 0) {//有可能是负数
             hashCodeV = - hashCodeV;
         }
         // 0 代表前面补充0     
         // 4 代表长度为4     
         // d 代表参数为正数型
         return String.format("%016d", hashCodeV);
	}
	
	
	
}
