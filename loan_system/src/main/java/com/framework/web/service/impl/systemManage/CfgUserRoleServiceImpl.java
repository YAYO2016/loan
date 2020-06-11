package com.framework.web.service.impl.systemManage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.mybatis.mysql.mapper.CfgUserRoleMapper;
import com.framework.mybatis.mysql.pojo.CfgUserRole;
import com.framework.web.service.intf.systemManage.CfgUserRoleService;


@Service("cfgUserRoleService")
public class CfgUserRoleServiceImpl  implements CfgUserRoleService {

	@Autowired
	private CfgUserRoleMapper cfgUserRoleMapper;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		return cfgUserRoleMapper.queryList(queryMap);
	}

	@Override
	public void doSaveCfgUserRole(CfgUserRole record) throws Exception {
		cfgUserRoleMapper.insert(record);
	}
	
	
	
}
