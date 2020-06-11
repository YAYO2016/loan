package com.loan.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loan.framework.service.model.AbsPojoSetPk;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/4/25 17:18
 */
public class EstateSalesmanInfo extends AbsPojoSetPk implements Serializable {

    private Long salesmanId; // 销售员ID
    private Long estateId; // 楼盘ID
    private String salesmanName; // 销售姓名
    private String salesmanTel; // 销售电话
    private String officeTel; // 销售办公电话
    private String accountName; // 账户名
    private String accountBank; // 开户行
    private String accountNo; // 账号
    private Date createTime; // 创建时间

    public Long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }

    public Long getEstateId() {
        return estateId;
    }

    public void setEstateId(Long estateId) {
        this.estateId = estateId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getSalesmanTel() {
        return salesmanTel;
    }

    public void setSalesmanTel(String salesmanTel) {
        this.salesmanTel = salesmanTel;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonIgnore
    public boolean isEmpty() {
        return StringUtils.isEmpty(salesmanName)
                && StringUtils.isEmpty(salesmanTel)
                && StringUtils.isEmpty(officeTel)
                && StringUtils.isEmpty(accountName)
                && StringUtils.isEmpty(accountBank)
                && StringUtils.isEmpty(salesmanName)
                && StringUtils.isEmpty(accountNo);
    }

    @Override
    public void setPk(Long pk) {
        setSalesmanId(pk);
    }
}
