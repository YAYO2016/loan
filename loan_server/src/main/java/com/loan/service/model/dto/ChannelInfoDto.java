package com.loan.service.model.dto;

import com.loan.service.model.ChannelInfo;
import com.loan.service.model.ChannelStaffInfo;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-20 18:57
 */
public class ChannelInfoDto extends ChannelInfo {
    private List<ChannelStaffInfo> staffInfos;

    public List<ChannelStaffInfo> getStaffInfos() {
        return staffInfos;
    }

    public void setStaffInfos(List<ChannelStaffInfo> staffInfos) {
        this.staffInfos = staffInfos;
    }
}
