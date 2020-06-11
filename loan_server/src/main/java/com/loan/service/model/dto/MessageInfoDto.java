package com.loan.service.model.dto;

import com.loan.service.model.MessageInfo;

/**
 * @author GuoKang
 * @date 2019/9/4 15:21
 */
public class MessageInfoDto extends MessageInfo {
    private String createUserName;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
}
