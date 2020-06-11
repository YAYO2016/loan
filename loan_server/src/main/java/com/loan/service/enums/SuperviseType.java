package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 监管类型
 *
 * @author GuoKang
 * @date 2019-05-05 21:17
 */
public enum SuperviseType implements BaseEnum {
    SUPERVISE("监管"),
    NON_SUPERVISE("非监管"),
    ;

    private String desc;

    SuperviseType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (SuperviseType item : SuperviseType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
