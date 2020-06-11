package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;

import java.io.Serializable;

/**
 * @author GuoKang
 * @date 2019-04-22 23:20
 */
public class RoleInfo extends AbsPojoSetPk implements Serializable {

    private String roleId; // 角色编码
    private String roleName; // 角色名称
    private String roleDesc; // 角色描述

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public void setPk(Long pk) {

    }
}
