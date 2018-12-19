package com.chinasofti.moviesell.biz;

import java.sql.SQLException;
import java.util.List;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasofti.commonsframework.util.PageBean;

public interface ICitiesBiz {

	public abstract boolean add(final Cities city);
	public abstract Cities findById(final int cno);
	public abstract List<Cities> findAll();
	public abstract boolean update(final Cities city);
	public abstract boolean delete(final int cno);
	
	
	/**
	 * 找出所有users 分页显示
	 * @param currentPage
	 * @param pageSize
	 * @param strSQL
	 * @param queryRunner
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public abstract PageBean findAllByPage( final int currentPage, final int pageSize);

	public abstract List<Cities> findAllByProName(final String proName);

}
