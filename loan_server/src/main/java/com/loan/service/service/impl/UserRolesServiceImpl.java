package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.UserRolesDao;
import com.loan.service.model.UserRoles;
import com.loan.service.model.dto.UserRolesDto;
import com.loan.service.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019/4/22 14:31
 */
@Service
public class UserRolesServiceImpl extends AbstractLoanService<UserRoles> implements UserRolesService {

    @Autowired
    private UserRolesDao userRolesDao;

    @Override
    protected ISingleTableDao<UserRoles> getMyBatisRepository() {
        return userRolesDao;
    }

    @Override
    protected UserRoles constructPkEntity(Long id) {
        return new UserRoles() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(UserRoles userRoles) {
        return userRoles.getRelationId();
    }

    @Override
    public List<String> getUserRolesByUserId(Long userId) {
        UserRoles queryUserRoles = new UserRoles();
        queryUserRoles.setUserId(userId);
        List<UserRoles> userRolesList = this.queryEntityList(queryUserRoles);
        List<String> roles = new ArrayList<>();
        userRolesList.forEach(userRoles -> roles.add(userRoles.getRoleId()));
        return roles;
    }

    @Override
    public List<UserRolesDto> getUserRolesDtoByUserId(Long userId) {
        return this.userRolesDao.getUserRolesDtoByUserId(userId);
    }

    @Override
    public void clearUserRolesByUserId(Long userId) {
        this.userRolesDao.clearUserRolesByUserId(userId);
    }
}
