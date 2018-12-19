package com.chinasofti.commonsframework.util;

import java.util.ArrayList;
import java.util.List;


public class PageBean {

	private int totalRows; // 记录查询结果的总返回行数
	private int totalPage; // 记录总的查询页数
	private int currentPage; // 记录客户端需要查询的页数
	private int pageSize; // 设置每一页显示的个数
	private List list = new ArrayList(); // 存放当前页数的记录集合

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageBean(int totalRows, int totalPage, int currentPage,
			int pageSize, List list) {
		super();
		this.totalRows = totalRows;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.list = list;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		// 通过总的记录个数和每一页显示个数
		return totalRows % pageSize == 0 ? totalRows / pageSize : totalRows
				/ pageSize + 1;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [totalRows=" + totalRows + ", totalPage=" + totalPage
				+ ", currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", list=" + list + "]";
	}

}
