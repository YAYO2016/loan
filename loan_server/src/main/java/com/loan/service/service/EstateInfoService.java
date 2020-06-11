package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.EstateInfo;
import com.loan.service.model.dto.EstateInfoDto;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/26 10:53
 */
public interface EstateInfoService extends LoanService<EstateInfo> {
    LoanPageList<EstateInfoDto> getDeveloperEstateInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    List<EstateInfoDto> getEstateInfoDto(Long developerId);

    void saveEstateInfoDto(Long developerId, EstateInfoDto estateInfoDto);

    void clearEstateInfo(Long developerId);

    void deleteEstateInfoById(Long estateId);
}
