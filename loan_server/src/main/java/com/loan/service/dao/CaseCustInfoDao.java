package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.enums.CaseCustomerType;
import com.loan.service.model.CaseCustInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-05-06 23:14
 */
@Component
public interface CaseCustInfoDao extends LoanDao<CaseCustInfo> {
    void deleteEntityByCustType(Map<String, Object> params);
}
