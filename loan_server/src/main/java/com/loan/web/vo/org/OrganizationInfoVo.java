package com.loan.web.vo.org;

import com.loan.service.model.dto.UserInfoDto;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-21 21:08
 */
public class OrganizationInfoVo {
    private Long orgId; // 组织机构编码
    private String orgName; // 组织机构名称
    private Long superOrgId; // 上级组织机构编码
    private String superOrgName; // 上级组织机构名称
    private String orgAddress; // 办公地址
    private Long orgLeaderId; // 负责人用户ID
    private String orgLeaderName; // 负责人用户名

    private List<UserInfoDto> userInfoList;

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

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public List<UserInfoDto> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfoDto> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
