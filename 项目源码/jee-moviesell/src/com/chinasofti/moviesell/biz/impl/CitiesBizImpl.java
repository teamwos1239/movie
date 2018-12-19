package com.chinasofti.moviesell.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasofti.commonsframework.datasource.ConnectionManager;
import com.chinasofti.commonsframework.datasource.TransactionManager;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.ICitiesBiz;
import com.chinasofti.moviesell.dao.ICitiesDao;
import com.chinasofti.moviesell.dao.impl.CitiesDaoImpl;

public class CitiesBizImpl implements ICitiesBiz {

	public boolean add(Cities city) {
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
		// 步骤5：开启一个事务处理
		TransactionManager.beginTransaction(connection);

		// 步骤6：执行Dao层方法完成添加操作
		ICitiesDao citiesDao = new CitiesDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = citiesDao.insert(city, queryRunner, connection);
			flag = affectedRows > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 步骤7：根据处理结果提交或回滚事务
		if (flag) {
			TransactionManager.commit(connection);
		} else {
			TransactionManager.rollback(connection);
		}
		// 步骤8：关闭数据库连接对象
		connectionManager.closeConnection(connection);
		// 返回
		return flag;
	}

	public Cities findById(int cno) {
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
		ICitiesDao citiesDao = new CitiesDaoImpl();
		try {
			Cities  city = citiesDao.selectById(cno, queryRunner, connection);
			return city;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public List<Cities> findAll() {
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
		ICitiesDao citiesDao = new CitiesDaoImpl();
		try {
			List<Cities> lstCity = citiesDao.selectAll(queryRunner, connection);
			return lstCity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public boolean update(Cities city) {
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
		// 步骤5：开启一个事务处理
		TransactionManager.beginTransaction(connection);

		// 步骤6：执行Dao层方法完成添加操作
		ICitiesDao citiesDao = new CitiesDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = citiesDao.update(city, queryRunner, connection);
			flag = affectedRows > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 步骤7：根据处理结果提交或回滚事务
		if (flag) {
			TransactionManager.commit(connection);
		} else {
			TransactionManager.rollback(connection);
		}
		// 步骤8：关闭数据库连接对象
		connectionManager.closeConnection(connection);
		// 返回
		return flag;
	}

	public boolean delete(int cno) {
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
		// 步骤5：开启一个事务处理
		TransactionManager.beginTransaction(connection);

		// 步骤6：执行Dao层方法完成添加操作
		ICitiesDao citiesDao = new CitiesDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = citiesDao.delete(cno, queryRunner, connection);
			flag = affectedRows > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 步骤7：根据处理结果提交或回滚事务
		if (flag) {
			TransactionManager.commit(connection);
		} else {
			TransactionManager.rollback(connection);
		}
		// 步骤8：关闭数据库连接对象
		connectionManager.closeConnection(connection);
		// 返回
		return flag;
	}

	public PageBean findAllByPage(int currentPage, int pageSize) {
		
		ConnectionManager connectionManager = new ConnectionManager();
		BasicDataSource basicDataSource = connectionManager.openConnection();
		QueryRunner queryRunner = new QueryRunner(basicDataSource);
		Log.out(this.getClass().getSimpleName(), "构建QueryRunner对象……");
		Connection connection = null;
		try {
			connection = basicDataSource.getConnection();
			Log.out(this.getClass().getSimpleName(),
					"从数据库连接池对象中获取一个数据库连接对象Connection……");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ICitiesDao citiesDao = new CitiesDaoImpl();
		

		try {
			//SELECT * FROM jeemoviesell.showmoive s limit ?,?  从0开始
			String strSQL = "SELECT * FROM cities limit ?,?";
			String strSQLCount = "SELECT count(*) FROM cities";
			PageBean pageBean=citiesDao.selectByPage(strSQLCount,strSQL, currentPage, pageSize, queryRunner, connection);
			return pageBean;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	public List<Cities> findAllByProName(String proName) {
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
				ICitiesDao citiesDao = new CitiesDaoImpl();
				try {
					List<Cities> lstCity = citiesDao.selectAllByProName(proName, queryRunner, connection);
					return lstCity;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 步骤6：关闭数据库连接
					connectionManager.closeConnection(connection);
				}
	}

}
