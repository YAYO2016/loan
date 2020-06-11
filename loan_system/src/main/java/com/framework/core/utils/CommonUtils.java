package com.framework.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.framework.core.entity.SessionBean;


public class CommonUtils {

	private final static Logger logger = Logger.getLogger(CommonUtils.class);
	
	public static String getNoLogInfoTemp(String logInfo){
        return "||||web|"+GlobalConst.BUSINESS_NAME+"||"+logInfo+"|";
    }

	public static String getLogInfoTemp(String logInfo){
        HttpSession session = ContextHolderUtils.getSession();
        SessionBean sb = (SessionBean)session.getAttribute(GlobalConst.SESSION_KEY);
        return "|"+sb.getLocalAddr()+"|"+sb.getLocalPort()+"|"+sb.getLocalName()+"|web|"+GlobalConst.BUSINESS_NAME+"|"+session.getId()+"|"+logInfo+"|";
    }

    public static String getLogInfoTemp(HttpServletRequest request,String logInfo){
        HttpSession session = request.getSession();
        SessionBean sb = (SessionBean)session.getAttribute(GlobalConst.SESSION_KEY);
        return "|"+sb.getLocalAddr()+"|"+sb.getLocalPort()+"|"+sb.getLocalName()+"|web|"+GlobalConst.BUSINESS_NAME+"|"+session.getId()+"|"+logInfo+"|";
    }

	
	/**
	 * 将输入的字符串列表根据连接字符组成一个字符串
	 *
	 * @param key
	 *            list中元素的key值
	 *
	 * @param list
	 *            当key不为空时，字符串列表里面是key value的map数据类型，当key为空是list里面是String类型
	 * @param combination
	 *            连接字符
	 * @return 合成的字符串
	 */
	public static String getCombineStr(List list, String key, String combination)
	{

		logger.info(CommonUtils.getLogInfoTemp("" + key));
		String result = "";
		if (list == null || list.isEmpty())
		{
			return "";
		}
		String value = "";
		for (int i = 0; i < list.size(); i++)
		{
			if (key == null || "".equals(key))
			{
				value = list.get(i) + "";
			} else
			{
				value = ((Map) list.get(i)).get(key) + "";
			}
			if (i == 0)
			{
				result = result + value;
			} else
			{
				result = result + combination + value;
			}
		}
		return result;
	}
}
