package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.enums.LoanType;
import com.loan.service.model.CaseLoanInfo;

/**
 * @author GuoKang
 * @date 2019-05-06 21:50
 */
public interface CaseLoanInfoService extends LoanService<CaseLoanInfo> {
    void saveCaseLoanInfo(CaseLoanInfo caseLoanInfo);

    void clearLoanAmountAndYearByType(Long caseId, LoanType loanType);
}
