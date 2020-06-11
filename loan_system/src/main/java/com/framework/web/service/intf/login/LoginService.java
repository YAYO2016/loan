package com.framework.web.service.intf.login;

import com.framework.core.entity.SessionBean;

public interface LoginService {
	
	/**
	 * 获取人员session信息
	 */
	public SessionBean getSessionBean(String userId) ;
	
	
}
