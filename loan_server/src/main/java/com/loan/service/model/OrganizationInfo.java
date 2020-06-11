package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-04-21 19:18
 */
public class OrganizationInfo extends AbsPojoSetPk implements Serializable {

    private Long orgId; // 组织机构编码
    private String orgName; // 组织机构名称
    private Long superOrgId; // 上级组织机构编码
    private String orgAddress; // 办公地址
    private Long orgLeaderId; // 负责人用户ID 关联user表
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getSuperOrgId() {
        return superOrgId;
    }

    public void setSuperOrgId(Long superOrgId) {
        this.superOrgId = superOrgId;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public Long getOrgLeaderId() {
        return orgLeaderId;
    }

    public void setOrgLeaderId(Long orgLeaderId) {
        this.orgLeaderId = orgLeaderId;
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
        setOrgId(pk);
    }
}
