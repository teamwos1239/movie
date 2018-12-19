package com.chinasofti.moviesell.biz;

import java.sql.SQLException;
import java.util.List;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.commonsframework.util.PageBean;

public interface IMoviesBiz {
	public abstract boolean add(final Movies movie);
	public abstract Movies findById(final int mno);
	public abstract List<Movies> findAll();
	public abstract boolean update(final Movies movie);
	public abstract boolean delete(final int mno);
	
	/**
	 * 找出所有Movies 分页显示
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
	 * 根据传入的sql语句进行查询，返回带有电影信息列表
	 */
	public abstract List<Movies> findByCondition(final String strSQL);
	

	
}
