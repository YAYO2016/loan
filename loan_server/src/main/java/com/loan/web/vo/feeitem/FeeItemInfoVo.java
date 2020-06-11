package com.loan.web.vo.feeitem;

import com.loan.service.enums.FeeItemOptional;

/**
 * @author GuoKang
 * @date 2019-04-23 23:36
 */
public class FeeItemInfoVo {
    private Long itemId; // 费用科目ID
    private String itemName; // 费用科目名称
    private String itemDesc; // 费用科目描述
    private Double itemPrice; // 费用科目单价
    private Byte itemRate; // 扣点率
    private FeeItemOptional optional; // 是否必选

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

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
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
}
