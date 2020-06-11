package com.framework.core.utils;

import java.io.Serializable;


@SuppressWarnings({ "serial"})
public class GlobalConst implements Serializable {
	 
	public static long stime = 1800000;//超时时长（毫秒）   
	public static boolean isDebug = true; 
	public static final int NUMBERS_PER_PAGE = 15;
	public static final String DIALECT = "MYSQL";
	public static String DATE_PATTERN_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	public static final String SESSION_KEY = "new_iop";//系统session键值常量
	public static final String DB_NAME = "";
	public static final String BUSINESS_NAME = "NEW_IOP";
	public static final String HELP_DOCUMENT_PATH="/mcupload/";//帮助文档下载路径
	
}
