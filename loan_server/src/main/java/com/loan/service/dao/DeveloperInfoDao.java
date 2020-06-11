package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.DeveloperInfo;
import com.loan.service.model.dto.DeveloperInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author GuoKang
 * @date 2019/4/26 10:48
 */
@Component
public interface DeveloperInfoDao extends LoanDao<DeveloperInfo> {
    DeveloperInfoDto getDeveloperInfoDto(@Param("developerId") Long developerId);
}
