package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.EstateSalesmanInfo;

/**
 * @author GuoKang
 * @date 2019/4/26 10:53
 */
public interface EstateSalesmanInfoService extends LoanService<EstateSalesmanInfo> {
    void deleteSalesmanInfoByEstateId(Long estateId);
}
