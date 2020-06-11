package com.loan.web.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author GuoKang
 * @date 2019/8/9 15:15
 */
@Component
@Order(1)
public class NettySocketRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(NettySocketRunner.class);

    private final SocketIOServer server;

    @Autowired
    public NettySocketRunner(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        logger.info("SocketIOServer start successful!!!");
    }
}
