package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.CaseOperateResult;
import com.loan.service.enums.CaseOperateType;
import com.loan.service.enums.CaseStatusDict;

import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-05-19 20:13
 */
public class CaseOperateLog extends AbsPojoSetPk {
    private Long logId; // 操作日志表主键ID
    private Long caseId; // 案子ID
    private CaseStatusDict caseStatus; // 案子状态
    private CaseOperateType operateType; // 操作步骤
    private CaseOperateResult operateResult; // 操作结果
    private String operateRemark; // 操作备注
    private Long operatorId; // 操作人ID
    private Long nextOperatorId; // 下一步操作人ID
    private Date operateTime; // 操作时间

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public CaseStatusDict getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatusDict caseStatus) {
        this.caseStatus = caseStatus;
    }

    public CaseOperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(CaseOperateType operateType) {
        this.operateType = operateType;
    }

    public CaseOperateResult getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(CaseOperateResult operateResult) {
        this.operateResult = operateResult;
    }

    public String getOperateRemark() {
        return operateRemark;
    }

    public void setOperateRemark(String operateRemark) {
        this.operateRemark = operateRemark;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getNextOperatorId() {
        return nextOperatorId;
    }

    public void setNextOperatorId(Long nextOperatorId) {
        this.nextOperatorId = nextOperatorId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public void setPk(Long pk) {
        setLogId(pk);
    }
}
