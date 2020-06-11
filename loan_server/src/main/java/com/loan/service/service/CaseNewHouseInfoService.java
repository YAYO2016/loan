package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.CaseNewHouseInfo;

/**
 * @author GuoKang
 * @date 2019-05-06 22:17
 */
public interface CaseNewHouseInfoService extends LoanService<CaseNewHouseInfo> {
    void saveNewHouseInfo(CaseNewHouseInfo caseNewHouseInfo);
}
