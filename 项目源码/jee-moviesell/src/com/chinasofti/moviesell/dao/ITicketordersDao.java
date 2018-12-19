package com.chinasofti.moviesell.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.gai.OrderItem;
import com.chinasofti.commonsframework.util.PageBean;

public interface ITicketordersDao {

	public abstract int insert(final Ticketorders order, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract Ticketorders selectById(final int ono, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract List<Ticketorders> selectAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int update(final Ticketorders order, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	public abstract int delete(final int ono, final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
	/**
	 * 找出所有详细订单对象列表
	 * <p>Project:jee-moviesell</p>
	 * <p>Package:com.chinasofti.moviesell.dao</p>
	 * <p>Title:selectOrderAll</p>
	 * <p>DescriptionL</p>
	 * <p>@param </p>
	 * <p>@return List<OrderItem></p>
	 * @author Administrator
	 * @since JDK 1.6
	 * @date 2014-11-9 上午1:26:55
	 * @version: 1.0
	 */
	public abstract List<OrderItem> selectOrderAll(final QueryRunner queryRunner, final Connection connection) throws SQLException;
	
	/**
	 * 根据传入的sql语句找出所有带有信息的订单
	 * @param uno
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract List<OrderItem> selectOrderByConditon (final String strSQL,final QueryRunner queryRunner, final Connection connection) throws SQLException;
	

	public abstract PageBean selectByPage(final String strSQLCount,final String strSQL,final int currentPage,final int pageSize,final QueryRunner queryRunner,final	Connection connection) throws SQLException ;

}
