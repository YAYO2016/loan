package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.BranchInfo;
import com.loan.service.model.dto.BranchInfoDto;

import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 10:58
 */
public interface BranchInfoService extends LoanService<BranchInfo> {
    LoanPageList<BranchInfoDto> getBranchInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    void saveSingleBranch(BranchInfoDto branchInfoDto);

    Integer countBranchCases(Long branchId);
}
