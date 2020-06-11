package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.BranchInfo;
import com.loan.service.model.dto.BranchInfoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 10:53
 */
@Component
public interface BranchInfoDao extends LoanDao<BranchInfo> {
    Integer countBranchInfoDto(Map<String, Object> params);

    List<BranchInfoDto> listBranchInfoDto(Map<String, Object> params);
}
