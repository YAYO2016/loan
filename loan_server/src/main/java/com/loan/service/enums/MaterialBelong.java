package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/25 11:01
 */
public enum MaterialBelong implements BaseEnum {
    BUYER("主贷人"),
    BUYER_SPOUSE("主贷人配偶"),
    CO_BUYER("共还人"),
    CO_BUYER_SPOUSE("共还人配偶"),
    SELLER("出售方"),
    SELLER_SPOUSE("出售方配偶"),
    CO_SELLER("共有人"),
    CO_SELLER_SPOUSE("共有人配偶"),
    ;

    private String desc;

    MaterialBelong(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (MaterialBelong item : MaterialBelong.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
