package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;

import java.io.Serializable;

/**
 * @author GuoKang
 * @date 2019/8/5 15:55
 */
public class CaseStaffs extends AbsPojoSetPk implements Serializable {

    private Long caseId; // 案子ID
    private Long createId; // 创建人ID
    private Long businessId; // 渠道专员ID
    private Long riskId; // 风控审核人员ID
    private Long financeId; // 财务审核人员ID
    private Long fieldId; // 外勤工作人员ID

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public void setPk(Long pk) {
        this.caseId = pk;
    }
}
