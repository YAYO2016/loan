package com.loan.web.vo.caseinfo;

import com.loan.service.enums.HouseProperty;

/**
 * @author GuoKang
 * @date 2019-05-07 20:10
 */
public class CaseNewHouseInfoVo {
    private Long caseId; // 案子ID
    private HouseProperty houseProperty; // 房产属性
    private String contractCode; // 契约号
    private String houseAddress; // 房产地址
    private String houseArea; // 房产面积
    private String contractAmount; // 契约总价
    private Double contractPrice; // 契约单价

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public HouseProperty getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(HouseProperty houseProperty) {
        this.houseProperty = houseProperty;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Double getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Double contractPrice) {
        this.contractPrice = contractPrice;
    }
}
