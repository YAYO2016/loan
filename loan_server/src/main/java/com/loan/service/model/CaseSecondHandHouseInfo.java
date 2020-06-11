package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.HouseProperty;
import com.loan.service.enums.PropertyRightsType;
import com.loan.service.enums.SuperviseType;

import java.io.Serializable;
import java.util.Date;

/**
 * 二手房抵押信息
 *
 * @author GuoKang
 * @date 2019-05-06 22:22
 */
public class CaseSecondHandHouseInfo extends AbsPojoSetPk implements Serializable {

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
    private String afttradeBdc; // 交易后不动产证号
    private String afttradeBdcArea; // 交易后不动产地址
    private String afttradeQsd; // 交易后契税单号
    private String afttradeZzsd; // 交易后增值税单号
    private Double afttradeJsdj; // 交易后计税单价
    private Double afttradeGhdj; // 交易后过户单价
    private Double afttradeUnitPrice; // 交易后成交单价
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

    public String getAfttradeBdc() {
        return afttradeBdc;
    }

    public void setAfttradeBdc(String afttradeBdc) {
        this.afttradeBdc = afttradeBdc;
    }

    public String getAfttradeBdcArea() {
        return afttradeBdcArea;
    }

    public void setAfttradeBdcArea(String afttradeBdcArea) {
        this.afttradeBdcArea = afttradeBdcArea;
    }

    public String getAfttradeQsd() {
        return afttradeQsd;
    }

    public void setAfttradeQsd(String afttradeQsd) {
        this.afttradeQsd = afttradeQsd;
    }

    public String getAfttradeZzsd() {
        return afttradeZzsd;
    }

    public void setAfttradeZzsd(String afttradeZzsd) {
        this.afttradeZzsd = afttradeZzsd;
    }

    public Double getAfttradeJsdj() {
        return afttradeJsdj;
    }

    public void setAfttradeJsdj(Double afttradeJsdj) {
        this.afttradeJsdj = afttradeJsdj;
    }

    public Double getAfttradeGhdj() {
        return afttradeGhdj;
    }

    public void setAfttradeGhdj(Double afttradeGhdj) {
        this.afttradeGhdj = afttradeGhdj;
    }

    public Double getAfttradeUnitPrice() {
        return afttradeUnitPrice;
    }

    public void setAfttradeUnitPrice(Double afttradeUnitPrice) {
        this.afttradeUnitPrice = afttradeUnitPrice;
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
