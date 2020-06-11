package com.framework.mybatis.mysql.pojo;

public class CrdtCaseCustRel {
    private String caseId;

    private String custId;

    private String relType;

    private String isTrue;

    private String isStream;

    private String isTrueStream;

    private String streamValue;

    private String coType;

    private String coName;

    private String coPhone;

    private String coAddress;

    private Double amountValue;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType == null ? null : relType.trim();
    }

    public String getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue == null ? null : isTrue.trim();
    }

    public String getIsStream() {
        return isStream;
    }

    public void setIsStream(String isStream) {
        this.isStream = isStream == null ? null : isStream.trim();
    }

    public String getIsTrueStream() {
        return isTrueStream;
    }

    public void setIsTrueStream(String isTrueStream) {
        this.isTrueStream = isTrueStream == null ? null : isTrueStream.trim();
    }

    public String getStreamValue() {
        return streamValue;
    }

    public void setStreamValue(String streamValue) {
        this.streamValue = streamValue == null ? null : streamValue.trim();
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

    public Double getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(Double amountValue) {
        this.amountValue = amountValue;
    }
}