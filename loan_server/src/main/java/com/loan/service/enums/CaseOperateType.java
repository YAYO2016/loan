package com.loan.service.enums;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 案子操作类型
 *
 * @author GuoKang
 * @date 2019-05-16 22:53
 */
public enum CaseOperateType {

    CREATE("新增"), // 新增案子（主要用于流程进展中展示）
    VIEW("查看"),
    MODIFY("修改"),
    SUBMIT("提交"),
    FENGKONG_CHECK("风控审核"),
    CAIWU_CHECK("财务审核"),
    FENGKONG_REFORM("整改"), // 风控整改
    CAIWU_REFORM("整改"), // 财务整改
    FIELD_RECEVING("收件"), // 财务审核通过后的收件
    FIELD_RECEIVED("送达"), // 财务审核通过后的送达
    INTERVIEW_APPOINTMENT("预约面签"), // 预约面签
    BANK_INTERVIEW("面签"), // 银行面签
    BANK_CHECK_COMMERCIAL("贷款审批(商)"), // 贷款审批 商业
    CHECK_COMMERCIAL_PASS("审批通过(商)"), // 审批通过 商业
    BANK_CHECK_RESERVE("贷款审批(公)"), // 贷款审批 公积金
    CHECK_RESERVE_PASS("审批通过(公)"), // 审批通过 公积金
    BANK_REFORM("整改"), // 银行整改
    PICK_UP_CASE("取件"), // 批复取件
    TRANSFER_APPOINTMENT("预约过户"), // 预约过户
    TRANSFER_MORTGAGE("过户"), // 过户抵押
    MORTGAGE_RECEVING("出件"), // 抵押出件
    SEND_OFF_LOANS("送行放款"), // 送行放款
    MAKE_LOAN("放款"), // 贷款发放
    CAIWU_REVIEW("复核"), // 财务复核
    CUSTOMER_RECEVING("客户取件"), // 客户取件
    ARCHIVE_CASE("归档"),
    ;

    private String desc;

    CaseOperateType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


    public static List getCodeDescList(List<CaseOperateType> operateTypeList) {
        if (CollectionUtils.isEmpty(operateTypeList)) return null;
        List<Map<String, String>> list = new ArrayList<>();
        operateTypeList.forEach(operateType -> {
            Map<String, String> map = new HashMap<>();
            map.put("code", operateType.toString());
            map.put("desc", operateType.getDesc());
            list.add(map);
        });
        return list;
    }
}
