package com.framework.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	private static Object lock = new Object();

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		if(applicationContext == null){
			synchronized (lock) {
				if(applicationContext == null){
					applicationContext = arg0;
				}
			}
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}
	

}
