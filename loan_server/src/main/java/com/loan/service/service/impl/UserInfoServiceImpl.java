package com.loan.service.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.UserInfoDao;
import com.loan.service.enums.RoleDict;
import com.loan.service.enums.UserStatus;
import com.loan.service.model.OrganizationInfo;
import com.loan.service.model.UserInfo;
import com.loan.service.model.UserRoles;
import com.loan.service.model.dto.UserInfoDto;
import com.loan.service.model.dto.UserRolesDto;
import com.loan.service.service.OrganizationInfoService;
import com.loan.service.service.PrivilegeInfoService;
import com.loan.service.service.UserInfoService;
import com.loan.service.service.UserRolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author GuoKang
 * @date 2019-04-17 23:21
 */
@Service
public class UserInfoServiceImpl extends AbstractLoanService<UserInfo> implements UserInfoService {

    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserRolesService userRolesService;
    @Autowired
    private OrganizationInfoService organizationInfoService;
    @Autowired
    private PrivilegeInfoService privilegeInfoService;

    @Override
    protected ISingleTableDao<UserInfo> getMyBatisRepository() {
        return userInfoDao;
    }

    @Override
    protected UserInfo constructPkEntity(Long id) {
        return new UserInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(UserInfo userInfo) {
        return userInfo.getUserId();
    }

    @Override
    public void clearUserOrgInfo(Long orgId) {
        this.userInfoDao.clearUserOrgInfo(orgId);
    }

    @Override
    public List<UserInfoDto> getUserInfoDtoByOrgId(Long orgId) {
        List<UserInfoDto> userInfoDtoList = new ArrayList<>();

        List<UserInfo> userInfoList = this.userInfoDao.getUserInfoByOrgId(orgId);
        userInfoList.forEach(userInfo -> {
            UserInfoDto dto = new UserInfoDto();
            BeanUtils.copyProperties(userInfo, dto);
            dto.setUserRoles(this.userRolesService.getUserRolesDtoByUserId(userInfo.getUserId()));
            userInfoDtoList.add(dto);
        });
        return userInfoDtoList;
    }

    @Override
    public List<UserInfo> getUserInfoByOrgId(Long orgId) {
        return this.userInfoDao.getUserInfoByOrgId(orgId);
    }

    @Override
    public LoanPageList<UserInfoDto> getUserInfoDtoPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.userInfoDao.countUserInfoDto(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<UserInfoDto> list = this.userInfoDao.listUserInfoDto(params);
        list.forEach(dto -> {
            dto.setUserPw(null);
            dto.setUserRoles(this.userRolesService.getUserRolesDtoByUserId(dto.getUserId()));
        });
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public UserInfoDto getUserInfoDtoById(Long userId) {
        UserInfoDto userInfoDto = this.userInfoDao.getUserInfoDtoByUserId(userId);
        userInfoDto.setUserPw(null);
        userInfoDto.setUserRoles(this.userRolesService.getUserRolesDtoByUserId(userId));
        userInfoDto.setRoles(getRolesList(userInfoDto.getUserRoles()));
        userInfoDto.setPrivileges(privilegeInfoService.getPrivilegesByUserId(userId));
        return userInfoDto;
    }

    @Override
    @Transactional
    public void saveSingleUserInfo(UserInfoDto userInfoDto) {
        Date now = new Date();

        if (null == userInfoDto.getUserId()) {
            // 新增
            userInfoDto.setCreateTime(now);
            userInfoDto.setModifyTime(now);
            userInfoDto.setStatus(UserStatus.VALID);
            this.create(userInfoDto);
        } else {
            UserInfo userInfo = this.getEntityById(userInfoDto.getUserId());
            userInfoDto.setCreateTime(userInfo.getCreateTime());
            userInfoDto.setModifyTime(now);
            userInfoDto.setCreateUserId(userInfo.getCreateUserId());
            userInfoDto.setStatus(userInfo.getStatus());
            this.modifyEntityById(userInfoDto);
        }

        // 清空用户的角色信息
        this.userRolesService.clearUserRolesByUserId(userInfoDto.getUserId());

        // 新增用户角色信息
        if (!CollectionUtils.isEmpty(userInfoDto.getRoles())) {
            userInfoDto.getRoles().forEach(roleId -> {
                UserRoles userRoles = new UserRoles();
                userRoles.setUserId(userInfoDto.getUserId());
                userRoles.setRoleId(roleId);
                userRoles.setCreateTime(now);
                userRoles.setModifyTime(now);
                this.userRolesService.create(userRoles);
            });
        }
    }

    @Override
    @Transactional
    public void modifyPassword(Long userId, String userPw) {
        Date now = new Date();
        if (null == userId || StringUtils.isEmpty(userPw))
            return;

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserId(userId);
        userInfoDto.setUserPw(userPw);
        userInfoDto.setModifyTime(now);
        this.modifyEntityById(userInfoDto);
    }

    @Override
    public List<UserInfo> getBusinessUserByUserId(Long userId) {
        List<UserRolesDto> rolesDtoList = this.userRolesService.getUserRolesDtoByUserId(userId);
        if (!this.getRolesList(rolesDtoList).contains(RoleDict.R0201.toString())) {
            return new ArrayList<UserInfo>() {{
                add(getEntityById(userId));
            }};
        }
        return this.userInfoDao.getUserByIds(this.getEntityById(userId).getBusinessUsers());
    }

    @Override
    public List<UserInfo> getUserByUserId(List userIds) {
        if (null == userIds || userIds.isEmpty())
            return new ArrayList<>();
        return this.userInfoDao.getUserByIds(userIds);
    }

    @Override
    public void updateUserStatus(Long userId, UserStatus userStatus) {
        // 把用户置为失效
        UserInfo userInfo = this.getEntityById(userId);
        userInfo.setStatus(userStatus);
        userInfo.setModifyTime(new Date());
        this.modifyEntityById(userInfo);
    }

    @Override
    public List<UserInfo> getUserListByRoleDict(RoleDict roleDict) {
        return this.userInfoDao.getUserListByRoleDict(roleDict.toString());
    }

    private List<String> getRolesList(List<UserRolesDto> userRolesDtoList) {
        return CollectionUtils.isEmpty(userRolesDtoList) ?
                new ArrayList<>() : userRolesDtoList.stream().map(UserRolesDto::getRoleId).collect(Collectors.toList());
    }

}
