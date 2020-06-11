package com.loan.service.service;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.model.dto.MessageInfoDto;

import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/8/12 14:02
 */
public interface MessageService {
    void sendMessageNotifyBySocket(String targetUserAccount, Object content);

}
