package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.ChannelStaffDao;
import com.loan.service.model.ChannelStaffInfo;
import com.loan.service.service.ChannelStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuoKang
 * @date 2019-05-04 16:11
 */
@Service
public class ChannelStaffServiceImpl extends AbstractLoanService<ChannelStaffInfo> implements ChannelStaffService {

    @Autowired
    private ChannelStaffDao channelStaffDao;

    @Override
    protected ISingleTableDao<ChannelStaffInfo> getMyBatisRepository() {
        return channelStaffDao;
    }

    @Override
    protected ChannelStaffInfo constructPkEntity(Long id) {
        return new ChannelStaffInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(ChannelStaffInfo channelStaffInfo) {
        return channelStaffInfo.getChannelId();
    }

    @Override
    public void clearChannelStaffByChannelId(Long channelId) {
        this.channelStaffDao.clearChannelStaffByChannelId(channelId);
    }
}
