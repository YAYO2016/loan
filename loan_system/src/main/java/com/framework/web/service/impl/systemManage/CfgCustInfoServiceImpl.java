package com.framework.web.service.impl.systemManage;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.mybatis.mysql.mapper.CfgCustInfoMapper;
import com.framework.mybatis.mysql.pojo.CfgCustInfo;
import com.framework.mybatis.mysql.pojo.DictBank;
import com.framework.web.service.intf.systemManage.CfgCustInfoService;


@Service("cfgCustInfoService")
public class CfgCustInfoServiceImpl implements CfgCustInfoService {

	@Autowired
	private  CfgCustInfoMapper cfgCustInfoMapper;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		return cfgCustInfoMapper.queryList(queryMap);
	}

	@Override
	public void doSaveCfgCustInfoManage(CfgCustInfo record) throws Exception {
		cfgCustInfoMapper.insert(record);
	}

	
}
