package com.framework.web.service.impl.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.core.entity.SessionBean;
import com.framework.mybatis.mysql.commapper.UserInfoMapper;
import com.framework.web.service.intf.login.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	private final static Logger logger = Logger.getLogger(LoginServiceImpl.class);
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/**
	 * 获取人员session信息
	 */
	public SessionBean getSessionBean(String userId) {
		List<Map<String, Object>> selectUserInfo = userInfoMapper.selectUserInfo(userId);
		SessionBean sb = new SessionBean();
		Map<String, Object> mm = null;
		Map<String,String> roleMap = new HashMap<String, String>();
		for (int i = 0; i < selectUserInfo.size(); i++) {
			mm = selectUserInfo.get(i);
			logger.info("menuId::"+String.valueOf(mm.get("menuId")));
			if(i == 0){
				sb.setUserId(String.valueOf(mm.get("userId")));
				sb.setUserName(String.valueOf(mm.get("userName")));
				sb.setOrgId(String.valueOf(mm.get("orgId")));
			}
			roleMap.put(String.valueOf(mm.get("menuId")), null);
		}
		sb.setRoleMap(roleMap);
		return sb;
	}

}
