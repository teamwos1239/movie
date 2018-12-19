package com.chinasofti.commonsframework.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.chinasofti.commonsframework.util.Log;

public class ConnectionManager {

	@SuppressWarnings("unused")
	public BasicDataSource openConnection(){
		// 步骤1：获取数据库连接对象提供者
		ConnectionResourceProvider connectionResourceProvider = ConnectionResourceProvider.getInstance();
		// 步骤2：获取数据库连接池对象
		BasicDataSource basicDataSource = ConnectionResourceProvider.getBasicDataSource();
		Log.out(this.getClass().getSimpleName(), "获取数据库连接池资源……");
		// 步骤3：返回数据库连接池资源
		return basicDataSource;
	}
	
	public void closeConnection(final Connection connection){
		// 步骤1：判断还回的连接对象是否有效
		if(connection != null){
			try {
				// 步骤2：将连接对象还回数据库连接池
				connection.close();
				Log.out(this.getClass().getSimpleName(), "还回数据库连接对象到数据库连接池……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
