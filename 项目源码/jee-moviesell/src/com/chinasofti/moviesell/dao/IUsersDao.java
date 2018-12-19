package com.chinasofti.moviesell.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.util.PageBean;


public interface IUsersDao {
	public abstract int insert(final Users user, final QueryRunner queryRunner,	final Connection connection) throws SQLException;

	public abstract Users selectById(final int uno,	final QueryRunner queryRunner, final Connection connection)	throws SQLException;

	public abstract List<Users> selectAll(final QueryRunner queryRunner,	final Connection connection) throws SQLException;

	public abstract int update(final Users user, final QueryRunner queryRunner,	final Connection connection) throws SQLException;

	public abstract int delete(final int uno, final QueryRunner queryRunner,	final Connection connection) throws SQLException;
	public abstract Users selectIdByEmail(final String uemail,	final QueryRunner queryRunner, final Connection connection)throws SQLException;
	
	
	public abstract PageBean selectByPage(final String strSQLCount,final String strSQL,final int currentPage,final int pageSize,final QueryRunner queryRunner,final	Connection connection) throws SQLException ;
}
