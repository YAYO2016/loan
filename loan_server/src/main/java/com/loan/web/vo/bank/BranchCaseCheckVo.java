package com.loan.web.vo.bank;

import com.loan.service.model.BranchInfo;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-21 22:06
 */
public class BranchCaseCheckVo {
    private Long caseId;
    private String bankName;
    private List<BranchInfo> branchInfos;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<BranchInfo> getBranchInfos() {
        return branchInfos;
    }

    public void setBranchInfos(List<BranchInfo> branchInfos) {
        this.branchInfos = branchInfos;
    }
}
