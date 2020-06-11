package com.loan.web.controller;

import com.loan.service.enums.RoleDict;
import com.loan.service.model.UserInfo;
import com.loan.service.model.dto.CaseCountBlockDto;
import com.loan.service.model.dto.CaseCountChartDto;
import com.loan.service.service.BusinessStatisticsService;
import com.loan.service.service.UserInfoService;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import com.loan.web.vo.business.CaseCountChartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author GuoKang
 * @date 2019-05-28 23:10
 */
@RestController
@RequestMapping("businessOverview")
public class BusinessOverviewController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private BusinessStatisticsService businessStatisticsService;

    /**
     * 获取柱状统计图
     *
     * @param type      1:个人;2:部门 不可为空
     * @param period    1:日;2:周;3:月;4:季度;5:年;可空 默认月
     * @param startDate 开始时间 不可为空
     * @param endDate   结束时间 不可为空
     * @return
     */
    @GetMapping("getCasesCount")
    public JsonData getCasesCount(@RequestParam("type") Integer type,
                                  @RequestParam(value = "period", required = false) Integer period,
                                  @RequestParam("startDate") Date startDate,
                                  @RequestParam("endDate") Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("userIds", Arrays.asList(LoginInfoHolder.getUserId()));
        if (2 == type) {
            UserInfo userInfo = userInfoService.getEntityById(LoginInfoHolder.getUserId());
            List<UserInfo> userInfos = userInfoService.getUserInfoByOrgId(userInfo.getOrgId());
            params.put("userIds", userInfos.stream().map(UserInfo::getUserId).collect(Collectors.toList()));
        }
        period = null == period ? 3 : period;
        params.put("period", period);
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        List<CaseCountChartDto> caseCountChartDtos = this.businessStatisticsService.getCasesCount(params);

        List<CaseCountChartVo> caseCountChartVos = new ArrayList<>();
        for (CaseCountChartDto dto : caseCountChartDtos) {
            CaseCountChartVo chartVo = new CaseCountChartVo();
            chartVo.setTime(dto.getPeriod());
            chartVo.setCaseCount(dto.getCaseCount());
            caseCountChartVos.add(chartVo);
        }

        return JsonData.getSucceed(caseCountChartVos);
    }


    /**
     * 获取个人或部门的方块数据统计
     *
     * @param type 1:个人;2:部门 不可为空
     * @return
     */
    @GetMapping("getCasesCountBlock")
    public JsonData getCasesCountForBlock(@RequestParam("type") Integer type) {
        Map<String, Object> params = new HashMap<>();
        params.put("userIds", Arrays.asList(LoginInfoHolder.getUserId()));
        if (2 == type) {
            UserInfo userInfo = userInfoService.getEntityById(LoginInfoHolder.getUserId());
            List<UserInfo> userInfos = userInfoService.getUserInfoByOrgId(userInfo.getOrgId());
            params.put("userIds", userInfos.stream().map(UserInfo::getUserId).collect(Collectors.toList()));
        }


        Map<String, Object> caseCountBlockDtoList = this.businessStatisticsService.getCasesCountForBlock(params,
                LoginInfoHolder.getUserId(),
                LoginInfoHolder.getUserRoles());
        return JsonData.getSucceed(caseCountBlockDtoList);
    }
}
