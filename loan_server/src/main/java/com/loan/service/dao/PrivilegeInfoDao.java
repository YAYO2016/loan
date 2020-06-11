package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.PrivilegeInfo;
import com.loan.service.model.RolePrivileges;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019/7/19 10:46
 */
@Component
public interface PrivilegeInfoDao extends LoanDao<PrivilegeInfo> {

    void insertRolePrivileges(RolePrivileges rolePrivileges);

    RolePrivileges getRolePrivilegesByRoleId(@Param("roleId") String roleId);

    void deleteRolePrivilegesByRoleId(@Param("roleId") String roleId);

    List<RolePrivileges> getRolePrivilegesByUserId(@Param("userId") Long userId);
}
