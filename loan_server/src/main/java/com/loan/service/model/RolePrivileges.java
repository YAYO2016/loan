package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/7/19 11:03
 */
public class RolePrivileges extends AbsPojoSetPk implements Serializable {
    private String roleId; // 角色编码
    private String checkedPrivileges; // 权限集合
    private Date createTime; // 创建或修改时间

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCheckedPrivileges() {
        return checkedPrivileges;
    }

    public void setCheckedPrivileges(String checkedPrivileges) {
        this.checkedPrivileges = checkedPrivileges;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setPk(Long pk) {

    }
}
