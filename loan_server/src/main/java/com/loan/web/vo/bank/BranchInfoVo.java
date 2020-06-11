package com.loan.web.vo.bank;

/**
 * @author GuoKang
 * @date 2019/4/23 13:11
 */
public class BranchInfoVo {
    private Long branchId; // 分行ID
    private String bankId; // 总行编码
    private String branchName; // 分行名称
    private String managerName; // 客户经理
    private String managerPhone; // 客户经理电话
    private String branchDesc; // 特殊情况描述

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
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

    public String getBranchDesc() {
        return branchDesc;
    }

    public void setBranchDesc(String branchDesc) {
        this.branchDesc = branchDesc;
    }
}
