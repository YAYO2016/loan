package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 15:25
 */
public enum FeeItemOptional implements BaseEnum {
    OPTIONAL("可选"),
    MANDATORY("必选"),
    ;

    private String desc;

    FeeItemOptional(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (FeeItemOptional optional : FeeItemOptional.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", optional.toString());
            map.put("desc", optional.getDesc());
            list.add(map);
        }
        return list;
    }
}
