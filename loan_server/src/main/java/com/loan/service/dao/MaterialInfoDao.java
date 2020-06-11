package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.MaterialInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/25 11:14
 */
@Component
public interface MaterialInfoDao extends LoanDao<MaterialInfo> {
    Integer countMaterialInfo(Map<String, Object> params);

    List<MaterialInfo> listMaterialInfo(Map<String, Object> params);
}
