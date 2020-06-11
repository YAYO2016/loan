package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.enums.RoleDict;
import com.loan.service.enums.UserStatus;
import com.loan.service.model.UserInfo;
import com.loan.service.model.dto.OrganizationInfoDto;
import com.loan.service.model.dto.UserInfoDto;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-17 23:20
 */
public interface UserInfoService extends LoanService<UserInfo> {
    void clearUserOrgInfo(Long orgId);

    List<UserInfoDto> getUserInfoDtoByOrgId(Long orgId);

    List<UserInfo> getUserInfoByOrgId(Long orgId);

    LoanPageList<UserInfoDto> getUserInfoDtoPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    UserInfoDto getUserInfoDtoById(Long userId);

    void saveSingleUserInfo(UserInfoDto userInfoDto);

    void updateUserStatus(Long userId, UserStatus userStatus);

    List<UserInfo> getUserListByRoleDict(RoleDict roleDict);

    void modifyPassword(Long userId, String userPw);

    List<UserInfo> getBusinessUserByUserId(Long userId);

    List<UserInfo> getUserByUserId(List userIds);
}
