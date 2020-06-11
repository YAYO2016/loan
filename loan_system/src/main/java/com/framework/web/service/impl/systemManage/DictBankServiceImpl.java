package com.framework.web.service.impl.systemManage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.framework.mybatis.mysql.mapper.DictBankMapper;
import com.framework.mybatis.mysql.pojo.DictBank;
import com.framework.web.service.intf.systemManage.DictBankService;

@Service("dictBankService")
public class DictBankServiceImpl implements DictBankService{

	@Autowired
	private DictBankMapper dictBankMapper;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> queryMap)
			throws Exception {
		
		return dictBankMapper.queryList(queryMap);
	}

	@Override
	public void doSaveDictBank(DictBank record) throws Exception {
		
		dictBankMapper.insert(record);
	}

}
