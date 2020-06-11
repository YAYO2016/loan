package com.loan.service.model.dto;

import com.loan.service.model.UserRoles;

/**
 * @author GuoKang
 * @date 2019/4/22 17:24
 */
public class UserRolesDto extends UserRoles {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
