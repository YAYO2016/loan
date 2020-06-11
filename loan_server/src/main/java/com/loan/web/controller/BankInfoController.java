package com.loan.web.controller;

import com.loan.service.model.BankInfo;
import com.loan.service.service.BankInfoService;
import com.loan.web.common.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019/4/23 12:36
 */
@RestController
@RequestMapping("/bank")
public class BankInfoController {

    @Autowired
    private BankInfoService bankInfoService;

    @GetMapping("list")
    public JsonData list() {
        BankInfo queryBankInfo = new BankInfo();
        List<BankInfo> bankInfoList = this.bankInfoService.queryEntityList(queryBankInfo);
        return JsonData.getSucceed(CollectionUtils.isEmpty(bankInfoList) ? new ArrayList<>() : bankInfoList);
    }
}
