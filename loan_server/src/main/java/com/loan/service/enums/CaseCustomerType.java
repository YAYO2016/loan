package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 案子与客户关系
 *
 * @author GuoKang
 * @date 2019-05-05 22:32
 */
public enum CaseCustomerType implements BaseEnum {
    BUYER_MAIN_CREDIT("买方主贷人"),
    BUYER_CO_PAYER("买方共还人"),
    SELLER_HOUSE_OWNER("卖方产权人"),
    SELLER_CO_OWNER("卖方共有人"),
    ;

    private String desc;

    CaseCustomerType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        List<Map<String, String>> list = new ArrayList<>();
        for (CaseCustomerType item : CaseCustomerType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", item.toString());
            map.put("desc", item.getDesc());
            list.add(map);
        }
        return list;
    }

    public static List<CaseCustomerType> getSubType(CaseCustomerType type) {
        List<CaseCustomerType> result = new ArrayList<>();
        switch (type) {
            case BUYER_MAIN_CREDIT:
                result.add(BUYER_CO_PAYER);
                break;

            case SELLER_HOUSE_OWNER:
                result.add(SELLER_CO_OWNER);
                break;

            default:
                result.add(type);
        }
        return result;
    }
}
