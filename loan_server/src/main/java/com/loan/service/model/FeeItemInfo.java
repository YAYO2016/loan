package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.FeeItemOptional;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/4/23 15:33
 */
public class FeeItemInfo extends AbsPojoSetPk implements Serializable {
    private Long itemId; // 费用科目ID
    private String itemName; // 费用科目名称
    private String itemDesc; // 费用科目描述
    private Integer itemPrice; // 费用科目单价
    private Byte itemRate; // 扣点率
    private FeeItemOptional optional; // 是否必选
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Byte getItemRate() {
        return itemRate;
    }

    public void setItemRate(Byte itemRate) {
        this.itemRate = itemRate;
    }

    public FeeItemOptional getOptional() {
        return optional;
    }

    public void setOptional(FeeItemOptional optional) {
        this.optional = optional;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public void setPk(Long pk) {
        setItemId(pk);
    }
}
