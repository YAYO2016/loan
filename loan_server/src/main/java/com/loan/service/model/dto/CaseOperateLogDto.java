package com.loan.service.model.dto;

import com.loan.service.model.CaseOperateLog;

/**
 * @author GuoKang
 * @date 2019-07-04 22:40
 */
public class CaseOperateLogDto extends CaseOperateLog {
    private UserInfoDto operatorInfo;

    public UserInfoDto getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(UserInfoDto operatorInfo) {
        this.operatorInfo = operatorInfo;
    }
}
