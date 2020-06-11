package com.loan.service.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.PrivilegeInfoDao;
import com.loan.service.model.PrivilegeInfo;
import com.loan.service.model.RolePrivileges;
import com.loan.service.model.dto.PrivilegeInfoDto;
import com.loan.service.model.dto.RolePrivilegesDto;
import com.loan.service.service.PrivilegeInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author GuoKang
 * @date 2019/7/19 10:48
 */
@Service
public class PrivilegeInfoServiceImpl extends AbstractLoanService<PrivilegeInfo> implements PrivilegeInfoService {
    @Autowired
    private PrivilegeInfoDao privilegeInfoDao;

    // 权限码集合，树状
    private static List<PrivilegeInfoDto> privilegeInfoDtoList = null;

    @Override
    protected ISingleTableDao<PrivilegeInfo> getMyBatisRepository() {
        return privilegeInfoDao;
    }

    @Override
    protected PrivilegeInfo constructPkEntity(Long id) {
        return null;
    }

    @Override
    protected Object getPk(PrivilegeInfo privilegeInfo) {
        return privilegeInfo.getCode();
    }

    @Override
    public RolePrivilegesDto getRolePrivilegesByRoleId(String roleId) {
        RolePrivilegesDto rolePrivilegesDto = new RolePrivilegesDto();
        RolePrivileges rolePrivileges = privilegeInfoDao.getRolePrivilegesByRoleId(roleId);
        if (null == rolePrivileges)
            rolePrivileges = new RolePrivileges() {{
                setRoleId(roleId);
            }};

        BeanUtils.copyProperties(rolePrivileges, rolePrivilegesDto);
        if (!StringUtils.isEmpty(rolePrivileges.getCheckedPrivileges()))
            rolePrivilegesDto.setCheckedPrivileges(JSONArray.parseArray(rolePrivileges.getCheckedPrivileges()));

        return rolePrivilegesDto;
    }

    @Override
    public void updateRolePrivileges(RolePrivilegesDto rolePrivilegesDto) {
        if (null == rolePrivilegesDto || StringUtils.isEmpty(rolePrivilegesDto.getRoleId()))
            return;
        RolePrivileges rolePrivileges = new RolePrivileges();
        BeanUtils.copyProperties(rolePrivilegesDto, rolePrivileges);
        if (null != rolePrivilegesDto.getCheckedPrivileges())
            rolePrivileges.setCheckedPrivileges(JSONArray.toJSONString(rolePrivilegesDto.getCheckedPrivileges()));

        // 存在角色与权限关系时，先删除
        RolePrivileges oldRel = privilegeInfoDao.getRolePrivilegesByRoleId(rolePrivilegesDto.getRoleId());
        if (null != oldRel) privilegeInfoDao.deleteRolePrivilegesByRoleId(rolePrivilegesDto.getRoleId());

        rolePrivileges.setCreateTime(new Date());
        privilegeInfoDao.insertRolePrivileges(rolePrivileges);
    }

    @Override
    public List<PrivilegeInfoDto> getAllPrivileges() {
        if (null == privilegeInfoDtoList) {
            PrivilegeInfo query = new PrivilegeInfo();
            List<PrivilegeInfo> privilegeInfos = this.queryEntityList(query);
            privilegeInfoDtoList = fillPrivilegeInfoDtos(null, privilegeInfos);
        }
        return privilegeInfoDtoList;
    }

    @Override
    public Set<String> getPrivilegesByUserId(Long userId) {
        // 根据UserId 找到所有的权限
        Set<String> privileges = new HashSet<>();
        List<RolePrivileges> rolePrivilegesList = this.privilegeInfoDao.getRolePrivilegesByUserId(userId);
        rolePrivilegesList.forEach(rolePrivileges ->
                privileges.addAll(JSONArray.parseArray(rolePrivileges.getCheckedPrivileges()).toJavaList(String.class)));

        // 遍历找到权限码的所有上级
        List<PrivilegeInfoDto> allPrivileges = this.getAllPrivileges();
        Set<String> parentPrivileges = new HashSet<>();
        for (String privilege : privileges) {
            PrivilegeInfoDto leafNode = findNode(privilege, allPrivileges);
            while (null != leafNode && null != leafNode.getParentCode()) {
                parentPrivileges.add(leafNode.getParentCode());
                leafNode = leafNode.getParent();
            }
        }

        privileges.addAll(parentPrivileges);
        return privileges;
    }

    /**
     * 从权限树中找到目标权限节点
     */
    private PrivilegeInfoDto findNode(String privileges, List<PrivilegeInfoDto> allPrivileges) {
        for (PrivilegeInfoDto privilegeInfoDto : allPrivileges) {
            if (!CollectionUtils.isEmpty(privilegeInfoDto.getChildren())) {
                PrivilegeInfoDto t = findNode(privileges, privilegeInfoDto.getChildren());
                if (null != t) return t;
            }
            if (privileges.equals(privilegeInfoDto.getCode()))
                return privilegeInfoDto;
        }
        return null;
    }

    /**
     * 构建权限树
     */
    private List<PrivilegeInfoDto> fillPrivilegeInfoDtos(PrivilegeInfoDto parentNode, List<PrivilegeInfo> allNodes) {
        List<PrivilegeInfoDto> nodes = new ArrayList<>();
        for (PrivilegeInfo node : allNodes) {
            if ((null == parentNode && null == node.getParentCode())
                    || (null != parentNode && Objects.equals(parentNode.getCode(), node.getParentCode()))) {
                // 当前节点
                PrivilegeInfoDto currentNode = new PrivilegeInfoDto();
                BeanUtils.copyProperties(node, currentNode);
                currentNode.setParent(parentNode);
                currentNode.setChildren(fillPrivilegeInfoDtos(currentNode, allNodes));
                nodes.add(currentNode);
            }
        }
        return nodes;
    }
}
