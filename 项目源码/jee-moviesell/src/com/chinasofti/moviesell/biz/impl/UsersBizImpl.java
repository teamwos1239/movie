package com.chinasofti.moviesell.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.datasource.ConnectionManager;
import com.chinasofti.commonsframework.datasource.TransactionManager;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.IUsersBiz;
import com.chinasofti.moviesell.dao.IUsersDao;
import com.chinasofti.moviesell.dao.impl.UsersDaoImpl;

public class UsersBizImpl implements IUsersBiz {

	public boolean add(Users user) {
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
		IUsersDao usersDao = new UsersDaoImpl();

		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = usersDao.insert(user, queryRunner, connection);
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

	public Users findById(int uno) {
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
		IUsersDao usersDao = new UsersDaoImpl();
		try {
			Users user = usersDao.selectById(uno, queryRunner, connection);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public List<Users> findAll() {
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
		IUsersDao usersDao = new UsersDaoImpl();

		try {
			List<Users> lstUser = usersDao.selectAll(queryRunner, connection);
			return lstUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public boolean update(Users user) {
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
		IUsersDao usersDao = new UsersDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = usersDao.update(user, queryRunner, connection);
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

	public boolean delete(int uno) {
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
		IUsersDao usersDao = new UsersDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = usersDao.delete(uno, queryRunner, connection);
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

	public Users checkLogin(Users user) {
		String useruemail = user.getUemail();
		String userupass = user.getUpass();

		List<Users> lstUser = this.findAll();
		
		for (Users userItem : lstUser) {
			if (userItem.getUemail().equals(useruemail)
					&& userItem.getUpass().equals(userupass)) {
				return userItem;
			}
		}

		return null;
	}

	public Users findUnoByEmail(String uemail) {
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
				IUsersDao usersDao = new UsersDaoImpl();
				try {
					Users user = usersDao.selectIdByEmail(uemail, queryRunner, connection);
					return user;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 关闭数据库连接
					connectionManager.closeConnection(connection);
				}
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
		IUsersDao usersDao = new UsersDaoImpl();
		

		try {
			//SELECT * FROM jeemoviesell.showmoive s limit ?,?  从0开始
			String strSQL = "SELECT * FROM users limit ?,?";
			String strSQLCount = "SELECT count(*) FROM users";
			PageBean pageBean=usersDao.selectByPage(strSQLCount,strSQL, currentPage, pageSize, queryRunner, connection);
			return pageBean;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
		
	}

}
