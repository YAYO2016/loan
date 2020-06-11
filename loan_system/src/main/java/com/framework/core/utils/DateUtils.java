package com.framework.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtils {
	
	private final static Logger logger = Logger.getLogger(DateUtils.class);

	/**日期格式转换**/
	public static String dateTimeFormat(String dateTime,String pattern) {
		try {
			if("".equals(dateTime)){
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(sdf.parse(dateTime));
		} catch (ParseException e) {
			logger.error(CommonUtils.getLogInfoTemp(e.getMessage()));
		}
		return null;
	}
	
	public static String dateTimeFormatToNull(String dateTime) {
		if("".equals(dateTime)){
			return null;
		}
		return dateTime;
	}
	
    public static Date stringToDate(String str) {  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = null;  
        try {  
            date = format.parse(str);   
        } catch (ParseException e) {  
            logger.error(CommonUtils.getLogInfoTemp(e.getMessage()));  
        }  
        date = java.sql.Date.valueOf(str);  
        return date;  
    }  
    
    public static String getNowTime(String format){
    	Date now = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);//可以方便地修改日期格式
    	String hehe = dateFormat.format(now);
    	return hehe;
    }
    
    public static String getNowHourAgoTime(String format){
    	Date now = new Date(new Date().getTime()-1*60*60*1000);
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);//可以方便地修改日期格式
    	String hehe = dateFormat.format(now);
    	return hehe;
    }
    
    public static String getPrvMon(String format1){
	    Calendar c = Calendar.getInstance();
	    c.add(Calendar.MONTH, -1);
	    SimpleDateFormat format =  new SimpleDateFormat(format1);
	    String time = format.format(c.getTime());
	    return time;
    }

    public static void main(String[] args) {
		logger.info(CommonUtils.getLogInfoTemp(getNowTime("yyyyMMddHHmmssSSS")));
	}
    
    public static String getPrvTime(String format){ //获取昨天的时间
    	Date prve = new Date(new Date().getTime()-24*60*60*1000);
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    	String hehe = dateFormat.format(prve);
    	return hehe;
    }
    
	/**
	 * 获取指定格式的当前日期 参数：pattern，日期格式，如:yyyyMMddhhmmss 格式描述符的含义参见JDK simpleDateFormat类
	 */
	public static String getCurrentDate(String pattern) {
		if (pattern == null) {
			throw new IllegalArgumentException("input string parameter is null");
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date now = new Date();
		return sdf.format(now);
	}
	
	 /**
     * 功能：得到当前月份月底 格式为：xxxx-yy-zz (eg: 2007-12-31)<br> 
     * @return String
     * @author pure
     */
    public static String thisMonthEnd(String pattern) {
        String strY = null;
        String strZ = null;
        Calendar  localTime = Calendar.getInstance();
        int x = localTime.get(Calendar.YEAR);
        int y = localTime.get(Calendar.MONTH) + 1;
        strZ = getStrZ(strZ, x, y);
        strY = y >= 10 ? String.valueOf(y) : ("0" + y);
        return x + pattern + strY + pattern + strZ;
    }

	private static String getStrZ(String strZ, int x, int y) {
		boolean leap;
		strZ = getNotLeapMonth(strZ, y);
        if (y == 2) {
            leap = leapYear(x);
            if (leap) {
                strZ = "29";
            }
            else {
                strZ = "28";
            }
        }
		return strZ;
	}

	private static String getNotLeapMonth(String strZ, int y) {
		if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10 || y == 12) {
            strZ = "31";
        }
        if (y == 4 || y == 6 || y == 9 || y == 11) {
            strZ = "30";
        }
		return strZ;
	}
    
    /**
     * 功能：判断输入年份是否为闰年<br>
     * 
     * @param year
     * @return 是：true  否：false
     * @author pure
     */
    public static boolean leapYear(int year) {
        boolean leap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                	leap = true;
                }
                else {
                	leap = false;
                }
            }
            else {
            	leap = true;
            }
        }
        else {
        	leap = false;
        }
        return leap;
    }
}
