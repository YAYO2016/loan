package com.loan.service.model.dto;

import com.alibaba.fastjson.JSONArray;
import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.model.RolePrivileges;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/7/19 11:03
 */
public class RolePrivilegesDto implements Serializable {
    private String roleId; // 角色编码
    private JSONArray checkedPrivileges = new JSONArray(); // 权限集合

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public JSONArray getCheckedPrivileges() {
        return checkedPrivileges;
    }

    public void setCheckedPrivileges(JSONArray checkedPrivileges) {
        this.checkedPrivileges = checkedPrivileges;
    }
}
