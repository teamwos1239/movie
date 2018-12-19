package com.chinasofti.commonsframework.datasource;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp.BasicDataSource;

import com.chinasofti.commonsframework.util.Log;

/**
 * Application Lifecycle Listener implementation class ConnectionPoolListener
 *
 */
public class ConnectionPoolListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ConnectionPoolListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @SuppressWarnings("unused")
	public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	
    	try {
    		// 步骤1：创建一个Context上下文对象用于访问数据库连接池资源
			Context initContext = new InitialContext(); // 初始化Context接口对象
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			// 步骤2：使用envContext对象获取项目配置过的数据库连接池资源
			BasicDataSource basicDataSource = (BasicDataSource) envContext.lookup("jdbc/MySQLDB");
			// 步骤3：创建一个数据库连接池连接对象提供者
			ConnectionResourceProvider connectionResourceProvider = ConnectionResourceProvider.getInstance();
			// 步骤4：将步骤2获取到的数据库连接池资源对象绑定到步骤3创建的连接对象提供者中
			ConnectionResourceProvider.setBasicDataSource(basicDataSource);
			Log.out(this.getClass().getSimpleName(), "CommonsFramework DataBase Connection Pool is successfully!");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @SuppressWarnings("unused")
	public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	// 步骤1：获取数据库连接池连接对象提供者
    	ConnectionResourceProvider connectionResourceProvider = ConnectionResourceProvider.getInstance();
    	// 步骤2：从提供者对象中获取到数据库连接池资源对象
    	BasicDataSource basicDataSource = ConnectionResourceProvider.getBasicDataSource();
    	// 步骤3：关闭数据库连接池资源
    	try {
			basicDataSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Log.out(this.getClass().getSimpleName(), "CommonsFramework DataBase Connection Pool has shutdown!");
    }
	
}
