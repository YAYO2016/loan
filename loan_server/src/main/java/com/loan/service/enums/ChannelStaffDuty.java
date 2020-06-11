package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-05-04 16:25
 */
public enum ChannelStaffDuty implements BaseEnum {
    WARRANT("权证"),
    AGENT("业务员"),
    ;

    private String desc;

    ChannelStaffDuty(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (ChannelStaffDuty channelStaffDuty : ChannelStaffDuty.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", channelStaffDuty.toString());
            map.put("desc", channelStaffDuty.getDesc());
            list.add(map);
        }
        return list;
    }
}
