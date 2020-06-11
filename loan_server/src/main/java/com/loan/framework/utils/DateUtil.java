package com.loan.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-05-18 20:57
 */
public class DateUtil {

    private static final Long dayMillisecond = 1000 * 3600 * 24L;
    private static final String monthFormater = "yyyy-MM";
    private static final String dateFormater = "yyyy-MM-dd";
    private static final String timeFormater = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取两个时间的天数差
     *
     * @param beforeDate 如 2018-10-20
     * @param afterDate  如 2018-10-21
     * @return date2与date1的日期差
     */
    public static Integer calcDateDiffDays(Date beforeDate, Date afterDate) {
        if (null == beforeDate || null == afterDate) return null;
        if (beforeDate.after(afterDate)) return 0;
        Integer diff;
        try {
            diff = (int) ((getDateForDay(afterDate).getTime() - getDateForDay(beforeDate).getTime()) / dayMillisecond);
        } catch (ParseException e) {
            return null;
        }
        return diff;
    }

    private static Date getDateForDay(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormater);
        return sdf.parse(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static Date getStartDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormater);
        String dateStr = sdf.format(date);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getEndDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormater);
        String dateStr = sdf.format(date);
        try {
            return new SimpleDateFormat(timeFormater).parse(dateStr + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getCurrentMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getStartDate(calendar.getTime());
    }

    public static Date getCurrentMonthLastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getEndDate(calendar.getTime());
    }
}
