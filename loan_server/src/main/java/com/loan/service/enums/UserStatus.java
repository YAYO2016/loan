package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-22 20:49
 */
public enum UserStatus implements BaseEnum {
    VALID("有效"),
    INVALID("失效"),
    ;

    private String desc;

    UserStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (UserStatus userStatus : UserStatus.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", userStatus.toString());
            map.put("desc", userStatus.getDesc());
            list.add(map);
        }
        return list;
    }
}
