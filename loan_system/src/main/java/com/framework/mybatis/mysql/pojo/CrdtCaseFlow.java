package com.framework.mybatis.mysql.pojo;

import java.util.Date;

public class CrdtCaseFlow {
    private String caseId;

    private String scageId;

    private String scageName;

    private String stepId;

    private String stepName;

    private Date beginTime;

    private Date endTime;

    private String dealUser;

    private String dealResule;

    private String dealInfo;

    private Integer seqNumber;

    private String state;

    private String nextScageId;

    private String nextStepId;

    private String nextUser;

    private String isTrans;

    private String allotUser;

    private String expressUser;

    private Date allotTime;

    private Date getTime;

    private Date finishTime;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDealUser() {
        return dealUser;
    }

    public void setDealUser(String dealUser) {
        this.dealUser = dealUser == null ? null : dealUser.trim();
    }

    public String getDealResule() {
        return dealResule;
    }

    public void setDealResule(String dealResule) {
        this.dealResule = dealResule == null ? null : dealResule.trim();
    }

    public String getDealInfo() {
        return dealInfo;
    }

    public void setDealInfo(String dealInfo) {
        this.dealInfo = dealInfo == null ? null : dealInfo.trim();
    }

    public Integer getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser == null ? null : nextUser.trim();
    }

    public String getIsTrans() {
        return isTrans;
    }

    public void setIsTrans(String isTrans) {
        this.isTrans = isTrans == null ? null : isTrans.trim();
    }

    public String getAllotUser() {
        return allotUser;
    }

    public void setAllotUser(String allotUser) {
        this.allotUser = allotUser == null ? null : allotUser.trim();
    }

    public String getExpressUser() {
        return expressUser;
    }

    public void setExpressUser(String expressUser) {
        this.expressUser = expressUser == null ? null : expressUser.trim();
    }

    public Date getAllotTime() {
        return allotTime;
    }

    public void setAllotTime(Date allotTime) {
        this.allotTime = allotTime;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}