package com.framework.web.service.intf.systemManage;
import java.util.List;
import java.util.Map;


public interface DictSysFuncService {
	
	/**
	 * 分页查询
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String, Object>>  queryList(Map<String, Object> queryMap) throws Exception;
	
}
