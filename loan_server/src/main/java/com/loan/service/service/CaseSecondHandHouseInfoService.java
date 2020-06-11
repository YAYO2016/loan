package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.enums.PropertyRightsType;
import com.loan.service.model.CaseSecondHandHouseInfo;

/**
 * @author GuoKang
 * @date 2019-05-06 22:35
 */
public interface CaseSecondHandHouseInfoService extends LoanService<CaseSecondHandHouseInfo> {
    void saveCaseSecondHandHouseInfo(CaseSecondHandHouseInfo caseSecondHandHouseInfo);

    void clearPropertyRightNo(Long caseId, PropertyRightsType propertyRightsType);
}
