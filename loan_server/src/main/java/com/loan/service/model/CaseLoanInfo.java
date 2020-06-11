package com.loan.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.LoanSubType;
import com.loan.service.enums.LoanType;
import com.loan.service.enums.RepaymentType;

import java.io.Serializable;
import java.util.Date;

/**
 * 案子贷款信息
 *
 * @author GuoKang
 * @date 2019-05-06 21:42
 */
public class CaseLoanInfo extends AbsPojoSetPk implements Serializable {
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
    private String loanBankBranch; // 贷款审批银行支行信息
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间
    private String channelName; // 品牌名称
    
    public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

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

    public String getLoanBankBranch() {
        return loanBankBranch;
    }

    public void setLoanBankBranch(String loanBankBranch) {
        this.loanBankBranch = loanBankBranch;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public void setPk(Long pk) {
        setCaseId(pk);
    }
}
