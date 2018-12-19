package com.chinasofti.moviesell.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Administraors;

public interface IAdminDao {

	public abstract int insert(final Administraors admin, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract Administraors selectById(final int ano, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract List<Administraors> selectAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int update(final Administraors admin, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int delete(final int ano, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
}
