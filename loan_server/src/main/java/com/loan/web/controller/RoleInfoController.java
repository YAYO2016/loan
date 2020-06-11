package com.loan.web.controller;

import com.loan.service.model.RoleInfo;
import com.loan.service.model.RolePrivileges;
import com.loan.service.model.dto.RolePrivilegesDto;
import com.loan.service.service.PrivilegeInfoService;
import com.loan.service.service.RoleInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-22 23:30
 */
@RestController
@RequestMapping("/role")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PrivilegeInfoService privilegeInfoService;

    @GetMapping("listAll")
    public JsonData listAll() {
        RoleInfo roleInfo = new RoleInfo();
        List<RoleInfo> roleInfoList = this.roleInfoService.queryEntityList(roleInfo);
        return JsonData.getSucceed(CollectionUtils.isEmpty(roleInfoList) ? new ArrayList<>() : roleInfoList);
    }

    @GetMapping("getRoleInfo")
    public JsonData getRoleInfo(@RequestParam("roleId") String roleId) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(roleId);
        List<RoleInfo> roleInfoList = this.roleInfoService.queryEntityList(roleInfo);
        if (CollectionUtils.isEmpty(roleInfoList))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "角色不存在");

        return JsonData.getSucceed(roleInfoList.get(0));
    }

    @PostMapping("updateRoleInfo")
    public JsonData updateRoleInfo(@RequestBody RoleInfo roleInfo) {
        if (StringUtils.isEmpty(roleInfo.getRoleId()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "角色ID不能为空");
        if (StringUtils.isEmpty(roleInfo.getRoleName()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "角色名称不能为空");

        this.roleInfoService.modifyEntityById(roleInfo);
        return JsonData.getSucceed();
    }

    @GetMapping("getRolePrivileges")
    public JsonData getRolePrivileges(@RequestParam("roleId") String roleId) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(roleId);
        List<RoleInfo> roleInfoList = this.roleInfoService.queryEntityList(roleInfo);
        if (CollectionUtils.isEmpty(roleInfoList))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "角色不存在");

        return JsonData.getSucceed(privilegeInfoService.getRolePrivilegesByRoleId(roleId));
    }

    @PostMapping("updateRolePrivileges")
    public JsonData updateRolePrivileges(@RequestBody RolePrivilegesDto rolePrivilegesDto) {
        if (StringUtils.isEmpty(rolePrivilegesDto.getRoleId()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "角色ID不能为空");

        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleId(rolePrivilegesDto.getRoleId());
        List<RoleInfo> roleInfoList = this.roleInfoService.queryEntityList(roleInfo);
        if (CollectionUtils.isEmpty(roleInfoList))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "角色不存在");

        privilegeInfoService.updateRolePrivileges(rolePrivilegesDto);
        return JsonData.getSucceed();
    }

    @GetMapping("getAllPrivileges")
    public JsonData getAllPrivileges() {
        return JsonData.getSucceed(privilegeInfoService.getAllPrivileges());
    }
}
