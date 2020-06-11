package com.loan.web.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loan.framework.pagination.PageInfo;

import java.io.Serializable;

/**
 * restful接口返回封装
 *
 * @author GuoKang
 * @date 2019-04-18 00:39
 */
@SuppressWarnings("serial")
public class JsonData implements Serializable {
    private Integer status;
    private String msg;
    private Object data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PageInfo pageInfo;

    private JsonData(Integer status, String msg, Object data, PageInfo pageInfo) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.pageInfo = pageInfo;
    }

    /**
     * 组装自定义的返回结果
     */
    public static JsonData getResult(Integer status, String msg) {
        return new JsonData(status, msg, null, null);
    }

    public static JsonData getResult(Integer status, String msg, Object data) {
        return new JsonData(status, msg, data, null);
    }

    public static JsonData getResult(Integer status, String msg, Object data, PageInfo pageInfo) {
        return new JsonData(status, msg, data, pageInfo);
    }

    /**
     * 根据枚举类返回结果
     */
    public static JsonData getResult(CommonData.StatusCode statusCode) {
        return new JsonData(statusCode.getCode(), statusCode.getDesc(), null, null);
    }

    public static JsonData getResult(CommonData.StatusCode statusCode, Object data) {
        return new JsonData(statusCode.getCode(), statusCode.getDesc(), data, null);
    }

    public static JsonData getResult(CommonData.StatusCode statusCode, Object data, PageInfo pageInfo) {
        return new JsonData(statusCode.getCode(), statusCode.getDesc(), data, pageInfo);
    }

    public static JsonData getSucceed(Object data) {
        return new JsonData(CommonData.StatusCode.STATUS_CODE_200.getCode(), CommonData.StatusCode.STATUS_CODE_200.getDesc(), data, null);
    }

    public static JsonData getSucceed(Object data, PageInfo pageInfo) {
        return new JsonData(CommonData.StatusCode.STATUS_CODE_200.getCode(), CommonData.StatusCode.STATUS_CODE_200.getDesc(), data, pageInfo);
    }

    public static JsonData getSucceed() {
        return new JsonData(CommonData.StatusCode.STATUS_CODE_200.getCode(), CommonData.StatusCode.STATUS_CODE_200.getDesc(), null, null);
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }
}
