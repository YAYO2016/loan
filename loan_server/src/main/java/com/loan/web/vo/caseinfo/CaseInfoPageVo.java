package com.loan.web.vo.caseinfo;

import com.loan.service.enums.CaseStatusDict;
import com.loan.service.enums.CaseSubType;
import com.loan.service.enums.CaseType;
import com.loan.service.enums.LoanType;

import java.util.Date;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-17 23:03
 */
public class CaseInfoPageVo {
    private Long caseId; // 案子ID
    private String mainCredit; // 主贷人姓名
    private String createUserName; // 签单人姓名
    private String loanBank; // 贷款银行
    private CaseType caseType; // 案子大类
    private CaseSubType caseSubType; // 案子小类
    private LoanType loanType; // 贷款大类
    private String reserveAmount; // 公积金贷款金额
    private String commercialAmount; // 商业贷款金额
    private Integer lastedDate; // 持续时间
    private CaseStatusDict caseStatus; // 案子状态
    private String caseStatusLink; // 环节
    private String caseStatusDesc; // 状态
    private List operateTypes; // 按钮
    private Date createTime; // 创建时间
    private String channelName; //品牌名称
    
    public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

    public String getReserveAmount() {
        return reserveAmount;
    }

    public void setReserveAmount(String reserveAmount) {
        this.reserveAmount = reserveAmount;
    }

    public String getCommercialAmount() {
        return commercialAmount;
    }

    public void setCommercialAmount(String commercialAmount) {
        this.commercialAmount = commercialAmount;
    }

    public Integer getLastedDate() {
        return lastedDate;
    }

    public void setLastedDate(Integer lastedDate) {
        this.lastedDate = lastedDate;
    }

    public String getCaseStatusLink() {
        return caseStatusLink;
    }

    public void setCaseStatusLink(String caseStatusLink) {
        this.caseStatusLink = caseStatusLink;
    }

    public String getCaseStatusDesc() {
        return caseStatusDesc;
    }

    public void setCaseStatusDesc(String caseStatusDesc) {
        this.caseStatusDesc = caseStatusDesc;
    }

    public CaseStatusDict getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatusDict caseStatus) {
        this.caseStatus = caseStatus;
    }

    public List getOperateTypes() {
        return operateTypes;
    }

    public void setOperateTypes(List operateTypes) {
        this.operateTypes = operateTypes;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
}
