package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 干系人信息
 *
 * @author GuoKang
 * @date 2019-05-06 22:38
 */
public class CaseCustInfo extends AbsPojoSetPk implements Serializable {

    private Long custId; // 人员ID
    private Long caseId; // 案子编码
    private CaseCustomerType caseCustType; // 案子与人员关系
    private CustomerRelation custRel; // 与主贷、卖方人关系
    private String custName; // 人员名称
    private IDType idType; // 证件类型
    private String idNo; // 证件号
    private String mobilePhone; // 手机号
    private String landPhone; // 固定电话
    private String coPhone; // 单位电话
    private CoType coType; // 单位性质
    private OccuType occuType; // 职业性质
    private Double amountValue; // 收入金额
    private String coName; // 单位名称
    private MaritalStatus maritalStatus; // 婚姻状况
    private String accountNo; // 账号
    private Date createTime; // 创建时间

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public CaseCustomerType getCaseCustType() {
        return caseCustType;
    }

    public void setCaseCustType(CaseCustomerType caseCustType) {
        this.caseCustType = caseCustType;
    }

    public CustomerRelation getCustRel() {
        return custRel;
    }

    public void setCustRel(CustomerRelation custRel) {
        this.custRel = custRel;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public IDType getIdType() {
        return idType;
    }

    public void setIdType(IDType idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getLandPhone() {
        return landPhone;
    }

    public void setLandPhone(String landPhone) {
        this.landPhone = landPhone;
    }

    public String getCoPhone() {
        return coPhone;
    }

    public void setCoPhone(String coPhone) {
        this.coPhone = coPhone;
    }

    public CoType getCoType() {
        return coType;
    }

    public void setCoType(CoType coType) {
        this.coType = coType;
    }

    public OccuType getOccuType() {
        return occuType;
    }

    public void setOccuType(OccuType occuType) {
        this.occuType = occuType;
    }

    public Double getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(Double amountValue) {
        this.amountValue = amountValue;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setPk(Long pk) {
        setCustId(pk);
    }
}
