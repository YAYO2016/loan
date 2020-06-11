package com.framework.web.service.impl.systemManage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.mybatis.mysql.mapper.CfgDictValueMapper;
import com.framework.mybatis.mysql.mapper.SequenceMapper;
import com.framework.web.service.intf.systemManage.CommService;


@Service("commService")
public class CommServiceImpl implements CommService {
	
	@Autowired
	private  SequenceMapper sequenceMapper;
	
	@Autowired
	private CfgDictValueMapper cfgDictValueMapper;
	
	@Override
	public Map<String, Object> getSeq(Map<String, Object> args)
			throws Exception {
		return sequenceMapper.querySeq(args);
	}
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		
		return cfgDictValueMapper.queryList(queryMap);
	}

}
