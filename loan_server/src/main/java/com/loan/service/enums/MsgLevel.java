package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/9/4 11:24
 */
public enum MsgLevel implements BaseEnum {

    NORMAL("普通"),
    IMPORT("重要"),
    EMERGENCY("重要且紧急"),
    ;

    private String desc;

    MsgLevel(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (MsgLevel item : MsgLevel.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
