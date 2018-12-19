package com.chinasofti.moviesell.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasoft.moviesell.domain.gai.TheatresItem;
import com.chinasofti.commonsframework.datasource.ConnectionManager;
import com.chinasofti.commonsframework.datasource.TransactionManager;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.dao.ITheatresDao;
import com.chinasofti.moviesell.dao.impl.TheatresDaoImpl;

public class TheatresBizImpl implements ITheatresBiz {

	public boolean add(Theatres theatre) {
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
		
		ITheatresDao theatresDao=new TheatresDaoImpl();

		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = theatresDao.insert(theatre, queryRunner, connection);
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

	public Theatres findById(int tno) {
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
		ITheatresDao theatresDao=new TheatresDaoImpl();

		try {
			Theatres theatre = theatresDao.selectById(tno, queryRunner, connection);
			return theatre;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public List<Theatres> findAll() {
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
		ITheatresDao theatresDao=new TheatresDaoImpl();

		try {
			List<Theatres> lstTheatres = theatresDao
					.selectAll(queryRunner, connection);
			return lstTheatres;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public boolean update(Theatres theatre) {
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

		ITheatresDao theatresDao=new TheatresDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = theatresDao.update(theatre, queryRunner, connection);
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

	public boolean delete(int tno) {
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

		ITheatresDao theatresDao=new TheatresDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = theatresDao.delete(tno, queryRunner, connection);
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

	public List<TheatresItem> findTheatresItemAll() {
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
		ITheatresDao theatresDao=new TheatresDaoImpl();

		try {
			List<TheatresItem> lstTheatresItem = theatresDao
					.selectTheatresItemAll(queryRunner, connection);
			return lstTheatresItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public List<Theatres> findByCno(int cno) {
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
		ITheatresDao theatresDao=new TheatresDaoImpl();

		try {
			List<Theatres> lstTheatres = theatresDao
					.selectByCno(cno, queryRunner, connection);
			return lstTheatres;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
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
		ITheatresDao theatresDao=new TheatresDaoImpl();

		try {
			//SELECT * FROM jeemoviesell.showmoive s limit ?,?  从0开始
			String strSQL = "SELECT c.cname as tcname,t.* FROM theatres t, cities c where t.cno=c.cno  order by t.tno limit ?,?";
			
			
			String strSQLCount = "SELECT count(*) FROM theatres t, cities c where t.cno=c.cno  order by t.tno";
			PageBean pageBean=theatresDao.selectByPage(strSQLCount,strSQL, currentPage, pageSize, queryRunner, connection);
			return pageBean;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

}
