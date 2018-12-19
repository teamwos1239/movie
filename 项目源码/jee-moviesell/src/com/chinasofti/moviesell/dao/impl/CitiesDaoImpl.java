package com.chinasofti.moviesell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.dao.ICitiesDao;

public class CitiesDaoImpl implements ICitiesDao {

	public int insert(Cities city, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		String cname = city.getCname();
		String cprovince = city.getCprovince();

		String strSQL = "insert into cities values(null, ?, ?)";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { cname, cprovince };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public Cities selectById(int cno, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		// TODO Auto-generated method stub
				String strSQL = "select * from cities where cno=?";
				Log.out(this.getClass().getSimpleName(), strSQL);
				Object[] params = new Object[] {cno};
				Log.out(this.getClass().getSimpleName(), params);
				
				// 创建一个BeanHandler对象
				BeanHandler<Cities> cityHandler = new BeanHandler<Cities>(Cities.class);
				// 执行查询操作
				Cities city = queryRunner.query(connection, strSQL, cityHandler, params);
				// 返回
				return city;
	}

	public List<Cities> selectAll(QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "select * from cities order by cno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Cities> deptListHandler = new BeanListHandler<Cities>(
				Cities.class);
		// 执行查询操作
		List<Cities> lstCity = queryRunner.query(connection, strSQL,
				deptListHandler, params);
		// 返回
		return lstCity;
	}

	public int update(Cities city, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "update cities set cname=?, cprovince=? where cno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { city.getCname(), city.getCprovince(), city.getCno() };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public int delete(int cno, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "delete from cities where cno=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { cno };
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
			
		
		// SELECT * FROM users s limit ?,?  从0开始
		// SELECT * FROM users where uno=3 limit 0,9
		Log.out(this.getClass().getSimpleName(), strSQL);

		int start = (currentPage - 1) * pageSize ;
		
		Object[] params = new Object[] {start,pageSize};
		Log.out(this.getClass().getSimpleName(), params);

		BeanListHandler<Cities> deptListHandler = new BeanListHandler<Cities>(Cities.class);
		List<Cities> lstCity = queryRunner.query(connection, strSQL,deptListHandler, params);
				
		pageBean.setList(lstCity);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		return pageBean;
	}

	public List<Cities> selectAllByProName(String proName,
			QueryRunner queryRunner, Connection connection) throws SQLException {
		
		String strSQL = "select * from cities where cprovince=? order by cno";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {proName};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Cities> deptListHandler = new BeanListHandler<Cities>(
				Cities.class);
		// 执行查询操作
		List<Cities> lstCity = queryRunner.query(connection, strSQL,
				deptListHandler, params);
		// 返回
		return lstCity;
	}

}
