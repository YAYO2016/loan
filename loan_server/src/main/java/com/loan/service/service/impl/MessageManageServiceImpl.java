package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.MessageManageDao;
import com.loan.service.enums.MsgStatus;
import com.loan.service.model.MessageInfo;
import com.loan.service.model.dto.MessageInfoDto;
import com.loan.service.service.MessageManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/9/4 14:13
 */
@Service
public class MessageManageServiceImpl extends AbstractLoanService<MessageInfo> implements MessageManageService {

    @Autowired
    private MessageManageDao messageManageDao;

    @Override
    protected ISingleTableDao<MessageInfo> getMyBatisRepository() {
        return messageManageDao;
    }

    @Override
    protected MessageInfo constructPkEntity(Long id) {
        return new MessageInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(MessageInfo messageInfo) {
        return messageInfo.getMsgId();
    }

    @Override
    public LoanPageList<MessageInfoDto> getMessageInfoDtoPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.messageManageDao.countMessageInfoDto(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<MessageInfoDto> list = this.messageManageDao.listMessageInfoDto(params);
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Transactional
    @Override
    public MessageInfo modifyMessageInfo(MessageInfo mInfo) {
        if (null == mInfo) return null;
        if (null == mInfo.getMsgId()) {
            mInfo.setMsgStatus(MsgStatus.WAIT_SEND);
            mInfo.setCreateTime(new Date());
            this.create(mInfo);
            return mInfo;
        }
        MessageInfo messageInfo = this.getEntityById(mInfo.getMsgId());
        if (null == messageInfo) return null;

        mInfo.setCreateTime(messageInfo.getCreateTime());
        mInfo.setCreateUser(messageInfo.getCreateUser());
        mInfo.setMsgStatus(messageInfo.getMsgStatus());
        this.modifyEntityById(mInfo);
        return mInfo;
    }

    @Transactional
    @Override
    public void sendMessage(Long messageId) {
        MessageInfo messageInfo = this.getEntityById(messageId);
        if (null == messageInfo) return;

        messageInfo.setMsgStatus(MsgStatus.SENDED);
        messageInfo.setSendTime(new Date());
        this.modifyEntityById(messageInfo);

        // TODO 给所有在线人员发送消息

    }

    @Override
    public Integer getSendedMessagesNum() {
        Map<String, Object> params = new HashMap<>();
        params.put("msgStatus", MsgStatus.SENDED);
        return this.messageManageDao.countMessageInfoDto(params);
    }
}
