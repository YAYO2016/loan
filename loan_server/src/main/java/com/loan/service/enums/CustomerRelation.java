package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 干系人与客户关系
 *
 * @author GuoKang
 * @date 2019-05-05 22:54
 */
public enum CustomerRelation implements BaseEnum {
    SPOUSES("夫妻"),
    RELATIVES("亲属"),
    NON_RELATIVES("非亲属"),
    ;

    private String desc;

    CustomerRelation(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (CustomerRelation item : CustomerRelation.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
