package com.loan.web.vo.org;

import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-04-21 21:08
 */
public class OrganizationInfoPageVo {
    private Long orgId; // 组织机构编码
    private String orgName; // 组织机构名称
    private Long superOrgId; // 上级组织机构编码
    private String superOrgName; // 上级组织机构名称
    private String orgAddress; // 办公地址
    private Long orgLeaderId; // 负责人用户ID
    private String orgLeaderName; // 负责人用户名
    private Date createTime; // 创建时间
    private Integer userCount; // 人员数

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

    public String getSuperOrgName() {
        return superOrgName;
    }

    public void setSuperOrgName(String superOrgName) {
        this.superOrgName = superOrgName;
    }

    public Long getOrgLeaderId() {
        return orgLeaderId;
    }

    public void setOrgLeaderId(Long orgLeaderId) {
        this.orgLeaderId = orgLeaderId;
    }

    public String getOrgLeaderName() {
        return orgLeaderName;
    }

    public void setOrgLeaderName(String orgLeaderName) {
        this.orgLeaderName = orgLeaderName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
