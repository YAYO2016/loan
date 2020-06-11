package com.framework.web.service.impl.systemManage;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.mybatis.mysql.mapper.DictSysFuncMapper;
import com.framework.web.service.intf.systemManage.DictSysFuncService;

@Service("dictSysFuncService")
public class DictSysFuncServiceImpl implements DictSysFuncService {
	 @Autowired
	 private DictSysFuncMapper dictSysFuncMapper;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		return dictSysFuncMapper.queryList(queryMap);
	}
	
}
