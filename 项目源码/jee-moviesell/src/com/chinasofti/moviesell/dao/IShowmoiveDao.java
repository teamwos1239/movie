package com.chinasofti.moviesell.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.commonsframework.util.PageBean;

public interface IShowmoiveDao {

	public abstract int insert(final Showmoive showmoive, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract Showmoive selectById(final int sno, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract List<Showmoive> selectAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int update(final Showmoive showmovie, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int delete(final int sno, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
	/**
	 * 
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract List<ShowmoiveItem> selectShowmoiveItemAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;
	/**
	 * 
	 * @param cno
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract List<ShowmoiveItem> selectShowmoiveItemByCname (final int cno,final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
	public abstract List<ShowmoiveItem> selectShowmoiveItemByConditon (final String strSQL,final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
	

	public abstract PageBean selectByPage(final String strSQLCount,final String strSQL,final int currentPage,final int pageSize,final QueryRunner queryRunner,final	Connection connection) throws SQLException ;

	
}
