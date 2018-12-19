package com.chinasofti.moviesell.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.commonsframework.datasource.ConnectionManager;
import com.chinasofti.commonsframework.datasource.TransactionManager;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.dao.IMoviesDao;
import com.chinasofti.moviesell.dao.impl.MoviesDaoImpl;

public class MoviesBizImpl implements IMoviesBiz {

	public boolean add(Movies movie) {
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
		IMoviesDao moviesDao = new MoviesDaoImpl();

		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = moviesDao.insert(movie, queryRunner, connection);
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

	public Movies findById(int mno) {
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

		IMoviesDao moviesDao = new MoviesDaoImpl();

		try {
			Movies movie = moviesDao.selectById(mno, queryRunner, connection);
			return movie;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	public List<Movies> findAll() {
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
		IMoviesDao moviesDao = new MoviesDaoImpl();

		try {
			List<Movies> lstMovie = moviesDao
					.selectAll(queryRunner, connection);
			return lstMovie;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 步骤6：关闭数据库连接
			connectionManager.closeConnection(connection);
		}
	}

	public boolean update(Movies movie) {
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

		IMoviesDao moviesDao = new MoviesDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = moviesDao.update(movie, queryRunner, connection);
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

	
	public boolean delete(int mno) {
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

		IMoviesDao moviesDao = new MoviesDaoImpl();
		int affectedRows = 0;
		boolean flag = false;
		try {
			affectedRows = moviesDao.delete(mno, queryRunner, connection);
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
		IMoviesDao moviesDao = new MoviesDaoImpl();
		

		try {
			//SELECT * FROM jeemoviesell.showmoive s limit ?,?  从0开始
			String strSQL = "SELECT * FROM movies limit ?,?";
			String strSQLCount = "SELECT count(*) FROM movies";
			PageBean pageBean=moviesDao.selectByPage(strSQLCount,strSQL, currentPage, pageSize, queryRunner, connection);
			return pageBean;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	public List<Movies> findByCondition(String strSQL) {
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
		IMoviesDao moviesDao = new MoviesDaoImpl();

		try {
			List<Movies> lstMovie = moviesDao
					.selectByConditon(strSQL, queryRunner, connection);
			return lstMovie;
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
