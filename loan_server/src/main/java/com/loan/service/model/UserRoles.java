package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/4/22 14:24
 */
public class UserRoles extends AbsPojoSetPk implements Serializable {

    private Long relationId; // 关联编码
    private Long userId; // 用户编码
    private String roleId; // 角色编码
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
        setRelationId(pk);
    }
}
