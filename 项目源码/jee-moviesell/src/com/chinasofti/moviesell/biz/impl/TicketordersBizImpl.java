package com.chinasofti.moviesell.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.gai.OrderItem;
import com.chinasofti.commonsframework.datasource.ConnectionManager;
import com.chinasofti.commonsframework.datasource.TransactionManager;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.ITicketordersBiz;
import com.chinasofti.moviesell.dao.ITicketordersDao;
import com.chinasofti.moviesell.dao.impl.TicketordersDaoImpl;

public class TicketordersBizImpl implements ITicketordersBiz {

	public boolean add(Ticketorders order) {
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
				ITicketordersDao ticketordersDao=new TicketordersDaoImpl();
				
				int affectedRows = 0;
				boolean flag = false;
				try {
					affectedRows = ticketordersDao.insert(order, queryRunner, connection);
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

	public Ticketorders findById(int ono) {
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
				ITicketordersDao ticketordersDao=new TicketordersDaoImpl();
				try {
					Ticketorders order = ticketordersDao.selectById(ono, queryRunner, connection);
					return order;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 关闭数据库连接
					connectionManager.closeConnection(connection);
				}
	}

	public List<Ticketorders> findAll() {
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
				ITicketordersDao ticketordersDao=new TicketordersDaoImpl();

				try {
					List<Ticketorders> lstTicketorders = ticketordersDao.selectAll(queryRunner, connection);
					return lstTicketorders;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally {
					// 步骤6：关闭数据库连接
					connectionManager.closeConnection(connection);
				}
	}

	public boolean update(Ticketorders order) {
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
				ITicketordersDao ticketordersDao=new TicketordersDaoImpl();
				int affectedRows = 0;
				boolean flag = false;
				try {
					affectedRows = ticketordersDao.update(order, queryRunner, connection);
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

	public boolean delete(int ono) {
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
				ITicketordersDao ticketordersDao=new TicketordersDaoImpl();
				int affectedRows = 0;
				boolean flag = false;
				try {
					affectedRows = ticketordersDao.delete(ono, queryRunner, connection);
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

	public List<OrderItem> findOrderItemAll() {
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
		ITicketordersDao ticketordersDao=new TicketordersDaoImpl();

		try {
			List<OrderItem> lstOrderItem = ticketordersDao.selectOrderAll(queryRunner, connection);
			return lstOrderItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public List<OrderItem> findOrderItemsByCondition(String strSQl) {
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
				ITicketordersDao ticketordersDao=new TicketordersDaoImpl();

				try {
					List<OrderItem> lstOrderItem = ticketordersDao.selectOrderByConditon(strSQl, queryRunner, connection);
					return lstOrderItem;
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				} finally {
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
		ITicketordersDao ticketordersDao=new TicketordersDaoImpl();

		try {
			//SELECT * FROM jeemoviesell.showmoive s limit ?,?  从0开始
			String strSQL = "SELECT * FROM ticketorders limit ?,?";
			String strSQLCount = "SELECT count(*) FROM ticketorders";
			PageBean pageBean=ticketordersDao.selectByPage(strSQLCount,strSQL, currentPage, pageSize, queryRunner, connection);
			return pageBean;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	public PageBean findAllByUnoPage(int uno, int currentPage, int pageSize) {
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
		ITicketordersDao ticketordersDao=new TicketordersDaoImpl();

		try {
			//SELECT * FROM jeemoviesell.showmoive s limit ?,?  从0开始
			String strSQL = "SELECT * FROM ticketorders where uno="+uno+" limit ?,?";
			String strSQLCount = "SELECT count(*) FROM ticketorders where uno="+uno;
			PageBean pageBean=ticketordersDao.selectByPage(strSQLCount,strSQL, currentPage, pageSize, queryRunner, connection);
			return pageBean;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

}
