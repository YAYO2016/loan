package com.loan.web.vo.flow;

import com.loan.service.enums.CaseOperateResult;
import com.loan.service.enums.CaseOperateType;
import com.loan.service.model.dto.LoanBranchDto;

/**
 * @author GuoKang
 * @date 2019/5/21 18:19
 */
public class ProcessCheckVo {
    private Long caseId;
    private CaseOperateType operateType;
    private CaseOperateResult operateResult;
    private Long nextOperatorId;
    private String operateRemark;

    // 审批银行信息 start
    private Long branchId; // 分行编码
    private String branchName; // 分行名称
    private String managerName; // 客户经理
    private String managerPhone; // 客户经理电话
    // 审批银行信息 end

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
}
