package com.chinasofti.moviesell.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.commonsframework.util.PageBean;

public interface IMoviesDao {

	public abstract int insert(final Movies movie,
			final QueryRunner queryRunner, final Connection connection)
			throws SQLException;

	public abstract Movies selectById(final int mno,
			final QueryRunner queryRunner, final Connection connection)
			throws SQLException;

	public abstract List<Movies> selectAll(final QueryRunner queryRunner,
			final Connection connection) throws SQLException;

	public abstract int update(final Movies movie,
			final QueryRunner queryRunner, final Connection connection)
			throws SQLException;

	public abstract int delete(final int mno, final QueryRunner queryRunner,
			final Connection connection) throws SQLException;
	
	public abstract PageBean selectByPage(final String strSQLCount,final String strSQL,final int currentPage,final int pageSize,final QueryRunner queryRunner,final	Connection connection) throws SQLException ;

	public abstract List<Movies> selectByConditon (final String strSQL,final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
	

}
