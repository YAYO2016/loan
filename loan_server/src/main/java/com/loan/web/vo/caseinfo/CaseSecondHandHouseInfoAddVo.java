package com.loan.web.vo.caseinfo;

import com.loan.service.enums.HouseProperty;
import com.loan.service.enums.PropertyRightsType;
import com.loan.service.enums.SuperviseType;

/**
 * 案子新增时的二手房信息
 *
 * @author GuoKang
 * @date 2019-05-07 20:39
 */
public class CaseSecondHandHouseInfoAddVo {
    private Long caseId; // 案子ID
    private HouseProperty houseProperty; // 房产属性
    private PropertyRightsType propertyRightsType; // 产权证类型
    private SuperviseType superviseType; // 监管类型
    private String pretradeHouseAddr; // 交易前房产地址
    private String pretradeCqz; // 交易前产权证号
    private String pretradeTdz; // 交易前土地证号
    private String pretradeBdc; // 交易前不动产证号
    private String pretradeArea; // 交易前房产面积
    private String pretradeFloor; // 交易前建筑楼层
    private String pretradeAge; // 交易前建筑年代
    private Double pretradeNetPrice; // 交易前网签价格
    private String pretradePrice; // 交易前成交总价
    private Double pretradeUnitPrice; // 交易前成交单价


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

    public PropertyRightsType getPropertyRightsType() {
        return propertyRightsType;
    }

    public void setPropertyRightsType(PropertyRightsType propertyRightsType) {
        this.propertyRightsType = propertyRightsType;
    }

    public SuperviseType getSuperviseType() {
        return superviseType;
    }

    public void setSuperviseType(SuperviseType superviseType) {
        this.superviseType = superviseType;
    }

    public String getPretradeHouseAddr() {
        return pretradeHouseAddr;
    }

    public void setPretradeHouseAddr(String pretradeHouseAddr) {
        this.pretradeHouseAddr = pretradeHouseAddr;
    }

    public String getPretradeCqz() {
        return pretradeCqz;
    }

    public void setPretradeCqz(String pretradeCqz) {
        this.pretradeCqz = pretradeCqz;
    }

    public String getPretradeTdz() {
        return pretradeTdz;
    }

    public void setPretradeTdz(String pretradeTdz) {
        this.pretradeTdz = pretradeTdz;
    }

    public String getPretradeBdc() {
        return pretradeBdc;
    }

    public void setPretradeBdc(String pretradeBdc) {
        this.pretradeBdc = pretradeBdc;
    }

    public String getPretradeArea() {
        return pretradeArea;
    }

    public void setPretradeArea(String pretradeArea) {
        this.pretradeArea = pretradeArea;
    }

    public String getPretradeFloor() {
        return pretradeFloor;
    }

    public void setPretradeFloor(String pretradeFloor) {
        this.pretradeFloor = pretradeFloor;
    }

    public String getPretradeAge() {
        return pretradeAge;
    }

    public void setPretradeAge(String pretradeAge) {
        this.pretradeAge = pretradeAge;
    }

    public Double getPretradeNetPrice() {
        return pretradeNetPrice;
    }

    public void setPretradeNetPrice(Double pretradeNetPrice) {
        this.pretradeNetPrice = pretradeNetPrice;
    }

    public String getPretradePrice() {
        return pretradePrice;
    }

    public void setPretradePrice(String pretradePrice) {
        this.pretradePrice = pretradePrice;
    }

    public Double getPretradeUnitPrice() {
        return pretradeUnitPrice;
    }

    public void setPretradeUnitPrice(Double pretradeUnitPrice) {
        this.pretradeUnitPrice = pretradeUnitPrice;
    }
}
