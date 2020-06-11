package com.loan.service.enums;

import com.loan.framework.enums.BaseEnum;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-10 22:36
 */
public enum CaseCfgType implements BaseEnum {
    CHANNEL_INFO("渠道信息"),
    DEVELOPER_INFO("开发商信息"),
    ESTATE_INFO("楼盘信息"),
    ESTATE_SALESMAN_INFO("楼盘销售员信息"),
    MATERIAL_INFO("材料信息"),
    FEE_ITEM_INFO("费用信息");

    private String desc;

    CaseCfgType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    @Override
    public List listAll() {
        return null;
    }
}
