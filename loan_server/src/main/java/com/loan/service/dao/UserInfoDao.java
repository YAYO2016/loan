package com.loan.service.dao;

import com.alibaba.fastjson.JSONArray;
import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.UserInfo;
import com.loan.service.model.dto.UserInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-17 23:22
 */
@Component
public interface UserInfoDao extends LoanDao<UserInfo> {
    UserInfo getUserInfoDtoByAccount(@Param("loginAccount") String loginAccount);

    Integer clearUserOrgInfo(@Param("orgId") Long orgId);

    List<UserInfo> getUserInfoByOrgId(@Param("orgId") Long orgId);

    Integer countUserInfoDto(Map<String, Object> params);

    List<UserInfoDto> listUserInfoDto(Map<String, Object> params);

    UserInfoDto getUserInfoDtoByUserId(@Param("userId") Long userId);

    List<UserInfo> getUserListByRoleDict(@Param("roleDict") String roleDict);

    List<UserInfo> getUserByIds(@Param("idList") List idList);
}
