package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.OrganizationInfo;
import com.loan.service.model.dto.OrganizationInfoDto;
import com.loan.service.model.dto.UserInfoDto;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-19 00:39
 */
public interface OrganizationInfoService extends LoanService<OrganizationInfo> {
    LoanPageList<OrganizationInfoDto> getOrganizationInfoLoanPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    Integer countOrgUsers(Long orgId);

    OrganizationInfoDto getOrganizationInfoDtoById(Long orgId);

    void saveSingleOrganization(OrganizationInfoDto organizationInfoDto, List<UserInfoDto> userInfoDtoList);
}
