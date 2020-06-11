package com.loan.web.controller;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.model.OrganizationInfo;
import com.loan.service.model.dto.OrganizationInfoDto;
import com.loan.service.service.OrganizationInfoService;
import com.loan.service.service.UserInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.vo.org.OrganizationInfoPageVo;
import com.loan.web.vo.org.OrganizationInfoVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-21 20:54
 */
@RestController
@RequestMapping("/org")
public class OrganizationInfoController {
    private Logger logger = LoggerFactory.getLogger(OrganizationInfoController.class);

    @Autowired
    private OrganizationInfoService organizationInfoService;
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("list")
    public JsonData list(@RequestParam(value = "orgId", required = false) Long orgId,
                         @RequestParam(value = "orgName", required = false) String orgName,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (null != orgId) params.put("orgId", orgId);
        if (!StringUtils.isEmpty(orgName)) params.put("orgName", orgName);

        LoanPageList<OrganizationInfoDto> organizationInfoLoanPageList = this.organizationInfoService.getOrganizationInfoLoanPageList(params, pageAttr);

        List<OrganizationInfoPageVo> pageVoList = new ArrayList<>();
        for (OrganizationInfo from : organizationInfoLoanPageList.getDatas()) {
            OrganizationInfoPageVo pageVo = new OrganizationInfoPageVo();
            BeanUtils.copyProperties(from, pageVo);
            pageVoList.add(pageVo);
        }

        this.getOrgUserCountForList(pageVoList);
        return JsonData.getSucceed(pageVoList, organizationInfoLoanPageList.getPageInfo());
    }

    @GetMapping("getSingleOrganization")
    public JsonData getSingleOrganization(@RequestParam(value = "orgId") Long orgId) {
        OrganizationInfoDto organizationInfoDto = this.organizationInfoService.getOrganizationInfoDtoById(orgId);
        if (null == organizationInfoDto)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "组织机构信息不存在");
        OrganizationInfoVo organizationInfoVo = new OrganizationInfoVo();
        BeanUtils.copyProperties(organizationInfoDto, organizationInfoVo);

        // 放入该组织机构下的用户信息
        organizationInfoVo.setUserInfoList(userInfoService.getUserInfoDtoByOrgId(orgId));
        return JsonData.getSucceed(organizationInfoVo);
    }

    @PostMapping("addOrUpdateSingleOrganization")
    public JsonData addOrUpdateSingleOrganization(@RequestBody OrganizationInfoVo organizationInfoVo) {
        if (null != organizationInfoVo.getOrgId()) {
            OrganizationInfo orgInfo = this.organizationInfoService.getEntityById(organizationInfoVo.getOrgId());
            if (null == orgInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "组织机构信息不存在");
        }

        OrganizationInfoDto organizationInfoDto = new OrganizationInfoDto();
        BeanUtils.copyProperties(organizationInfoVo, organizationInfoDto);
        this.organizationInfoService.saveSingleOrganization(organizationInfoDto, organizationInfoVo.getUserInfoList());
        return JsonData.getSucceed();
    }

    @PostMapping("deleteOrganization")
    public JsonData deleteOrganization(@RequestBody OrganizationInfoVo organizationInfoVo) {
        if (null == organizationInfoVo.getOrgId()) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);
        OrganizationInfo orgInfo = this.organizationInfoService.getEntityById(organizationInfoVo.getOrgId());
        if (null == orgInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "组织机构信息不存在");

        if (this.organizationInfoService.countOrgUsers(orgInfo.getOrgId()) > 0)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "组织机构下已有用户，不允许删除");

        this.organizationInfoService.deleteEntityById(orgInfo.getOrgId());
        return JsonData.getSucceed();
    }

    /**
     * 获取组织机构下的用户数
     *
     * @param organizationInfoPageVoList
     */
    private void getOrgUserCountForList(List<OrganizationInfoPageVo> organizationInfoPageVoList) {
        organizationInfoPageVoList.forEach(vo -> vo.setUserCount(this.organizationInfoService.countOrgUsers(vo.getOrgId())));
    }
    
    @GetMapping("orgList")
    public JsonData list() {
    	OrganizationInfo queryOrganizationInfo = new OrganizationInfo();
        List<OrganizationInfo> organizationInfoList = this.organizationInfoService.queryEntityList(queryOrganizationInfo);
        return JsonData.getSucceed(CollectionUtils.isEmpty(organizationInfoList) ? new ArrayList<>() : organizationInfoList);
    }
    
    
}
