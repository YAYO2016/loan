package com.loan.web.controller;

import com.loan.service.model.dto.UserInfoDto;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GuoKang
 * @date 2019-04-18 22:18
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/getAuth")
    @ResponseBody
    public JsonData getAuth() {
        UserInfoDto userInfoDto = LoginInfoHolder.getUserInfoDto();
        return JsonData.getSucceed(userInfoDto);
    }
}
