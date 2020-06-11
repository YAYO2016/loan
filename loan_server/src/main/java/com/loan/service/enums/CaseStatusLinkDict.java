package com.loan.service.enums;

/**
 * 案子状态所属环节
 *
 * @author GuoKang
 * @date 2019-05-12 10:59
 */
public enum CaseStatusLinkDict {
    QIAN_DAN("签单环节"),
    SHEN_HE("审核环节"),
    SONG_JIAN("送件环节"),
    MIAN_QIAN("面签环节"),
    BANK_SHEN_HE("银行审核环节"),
    QU_JIAN("取件环节"),
    GUO_HU_DI_YA("过户抵押环节"),
    CHU_JIAN("出件环节"),
    LUO_SHI_FANG_KUAN("落实放款环节"),
    JIE_AN("结案"),
    ;
    private String desc;

    CaseStatusLinkDict(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }


}
