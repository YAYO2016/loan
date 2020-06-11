package com.framework.web.service.impl.systemManage;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.mybatis.mysql.mapper.CfgUserMapper;
import com.framework.mybatis.mysql.pojo.CfgUser;
import com.framework.web.service.intf.systemManage.CfgUserService;

@Service("cfgUserService")
public class CfgUserServiceImpl implements CfgUserService{

	@Autowired
	private  CfgUserMapper  cfgUserMapper;
	
	@Override
	public void doSaveCfgUser(CfgUser record) throws Exception {
		cfgUserMapper.insert(record);
	}

	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		
		return cfgUserMapper.queryUserList(queryMap);
	}

}
