package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 案子小类
 *
 * @author GuoKang
 * @date 2019/5/5 17:45
 */
public enum CaseSubType implements BaseEnum {

    NEW_HOUSE("一手房", CaseType.HOME_LOAN),
    SECOND_HAND_HOUSE("二手房", CaseType.HOME_LOAN),
    ;

    private String desc;
    private CaseType caseType;
    private static Map<CaseType, List> caseTypeMap = new HashMap<>();

    CaseSubType(String desc, CaseType caseType) {
        this.desc = desc;
        this.caseType = caseType;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        return listCaseSubType(null);
    }

    public static List getSubType(CaseType caseType) {
        List subTypeList = caseTypeMap.get(caseType);
        if (CollectionUtils.isEmpty(subTypeList)) {
            initCaseTypeMap(caseType);
            subTypeList = caseTypeMap.get(caseType);
        }
        return subTypeList;
    }

    private static void initCaseTypeMap(CaseType caseType) {
        caseTypeMap.put(caseType, listCaseSubType(caseType));
    }

    private static List listCaseSubType(CaseType caseType) {
        List<Map<String, String>> list = new ArrayList<>();
        for (CaseSubType caseSubType : CaseSubType.values()) {
            if (null != caseType
                    && !caseSubType.caseType.equals(caseType))
                continue;
            Map<String, String> map = new HashMap<>();
            map.put("code", caseSubType.toString());
            map.put("desc", caseSubType.getDesc());
            list.add(map);
        }
//        if (CollectionUtils.isEmpty(list)) return null;
        return list;
    }
}
