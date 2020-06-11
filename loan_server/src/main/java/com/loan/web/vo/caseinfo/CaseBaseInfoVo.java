package com.loan.web.vo.caseinfo;

import com.loan.service.enums.*;
import com.loan.service.model.UserInfo;

/**
 * 案子基本信息
 *
 * @author GuoKang
 * @date 2019/5/6 11:21
 */
public class CaseBaseInfoVo {
    private Long caseId; // 案子ID
    private CaseType caseType; // 案子大类
    private CaseSubType caseSubType; // 案子小类
    private HouseProperty houseProperty; // 房产属性
    private PropertyRightsType propertyRightsType; // 产权类型
    private SuperviseType superviseType; // 监管类型
    private ChannelType channelType; // 来源渠道
    private LoanType loanType; // 贷款类型
    private LoanSubType loanSubType; // 贷款小类
    private MaritalStatus maritalStatus; // 买方婚姻状况
    private LoanTerms loanTerms; // 放款条件
    private UserInfo businessUser; // 渠道专员

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

    public HouseProperty getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(HouseProperty houseProperty) {
        this.houseProperty = houseProperty;
    }

    public PropertyRightsType getPropertyRightsType() {
        return propertyRightsType;
    }

    public void setPropertyRightsType(PropertyRightsType propertyRightsType) {
        this.propertyRightsType = propertyRightsType;
    }

    public SuperviseType getSuperviseType() {
        return superviseType;
    }

    public void setSuperviseType(SuperviseType superviseType) {
        this.superviseType = superviseType;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
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

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LoanTerms getLoanTerms() {
        return loanTerms;
    }

    public void setLoanTerms(LoanTerms loanTerms) {
        this.loanTerms = loanTerms;
    }

    public UserInfo getBusinessUser() {
        return businessUser;
    }

    public void setBusinessUser(UserInfo businessUser) {
        this.businessUser = businessUser;
    }
}
