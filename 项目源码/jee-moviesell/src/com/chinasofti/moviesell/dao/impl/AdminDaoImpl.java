package com.chinasofti.moviesell.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasoft.moviesell.domain.Administraors;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.moviesell.dao.IAdminDao;

public class AdminDaoImpl implements IAdminDao {

	public int insert(Administraors admin, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Administraors selectById(int ano, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		
					String strSQL = "select * from administraors where ano=?";
					Log.out(this.getClass().getSimpleName(), strSQL);
					Object[] params = new Object[] {ano};
					Log.out(this.getClass().getSimpleName(), params);
					
					// 创建一个BeanHandler对象
					BeanHandler<Administraors> adminHandler = new BeanHandler<Administraors>(Administraors.class);
					// 执行查询操作
					Administraors admin = queryRunner.query(connection, strSQL, adminHandler, params);
					// 返回
					return admin;
	}

	public List<Administraors> selectAll(QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from administraors order by ano";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Administraors> adminListHandler = new BeanListHandler<Administraors>(
				Administraors.class);
		// 执行查询操作
		List<Administraors> lstAdmin = queryRunner.query(connection, strSQL,
				adminListHandler, params);
		// 返回
		return lstAdmin;
	}

	public int update(Administraors admin, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int ano, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
