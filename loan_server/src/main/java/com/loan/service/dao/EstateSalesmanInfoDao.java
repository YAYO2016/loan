package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.EstateSalesmanInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author GuoKang
 * @date 2019/4/26 10:30
 */
@Component
public interface EstateSalesmanInfoDao extends LoanDao<EstateSalesmanInfo> {
    void deleteSalesmanInfoByEstateId(@Param("estateId") Long estateId);
}
