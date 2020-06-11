package com.loan.service.model.dto;

import com.loan.service.model.*;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-06 23:42
 */
public class CaseBaseInfoDto extends CaseBaseInfo {
    private CaseLoanInfo loanInfo;
    private CaseNewHouseInfo newHouseInfo;
    private CaseSecondHandHouseInfo secondHandHouseInfo;
    private List<CaseCustInfo> custInfos;
    private UserInfo businessUser; // 对应渠道专员

    public CaseLoanInfo getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(CaseLoanInfo loanInfo) {
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

    public List<CaseCustInfo> getCustInfos() {
        return custInfos;
    }

    public void setCustInfos(List<CaseCustInfo> custInfos) {
        this.custInfos = custInfos;
    }

    public UserInfo getBusinessUser() {
        return businessUser;
    }

    public void setBusinessUser(UserInfo businessUser) {
        this.businessUser = businessUser;
    }
}
