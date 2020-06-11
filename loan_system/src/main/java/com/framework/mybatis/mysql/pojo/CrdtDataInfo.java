package com.framework.mybatis.mysql.pojo;

public class CrdtDataInfo {
    private String caseId;

    private String dataBelong;

    private String dataName;

    private Integer dataCount;

    private String orgInfo;

    private String dupInfo;

    private String remark;

    private String state;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getDataBelong() {
        return dataBelong;
    }

    public void setDataBelong(String dataBelong) {
        this.dataBelong = dataBelong == null ? null : dataBelong.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public String getOrgInfo() {
        return orgInfo;
    }

    public void setOrgInfo(String orgInfo) {
        this.orgInfo = orgInfo == null ? null : orgInfo.trim();
    }

    public String getDupInfo() {
        return dupInfo;
    }

    public void setDupInfo(String dupInfo) {
        this.dupInfo = dupInfo == null ? null : dupInfo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}