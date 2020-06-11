package com.loan.web.controller;

import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-21 00:07
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    private Logger logger = LoggerFactory.getLogger(CommonController.class);

    @GetMapping("getEnumsMap")
    public JsonData getEnumsMap(@RequestParam("enumsType") String enumsType) {
        List list = getEnumsMapList(enumsType);
        if (null == list)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "枚举数据为空");
        return JsonData.getSucceed(list);
    }

    @GetMapping("getBatchEnumsMap")
    public JsonData getBatchEnumsMap(@RequestParam("enumsTypes") String enumsTypes) {
        List<String> enumsTypeList = Arrays.asList(enumsTypes.split(","));

        Map<String, List> resultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(enumsTypeList)) {
            enumsTypeList.forEach(enumsType -> {
                if (StringUtils.isEmpty(enumsType)) return;
                List list = getEnumsMapList(enumsType);
                if (null == list) return;
                resultMap.put(enumsType, list);
            });
        }
        if (resultMap.isEmpty())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "枚举数据为空");
        return JsonData.getSucceed(resultMap);
    }


    private List getEnumsMapList(String enumsType) {
        Class<?> clazz = null;
        List list = null;
        try {
            clazz = Class.forName("com.loan.service.enums." + enumsType);
            Method method = clazz.getMethod("listAll");
            if (clazz.getEnumConstants().length > 0)
                list = (List) method.invoke(clazz.getEnumConstants()[0]);
        } catch (Exception e) {
            logger.error("获取枚举类数据异常", e);
        }
        return list;
    }
}

