package com.loan.service.enums;

/**
 * 操作结果
 *
 * @author GuoKang
 * @date 2019-05-16 23:10
 */
public enum CaseOperateResult {

    PASS("通过"),
    NOT_PASS("不通过"),
    ;

    private String desc;

    CaseOperateResult(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

}
