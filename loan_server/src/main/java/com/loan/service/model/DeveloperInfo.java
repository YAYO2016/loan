package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/4/26 10:46
 */
public class DeveloperInfo extends AbsPojoSetPk implements Serializable {
    private Long developerId; // 开发商ID
    private String developerName; // 开发商名称
    private String developerAddr; // 开发商地址
    private String developerTel; // 开发商电话
    private String financeName; // 财务负责人姓名
    private String financeTel; // 财务负责人电话
    private String accountNo; // 监管账户
    private String accountBank; // 监管账户开户行
    private Long createUser; // 创建人
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperAddr() {
        return developerAddr;
    }

    public void setDeveloperAddr(String developerAddr) {
        this.developerAddr = developerAddr;
    }

    public String getDeveloperTel() {
        return developerTel;
    }

    public void setDeveloperTel(String developerTel) {
        this.developerTel = developerTel;
    }

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    public String getFinanceTel() {
        return financeTel;
    }

    public void setFinanceTel(String financeTel) {
        this.financeTel = financeTel;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public void setPk(Long pk) {
        setDeveloperId(pk);
    }
}
