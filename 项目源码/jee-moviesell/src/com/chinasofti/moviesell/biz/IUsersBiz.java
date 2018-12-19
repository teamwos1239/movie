package com.chinasofti.moviesell.biz;

import java.sql.SQLException;
import java.util.List;

import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.util.PageBean;

public interface IUsersBiz {
	public abstract boolean add(final Users user);
	public abstract Users findById(final int uno);
	public abstract List<Users> findAll();
	public abstract boolean update(final Users user);
	public abstract boolean delete(final int uno);
	public abstract Users checkLogin(final  Users user);
	
	/**
	 * 根据传入的email找到用户编号
	 * <p>Project:jee-moviesell</p>
	 * <p>Package:com.chinasofti.moviesell.biz</p>
	 * <p>Title:findUnoByEmail</p>
	 * <p>DescriptionL</p>
	 * <p>@param </p>
	 * <p>@return Users</p>
	 * @author Administrator
	 * @since JDK 1.6
	 * @date 2014-11-8 下午11:41:40
	 * @version: 1.0
	 */
	public abstract Users findUnoByEmail(String uemail);
	
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
	

	
	
	
}
