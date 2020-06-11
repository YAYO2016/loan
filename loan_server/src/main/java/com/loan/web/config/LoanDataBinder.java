package com.loan.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 接受前台时间类型的传值，并格式化
 *
 * @author GuoKang
 * @date 2019-05-30 20:57
 */
@Configuration
public class LoanDataBinder implements WebBindingInitializer {
    private static final LoanDataBinder LOAN_DATA_BINDER = new LoanDataBinder();

    @Override
    public void initBinder(WebDataBinder webDataBinder) {
        // 字符串去空格
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

        // 时间格式转化
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    public void getWebBindingInitializer(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        requestMappingHandlerAdapter.setWebBindingInitializer(LOAN_DATA_BINDER);
    }

}
