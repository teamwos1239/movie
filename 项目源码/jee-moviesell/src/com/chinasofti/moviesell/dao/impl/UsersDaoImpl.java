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

import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.dao.IUsersDao;

public class UsersDaoImpl implements IUsersDao {

	public int insert(Users user, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		// TODO Auto-generated method stub

		String uemail = user.getUemail();
		String uname = user.getUname();
		String usex = user.getUsex();
		Date ubirthday = user.getUbirthday();
		String upass = user.getUpass();
		int ulevel = user.getUlevel();
		int uleveltime = user.getUleveltime();
		int uintegral = user.getUintegral();
		
		String strSQL = "insert into users values(null, ?, ?,?, ?,?, ?,?,?)";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { uemail, uname, usex, ubirthday, upass,
				ulevel, uleveltime, uintegral};
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public Users selectById(int uno, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from users where uno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { uno };
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanHandler对象
		BeanHandler<Users> userHandler = new BeanHandler<Users>(Users.class);
		// 执行查询操作
		Users user = queryRunner.query(connection, strSQL, userHandler, params);
		// 返回
		return user;
	}

	public List<Users> selectAll(QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "select * from users order by uno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Users> userListHandler = new BeanListHandler<Users>(
				Users.class);
		// 执行查询操作
		List<Users> lstUser = queryRunner.query(connection, strSQL,
				userListHandler, params);
		// 返回
		return lstUser;
	}

	public int update(Users user, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "update users set uemail=?,uname=?,usex=?,ubirthday=?,upass=?,ulevel=?,uleveltime=?,uintegral=? where uno=?";
		// "uemail=?,uname=?,usex=?,ubirthday=?,upass=?,ulevel=?,uleveltime=?,uintegral=?"

		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { user.getUemail(), user.getUname(),
				user.getUsex(), user.getUbirthday(), user.getUpass(),
				user.getUlevel(), user.getUleveltime(), user.getUintegral(),
				 user.getUno() };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public int delete(int uno, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "delete from users where uno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { uno };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;

	}

	public Users selectIdByEmail(String uemail, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from users where uemail=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { uemail };
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanHandler对象
		BeanHandler<Users> userHandler = new BeanHandler<Users>(Users.class);
		// 执行查询操作
		Users user = queryRunner.query(connection, strSQL, userHandler, params);
		// 返回
		return user;
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

		BeanListHandler<Users> userListHandler = new BeanListHandler<Users>(Users.class);
		// 执行查询操作
		List<Users> lstUser = queryRunner.query(connection, strSQL,	userListHandler, params);
		 
		pageBean.setList(lstUser);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		return pageBean;
	}

}
