package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.enums.CaseCustomerType;
import com.loan.service.model.CaseCustInfo;
import com.loan.service.model.dto.CaseCustInfoDto;

/**
 * @author GuoKang
 * @date 2019-05-06 23:18
 */
public interface CaseCustInfoService extends LoanService<CaseCustInfo> {
    CaseCustInfoDto getCustInfoDtoByCaseCustomerType(Long caseId, CaseCustomerType type);

    void saveCaseCustInfo(CaseCustInfoDto caseCustInfoDto);
}
