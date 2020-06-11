package com.framework.web.service.intf.systemManage;

import java.util.List;
import java.util.Map;

import com.framework.mybatis.mysql.pojo.CfgCustInfo;


public interface CfgCustInfoService {

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
	public void  doSaveCfgCustInfoManage(CfgCustInfo record )throws Exception;
	
}
