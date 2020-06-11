package com.loan.web.controller;

import com.loan.service.service.MessageService;
import com.loan.web.common.LoginInfoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoKang
 * @date 2019/8/9 11:23
 */
@RestController
@RequestMapping("socket")
public class SocketMsgDemoController {

    @Autowired
    private MessageService messageService;

    @GetMapping("pushAll")
    public void pushMessage(@RequestParam("loginAccount") String loginAccount) {
        messageService.sendMessageNotifyBySocket(loginAccount, LoginInfoHolder.getUserInfoDto());
    }
}
