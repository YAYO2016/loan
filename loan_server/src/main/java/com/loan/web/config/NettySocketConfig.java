package com.loan.web.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuoKang
 * @date 2019/8/9 14:08
 */

@Configuration
public class NettySocketConfig {

    @Value("${netty.socket.hostname}")
    private String hostname;
    @Value("${netty.socket.post}")
    private Integer port;

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(hostname);
        config.setPort(port);
        config.setMaxFramePayloadLength(1024 * 1024);
        config.setMaxHttpContentLength(1024 * 1024);
        //该处进行身份验证h
//        config.setAuthorizationListener(handshakeData -> {
//            //http://localhost:8081?username=test&password=test
//            //例如果使用上面的链接进行connect，可以使用如下代码获取用户密码信息
//            //String username = data.getSingleUrlParam("username");
//            //String password = data.getSingleUrlParam("password");
//            return true;
//        });
        return new SocketIOServer(config);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}

