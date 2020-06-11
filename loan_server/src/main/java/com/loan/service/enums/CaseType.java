package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 案子大类
 *
 * @author GuoKang
 * @date 2019/5/5 17:43
 */
public enum CaseType implements BaseEnum {

    HOME_LOAN("住房贷款"),
    ;

    private String desc;

    CaseType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public List listAll() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (CaseType caseType : CaseType.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", caseType.toString());
            map.put("desc", caseType.getDesc());
            List children = CaseSubType.getSubType(caseType);
            if (!CollectionUtils.isEmpty(children))
                map.put("children", children);
            list.add(map);
        }
        return list;
    }
}
