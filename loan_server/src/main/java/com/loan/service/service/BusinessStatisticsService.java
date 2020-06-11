package com.loan.service.service;

import com.loan.service.model.dto.CaseCountChartDto;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-05-30 19:56
 */
public interface BusinessStatisticsService {
    List<CaseCountChartDto> getCasesCount(Map<String, Object> params);

    Map<String, Object> getCasesCountForBlock(Map<String, Object> params, Long userId, List<String> userRoles);
}
