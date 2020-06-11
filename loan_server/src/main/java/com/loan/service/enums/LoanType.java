package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 贷款类型
 *
 * @author GuoKang
 * @date 2019-05-05 21:20
 */
public enum LoanType implements BaseEnum {
    RESERVE("公积金贷款"),
    SYNDICATED("组合贷款"),
    COMMERCIAL("商业贷款"),
    ;

    private String desc;

    LoanType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LoanType item : LoanType.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            List children = LoanSubType.getSubType(item);
            if (!CollectionUtils.isEmpty(children))
                map.put("children", children);
            list.add(map);
        }
        return list;
    }
}
