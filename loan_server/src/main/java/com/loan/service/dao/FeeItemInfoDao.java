package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.FeeItemInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 16:15
 */
@Component
public interface FeeItemInfoDao extends LoanDao<FeeItemInfo> {
    Integer countFeeItemInfo(Map<String, Object> params);

    List<FeeItemInfo> listFeeItemInfo(Map<String, Object> params);
}
