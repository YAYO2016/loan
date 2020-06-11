package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.CaseBaseInfo;
import com.loan.service.model.dto.CaseBaseInfoDto;
import com.loan.service.model.dto.CasePageInfoDto;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-05-06 21:39
 */
public interface CaseBaseInfoService extends LoanService<CaseBaseInfo> {
    CaseBaseInfoDto getCaseBaseInfoDtoByCaseId(Long caseId);

    CaseBaseInfoDto saveCaseBaseInfoDto(Long userId, CaseBaseInfoDto caseBaseInfoDto);

    /**
     * 获取待办案子列表
     **/
    LoanPageList<CaseBaseInfoDto> getCaseBaseInfoDtoPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    /**
     * 获取全部案子列表
     **/
    LoanPageList<CasePageInfoDto> getAllCaseList(Map<String, Object> params, LoanPageAttribute pageAttr);
    /**
     * 删除案子
     * @param params
     */
    void delCase(Map<String, Object> params);
    
    
    List<Map<String, Object>>  getButtonList(Map<String, Object> params);

    List<String> getCaseStatus(String btnType);
    
    /**
     * 到处当前列表
     **/
    List<CasePageInfoDto>  getAllCaseList(Map<String, Object> params);
 }
