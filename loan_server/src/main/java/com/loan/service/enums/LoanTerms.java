package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 放款条件
 *
 * @author GuoKang
 * @date 2019-05-05 22:08
 */
public enum LoanTerms implements BaseEnum {
    INITIAL("草签"),
    RECORD("备案"),
    MORTGAGE("抵押"),
    ;

    private String desc;

    LoanTerms(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (LoanTerms item : LoanTerms.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }
}
