package com.loan.service.model.dto;

import com.loan.service.model.CaseLoanInfo;

/**
 * @author GuoKang
 * @date 2019-05-22 21:55
 */
public class CaseLoanInfoDto extends CaseLoanInfo {
    private LoanBranchDto loanBranch;

    public LoanBranchDto getLoanBranch() {
        return loanBranch;
    }

    public void setLoanBranch(LoanBranchDto loanBranch) {
        this.loanBranch = loanBranch;
    }
}
