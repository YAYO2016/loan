package com.loan.service.enums;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-12 10:35
 */
public enum RoleDict {
    R0101("管理员", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
    }}),
    R0201("签单专员", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
        add(CaseOperateType.MODIFY);
        add(CaseOperateType.SUBMIT);
        add(CaseOperateType.FENGKONG_REFORM);
        add(CaseOperateType.CAIWU_REFORM);
        add(CaseOperateType.INTERVIEW_APPOINTMENT);
        add(CaseOperateType.BANK_INTERVIEW);
        add(CaseOperateType.BANK_REFORM);
        add(CaseOperateType.TRANSFER_APPOINTMENT);
        add(CaseOperateType.TRANSFER_MORTGAGE);
        add(CaseOperateType.MORTGAGE_RECEVING);
        add(CaseOperateType.CUSTOMER_RECEVING);
        add(CaseOperateType.ARCHIVE_CASE);
    }}),
    R0301("风控专员", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
        add(CaseOperateType.FENGKONG_CHECK);
        add(CaseOperateType.BANK_CHECK_RESERVE);
        add(CaseOperateType.CHECK_RESERVE_PASS);
        add(CaseOperateType.BANK_CHECK_COMMERCIAL);
        add(CaseOperateType.CHECK_COMMERCIAL_PASS);
        add(CaseOperateType.MAKE_LOAN);
    }}),
    R0401("财务专员", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
        add(CaseOperateType.CAIWU_CHECK);
        add(CaseOperateType.CAIWU_REVIEW);
    }}),
    R0501("渠道专员", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
    }}),
    R0601("外勤专员", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
        add(CaseOperateType.FIELD_RECEVING);
        add(CaseOperateType.FIELD_RECEIVED);
        add(CaseOperateType.PICK_UP_CASE);
        add(CaseOperateType.SEND_OFF_LOANS);
    }}),
    R0701("公司决策人", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
    }}),
    R0702("公司负责人", new ArrayList<CaseOperateType>() {{
        add(CaseOperateType.VIEW);
    }}),
    ;

    private String desc;
    private List<CaseOperateType> statusOperateTypes;

    RoleDict(String desc, List<CaseOperateType> statusOperateTypes) {
        this.desc = desc;
        this.statusOperateTypes = statusOperateTypes;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<CaseOperateType> getStatusOperateTypes() {
        return statusOperateTypes;
    }


    public static List<RoleDict> getRoleDictByRoleStr(List<String> roles) {
        if (CollectionUtils.isEmpty(roles)) return null;
        List<RoleDict> roleDictList = new ArrayList<>();
        Arrays.asList(RoleDict.values()).forEach(roleDict -> {
            if (roles.contains(roleDict.toString())) {
                roleDictList.add(roleDict);
            }
        });
        return roleDictList;
    }

    public static RoleDict getRoleDictByRoleStr(String roles) {
        List<RoleDict> roleDictList = getRoleDictByRoleStr(new ArrayList<String>() {{
            add(roles);
        }});
        return CollectionUtils.isEmpty(roleDictList) ? null : roleDictList.get(0);
    }
}
