package com.loan.web.vo.caseinfo;

import com.alibaba.fastjson.JSONArray;
import com.loan.service.enums.CaseOperateType;
import com.loan.service.enums.CaseSubType;
import com.loan.service.enums.CaseType;
import com.loan.service.model.CaseLoanInfo;

/**
 * @author GuoKang
 * @date 2019-05-23 22:24
 */
public class CaseReformInfoVo {
    private Long caseId; // 案子ID
    private CaseType caseType; // 案子大类
    private CaseSubType caseSubType; // 案子小类
    private String reformSource; // 整改来源
    private String reformRemark; // 整改意见

    private CaseLoanInfo loanInfo; // 贷款信息
    private JSONArray materialInfo; // 材料信息
    private JSONArray feeItemInfo; // 费用信息


    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public CaseSubType getCaseSubType() {
        return caseSubType;
    }

    public void setCaseSubType(CaseSubType caseSubType) {
        this.caseSubType = caseSubType;
    }

    public String getReformSource() {
        return reformSource;
    }

    public void setReformSource(String reformSource) {
        this.reformSource = reformSource;
    }

    public String getReformRemark() {
        return reformRemark;
    }

    public void setReformRemark(String reformRemark) {
        this.reformRemark = reformRemark;
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
