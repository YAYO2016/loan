package com.loan.service.model.dto;

import java.io.Serializable;

/**
 * @author GuoKang
 * @date 2019-05-21 21:38
 */
public class LoanBranchDto implements Serializable {

    private Long branchId; // 分行名称
    private String branchName; // 分行名称
    private String managerName; // 客户经理
    private String managerPhone; // 客户经理电话

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
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
