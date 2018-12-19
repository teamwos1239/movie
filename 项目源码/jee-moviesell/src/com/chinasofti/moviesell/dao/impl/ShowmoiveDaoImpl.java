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

import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.dao.IShowmoiveDao;

public class ShowmoiveDaoImpl implements IShowmoiveDao {

	public int insert(Showmoive showmoive, QueryRunner queryRunner,
			Connection connection) throws SQLException {

		int tno = showmoive.getTno();
		int mno = showmoive.getMno();
		int shallno = showmoive.getShallno();
		Date stime = showmoive.getStime();
		float sprice = showmoive.getSprice();
		String sseatsatust1 = showmoive.getSseatsatust1();
		String sseatsatust2 = showmoive.getSseatsatust2();
		String sseatsatust3 = showmoive.getSseatsatust3();
		String sseatsatust4 = showmoive.getSseatsatust4();
		String sseatsatust5 = showmoive.getSseatsatust5();
		String sseatsatust6 = showmoive.getSseatsatust6();
		String sseatsatust7 = showmoive.getSseatsatust7();
		String sseatsatust8 = showmoive.getSseatsatust8();
		String sseatsatust9 = showmoive.getSseatsatust9();
		String slanguage = showmoive.getSlanguage();
		/*
		 * sno,
		 * tno,mno,shallno,stime,sprice,sseatsatust1,sseatsatust2,sseatsatust3
		 * ,sseatsatust4
		 * ,sseatsatust5,sseatsatust6,sseatsatust7,sseatsatust8,sseatsatust9
		 * ,slanguage;
		 */

		String strSQL = "insert into showmoive values(null, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?,?, ?,?)";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { tno, mno, shallno, stime, sprice,
				sseatsatust1, sseatsatust2, sseatsatust3, sseatsatust4,
				sseatsatust5, sseatsatust6, sseatsatust7, sseatsatust8,
				sseatsatust9, slanguage };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public Showmoive selectById(int sno, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from showmoive where sno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { sno };
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanHandler对象
		BeanHandler<Showmoive> showmoiveHandler = new BeanHandler<Showmoive>(
				Showmoive.class);
		// 执行查询操作
		Showmoive showmoive = queryRunner.query(connection, strSQL,
				showmoiveHandler, params);
		// 返回
		return showmoive;
	}

	public List<Showmoive> selectAll(QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from showmoive order by sno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Showmoive> showmoivelstHandler = new BeanListHandler<Showmoive>(
				Showmoive.class);
		// 执行查询操作
		List<Showmoive> lstShowmoive = queryRunner.query(connection, strSQL,
				showmoivelstHandler, params);
		// 返回
		return lstShowmoive;
	}

	public int update(Showmoive showmovie, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "update showmoive set tno=?,mno=?,shallno=?,stime=?,sprice=?,sseatsatust1=?,sseatsatust2=?,sseatsatust3=?,sseatsatust4=?,sseatsatust5=?,sseatsatust6=?,sseatsatust7=?,sseatsatust8=?,sseatsatust9=?,slanguage=? where sno=?";

		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { showmovie.getTno(),
				showmovie.getMno(), showmovie.getShallno(),
				showmovie.getStime(), showmovie.getSprice(),
				showmovie.getSseatsatust1(), showmovie.getSseatsatust2(),
				showmovie.getSseatsatust3(), showmovie.getSseatsatust4(),
				showmovie.getSseatsatust5(), showmovie.getSseatsatust6(),
				showmovie.getSseatsatust7(), showmovie.getSseatsatust8(),
				showmovie.getSseatsatust9(), showmovie.getSlanguage(),
				showmovie.getSno()

		};
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public int delete(int sno, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "delete from showmoive where sno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { sno };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public List<ShowmoiveItem> selectShowmoiveItemAll(QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select m.mversion as smversion,m.mlength as smlength,t.tname as stname,m.mname as smname,s.* from showmoive s,theatres t,movies m where s.mno=m.mno and s.tno=t.tno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<ShowmoiveItem> ShowmoiveItemlstHandler = new BeanListHandler<ShowmoiveItem>(
				ShowmoiveItem.class);
		// 执行查询操作
		List<ShowmoiveItem> lstShowmoiveItem = queryRunner.query(connection, strSQL,
				ShowmoiveItemlstHandler, params);
		// 返回
		return lstShowmoiveItem;
	}

	public List<ShowmoiveItem> selectShowmoiveItemByCname(int cno,
			QueryRunner queryRunner, Connection connection) throws SQLException {
		String strSQL = "SELECT * FROM v_showmoive v where cno=? and datediff(stime,now())=0;";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {cno};
		Log.out(this.getClass().getSimpleName(), params);

		BeanListHandler<ShowmoiveItem> ShowmoiveItemlstHandler = new BeanListHandler<ShowmoiveItem>(
				ShowmoiveItem.class);
		List<ShowmoiveItem> lstShowmoiveItem = queryRunner.query(connection, strSQL,
				ShowmoiveItemlstHandler, params);
		return lstShowmoiveItem;
	}

	public List<ShowmoiveItem> selectShowmoiveItemByConditon(String strSQL,
			QueryRunner queryRunner, Connection connection) throws SQLException {
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		BeanListHandler<ShowmoiveItem> ShowmoiveItemlstHandler = new BeanListHandler<ShowmoiveItem>(
				ShowmoiveItem.class);
		List<ShowmoiveItem> lstShowmoiveItem = queryRunner.query(connection, strSQL,
				ShowmoiveItemlstHandler, params);
		return lstShowmoiveItem;
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

		BeanListHandler<ShowmoiveItem> ShowmoiveItemlstHandler = new BeanListHandler<ShowmoiveItem>(
				ShowmoiveItem.class);
		List<ShowmoiveItem> lstShowmoiveItem = queryRunner.query(connection, strSQL,
				ShowmoiveItemlstHandler, params);
		
		 
		pageBean.setList(lstShowmoiveItem);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		return pageBean;
	}

}
