package com.framework.mybatis.mysql.pojo;

public class CfgOrg {
    private String orgId;

    private String orgName;

    private String superOrgId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getSuperOrgId() {
        return superOrgId;
    }

    public void setSuperOrgId(String superOrgId) {
        this.superOrgId = superOrgId == null ? null : superOrgId.trim();
    }
}