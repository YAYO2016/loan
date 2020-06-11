package com.framework.web.service.impl.systemManage;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.mybatis.mysql.mapper.DictAgencyMapper;
import com.framework.mybatis.mysql.pojo.DictAgency;
import com.framework.web.service.intf.systemManage.DictAgencyInfoService;


@Service("dictAgencyInfoService")
public class DictAgencyInfoServiceImpl implements DictAgencyInfoService {
	
	@Autowired
	private DictAgencyMapper DictAgencyMapper;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		return DictAgencyMapper.queryList(queryMap);
	}

	@Override
	public void doSaveDictAgencyInfo(DictAgency record) throws Exception {
		
		DictAgencyMapper.insert(record);
	}

	
	
	
	
}
