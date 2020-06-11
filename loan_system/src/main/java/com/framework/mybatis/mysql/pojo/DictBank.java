package com.framework.mybatis.mysql.pojo;

public class DictBank {
    private String bankId;

    private String bankName;

    private String branchId;

    private String branchName;

    private String subBranchId;

    private String subBranchName;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getSubBranchId() {
        return subBranchId;
    }

    public void setSubBranchId(String subBranchId) {
        this.subBranchId = subBranchId == null ? null : subBranchId.trim();
    }

    public String getSubBranchName() {
        return subBranchName;
    }

    public void setSubBranchName(String subBranchName) {
        this.subBranchName = subBranchName == null ? null : subBranchName.trim();
    }
}