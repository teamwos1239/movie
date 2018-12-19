package com.chinasofti.moviesell.biz;

import java.sql.SQLException;
import java.util.List;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasoft.moviesell.domain.gai.TheatresItem;
import com.chinasofti.commonsframework.util.PageBean;

public interface ITheatresBiz {
	public abstract boolean add(final Theatres theatre);
	public abstract Theatres findById(final int tno);
	public abstract List<Theatres> findAll();
	public abstract boolean update(final Theatres theatre);
	public abstract boolean delete(final int tno);
	
	/**
	 * 返回cno城市的电影院结果集
	 * <p>Project:jee-moviesell</p>
	 * <p>Package:com.chinasofti.moviesell.biz</p>
	 * <p>Title:findByCno</p>
	 * <p>DescriptionL</p>
	 * <p>@param </p>
	 * <p>@return List<Theatres></p>
	 * @author Administrator
	 * @since JDK 1.6
	 * @date 2014-11-8 下午10:24:00
	 * @version: 1.0
	 */
	public abstract List<Theatres> findByCno(final int cno);
	/**
	 * 返回带有城市名称电影院信息列表
	 * @return
	 */
	public abstract List<TheatresItem> findTheatresItemAll();
	
	
	

	/**
	 * 找出所有theatreItem 分页显示
	 * @param currentPage
	 * @param pageSize
	 * @param strSQL
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract PageBean findAllByPage( final int currentPage, final int pageSize);
	

	
}
