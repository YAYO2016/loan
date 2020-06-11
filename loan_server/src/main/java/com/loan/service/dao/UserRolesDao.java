package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.UserRoles;
import com.loan.service.model.dto.UserRolesDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019/4/22 14:29
 */
@Component
public interface UserRolesDao extends LoanDao<UserRoles> {

    List<UserRolesDto> getUserRolesDtoByUserId(@Param("userId") Long userId);

    void clearUserRolesByUserId(@Param("userId") Long userId);
}
