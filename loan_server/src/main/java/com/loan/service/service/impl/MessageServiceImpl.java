package com.loan.service.service.impl;

import com.corundumstudio.socketio.SocketIOServer;
import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.model.FeeItemInfo;
import com.loan.service.model.dto.MessageInfoDto;
import com.loan.service.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/8/12 14:02
 */
@Service
public class MessageServiceImpl implements MessageService {

    private Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Value("${netty.socket.notify.method.name}")
    private String socketNotifyMethodName;

    @Autowired
    private SocketIOServer socketIOServer;

    @Override
    public void sendMessageNotifyBySocket(String targetUserAccount, Object content) {
        socketIOServer.getRoomOperations(targetUserAccount)
                .sendEvent(socketNotifyMethodName, content);
    }
}
