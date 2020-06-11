package com.framework.web.service.intf.systemManage;

import java.util.List;
import java.util.Map;


/**
 * 公共
 * @author ljw
 *
 */
public interface CommService {
	/**
	 * 获取序列
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public  Map<String, Object> getSeq(Map<String, Object> args) throws Exception;
	/**
	 * 查询字典表
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String, Object>>  queryList(Map<String, Object> queryMap) throws Exception;
	
}
