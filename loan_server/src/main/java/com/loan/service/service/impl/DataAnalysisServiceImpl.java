package com.loan.service.service.impl;

import java.util.List;
import java.util.Map;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.dao.DataAnalysisDao;
import com.loan.service.model.dto.UserInfoDto;
import com.loan.service.service.DataAnalysisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataAnalysisServiceImpl  implements DataAnalysisService {

	@Autowired
	private DataAnalysisDao dataAnalysisDao;
	
	@Override
	public List<Map<String, Object>> getCompanyDay(Map<String, Object> params) {
		return dataAnalysisDao.getCompanyDay(params);
	}
	
	@Override
	public List<Map<String, Object>> getCompanyMonth(Map<String, Object> params) {
		return dataAnalysisDao.getCompanyMonth(params);
	}

	@Override
	public List<Map<String, Object>> getcaseNumByType(Map<String, Object> params) {
		return dataAnalysisDao.getcaseNumByType(params);
	}

	@Override
	public List<Map<String, Object>> getcaseNumByCaseType(
			Map<String, Object> params) {
		return dataAnalysisDao.getcaseNumByCaseType(params);
	}

	@Override
	public List<Map<String, Object>> getcaseNumByOrgId(
			Map<String, Object> params) {
		return dataAnalysisDao.getcaseNumByOrgId(params);
	}

	@Override
	public List<Map<String, Object>> getCompanyCount(Map<String, Object> params) {
		return dataAnalysisDao.getCompanyCount(params);
	}

	@Override
	public List<Map<String, Object>> orgInfo(Map<String, Object> params) {
		return dataAnalysisDao.orgInfo(params);
	}
	
	@Override
	public List<Map<String, Object>> orgInfoByOrgId(Map<String, Object> params) {
		return dataAnalysisDao.orgInfoByOrgId(params);
	}

	@Override
	public LoanPageList<Map<String, Object>> getUserPageList(
			Map<String, Object> params, LoanPageAttribute pageAttr) {
		if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
		params.put("pageSize", pageAttr.getPageSize());
	    params.put("offSet", pageAttr.getBegin());
	    int count = this.dataAnalysisDao.countUserPage(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<Map<String, Object>> list = dataAnalysisDao.listUserPage(params);
		
		
		return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
	}

	@Override
	public List<Map<String, Object>> getCompanyInfoByOrgId(
			Map<String, Object> params) {
		return dataAnalysisDao.getCompanyInfoByOrgId(params);
	}

	@Override
	public List<Map<String, Object>> getUserCaseNumByOrgId(
			Map<String, Object> params) {

		return dataAnalysisDao.getUserCaseNumByOrgId(params);
	}

	@Override
	public List<Map<String, Object>> getUserInfoByOrgId(
			Map<String, Object> params) {
		return dataAnalysisDao.getUserInfoByOrgId(params);
	}
}
