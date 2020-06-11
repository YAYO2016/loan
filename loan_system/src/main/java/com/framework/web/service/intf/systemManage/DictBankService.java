package com.framework.web.service.intf.systemManage;
import java.util.List;
import java.util.Map;

import com.framework.mybatis.mysql.pojo.DictBank;




public interface DictBankService {

	/**
	 * 分页查询
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String, Object>>  queryList(Map<String, Object> queryMap) throws Exception;
	
	
	/**
	 * 新增
	 * @param args
	 * @throws Exception
	 */
	public void  doSaveDictBank(DictBank record )throws Exception;
	
}
