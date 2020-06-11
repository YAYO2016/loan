package com.loan.service.service;

import java.util.List;
import java.util.Map;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.model.dto.UserInfoDto;


public interface DataAnalysisService  {
	
	List<Map<String, Object>>  getCompanyDay(Map<String, Object> params);
	
	
	List<Map<String, Object>>  getCompanyMonth(Map<String, Object> params);
	

	List<Map<String, Object>>  getcaseNumByType(Map<String, Object> params);
	
	List<Map<String, Object>>  getcaseNumByCaseType(Map<String, Object> params);
	
	List<Map<String, Object>>  getcaseNumByOrgId(Map<String, Object> params);
	
	List<Map<String, Object>>  getCompanyCount(Map<String, Object> params);
	
	List<Map<String, Object>>  orgInfo(Map<String, Object> params);
	
	List<Map<String, Object>>  orgInfoByOrgId(Map<String, Object> params);

	LoanPageList<Map<String, Object>> getUserPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

	List<Map<String, Object>>  getCompanyInfoByOrgId(Map<String, Object> params);
	
	List<Map<String, Object>>  getUserCaseNumByOrgId(Map<String, Object> params);
	
	List<Map<String, Object>>  getUserInfoByOrgId(Map<String, Object> params); 
	
}
