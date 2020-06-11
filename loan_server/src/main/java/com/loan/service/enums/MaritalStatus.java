package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 婚姻状态
 *
 * @author GuoKang
 * @date 2019-05-05 22:05
 */
public enum MaritalStatus implements BaseEnum {
    BACHELOR("单身"),
    MARRIED("已婚"),
    DIVORCED("离异"),
    ;

    private String desc;

    MaritalStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (MaritalStatus item : MaritalStatus.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
