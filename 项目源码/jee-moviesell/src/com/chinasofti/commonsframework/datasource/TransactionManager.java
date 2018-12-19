package com.chinasofti.commonsframework.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import com.chinasofti.commonsframework.util.Log;

public class TransactionManager {

	/**
	 * <p>Project: CH01-Mission01-JDBC</p>
	 * <p>Package: com.chinasofti.easyframework.dbutils</p>
	 * <p>Title: beginTransaction</p>
	 * <p>Description: 开启一个事务操作</p>
	 * <p>@param connection</p>
	 * <p>@return void</p>
	 * @author alvin
	 * @since JDK 1.7.55
	 * @date  2014年9月29日 下午4:12:31
	 * @version: 1.0
	 */
	public static void beginTransaction(final Connection connection){
		// 判断Connection对象是否为空
		if(connection != null){
			try {
				connection.setAutoCommit(false);
				Log.out("TransactionManager", "数据库事务设置为手动模式并启动……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // 设置事务为手动提交模式
		}
	}
	
	/**
	 * <p>Project: CH01-Mission01-JDBC</p>
	 * <p>Package: com.chinasofti.easyframework.dbutils</p>
	 * <p>Title: commit</p>
	 * <p>Description: 提交事务</p>
	 * <p>@param connection</p>
	 * <p>@return void</p>
	 * @author alvin
	 * @since JDK 1.7.55
	 * @date  2014年9月29日 下午4:13:48
	 * @version: 1.0
	 */
	public static void commit(final Connection connection){
		// 判断Connection对象是否为空
		if(connection != null){
			try {
				connection.commit(); // 提交事务
				Log.out("TransactionManager", "数据库事务提交……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}		
	}
	
	public static void rollback(final Connection connection){
		// 判断Connection对象是否为空
		if(connection != null){
			try {
				connection.rollback(); // 提交回滚
				Log.out("TransactionManager", "数据库事务回滚……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}		
	}
}
