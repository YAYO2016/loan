package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.MsgLevel;
import com.loan.service.enums.MsgStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/9/4 11:19
 */
public class MessageInfo extends AbsPojoSetPk implements Serializable {

    private Long msgId; // 消息ID
    private String msgTitle; // 消息标题
    private String msgContent; // 消息内容
    private MsgLevel msgLevel; // 消息等级
    private MsgStatus msgStatus; // 消息状态
    private Long createUser; // 创建人ID
    private Date sendTime; // 发送时间
    private Date createTime; // 创建时间

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public MsgLevel getMsgLevel() {
        return msgLevel;
    }

    public void setMsgLevel(MsgLevel msgLevel) {
        this.msgLevel = msgLevel;
    }

    public MsgStatus getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(MsgStatus msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setPk(Long pk) {
        setMsgId(pk);
    }
}
