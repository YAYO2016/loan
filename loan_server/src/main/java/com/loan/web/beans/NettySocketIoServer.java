package com.loan.web.beans;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.loan.service.model.dto.UserInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author GuoKang
 * @date 2019/8/9 15:25
 */
@Component
public class NettySocketIoServer {
    private Logger logger = LoggerFactory.getLogger(NettySocketIoServer.class);

    @OnConnect
    public void onConnect(SocketIOClient client) {
        // 客户端连接时调用方法
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        // 客户端断开连接时调用方法
    }

    @OnEvent(value = "userRegisterEvent")
    public void onUserRegisterEvent(SocketIOClient client, AckRequest ackRequest, UserInfoDto data) {
        logger.info("user:" + data.getLoginAccount() + "| use client:" + client.getSessionId() + " join room !!!");
        client.getAllRooms().stream()
                .filter(StringUtils::hasText) // 空room是默认全部，不能退出
                .forEach(client::leaveRoom);
        client.joinRoom(data.getLoginAccount());
    }
}
