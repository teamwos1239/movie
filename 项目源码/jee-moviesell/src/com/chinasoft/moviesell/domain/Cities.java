package com.chinasoft.moviesell.domain;

import java.io.Serializable;
/**
 * 用于存放有电影院的城市
 * @author Administrator
 *
 */
public class Cities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int cno;
	private String cname;
	private String cprovince;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCprovince() {
		return cprovince;
	}
	public void setCprovince(String cprovince) {
		this.cprovince = cprovince;
	}
	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cities(int cno, String cname, String cprovince) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cprovince = cprovince;
	}
	@Override
	public String toString() {
		return "Cities [cno=" + this.cno + ", cname=" + this.cname + ", cprovince=" + this.cprovince+ "]";

	}
	
	
}
