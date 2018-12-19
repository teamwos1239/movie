package com.chinasofti.moviesell.biz;

import java.sql.SQLException;
import java.util.List;

import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.gai.OrderItem;
import com.chinasofti.commonsframework.util.PageBean;

public interface ITicketordersBiz {
	public abstract boolean add(final Ticketorders order);
	public abstract Ticketorders findById(final int ono);
	public abstract List<Ticketorders> findAll();
	public abstract boolean update(final Ticketorders order);
	public abstract boolean delete(final int ono);
	
	/**
	 * 找出所有详细订单对象列表
	 * <p>Project:jee-moviesell</p>
	 * <p>Package:com.chinasofti.moviesell.biz</p>
	 * <p>Title:findOrderItemAll</p>
	 * <p>DescriptionL</p>
	 * <p>@param </p>
	 * <p>@return List<OrderItem></p>
	 * @author Administrator
	 * @since JDK 1.6
	 * @date 2014-11-9 上午1:41:02
	 * @version: 1.0
	 */
	public abstract List<OrderItem> findOrderItemAll();
	
	/**
	 * 根据传入的sql语句查询
	 * @param strSQl
	 * @return
	 */
	public abstract List<OrderItem> findOrderItemsByCondition(final String strSQl);
	
	
	/**
	 * 找出所有orderItem 分页显示
	 * @param currentPage
	 * @param pageSize
	 * @param strSQL
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract PageBean findAllByPage( final int currentPage, final int pageSize);
	

	
	/**
	 * 找出所有uno用户orderItem 分页显示
	 * @param currentPage
	 * @param pageSize
	 * @param strSQL
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract PageBean findAllByUnoPage(final int uno, final int currentPage, final int pageSize);
		
}
