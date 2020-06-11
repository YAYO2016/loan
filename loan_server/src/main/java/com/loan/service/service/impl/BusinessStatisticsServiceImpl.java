package com.loan.service.service.impl;

import com.loan.framework.utils.DateUtil;
import com.loan.service.dao.BusinessStatisticsDao;
import com.loan.service.dao.CaseBaseInfoDao;
import com.loan.service.enums.RoleDict;
import com.loan.service.model.CaseBaseInfo;
import com.loan.service.model.dto.CaseCountChartDto;
import com.loan.service.service.BusinessStatisticsService;
import com.loan.service.service.CaseBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-05-30 19:57
 */
@Service
public class BusinessStatisticsServiceImpl implements BusinessStatisticsService {

    @Autowired
    private CaseBaseInfoDao caseBaseInfoDao;
    @Autowired
    private BusinessStatisticsDao businessStatisticsDao;

    @Override
    public List<CaseCountChartDto> getCasesCount(Map<String, Object> params) {
        return businessStatisticsDao.getCasesCount(params);
    }

    @Override
    public Map<String, Object> getCasesCountForBlock(Map<String, Object> params, Long userId, List<String> userRoles) {
        Map<String, Object> resultMap = this.getDefaultCountMap();

        if (userRoles.contains(RoleDict.R0201.toString())) {
            // 签单  不要更改下面代码的顺序
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("userId", userId);
            queryParams.put("pageType", 2);
            resultMap.put("c11", caseBaseInfoDao.countCasePageInfo(queryParams));// 签单总数
            queryParams.put("startDate", DateUtil.getCurrentMonthFirstDate());
            queryParams.put("endDate", DateUtil.getCurrentMonthLastDate());
            resultMap.put("c12", caseBaseInfoDao.countCasePageInfo(queryParams));// 当月签单数
            queryParams.put("startDate", null);
            queryParams.put("endDate", null);
            queryParams.put("ifClose", 1);
            resultMap.put("c13", caseBaseInfoDao.countCasePageInfo(queryParams));// 进行中
            queryParams.put("ifClose", 2);
            resultMap.put("c14", caseBaseInfoDao.countCasePageInfo(queryParams));// 完成
            queryParams.put("pageType", 1);
            resultMap.put("c15", caseBaseInfoDao.countCasePageInfo(queryParams));// 待办任务
        } else {
            // 非签单 不要更改下面代码的顺序
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("userId", userId);
            queryParams.put("pageType", 3);
            resultMap.put("c21", caseBaseInfoDao.countAllMyCasePageInfo(queryParams));// 审核案子总数
            queryParams.put("startDate", DateUtil.getCurrentMonthFirstDate());
            queryParams.put("endDate", DateUtil.getCurrentMonthLastDate());
            resultMap.put("c22",  caseBaseInfoDao.countAllMyCasePageInfo(queryParams));// 当月审核案子数
            queryParams.put("startDate", null);
            queryParams.put("endDate", null);
            resultMap.put("c23", "-");// 当月收入
            queryParams.put("pageType", 1);
            resultMap.put("c24", caseBaseInfoDao.countCasePageInfo(queryParams));// 待办任务
        }

        return resultMap;
    }

    private Map<String, Object> getDefaultCountMap() {
        Map<String, Object> resultMap = new HashMap<>();

        // 工作台-签单人员
        resultMap.put("c11", 0);// 签单总数
        resultMap.put("c12", 0);// 当月签单数
        resultMap.put("c13", 0);// 进行中
        resultMap.put("c14", 0);// 完成
        resultMap.put("c15", 0);// 待办任务

        // 工作台-风控/财务
        resultMap.put("c21", 0);// 审核案子总数
        resultMap.put("c22", 0);// 当月审核案子数
        resultMap.put("c23", "——");// 当月收入
        resultMap.put("c24", 0);// 待办任务
        return resultMap;
    }


}
