package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.enums.CaseCfgType;
import com.loan.service.model.CaseCfgInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-10 22:30
 */
@Component
public interface CaseCfgInfoDao extends LoanDao<CaseCfgInfo> {
    void clearCaseCfgInfo(@Param("caseId") Long caseId, @Param("caseCfgTypes") List<CaseCfgType> caseCfgTypes);
}
