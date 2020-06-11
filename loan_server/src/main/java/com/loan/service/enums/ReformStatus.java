package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 是否整改
 *
 * @author GuoKang
 * @date 2019-05-06 22:05
 */
public enum ReformStatus implements BaseEnum {
    NON_REFORM("未整改"),
    REFORM("整改"),
    ;

    private String desc;

    ReformStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (ReformStatus item : ReformStatus.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
