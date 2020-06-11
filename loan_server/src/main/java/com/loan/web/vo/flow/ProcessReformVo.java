package com.loan.web.vo.flow;

import com.alibaba.fastjson.JSONArray;
import com.loan.service.enums.CaseOperateType;
import com.loan.service.model.CaseLoanInfo;

/**
 * @author GuoKang
 * @date 2019-05-21 22:54
 */
public class ProcessReformVo {
    private Long caseId;
    private CaseOperateType operateType;
    private CaseLoanInfo loanInfo; // 贷款信息
    private JSONArray materialInfo; // 材料信息
    private JSONArray feeItemInfo; // 费用信息

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

    public CaseLoanInfo getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(CaseLoanInfo loanInfo) {
        this.loanInfo = loanInfo;
    }

    public JSONArray getMaterialInfo() {
        return materialInfo;
    }

    public void setMaterialInfo(JSONArray materialInfo) {
        this.materialInfo = materialInfo;
    }

    public JSONArray getFeeItemInfo() {
        return feeItemInfo;
    }

    public void setFeeItemInfo(JSONArray feeItemInfo) {
        this.feeItemInfo = feeItemInfo;
    }
}
