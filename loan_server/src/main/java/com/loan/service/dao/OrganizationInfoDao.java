package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.OrganizationInfo;
import com.loan.service.model.dto.OrganizationInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-21 20:08Ø
 */
@Component
public interface OrganizationInfoDao extends LoanDao<OrganizationInfo> {
    Integer countOrganizationInfo(Map<String, Object> params);

    List<OrganizationInfoDto> listOrganizationInfo(Map<String, Object> params);

    OrganizationInfoDto getOrganizationInfoDtoById(@Param("orgId") Long orgId);
}
