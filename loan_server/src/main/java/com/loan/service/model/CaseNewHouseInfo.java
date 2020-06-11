package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.HouseProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 一手房抵押信息
 *
 * @author GuoKang
 * @date 2019-05-06 21:54
 */
public class CaseNewHouseInfo extends AbsPojoSetPk implements Serializable {

    private Long caseId; // 案子ID
    private HouseProperty houseProperty; // 房产属性
    private String contractCode; // 契约号
    private String houseAddress; // 房产地址
    private String houseArea; // 房产面积
    private String contractAmount; // 契约总价
    private Double contractPrice; // 契约单价
    private Date createTime; // 创建时间

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setPk(Long pk) {
        setCaseId(pk);
    }
}
