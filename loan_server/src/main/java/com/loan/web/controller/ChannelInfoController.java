package com.loan.web.controller;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.enums.ChannelType;
import com.loan.service.model.ChannelInfo;
import com.loan.service.model.dto.ChannelInfoDto;
import com.loan.service.service.ChannelInfoService;
import com.loan.service.service.UserInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import com.loan.web.vo.channel.ChannelInfoPageVo;
import com.loan.web.vo.channel.ChannelInfoVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/19 15:52
 */
@RestController
@RequestMapping("/channel")
public class ChannelInfoController {

    private Logger logger = LoggerFactory.getLogger(ChannelInfoController.class);

    @Autowired
    private ChannelInfoService channelInfoService;
    @Autowired
    private UserInfoService  userInfoService;

    @GetMapping("list")
    public JsonData list(@RequestParam(value = "channelName", required = false) String channelName,
                         @RequestParam(value = "channelType", required = false) ChannelType channelType,
                         @RequestParam(value = "createUserName", required = false) String createUserName,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(channelName)) params.put("channelName", channelName);
        if (null != channelType) params.put("channelType", channelType);
        if (!StringUtils.isEmpty(createUserName)) params.put("createUserName", createUserName);

        
        boolean flag=true;
        for(String roleId:LoginInfoHolder.getUserRoles()){
        	if("R0101".equals(roleId)){
        		flag=false;
        	}
        }
        
        if (flag) params.put("createUser", LoginInfoHolder.getUserId());
        
        LoanPageList<ChannelInfo> channelInfoLoanPageList = this.channelInfoService.getChannelInfoLoanPageList(params, pageAttr);

        List<ChannelInfoPageVo> voList = new ArrayList<>();
        for (ChannelInfo from : channelInfoLoanPageList.getDatas()) {
            ChannelInfoPageVo pageVo = new ChannelInfoPageVo();
            BeanUtils.copyProperties(from, pageVo);
            voList.add(pageVo);
        }

        this.getChannelInfoCaseCountForList(voList);
        return JsonData.getSucceed(voList, channelInfoLoanPageList.getPageInfo());
    }

    @GetMapping("getSingleChannel")
    public JsonData getSingleChannel(@RequestParam(value = "channelId") Long channelId) {
        ChannelInfoDto channelInfoDto = this.channelInfoService.getChannelInfoDtoById(channelId);
        if (null == channelInfoDto)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "渠道信息不存在");

        ChannelInfoVo channelInfoVo = new ChannelInfoVo();
        BeanUtils.copyProperties(channelInfoDto, channelInfoVo);

        return JsonData.getSucceed(channelInfoVo);
    }

    @PostMapping("addOrUpdateSingleChannel")
    public JsonData addOrUpdateSingleChannel(@RequestBody ChannelInfoVo channelInfoVo) {
        if (null != channelInfoVo.getChannelId()) {
            ChannelInfo channelInfo = this.channelInfoService.getEntityById(channelInfoVo.getChannelId());
            if (null == channelInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "渠道信息不存在");
        }

        ChannelInfoDto channelInfoDto = new ChannelInfoDto();
        BeanUtils.copyProperties(channelInfoVo, channelInfoDto);
        channelInfoDto.setCreateUserName(userInfoService.getUserInfoDtoById(LoginInfoHolder.getUserId()).getUserName());
        channelInfoDto.setCreateUser(LoginInfoHolder.getUserId());
        
        this.channelInfoService.saveSingleChannel(channelInfoDto);
        return JsonData.getSucceed();
    }

    @PostMapping("deleteChannel")
    public JsonData deleteChannel(@RequestBody ChannelInfoVo channelInfoVo) {
        if (null == channelInfoVo.getChannelId()) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);
        ChannelInfo channelInfo = this.channelInfoService.getEntityById(channelInfoVo.getChannelId());
        if (null == channelInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "渠道信息不存在");

        this.channelInfoService.deleteChannelById(channelInfo.getChannelId());
        return JsonData.getSucceed();
    }

    /**
     * 获取每个渠道的案子数
     *
     * @param channelInfoPageVoList
     */
    private void getChannelInfoCaseCountForList(List<ChannelInfoPageVo> channelInfoPageVoList) {
        channelInfoPageVoList.forEach(pageVo -> pageVo.setCaseCount(this.channelInfoService.countChannelCases(pageVo.getChannelId())));
    }
    
    
    
    /**
     * 地区名称下拉框
     * @param 
     * @return
     */
    @GetMapping("areaName")
    public JsonData areaName() {
    	List<Map<String, Object>>  list=channelInfoService.areaName();
        return JsonData.getSucceed(list);
    }
    
}
