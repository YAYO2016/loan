package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.CaseLoanInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author GuoKang
 * @date 2019-05-06 21:48
 */
@Component
public interface CaseLoanInfoDao extends LoanDao<CaseLoanInfo> {
    void clearReserveInfoByCaseId(@Param("caseId") Long caseId);

    void clearCommercialInfoByCaseId(@Param("caseId") Long caseId);
}
