package com.loan.framework.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author GuoKang
 * @date 2019-04-23 23:43
 */
public class FeeUtils {

    /**
     * 把分转成元
     *
     * @param cent
     * @return
     */
    public static Double getYuanFromCent(Integer cent) {
        if (null == cent) return null;
        return BigDecimal.valueOf(Long.valueOf(cent)).divide(new BigDecimal(100)).doubleValue();
    }

    /**
     * 把元转成分
     *
     * @param yuan
     * @return
     */
    public static Integer getCentFromYuan(Double yuan) {
        if (null == yuan) return null;
        return BigDecimal.valueOf(yuan).multiply(new BigDecimal(100)).intValue();
    }

    /**
     *
     */
    public static String getFeeStringNoDecimal(Double fee) {
        return null == fee ? "0" : new DecimalFormat("#").format(fee);
    }
}
