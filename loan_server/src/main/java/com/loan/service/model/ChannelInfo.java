package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.ChannelType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-04-19 00:13
 */
public class ChannelInfo extends AbsPojoSetPk implements Serializable {
    private Long channelId; // 中介编码
    private ChannelType channelType; // 渠道类型
    private String channelName; // 中介名称
    private String channelPhone; // 中介电话
    private String channelAddress; // 中介地址
    private String bossName;// 中介老板
    private String bossMphone;// 中介老板手机
    private String accountName;// 返款结算户名
    private String accountBank;// 结算卡开户行
    private String accountNo;// 账号
    private Long createUser;// 创建人
    private String createUserName;// 创建人
    private Date createTime;// 创建时间
    private Date modifyTime;// 修改时间
    
    private String areaName;// 所在区域
    private String tradeModel;// 经营类型
    private String storeName;// 门店名称
    private String regName;// 注册名称

    
    
    
    
    public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	

	public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelPhone() {
        return channelPhone;
    }

    public void setChannelPhone(String channelPhone) {
        this.channelPhone = channelPhone;
    }

    public String getChannelAddress() {
        return channelAddress;
    }

    public void setChannelAddress(String channelAddress) {
        this.channelAddress = channelAddress;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getBossMphone() {
        return bossMphone;
    }

    public void setBossMphone(String bossMphone) {
        this.bossMphone = bossMphone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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

    public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getTradeModel() {
		return tradeModel;
	}

	public void setTradeModel(String tradeModel) {
		this.tradeModel = tradeModel;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	@Override
    public void setPk(Long pk) {
        setChannelId(pk);
    }
}
