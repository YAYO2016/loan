package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 职业性质
 *
 * @author GuoKang
 * @date 2019-05-06 22:48
 */
public enum OccuType implements BaseEnum {
    CIVIL_SERVANT("公务员"),
    WITHIN_SYSTEM("事业编制"),
    PRIVATE_OWNERS("私企业主"),
    INDIVIDUAL_OWNERS("个体业主"),
    GENERAL_STAFF("普通职员"),
    ;

    private String desc;

    OccuType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (OccuType item : OccuType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
