package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.UserRoles;
import com.loan.service.model.dto.UserRolesDto;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019/4/22 14:30
 */
public interface UserRolesService extends LoanService<UserRoles> {
    List<String> getUserRolesByUserId(Long userId);

    List<UserRolesDto> getUserRolesDtoByUserId(Long userId);

    void clearUserRolesByUserId(Long userId);
}
