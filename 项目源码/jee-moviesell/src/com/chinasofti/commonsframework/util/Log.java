package com.chinasofti.commonsframework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	/**
	 * <p>Project: CH01-Mission01-JDBC</p>
	 * <p>Package: com.chinasofti.easyframework.utils</p>
	 * <p>Title: out</p>
	 * <p>Description: 日志系统中专门输出类状态和消息的方法</p>
	 * <p>@param className
	 * <p>@param message</p>
	 * <p>@return void</p>
	 * @author alvin
	 * @since JDK 1.7.55
	 * @date  2014年9月29日 下午4:01:48
	 * @version: 1.0
	 */
	public static void out(final String className, final String message){
		String strDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		System.out.println("[CommonsFramework "+className+" "+strDate+ "]: " + message);
	}
	
	/**
	 * <p>Project: CH01-Mission01-JDBC</p>
	 * <p>Package: com.chinasofti.easyframework.utils</p>
	 * <p>Title: out</p>
	 * <p>Description:日志系统中专门输出SQL语句参数的方法 </p>
	 * <p>@param className
	 * <p>@param params</p>
	 * <p>@return void</p>
	 * @author alvin
	 * @since JDK 1.7.55
	 * @date  2014年9月29日 下午4:57:49
	 * @version: 1.0
	 */
	public static void out(final String className, final Object...params){
		if(params.length == 0){
			Log.out(className, "无参数");
			return;
		}
		String strDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		StringBuilder stringBuilder = new StringBuilder("[");
		for (int i = 0; i < params.length; i++) {
			stringBuilder.append(params[i]+", ");
		}
		stringBuilder = new StringBuilder(stringBuilder.subSequence(0, stringBuilder.length()-2));
		stringBuilder.append("]");
		System.out.println("[CommonsFramework "+className+" "+strDate+ "]: " + stringBuilder.toString());
	}
}
