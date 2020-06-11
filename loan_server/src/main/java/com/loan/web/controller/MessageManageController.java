package com.loan.web.controller;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.utils.DateUtil;
import com.loan.service.enums.MsgLevel;
import com.loan.service.enums.MsgStatus;
import com.loan.service.model.MessageInfo;
import com.loan.service.model.dto.MessageInfoDto;
import com.loan.service.service.MessageManageService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/9/4 14:58
 */
@RestController
@RequestMapping("/message")
public class MessageManageController {

    @Autowired
    private MessageManageService messageManageService;


    @GetMapping("list")
    public JsonData list(@RequestParam(value = "keyWord", required = false) String keyWord,
                         @RequestParam(value = "createUserName", required = false) String createUserName,
                         @RequestParam(value = "startSendTime", required = false) Date startSendTime,
                         @RequestParam(value = "endSendTime", required = false) Date endSendTime,
                         @RequestParam(value = "msgLevel", required = false) MsgLevel msgLevel,
                         @RequestParam(value = "msgStatus", required = false) MsgStatus msgStatus,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(keyWord)) params.put("keyWord", keyWord);
        if (!StringUtils.isEmpty(createUserName)) params.put("createUserName", createUserName);
        if (null != startSendTime) params.put("startSendTime", DateUtil.getStartDate(startSendTime));
        if (null != endSendTime) params.put("endSendTime", DateUtil.getEndDate(endSendTime));
        if (null != msgLevel) params.put("msgLevel", msgLevel);
        if (null != msgStatus) params.put("msgStatus", msgStatus);

        LoanPageList<MessageInfoDto> dtoPageList = this.messageManageService.getMessageInfoDtoPageList(params, pageAttr);

        return JsonData.getSucceed(dtoPageList.getDatas(), dtoPageList.getPageInfo());
    }

    @GetMapping("getSingleMessage")
    public JsonData getSingleMessage(@RequestParam(value = "msgId") Long msgId) {
        MessageInfo messageInfo = this.messageManageService.getEntityById(msgId);
        if (null == messageInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "消息不存在");
        return JsonData.getSucceed(messageInfo);
    }

    @PostMapping("addOrUpdateSingleMessage")
    public JsonData addOrUpdateSingleMessage(@RequestBody MessageInfo mInfo) {
        if (null != mInfo.getMsgId()) {
            MessageInfo messageInfo = this.messageManageService.getEntityById(mInfo.getMsgId());
            if (null == messageInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "消息不存在");
        }
        mInfo.setCreateUser(LoginInfoHolder.getUserId());
        return JsonData.getSucceed(this.messageManageService.modifyMessageInfo(mInfo));
    }

    @PostMapping("sendMessage")
    public JsonData sendMessage(@RequestBody MessageInfo mInfo) {
        if (null != mInfo.getMsgId()) {
            MessageInfo messageInfo = this.messageManageService.getEntityById(mInfo.getMsgId());
            if (null == messageInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "消息不存在");
        }
        this.messageManageService.sendMessage(mInfo.getMsgId());
        return JsonData.getSucceed();
    }

    @GetMapping("getSendedMessagesNum")
    public JsonData getSendedMessagesNum() {
        return JsonData.getSucceed(this.messageManageService.getSendedMessagesNum());
    }
}
