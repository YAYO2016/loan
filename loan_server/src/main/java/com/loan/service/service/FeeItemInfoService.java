package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.FeeItemInfo;

import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 16:16
 */
public interface FeeItemInfoService extends LoanService<FeeItemInfo> {
    LoanPageList<FeeItemInfo> getFeeItemInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    void saveFeeItemInfo(FeeItemInfo feeItemInfo);
}
