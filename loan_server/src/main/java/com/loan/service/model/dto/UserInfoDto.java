package com.loan.service.model.dto;

import com.loan.service.model.UserInfo;

import java.util.List;
import java.util.Set;

/**
 * @author GuoKang
 * @date 2019/4/22 14:33
 */
public class UserInfoDto extends UserInfo {
    private String createUserName; // 创建人姓名
    private String orgName; // 组织机构名
    private List<UserRolesDto> userRoles; // 角色集合
    private List<String> roles; // 角色集合
    private Set<String> privileges; // 权限集合

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<UserRolesDto> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRolesDto> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<String> privileges) {
        this.privileges = privileges;
    }
}
