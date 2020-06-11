package com.loan.service.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.loan.service.enums.CaseOperateType.*;

/**
 * 案子状态
 *
 * @author GuoKang
 * @date 2019-05-12 10:44
 */
public enum CaseStatusDict {
    STATUS_101("案子已建立", CaseStatusLinkDict.QIAN_DAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(SUBMIT);
    }}),
    STATUS_102("待风控审核", CaseStatusLinkDict.SHEN_HE, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(FENGKONG_CHECK);
    }}),
    STATUS_103("待财务审核", CaseStatusLinkDict.SHEN_HE, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(CAIWU_CHECK);
    }}),
    STATUS_104("风控审核不通过", CaseStatusLinkDict.QIAN_DAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(FENGKONG_REFORM);
    }}),
    STATUS_105("财务审核通过", CaseStatusLinkDict.SONG_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(FIELD_RECEVING);
    }}),
    STATUS_106("财务审核不通过", CaseStatusLinkDict.QIAN_DAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(CAIWU_REFORM);
    }}),
    STATUS_107("外勤已收件", CaseStatusLinkDict.SONG_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(FIELD_RECEIVED);
    }}),
    STATUS_108("外勤已送件", CaseStatusLinkDict.MIAN_QIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(INTERVIEW_APPOINTMENT);
    }}),
    STATUS_109("已预约面签", CaseStatusLinkDict.BANK_SHEN_HE, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(BANK_INTERVIEW);
    }}),
    STATUS_110("面签通过", CaseStatusLinkDict.BANK_SHEN_HE, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(BANK_CHECK_COMMERCIAL);
        add(BANK_CHECK_RESERVE);
    }}),
    STATUS_111("审批中(商)", CaseStatusLinkDict.QU_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(CHECK_COMMERCIAL_PASS);
    }}),
    STATUS_112("审批通过(商)", CaseStatusLinkDict.QU_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(BANK_CHECK_RESERVE);
        add(PICK_UP_CASE);
    }}),
    STATUS_113("审批中(公)", CaseStatusLinkDict.QU_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(CHECK_RESERVE_PASS);
    }}),
    STATUS_114("审批通过(公)", CaseStatusLinkDict.QU_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(PICK_UP_CASE);
    }}),
    STATUS_115("银行审核不通过", CaseStatusLinkDict.QIAN_DAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(BANK_REFORM);
    }}),
    STATUS_116("取回案件", CaseStatusLinkDict.QU_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(TRANSFER_APPOINTMENT);
    }}),
    STATUS_117("已预约过户", CaseStatusLinkDict.GUO_HU_DI_YA, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(TRANSFER_MORTGAGE);
    }}),
    STATUS_118("过户抵押办理", CaseStatusLinkDict.CHU_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(MORTGAGE_RECEVING);
    }}),
    STATUS_119("抵押出件", CaseStatusLinkDict.CHU_JIAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MODIFY);
        add(SEND_OFF_LOANS);
    }}),
    STATUS_120("落实放款", CaseStatusLinkDict.LUO_SHI_FANG_KUAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(MAKE_LOAN);
    }}),
    STATUS_121("贷款已发放", CaseStatusLinkDict.LUO_SHI_FANG_KUAN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(CAIWU_REVIEW);
    }}),
    STATUS_122("财务已复核", CaseStatusLinkDict.JIE_AN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(CUSTOMER_RECEVING);
    }}),
    STATUS_123("客户已取件", CaseStatusLinkDict.JIE_AN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
        add(ARCHIVE_CASE);
    }}),
    STATUS_124("已归档", CaseStatusLinkDict.JIE_AN, new ArrayList<CaseOperateType>() {{
        add(VIEW);
    }}),
    ;

    private String desc;
    private CaseStatusLinkDict statusLinkDict;
    private List<CaseOperateType> statusOperateTypes;

    CaseStatusDict(String desc, CaseStatusLinkDict statusLinkDict, List<CaseOperateType> statusOperateTypes) {
        this.desc = desc;
        this.statusLinkDict = statusLinkDict;
        this.statusOperateTypes = statusOperateTypes;
    }

    public String getDesc() {
        return this.desc;
    }

    public CaseStatusLinkDict getStatusLinkDict() {
        return statusLinkDict;
    }

    public List<CaseOperateType> getStatusOperateTypes() {
        return statusOperateTypes;
    }


    public static List<CaseStatusDict> getReformStatusList() {
        return Arrays.asList(STATUS_104, STATUS_106, STATUS_111);
    }
}
