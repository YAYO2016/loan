package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.BankInfo;

/**
 * @author GuoKang
 * @date 2019/4/23 12:57
 */
public interface BankInfoService extends LoanService<BankInfo> {
    BankInfo getBankInfoByBankId(String bankId);
}
