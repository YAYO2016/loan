package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.ChannelStaffInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author GuoKang
 * @date 2019-05-04 16:09
 */
@Component
public interface ChannelStaffDao extends LoanDao<ChannelStaffInfo> {
    void clearChannelStaffByChannelId(@Param("channelId") Long channelId);
}
