package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单位性质
 *
 * @author GuoKang
 * @date 2019-05-06 22:47
 */
public enum CoType implements BaseEnum {
    ORGAN("机关"),
    BUSINESS("事业"),
    STATE_OWNED("国企"),
    COMPANY("公司"),
    SELF_EMPLOYED("个体"),
    ;

    private String desc;

    CoType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (CoType item : CoType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
