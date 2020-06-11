package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 贷款小类
 *
 * @author GuoKang
 * @date 2019-05-05 21:25
 */
public enum LoanSubType implements BaseEnum {
    R_PROVINCIAL("省级公积金", LoanType.RESERVE),
    R_CITY("市级公积金", LoanType.RESERVE),
    R_RAILWAY("铁路公积金", LoanType.RESERVE),
    R_PRISON("监狱公积金", LoanType.RESERVE),

    S_PROVINCIAL("省级公积金", LoanType.SYNDICATED),
    S_CITY("市级公积金", LoanType.SYNDICATED),
    S_RAILWAY("铁路公积金", LoanType.SYNDICATED),
    S_PRISON("监狱公积金", LoanType.SYNDICATED),
    ;

    private String desc;
    private LoanType loanType;
    private static Map<LoanType, List> subMap = new HashMap<>();

    LoanSubType(String desc, LoanType loanType) {
        this.desc = desc;
        this.loanType = loanType;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        return listSubType(null);
    }

    public static List getSubType(LoanType loanType) {
        List subTypeList = subMap.get(loanType);
        if (CollectionUtils.isEmpty(subTypeList)) {
            initTypeMap(loanType);
            subTypeList = subMap.get(loanType);
        }
        return subTypeList;
    }

    private static void initTypeMap(LoanType loanType) {
        subMap.put(loanType, listSubType(loanType));
    }

    private static List listSubType(LoanType loanType) {
        List<Map<String, String>> list = new ArrayList<>();
        for (LoanSubType item : LoanSubType.values()) {
            if (null != loanType
                    && !item.loanType.equals(loanType))
                continue;
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
//        if (CollectionUtils.isEmpty(list)) return null;
        return list;
    }
}