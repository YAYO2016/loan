package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 还款方式
 *
 * @author GuoKang
 * @date 2019-05-05 23:47
 */
public enum RepaymentType implements BaseEnum {
    EQUAL_PRINCIPAL("等额本金"),
    EQUAL_INTEREST("等额本息"),
    ;

    private String desc;

    RepaymentType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (RepaymentType item : RepaymentType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
