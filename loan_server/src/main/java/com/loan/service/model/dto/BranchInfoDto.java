package com.loan.service.model.dto;

import com.loan.service.model.BranchInfo;

/**
 * @author GuoKang
 * @date 2019/4/23 11:21
 */
public class BranchInfoDto extends BranchInfo {


    private String bankName; // 总行名称
    private Integer caseCount; // 案子数

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(Integer caseCount) {
        this.caseCount = caseCount;
    }
}
