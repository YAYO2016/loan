package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-20 20:27
 */
public enum ChannelType implements BaseEnum {
//    DEFAULT("无"),
    AGENCY("中介"),
    PEER("同行"),
    ;

    private String desc;

    ChannelType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public List listAll() {
        List<Map<String,String>> list = new ArrayList<>();
        for (ChannelType channelType : ChannelType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", channelType.toString());
            map.put("desc", channelType.getDesc());
            list.add(map);
        }
        return list;
    }
}
