package com.loan.web.common;

/**
 * @author GuoKang
 * @date 2019-04-18 00:39
 */
public interface CommonData {
    enum StatusCode {
        STATUS_CODE_100(100, "异常状态"),
        STATUS_CODE_200(200, "操作成功"),
        STATUS_CODE_300(300, "您还未登录系统或登录信息已失效，请登录"),
        STATUS_CODE_301(301, "账号或密码错误"),
        STATUS_CODE_320(320, "权限不足"),
        STATUS_CODE_400(400, "业务错误"),
        STATUS_CODE_401(401, "缺少必要参数"),
        // 需要增加枚举时，需要和前端人员协商含义
        ;

        private Integer code;
        private String desc;

        StatusCode(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
