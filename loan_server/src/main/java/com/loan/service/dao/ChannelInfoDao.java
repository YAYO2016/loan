package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.ChannelInfo;
import com.loan.service.model.dto.ChannelInfoDto;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-19 00:12
 */
@Component
public interface ChannelInfoDao extends LoanDao<ChannelInfo> {
    Integer countChannelInfo(Map<String, Object> params);

    List<ChannelInfo> listChannelInfo(Map<String, Object> params);
    
    void deleteCaseRel(Map<String, Object>  param);
    
    void saveCaseRel(Map<String, Object>  param);

    List<Map<String, Object>> areaName();
    
}
