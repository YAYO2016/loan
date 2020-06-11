package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.CaseSecondHandHouseInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author GuoKang
 * @date 2019-05-06 22:31
 */
@Component
public interface CaseSecondHandHouseInfoDao extends LoanDao<CaseSecondHandHouseInfo> {
    void clearBDCNo(@Param("caseId") Long caseId);

    void clearCQZAndTDZ(@Param("caseId") Long caseId);
}
