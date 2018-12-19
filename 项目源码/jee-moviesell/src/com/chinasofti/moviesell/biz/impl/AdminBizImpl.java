package com.chinasofti.moviesell.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Administraors;
import com.chinasofti.commonsframework.datasource.ConnectionManager;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.moviesell.biz.IAdminBiz;
import com.chinasofti.moviesell.dao.IAdminDao;
import com.chinasofti.moviesell.dao.impl.AdminDaoImpl;

public class AdminBizImpl implements IAdminBiz{

	public boolean add(Administraors admin) {
		// TODO Auto-generated method stub
		
	
		
		return false;
	}

	public Administraors findById(int ano) {
		// TODO Auto-generated method stub
				// 步骤1：创建一个连接管理器
				ConnectionManager connectionManager = new ConnectionManager();
				// 步骤2：获取数据库连接池对象
				BasicDataSource basicDataSource = connectionManager.openConnection();
				// 步骤3：构建一个QueryRunner对象
				QueryRunner queryRunner = new QueryRunner(basicDataSource);
				Log.out(this.getClass().getSimpleName(), "构建QueryRunner对象……");
				// 步骤4：获取一个数据库连接对象
				Connection connection = null;
				try {
					connection = basicDataSource.getConnection();
					Log.out(this.getClass().getSimpleName(),
							"从数据库连接池对象中获取一个数据库连接对象Connection……");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 步骤5：调用Dao
				IAdminDao adminDao=new AdminDaoImpl();
				
				try {
					Administraors  admin = adminDao.selectById(ano, queryRunner, connection);
					return admin;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 关闭数据库连接
					connectionManager.closeConnection(connection);
				}
	}

	public List<Administraors> findAll() {
		// TODO Auto-generated method stub
				// 步骤1：创建一个连接管理器
				ConnectionManager connectionManager = new ConnectionManager();
				// 步骤2：获取数据库连接池对象
				BasicDataSource basicDataSource = connectionManager.openConnection();
				// 步骤3：构建一个QueryRunner对象
				QueryRunner queryRunner = new QueryRunner(basicDataSource);
				Log.out(this.getClass().getSimpleName(), "构建QueryRunner对象……");
				// 步骤4：获取一个数据库连接对象
				Connection connection = null;
				try {
					connection = basicDataSource.getConnection();
					Log.out(this.getClass().getSimpleName(),
							"从数据库连接池对象中获取一个数据库连接对象Connection……");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 步骤5：调用Dao
				IAdminDao adminDao=new AdminDaoImpl();
				
				try {
					List<Administraors> lstAdmin = adminDao.selectAll(queryRunner, connection);
					return lstAdmin;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 步骤6：关闭数据库连接
					connectionManager.closeConnection(connection);
				}
	}

	public boolean update(Administraors admin) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int ano) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkLogin(Administraors admin) {
		
		String adminaacount=admin.getAaccount();
		String adminapass=admin.getApass();
		
		List<Administraors> lstAdmin=this.findAll();
		for (Administraors adminItem : lstAdmin) {
			if(adminItem.getAaccount().equals(adminaacount)&&adminItem.getApass().equals(adminapass)){
				return true;
			}
		}
		
		return false;
	}

}
