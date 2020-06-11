package com.loan.framework.enums;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-21 00:16
 */
public interface BaseEnum {
    /**
     * 前端需要获取此枚举的集合时，务必实现此方法
     */
    List listAll();
}
