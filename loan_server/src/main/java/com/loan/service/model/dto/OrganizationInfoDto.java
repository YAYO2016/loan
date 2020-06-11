package com.loan.service.model.dto;

import com.loan.service.model.OrganizationInfo;

/**
 * @author GuoKang
 * @date 2019-04-21 21:54
 */
public class OrganizationInfoDto extends OrganizationInfo {
    private String superOrgName; // 上级组织机构名称
    private String orgLeaderName; // 负责人用户名

    public String getSuperOrgName() {
        return superOrgName;
    }

    public void setSuperOrgName(String superOrgName) {
        this.superOrgName = superOrgName;
    }

    public String getOrgLeaderName() {
        return orgLeaderName;
    }

    public void setOrgLeaderName(String orgLeaderName) {
        this.orgLeaderName = orgLeaderName;
    }
}
