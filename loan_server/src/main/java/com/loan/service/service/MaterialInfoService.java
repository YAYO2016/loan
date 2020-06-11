package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.MaterialInfo;

import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/25 11:15
 */
public interface MaterialInfoService extends LoanService<MaterialInfo> {
    LoanPageList<MaterialInfo> getMaterialInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    void saveSingleMaterial(MaterialInfo materialInfo);

}
