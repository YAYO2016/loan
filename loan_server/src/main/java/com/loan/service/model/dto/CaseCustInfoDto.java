package com.loan.service.model.dto;

import com.loan.service.model.CaseCustInfo;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-07 21:38
 */
public class CaseCustInfoDto extends CaseCustInfo {

    private List<CaseCustInfo> otherCusts;

    public List<CaseCustInfo> getOtherCusts() {
        return otherCusts;
    }

    public void setOtherCusts(List<CaseCustInfo> otherCusts) {
        this.otherCusts = otherCusts;
    }
}
