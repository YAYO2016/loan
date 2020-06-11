package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.ChannelInfo;
import com.loan.service.model.dto.CaseCfgInfoDto;
import com.loan.service.model.dto.ChannelInfoDto;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-19 00:39
 */
public interface ChannelInfoService extends LoanService<ChannelInfo> {
    LoanPageList<ChannelInfo> getChannelInfoLoanPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    Integer countChannelCases(Long channelId);

    ChannelInfoDto getChannelInfoDtoById(Long channelId);

    void saveSingleChannel(ChannelInfoDto channelInfoDto);

    void deleteChannelById(Long channelId);
    
    void saveCaseRel(Map<String, Object>  param);
    
     List<Map<String, Object>> areaName();

}
