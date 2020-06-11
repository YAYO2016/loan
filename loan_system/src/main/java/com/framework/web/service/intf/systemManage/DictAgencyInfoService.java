package com.framework.web.service.intf.systemManage;
import java.util.List;
import java.util.Map;
import com.framework.mybatis.mysql.pojo.DictAgency;


public interface DictAgencyInfoService {
	/**
	 * 分页查询
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String, Object>>  queryList(Map<String, Object> queryMap) throws Exception;
	
	/**
	 * 保存修改的
	 * @param args
	 * @throws Exception
	 */
	public void  doSaveDictAgencyInfo(DictAgency record)throws Exception;
	
	
}
