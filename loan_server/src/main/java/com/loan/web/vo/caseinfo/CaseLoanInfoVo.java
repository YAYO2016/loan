package com.loan.web.vo.caseinfo;

import com.loan.service.enums.LoanSubType;
import com.loan.service.enums.LoanType;
import com.loan.service.enums.RepaymentType;

/**
 * @author GuoKang
 * @date 2019/5/7 15:54
 */
public class CaseLoanInfoVo {
    private Long caseId; // 案子ID
    private LoanType loanType; // 贷款类型
    private LoanSubType loanSubType; // 贷款小类
    private Double reserveAmount; // 公积金贷款金额
    private Integer reserveYear; // 公积金贷款年限
    private Double commercialAmount; // 商业贷款金额
    private Integer commercialYear; // 商业贷款年限
    private RepaymentType repaymentType; // 还款方式
    private String repaymentAccount; // 还款账号
    private String loanBank; // 贷款银行
    private Long loanBankBranch; // 贷款审批银行支行ID

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public LoanSubType getLoanSubType() {
        return loanSubType;
    }

    public void setLoanSubType(LoanSubType loanSubType) {
        this.loanSubType = loanSubType;
    }

    public Double getReserveAmount() {
        return reserveAmount;
    }

    public void setReserveAmount(Double reserveAmount) {
        this.reserveAmount = reserveAmount;
    }

    public Integer getReserveYear() {
        return reserveYear;
    }

    public void setReserveYear(Integer reserveYear) {
        this.reserveYear = reserveYear;
    }

    public Double getCommercialAmount() {
        return commercialAmount;
    }

    public void setCommercialAmount(Double commercialAmount) {
        this.commercialAmount = commercialAmount;
    }

    public Integer getCommercialYear() {
        return commercialYear;
    }

    public void setCommercialYear(Integer commercialYear) {
        this.commercialYear = commercialYear;
    }

    public RepaymentType getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(RepaymentType repaymentType) {
        this.repaymentType = repaymentType;
    }

    public String getRepaymentAccount() {
        return repaymentAccount;
    }

    public void setRepaymentAccount(String repaymentAccount) {
        this.repaymentAccount = repaymentAccount;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public Long getLoanBankBranch() {
        return loanBankBranch;
    }

    public void setLoanBankBranch(Long loanBankBranch) {
        this.loanBankBranch = loanBankBranch;
    }
}
