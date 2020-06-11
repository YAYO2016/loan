package com.framework.web.service.intf.systemManage;
import java.util.List;
import java.util.Map;

import com.framework.mybatis.mysql.pojo.CfgUserRole;


public interface CfgUserRoleService {
	/**
	 * 分页查询
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String, Object>>  queryList(Map<String, Object> queryMap) throws Exception;
	
	/**
	 * 保存新增的用户信息
	 * @param args
	 * @throws Exception
	 */
	public void  doSaveCfgUserRole(CfgUserRole record)throws Exception;
	
}
