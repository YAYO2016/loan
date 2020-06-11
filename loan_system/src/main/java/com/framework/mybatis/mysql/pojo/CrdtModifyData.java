package com.framework.mybatis.mysql.pojo;

public class CrdtModifyData {
    private String caseId;

    private String dataName;

    private String realInfo;

    private String modifyInfo;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getRealInfo() {
        return realInfo;
    }

    public void setRealInfo(String realInfo) {
        this.realInfo = realInfo == null ? null : realInfo.trim();
    }

    public String getModifyInfo() {
        return modifyInfo;
    }

    public void setModifyInfo(String modifyInfo) {
        this.modifyInfo = modifyInfo == null ? null : modifyInfo.trim();
    }
}