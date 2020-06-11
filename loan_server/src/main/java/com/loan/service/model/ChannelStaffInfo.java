package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.ChannelStaffDuty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-05-04 15:59
 */
public class ChannelStaffInfo extends AbsPojoSetPk implements Serializable {
    private Long staffId; // 对接人ID
    private Long channelId; // 渠道ID
    private String staffName; // 对接人姓名
    private String staffTel; // 对接人电话
    private ChannelStaffDuty staffDuty; // 对接人职务
    private Date createTime; // 创建时间

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTel() {
        return staffTel;
    }

    public void setStaffTel(String staffTel) {
        this.staffTel = staffTel;
    }

    public ChannelStaffDuty getStaffDuty() {
        return staffDuty;
    }

    public void setStaffDuty(ChannelStaffDuty staffDuty) {
        this.staffDuty = staffDuty;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setPk(Long pk) {
        setStaffId(pk);
    }
}
