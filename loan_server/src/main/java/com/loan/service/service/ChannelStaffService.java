package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.ChannelStaffInfo;

/**
 * @author GuoKang
 * @date 2019-05-04 16:10
 */
public interface ChannelStaffService extends LoanService<ChannelStaffInfo> {
    void clearChannelStaffByChannelId(Long channelId);
}
