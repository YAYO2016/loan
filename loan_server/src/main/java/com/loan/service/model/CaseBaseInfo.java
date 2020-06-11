package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 案子基本信息
 *
 * @author GuoKang
 * @date 2019-05-05 23:00
 */
public class CaseBaseInfo extends AbsPojoSetPk implements Serializable {
    private Long caseId; // 案子ID
    private CaseType caseType; // 案子大类
    private CaseSubType caseSubType; // 案子小类
    private ChannelType channelType; // 渠道类型（二手房特有）
    private LoanTerms loanTerms; // 放款条件（一手房特有）
    private ReformStatus isReform; // 是否整改
    private CaseStatusDict caseStatus; // 案子状态
    private Long createUser; // 创建人
    private Date createTime; // 创建时间
    private Short caseVersion; // 案子版本
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

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public LoanTerms getLoanTerms() {
        return loanTerms;
    }

    public void setLoanTerms(LoanTerms loanTerms) {
        this.loanTerms = loanTerms;
    }

    public ReformStatus getIsReform() {
        return isReform;
    }

    public void setIsReform(ReformStatus isReform) {
        this.isReform = isReform;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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

    public CaseStatusDict getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatusDict caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Short getCaseVersion() {
        return caseVersion;
    }

    public void setCaseVersion(Short caseVersion) {
        this.caseVersion = caseVersion;
    }

    @Override
    public void setPk(Long pk) {
        setCaseId(pk);
    }
}
