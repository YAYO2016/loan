package com.framework.mybatis.mysql.pojo;

public class CfgCaseItemLimit {
    private String caseType;

    private String scageId;

    private String stepId;

    private String colmName;

    private String isShow;

    private String isReq;

    private String isModify;

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    public String getScageId() {
        return scageId;
    }

    public void setScageId(String scageId) {
        this.scageId = scageId == null ? null : scageId.trim();
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId == null ? null : stepId.trim();
    }

    public String getColmName() {
        return colmName;
    }

    public void setColmName(String colmName) {
        this.colmName = colmName == null ? null : colmName.trim();
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    public String getIsReq() {
        return isReq;
    }

    public void setIsReq(String isReq) {
        this.isReq = isReq == null ? null : isReq.trim();
    }

    public String getIsModify() {
        return isModify;
    }

    public void setIsModify(String isModify) {
        this.isModify = isModify == null ? null : isModify.trim();
    }
}