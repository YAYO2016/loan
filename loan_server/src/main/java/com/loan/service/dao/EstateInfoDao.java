package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.EstateInfo;
import com.loan.service.model.dto.EstateInfoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/26 10:38
 */
@Component
public interface EstateInfoDao extends LoanDao<EstateInfo> {
    Integer countEstateInfoDto(Map<String, Object> params);

    List<EstateInfoDto> listEstateInfoDto(Map<String, Object> params);
}
