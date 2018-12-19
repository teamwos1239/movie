package com.chinasofti.moviesell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.dao.IMoviesDao;

public class MoviesDaoImpl implements IMoviesDao {
	

	public int insert(Movies movie, QueryRunner queryRunner,
			Connection connection) throws SQLException {

		String mname = movie.getMname();
		String mtype = movie.getMtype();
		Date mstarttime = movie.getMstarttime();
		Date mendtime = movie.getMendtime();
		String mroles = movie.getMroles();
		String mdirector = movie.getMdirector();
		String mcountry = movie.getMcountry();
		String mversion = movie.getMversion();
		int mlength = movie.getMlength();
		String minformation = movie.getMinformation();
		int mlikerate = movie.getMlikerate();
		String mpicpath = movie.getMpicpath();
		String mspecial = movie.getMspecial();

		/*
		 * mname,mtype,mstarttime,mendtime,mroles,mdirector, mcountry,mversion,
		 * mlength,minformation,mlikerate,mposter,mspecial
		 */

		String strSQL = "insert into movies values(null, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?,?)";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { mname, mtype, mstarttime, mendtime,
				mroles, mdirector, mcountry, mversion, mlength, minformation,
				mlikerate, mpicpath, mspecial };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public Movies selectById(int mno, QueryRunner queryRunner,
			Connection connection) throws SQLException {

		String strSQL = "select * from movies where mno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { mno };
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanHandler对象
		BeanHandler<Movies> movieHandler = new BeanHandler<Movies>(Movies.class);
		// 执行查询操作
		Movies movie = queryRunner.query(connection, strSQL, movieHandler,
				params);
		// 返回
		return movie;
	}

	public List<Movies> selectAll(QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "select * from movies order by mno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Movies> movieistHandler = new BeanListHandler<Movies>(
				Movies.class);
		// 执行查询操作
		List<Movies> lstMovie = queryRunner.query(connection, strSQL,
				movieistHandler, params);
		// 返回
		return lstMovie;
	}

	public int update(Movies movie, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "update movies set mname=?,mtype=?,mstarttime=?,mendtime=?,mroles=?,mdirector=?, mcountry=?,mversion=?, mlength=?,minformation=?,mlikerate=?,mpicpath=?,mspecial=? where mno=?";

		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { movie.getMname(), movie.getMtype(),
				movie.getMstarttime(), movie.getMendtime(), movie.getMroles(),
				movie.getMdirector(), movie.getMcountry(), movie.getMversion(),
				movie.getMlength(), movie.getMinformation(),
				movie.getMlikerate(), movie.getMpicpath(), movie.getMspecial(),
				movie.getMno()

		};
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public int delete(int mno, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "delete from movies where mno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { mno };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public PageBean selectByPage(String strSQLCount, String strSQL,
			int currentPage, int pageSize, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		
		PageBean pageBean = new PageBean();

		Object[] params1 = new Object[] {  };
 
		PreparedStatement preparedStatement = connection.prepareStatement(strSQLCount);
		Log.out(this.getClass().getSimpleName(), strSQLCount);
		Log.out(this.getClass().getSimpleName(), params1);
		for (int i = 0; i < params1.length; i++) {
			preparedStatement.setObject(i+1, params1[i]);
		}
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			pageBean.setTotalRows(resultSet.getInt(1));
		}
			
		
		// SELECT * FROM ticketorders s limit ?,?  从0开始
		// SELECT * FROM ticketorders where uno=3 limit 0,9
		Log.out(this.getClass().getSimpleName(), strSQL);

		int start = (currentPage - 1) * pageSize ;
		
		Object[] params = new Object[] {start,pageSize};
		Log.out(this.getClass().getSimpleName(), params);

		BeanListHandler<Movies> movieistHandler = new BeanListHandler<Movies>(
				Movies.class);
		// 执行查询操作
		List<Movies> lstMovie = queryRunner.query(connection, strSQL,movieistHandler, params);
		
		
		pageBean.setList(lstMovie);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		return pageBean;
	}

	public List<Movies> selectByConditon(String strSQL,
			QueryRunner queryRunner, Connection connection) throws SQLException {
		
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Movies> movieistHandler = new BeanListHandler<Movies>(
				Movies.class);
		// 执行查询操作
		List<Movies> lstMovie = queryRunner.query(connection, strSQL,
				movieistHandler, params);
		// 返回
		return lstMovie;
	}

}
