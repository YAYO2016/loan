package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.PrivilegeInfo;
import com.loan.service.model.dto.PrivilegeInfoDto;
import com.loan.service.model.dto.RolePrivilegesDto;

import java.util.List;
import java.util.Set;

/**
 * @author GuoKang
 * @date 2019/7/19 10:47
 */
public interface PrivilegeInfoService extends LoanService<PrivilegeInfo> {

    RolePrivilegesDto getRolePrivilegesByRoleId(String roleId);

    void updateRolePrivileges(RolePrivilegesDto rolePrivileges);

    List<PrivilegeInfoDto> getAllPrivileges();

    Set<String> getPrivilegesByUserId(Long userId);
}
