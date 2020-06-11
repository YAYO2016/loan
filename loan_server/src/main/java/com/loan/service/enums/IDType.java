package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 证件类型
 *
 * @author GuoKang
 * @date 2019-05-06 22:46
 */
public enum IDType implements BaseEnum {
    ID_CARD("身份证"),
    MILITARY_OFFICER("军官证"),
    GAT_CARD("港澳台"),
    PASSPORT("护照"),
    ;

    private String desc;

    IDType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (IDType item : IDType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
