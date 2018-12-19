package com.chinasofti.moviesell.biz;
import java.util.List;

import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.commonsframework.util.PageBean;

public interface IShowmovieBiz {
	public abstract boolean add(final Showmoive showmoive);
	public abstract Showmoive findById(final int sno);
	public abstract List<Showmoive> findAll();
	public abstract boolean update(final Showmoive showmoive);
	public abstract boolean delete(final int sno);
	
	
	
	/**
	 * 返回带有电影院名称，电影名称电影放映信息列表
	 * @return
	 */
	public abstract List<ShowmoiveItem> findShowmoiveItemAll();
	
	/**
	 * 根据传入的城市编号，返回带有电影院名称，电影名称电影放映信息列表
	 * @return
	 */
	public abstract List<ShowmoiveItem> findShowmoiveItemByCname(final int cno);
	
	/**
	 * 根据传入的sql语句进行查询，返回带有电影院名称，电影名称电影放映信息列表
	 * <p>Project:jee-moviesell</p>
	 * <p>Package:com.chinasofti.moviesell.biz</p>
	 * <p>Title:findShowmoiveItemByCondition</p>
	 * <p>DescriptionL</p>
	 * <p>@param </p>
	 * <p>@return List<ShowmoiveItem></p>
	 * @author Administrator
	 * @since JDK 1.6
	 * @date 2014-11-8 下午12:20:44
	 * @version: 1.0
	 */
	public abstract List<ShowmoiveItem> findShowmoiveItemByCondition(final String strSQL);
	

	/**
	 * 找出所有ShowmoiveItem 分页显示
	 * @param currentPage
	 * @param pageSize
	 * @param paixun
	 * @return
	 */
	public abstract PageBean findAllByPage( final int currentPage, final int pageSize,final String paixun);
	

	
}
