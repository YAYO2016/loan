package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.DeveloperInfo;
import com.loan.service.model.dto.DeveloperInfoDto;

/**
 * @author GuoKang
 * @date 2019/4/26 10:54
 */
public interface DeveloperInfoService extends LoanService<DeveloperInfo> {
    DeveloperInfoDto getDeveloperInfoDto(Long developerId);

    void saveDeveloperInfoDto(DeveloperInfoDto developerInfoDto);

}
