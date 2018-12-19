package com.chinasofti.moviesell.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasofti.commonsframework.util.PageBean;

public interface ICitiesDao {
	
	public abstract int insert(final Cities city, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract Cities selectById(final int cno, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract List<Cities> selectAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int update(final Cities city, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int delete(final int cno, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
	public abstract PageBean selectByPage(final String strSQLCount,final String strSQL,final int currentPage,final int pageSize,final QueryRunner queryRunner,final	Connection connection) throws SQLException ;
	
	public abstract List<Cities> selectAllByProName(String proName ,final QueryRunner queryRunner, final Connection connection) throws SQLException;
}
