package com.framework.mybatis.mysql.pojo;

public class DictCaseFlow {
    private String caseType;

    private String scageId;

    private String scageName;

    private String stepId;

    private String stepName;

    private String stepType;

    private String nextScageId;

    private String nextStepId;

    private String backScageId;

    private String backStepId;

    private Integer daysLimit;

    private String thisRoleId;

    private String nextRoleId;

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

    public String getScageName() {
        return scageName;
    }

    public void setScageName(String scageName) {
        this.scageName = scageName == null ? null : scageName.trim();
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId == null ? null : stepId.trim();
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType == null ? null : stepType.trim();
    }

    public String getNextScageId() {
        return nextScageId;
    }

    public void setNextScageId(String nextScageId) {
        this.nextScageId = nextScageId == null ? null : nextScageId.trim();
    }

    public String getNextStepId() {
        return nextStepId;
    }

    public void setNextStepId(String nextStepId) {
        this.nextStepId = nextStepId == null ? null : nextStepId.trim();
    }

    public String getBackScageId() {
        return backScageId;
    }

    public void setBackScageId(String backScageId) {
        this.backScageId = backScageId == null ? null : backScageId.trim();
    }

    public String getBackStepId() {
        return backStepId;
    }

    public void setBackStepId(String backStepId) {
        this.backStepId = backStepId == null ? null : backStepId.trim();
    }

    public Integer getDaysLimit() {
        return daysLimit;
    }

    public void setDaysLimit(Integer daysLimit) {
        this.daysLimit = daysLimit;
    }

    public String getThisRoleId() {
        return thisRoleId;
    }

    public void setThisRoleId(String thisRoleId) {
        this.thisRoleId = thisRoleId == null ? null : thisRoleId.trim();
    }

    public String getNextRoleId() {
        return nextRoleId;
    }

    public void setNextRoleId(String nextRoleId) {
        this.nextRoleId = nextRoleId == null ? null : nextRoleId.trim();
    }
}