package com.loan.service.model.dto;

import com.loan.service.model.*;

/**
 * @author GuoKang
 * @date 2019-05-11 22:37
 */
public class CaseOverviewInfoDto extends CaseBaseInfo {
    private CaseLoanInfoDto loanInfo;
    private CaseNewHouseInfo newHouseInfo;
    private CaseSecondHandHouseInfo secondHandHouseInfo;
    private CaseCustInfoDto buyerCustInfo;
    private CaseCustInfoDto sellerCustInfo;
    private CaseCfgInfoDto cfgInfo;

    public CaseLoanInfoDto getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(CaseLoanInfoDto loanInfo) {
        this.loanInfo = loanInfo;
    }

    public CaseNewHouseInfo getNewHouseInfo() {
        return newHouseInfo;
    }

    public void setNewHouseInfo(CaseNewHouseInfo newHouseInfo) {
        this.newHouseInfo = newHouseInfo;
    }

    public CaseSecondHandHouseInfo getSecondHandHouseInfo() {
        return secondHandHouseInfo;
    }

    public void setSecondHandHouseInfo(CaseSecondHandHouseInfo secondHandHouseInfo) {
        this.secondHandHouseInfo = secondHandHouseInfo;
    }

    public CaseCustInfoDto getBuyerCustInfo() {
        return buyerCustInfo;
    }

    public void setBuyerCustInfo(CaseCustInfoDto buyerCustInfo) {
        this.buyerCustInfo = buyerCustInfo;
    }

    public CaseCustInfoDto getSellerCustInfo() {
        return sellerCustInfo;
    }

    public void setSellerCustInfo(CaseCustInfoDto sellerCustInfo) {
        this.sellerCustInfo = sellerCustInfo;
    }

    public CaseCfgInfoDto getCfgInfo() {
        return cfgInfo;
    }

    public void setCfgInfo(CaseCfgInfoDto cfgInfo) {
        this.cfgInfo = cfgInfo;
    }
}
