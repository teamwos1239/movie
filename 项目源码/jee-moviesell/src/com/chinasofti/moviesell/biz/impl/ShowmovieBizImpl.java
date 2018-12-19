package com.chinasofti.moviesell.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.commonsframework.datasource.ConnectionManager;
import com.chinasofti.commonsframework.datasource.TransactionManager;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.dao.IShowmoiveDao;
import com.chinasofti.moviesell.dao.impl.ShowmoiveDaoImpl;

public class ShowmovieBizImpl implements IShowmovieBiz {

	public boolean add(Showmoive showmoive) {
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
		TransactionManager.beginTransaction(connection);

		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();
		
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = showmoiveDao.insert(showmoive, queryRunner, connection);
			flag = affectedRows > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (flag) {
			TransactionManager.commit(connection);
		} else {
			TransactionManager.rollback(connection);
		}
		connectionManager.closeConnection(connection);
		return flag;
	}

	public Showmoive findById(int sno) {
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

		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();

		try {
			Showmoive showmoive = showmoiveDao.selectById(sno, queryRunner, connection);
			return showmoive;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	public List<Showmoive> findAll() {
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
		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();

		try {
			List<Showmoive> lstShowmoive = showmoiveDao
					.selectAll(queryRunner, connection);
			return lstShowmoive;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public boolean update(Showmoive showmoive) {
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
		TransactionManager.beginTransaction(connection);

		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = showmoiveDao.update(showmoive, queryRunner, connection);
			flag = affectedRows > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (flag) {
			TransactionManager.commit(connection);
		} else {
			TransactionManager.rollback(connection);
		}
		connectionManager.closeConnection(connection);
		return flag;
	}

	public boolean delete(int sno) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransactionManager.beginTransaction(connection);

		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = showmoiveDao.delete(sno, queryRunner, connection);
			flag = affectedRows > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (flag) {
			TransactionManager.commit(connection);
		} else {
			TransactionManager.rollback(connection);
		}
		connectionManager.closeConnection(connection);
		return flag;
	}

	public List<ShowmoiveItem> findShowmoiveItemAll() {
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
		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();

		try {
			List<ShowmoiveItem> lstShowmoiveItem = showmoiveDao
					.selectShowmoiveItemAll(queryRunner, connection);
			return lstShowmoiveItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public List<ShowmoiveItem> findShowmoiveItemByCname(int cno) {
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
		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();

		try {
			List<ShowmoiveItem> lstShowmoiveItem = showmoiveDao
					.selectShowmoiveItemByCname(cno, queryRunner, connection);
			return lstShowmoiveItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public List<ShowmoiveItem> findShowmoiveItemByCondition(String strSQL) {
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
		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();

		try {
			List<ShowmoiveItem> lstShowmoiveItem = showmoiveDao
					.selectShowmoiveItemByConditon(strSQL, queryRunner, connection);
			return lstShowmoiveItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public PageBean findAllByPage(int currentPage, int pageSize,final String paixun) {
		
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
		IShowmoiveDao showmoiveDao=new ShowmoiveDaoImpl();

		try {
			//SELECT * FROM jeemoviesell.showmoive s limit ?,?  从0开始
			String strSQL = "SELECT * FROM v_showmoive v order by "+paixun+"  limit ?,?";
			String strSQLCount = "SELECT count(*) FROM v_showmoive v";
			PageBean pageBean=showmoiveDao.selectByPage(strSQLCount,strSQL, currentPage, pageSize, queryRunner, connection);
			return pageBean;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}
	

}
