package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房产属性
 *
 * @author GuoKang
 * @date 2019-05-05 21:09
 */
public enum HouseProperty implements BaseEnum {
    RESIDENCE("住宅"),
    APARTMENT("公寓"),
    STORE("商铺"),
    OFFICE_BUILDING("写字楼"),
    ;

    private String desc;

    HouseProperty(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (HouseProperty item : HouseProperty.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
