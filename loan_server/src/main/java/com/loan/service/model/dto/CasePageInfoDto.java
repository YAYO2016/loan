package com.loan.service.model.dto;

import com.loan.service.enums.CaseStatusDict;
import com.loan.service.enums.CaseSubType;
import com.loan.service.enums.CaseType;
import com.loan.service.enums.LoanType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/8/24 10:51
 */
public class CasePageInfoDto implements Serializable {
    private Long caseId; // 案子ID
    private Long createUser; // 签单人
    private String createUserName; // 签单人姓名
    private String mainCredit; // 主贷人姓名
    private String loanBank; // 贷款银行
    private CaseType caseType; // 案子大类
    private CaseSubType caseSubType; // 案子小类
    private LoanType loanType; // 贷款大类
    private Double reserveAmount; // 公积金贷款金额
    private Double commercialAmount; // 商业贷款金额
    private CaseStatusDict caseStatus; // 案子状态
    private Date createTime; // 创建时间
    private String channelName; //品牌名称

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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getMainCredit() {
        return mainCredit;
    }

    public void setMainCredit(String mainCredit) {
        this.mainCredit = mainCredit;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public CaseSubType getCaseSubType() {
        return caseSubType;
    }

    public void setCaseSubType(CaseSubType caseSubType) {
        this.caseSubType = caseSubType;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Double getReserveAmount() {
        return reserveAmount;
    }

    public void setReserveAmount(Double reserveAmount) {
        this.reserveAmount = reserveAmount;
    }

    public Double getCommercialAmount() {
        return commercialAmount;
    }

    public void setCommercialAmount(Double commercialAmount) {
        this.commercialAmount = commercialAmount;
    }

    public CaseStatusDict getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatusDict caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
