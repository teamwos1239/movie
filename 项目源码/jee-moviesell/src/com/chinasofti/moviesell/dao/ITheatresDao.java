package com.chinasofti.moviesell.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasoft.moviesell.domain.gai.TheatresItem;
import com.chinasofti.commonsframework.util.PageBean;

public interface ITheatresDao {

	public abstract int insert(final Theatres theatre, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract Theatres selectById(final int tno, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract List<Theatres> selectAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int update(final Theatres theatre, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int delete(final int tno, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	 
	
	/**
	 * 根据传入城市编号返回电影院结果集
	 * <p>Project:jee-moviesell</p>
	 * <p>Package:com.chinasofti.moviesell.dao</p>
	 * <p>Title:selectByCno</p>
	 * <p>DescriptionL</p>
	 * <p>@param </p>
	 * <p>@return List<Theatres></p>
	 * @author Administrator
	 * @since JDK 1.6
	 * @date 2014-11-8 下午10:21:39
	 * @version: 1.0
	 */
	public abstract List<Theatres> selectByCno(final int cno, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	/**
	 * 返回带有城市名称电影院信息列表
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract List<TheatresItem>  selectTheatresItemAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;



	public abstract PageBean selectByPage(final String strSQLCount,final String strSQL,final int currentPage,final int pageSize,final QueryRunner queryRunner,final	Connection connection) throws SQLException ;

}
