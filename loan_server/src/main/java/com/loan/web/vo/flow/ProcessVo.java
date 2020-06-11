package com.loan.web.vo.flow;

import com.loan.service.enums.CaseOperateResult;
import com.loan.service.enums.CaseOperateType;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author GuoKang
 * @date 2019/5/21 18:19
 */
public class ProcessVo {
    private Long caseId;
    private CaseOperateType operateType;
    private CaseOperateResult operateResult;
    private Long nextOperatorId;
    private String operateRemark;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
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

    public Long getNextOperatorId() {
        return nextOperatorId;
    }

    public void setNextOperatorId(Long nextOperatorId) {
        this.nextOperatorId = nextOperatorId;
    }

    public String getOperateRemark() {
        return operateRemark;
    }

    public void setOperateRemark(String operateRemark) {
        this.operateRemark = operateRemark;
    }
}
