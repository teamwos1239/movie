package com.chinasofti.commonsframework.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class RequestToBean {
	
	// 扩展：实现对日期数据类型的自动封装处理
	static{
		// 步骤1：创建一个DataConverter转换器
		DateConverter dateConverter = new DateConverter();
		// 步骤2：设置一个日期格式数组
		String[] pattern = new String[]{"yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd"};
		// 步骤3：将设置好的日期格式数组绑定到日期转换器对象中
		dateConverter.setPatterns(pattern);
		// 步骤4：注册日期转换请并设置其转换的数据类型为java.util.Date
		ConvertUtils.register(dateConverter, java.util.Date.class);
	}

	// 步骤1：自定义一个方法populate用于将请求参数转换成实体类
	@SuppressWarnings("rawtypes")
	public static void polulate(HttpServletRequest request, Object bean){
		// 步骤1-1：创建一个Map集合用于获取请求对象中的参数列表集合
		Map properties = request.getParameterMap();
		Log.out("RequestToBean", "获取请求参数列表……");
		// 步骤1-2：使用BeanUtils包中的populate方法实现自动转换
		try {
			BeanUtils.populate(bean, properties);
			Log.out("RequestToBean", "分装客户端请求参数到实体类"+bean.getClass().getSimpleName()+"……");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
