package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 材料状态
 *
 * @author GuoKang
 * @date 2019-05-12 13:19
 */
public enum MaterialStatus implements BaseEnum {
    PROVIDED("已提供"),
    NOT_PROVIDED("未提供"),
    ;

    private String desc;

    MaterialStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (MaterialStatus item : MaterialStatus.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
