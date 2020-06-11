package com.framework.web.service.impl.systemManage;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.mybatis.mysql.mapper.CfgDictMapper;
import com.framework.mybatis.mysql.pojo.CfgDict;
import com.framework.mybatis.mysql.pojo.CfgUser;
import com.framework.web.service.intf.systemManage.CfgDictInfoService;

@Service("cfgDictInfoService")
public class CfgDictServiceImpl  implements CfgDictInfoService {

	@Autowired
	private CfgDictMapper  cfgDictMapper;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		return cfgDictMapper.queryList(queryMap);
	}

	@Override
	public void doSaveCfgDict(CfgDict record) throws Exception {
		cfgDictMapper.insert(record);
	}
	
}
