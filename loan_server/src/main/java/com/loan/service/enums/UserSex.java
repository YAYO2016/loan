package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-22 20:48
 */
public enum UserSex implements BaseEnum {
    MALE("男"),
    FEMALE("女"),
    ;

    private String desc;

    UserSex(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (UserSex userSex : UserSex.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", userSex.toString());
            map.put("desc", userSex.getDesc());
            list.add(map);
        }
        return list;
    }
}
