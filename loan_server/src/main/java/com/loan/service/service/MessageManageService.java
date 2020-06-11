package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.service.LoanService;
import com.loan.service.model.MessageInfo;
import com.loan.service.model.dto.MessageInfoDto;

import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/9/4 14:12
 */
public interface MessageManageService extends LoanService<MessageInfo> {
    LoanPageList<MessageInfoDto> getMessageInfoDtoPageList(Map<String, Object> params, LoanPageAttribute pageAttr);

    MessageInfo modifyMessageInfo(MessageInfo mInfo);

    void sendMessage(Long messageId);

    Integer getSendedMessagesNum();
}
