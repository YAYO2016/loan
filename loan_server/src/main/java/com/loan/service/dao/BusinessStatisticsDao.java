package com.loan.service.dao;

import com.loan.service.model.dto.CaseCountChartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-05-30 19:57
 */
@Component
public interface BusinessStatisticsDao {
    List<CaseCountChartDto> getCasesCount(Map<String, Object> params);
}
