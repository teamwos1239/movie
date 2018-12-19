package com.chinasofti.moviesell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasoft.moviesell.domain.gai.TheatresItem;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.dao.ITheatresDao;

public class TheatresDaoImpl implements ITheatresDao {

	public int insert(Theatres theatre, QueryRunner queryRunner,
			Connection connection) throws SQLException {

		int cno = theatre.getCno();
		int thallnumber = theatre.getThallnumber();
		int tseatnumber = theatre.getTseatnumber();
		String tname = theatre.getTname();
		String taddress = theatre.getTaddress();
		String tintro = theatre.getTintro();
		String ttel = theatre.getTtel();
		String tspecialinfo = theatre.getTspecialinfo();
		String tparkloc = theatre.getTparkloc();
		String tbusinfo = theatre.getTbusinfo();
		/*
		 * 
		 * 
		 * "tno,cno,thallnumber,tseatnumber,tname, taddress,tintro,ttel,tspecialinfo,tparkloc, tbusinfo"
		 */

		/*cno,tname,taddress,tintro,thallnumber,ttel,tseatnumber,tspecialinfo,tparkloc,tbusinfo*/
		
		String strSQL = "insert into theatres values(null, ?, ?,?, ?, ?, ?,?, ?, ?, ?)";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {cno,tname,taddress,tintro,thallnumber,ttel,tseatnumber,tspecialinfo,tparkloc,tbusinfo };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public Theatres selectById(int tno, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from theatres where tno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { tno };
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanHandler对象
		BeanHandler<Theatres> theatresHandler = new BeanHandler<Theatres>(
				Theatres.class);
		// 执行查询操作
		Theatres theatres = queryRunner.query(connection, strSQL,
				theatresHandler, params);
		// 返回
		return theatres;
	}

	public List<Theatres> selectAll(QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from theatres order by tno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Theatres> theatreslstHandler = new BeanListHandler<Theatres>(
				Theatres.class);
		// 执行查询操作
		List<Theatres> lstTheatres = queryRunner.query(connection, strSQL,
				theatreslstHandler, params);
		// 返回
		return lstTheatres;
	}

	public int update(Theatres theatre, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "update theatres set cno=?,thallnumber=?,tseatnumber=?,tname=?, taddress=?,tintro=?,ttel=?,tspecialinfo=?,tparkloc=?, tbusinfo=? where tno=?";

		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { theatre.getCno(),
				theatre.getThallnumber(), theatre.getTseatnumber(),
				theatre.getTname(), theatre.getTaddress(), theatre.getTintro(),
				theatre.getTtel(), theatre.getTspecialinfo(),
				theatre.getTparkloc(), theatre.getTbusinfo(), theatre.getTno() };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public int delete(int tno, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "delete from theatres where tno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { tno };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public List<TheatresItem> selectTheatresItemAll(QueryRunner queryRunner,
			Connection connection) throws SQLException {
		
		String strSQL = "SELECT c.cname as tcname,t.* FROM theatres t, cities c where t.cno=c.cno  order by t.tno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<TheatresItem> theatresItemlstHandler = new BeanListHandler<TheatresItem>(
				TheatresItem.class);
		// 执行查询操作
		List<TheatresItem> lstTheatresItem = queryRunner.query(connection, strSQL,
				theatresItemlstHandler, params);
		
		// 返回
		return lstTheatresItem;
	}

	public List<Theatres> selectByCno(int cno, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		
		String strSQL = "select * from theatres where cno=? order by tno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {cno};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Theatres> theatreslstHandler = new BeanListHandler<Theatres>(
				Theatres.class);
		// 执行查询操作
		List<Theatres> lstTheatres = queryRunner.query(connection, strSQL,
				theatreslstHandler, params);
		// 返回
		return lstTheatres;
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

		// 创建一个BeanListHandler对象
		BeanListHandler<TheatresItem> theatresItemlstHandler = new BeanListHandler<TheatresItem>(
					TheatresItem.class);
			// 执行查询操作
		List<TheatresItem> lstTheatresItem = queryRunner.query(connection, strSQL,
						theatresItemlstHandler, params);
		
		 
		pageBean.setList(lstTheatresItem);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		return pageBean;
	}

}
