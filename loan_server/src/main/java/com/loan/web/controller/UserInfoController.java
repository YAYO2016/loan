package com.loan.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.enums.RoleDict;
import com.loan.service.enums.UserStatus;
import com.loan.service.model.UserInfo;
import com.loan.service.model.dto.UserInfoDto;
import com.loan.service.service.UserInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import com.loan.web.vo.user.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-22 20:24
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("list")
    public JsonData list(@RequestParam(value = "userName", required = false) String userName,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(userName)) params.put("userName", userName);

        LoanPageList<UserInfoDto> userInfoDtoPageList = this.userInfoService.getUserInfoDtoPageList(params, pageAttr);

        return JsonData.getSucceed(userInfoDtoPageList.getDatas(), userInfoDtoPageList.getPageInfo());
    }


    @GetMapping("getSingleUserInfo")
    public JsonData getSingleUserInfo(@RequestParam(value = "userId") Long userId) {
        UserInfoDto userInfoDto = this.userInfoService.getUserInfoDtoById(userId);
        if (null == userInfoDto)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "用户信息信息不存在");
        return JsonData.getSucceed(userInfoDto);
    }

    @PostMapping("addOrUpdateSingleUserInfo")
    public JsonData addOrUpdateSingleUserInfo(@RequestBody UserInfoVo userInfoVo) {
        if (StringUtils.isEmpty(userInfoVo.getLoginAccount()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "登录账号不允许为空");

        if (null != userInfoVo.getUserId()) {
            UserInfo userInfo = this.userInfoService.getEntityById(userInfoVo.getUserId());
            if (null == userInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "用户信息不存在");
        } else {
            // 新增用户需要校验loginAccount
            List<UserInfo> userInfos = this.userInfoService.queryEntityList(new UserInfo() {{
                setLoginAccount(userInfoVo.getLoginAccount());
            }});
            if (userInfos.size() > 0)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "登录账号已存在");
        }

        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(userInfoVo, userInfoDto);
        // 创建人ID
        userInfoDto.setCreateUserId(LoginInfoHolder.getUserId());

        if (CollectionUtils.isEmpty(userInfoDto.getRoles()) || !userInfoDto.getRoles().contains(RoleDict.R0201.toString()))
            userInfoDto.setBusinessUsers(new JSONArray());// 没有签单角色时，清空渠道专员字段

        this.userInfoService.saveSingleUserInfo(userInfoDto);
        return JsonData.getSucceed();
    }

    @PostMapping("updateUserStatus")
    public JsonData updateUserStatus(@RequestBody UserInfoVo userInfoVo) {
        if (null == userInfoVo.getUserId() || null == userInfoVo.getUserStatus())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);
        UserInfo userInfo = this.userInfoService.getEntityById(userInfoVo.getUserId());
        if (null == userInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "用户信息不存在");

        this.userInfoService.updateUserStatus(userInfoVo.getUserId(), userInfoVo.getUserStatus());
        return JsonData.getSucceed();
    }

    @GetMapping("listRoleUser")
    public JsonData list(@RequestParam(value = "roleDict") RoleDict roleDict) {
        List<UserInfo> userInfoList = this.userInfoService.getUserListByRoleDict(roleDict);
        return JsonData.getSucceed(userInfoList);
    }

    /**
     * 获取当前登录人绑定的渠道专员
     */
    @GetMapping("getBusinessUser")
    public JsonData getBusinessUser() {
        UserInfoDto userInfoDto = LoginInfoHolder.getUserInfoDto();
        if (null == userInfoDto) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_100, "当前登录人信息不存在，请重新登录");
        if (!userInfoDto.getRoles().contains(RoleDict.R0201.toString()))
            return JsonData.getSucceed(new ArrayList<UserInfo>() {{
                add(userInfoDto);
            }});

        return JsonData.getSucceed(this.userInfoService.getUserByUserId(userInfoDto.getBusinessUsers()));
    }

    /**
     * 修改当前登录人的密码
     *
     * @param userInfoVo
     * @return
     */
    @PostMapping("modifyPassword")
    public JsonData modifyPassword(@RequestBody UserInfoVo userInfoVo) {
        if (null == userInfoVo.getUserPw()) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);
        UserInfo userInfo = this.userInfoService.getEntityById(LoginInfoHolder.getUserId());
        if (null == userInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "用户信息不存在");

        this.userInfoService.modifyPassword(userInfo.getUserId(), userInfoVo.getUserPw());
        return JsonData.getSucceed();
    }

    /**
     * 修改当前登录人的密码
     *
     * @return
     */
    @GetMapping("getUserByOrgId")
    public JsonData getUserByOrgId(@RequestParam(value = "orgId") Long orgId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setOrgId(orgId);
        List<UserInfo> userInfoList = this.userInfoService.queryEntityList(userInfo);
        return JsonData.getSucceed(userInfoList);
    }
}
