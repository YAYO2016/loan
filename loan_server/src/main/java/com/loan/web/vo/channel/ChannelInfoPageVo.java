package com.loan.web.vo.channel;

import com.loan.service.enums.ChannelType;

/**
 * @author GuoKang
 * @date 2019/4/19 16:52
 */
public class ChannelInfoPageVo {
    private Long channelId; // 中介编码
    private ChannelType channelType; // 渠道类型
    private String channelName; // 中介名称
    private String channelAddress; // 中介地址
    private String bossName;// 中介老板
    private String bossMphone;// 中介老板手机

    private Integer caseCount;// 案子数量

    private String areaName;// 所在区域
    private String tradeModel;// 经营类型
    private String storeName;// 门店名称
    private String regName;// 注册名称
    private String createUserName;// 创建人
    
    
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

    public Integer getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(Integer caseCount) {
        this.caseCount = caseCount;
    }

    public String getChannelAddress() {
        return channelAddress;
    }

    public void setChannelAddress(String channelAddress) {
        this.channelAddress = channelAddress;
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
    
}
