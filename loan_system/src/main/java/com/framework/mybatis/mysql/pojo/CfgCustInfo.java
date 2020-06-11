package com.framework.mybatis.mysql.pojo;

public class CfgCustInfo {
    private String custId;

    private String custName;

    private String idType;

    private String idNumber;

    private String mobilePhone;

    private String landPhone;

    private String occupType;

    private String incomeSource;

    private Double amountValue;

    private String coType;

    private String coName;

    private String coPhone;

    private String coAddress;

    private String accountName;

    private String khhName;

    private String streamValue;

    private String accountId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getLandPhone() {
        return landPhone;
    }

    public void setLandPhone(String landPhone) {
        this.landPhone = landPhone == null ? null : landPhone.trim();
    }

    public String getOccupType() {
        return occupType;
    }

    public void setOccupType(String occupType) {
        this.occupType = occupType == null ? null : occupType.trim();
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource == null ? null : incomeSource.trim();
    }

    public Double getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(Double amountValue) {
        this.amountValue = amountValue;
    }

    public String getCoType() {
        return coType;
    }

    public void setCoType(String coType) {
        this.coType = coType == null ? null : coType.trim();
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName == null ? null : coName.trim();
    }

    public String getCoPhone() {
        return coPhone;
    }

    public void setCoPhone(String coPhone) {
        this.coPhone = coPhone == null ? null : coPhone.trim();
    }

    public String getCoAddress() {
        return coAddress;
    }

    public void setCoAddress(String coAddress) {
        this.coAddress = coAddress == null ? null : coAddress.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getKhhName() {
        return khhName;
    }

    public void setKhhName(String khhName) {
        this.khhName = khhName == null ? null : khhName.trim();
    }

    public String getStreamValue() {
        return streamValue;
    }

    public void setStreamValue(String streamValue) {
        this.streamValue = streamValue == null ? null : streamValue.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }
}