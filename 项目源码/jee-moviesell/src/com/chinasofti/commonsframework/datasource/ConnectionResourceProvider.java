package com.chinasofti.commonsframework.datasource;

import org.apache.commons.dbcp.BasicDataSource;

// 单例模式：数据库连接池中连接对象资源提供者
public class ConnectionResourceProvider {

	// 步骤1：创建一个属性对象，该属性类型必须是自身
	private static ConnectionResourceProvider instance;  
	// 步骤2：创建一个属性对象，该属性应该是数据库连接池资源对象
	private static BasicDataSource basicDataSource;
	
	// 步骤2：构造方法必须是私有的
	private ConnectionResourceProvider(){}

	// 步骤3：生成类属性的getter和setter方法
	public static BasicDataSource getBasicDataSource() {
		return basicDataSource;
	}

	public static void setBasicDataSource(BasicDataSource basicDataSource) {
		ConnectionResourceProvider.basicDataSource = basicDataSource;
	}

	public static ConnectionResourceProvider getInstance() {
		if(instance == null){
			return new ConnectionResourceProvider();
		}else{
			return instance;
		}		
	}
	
	
}
