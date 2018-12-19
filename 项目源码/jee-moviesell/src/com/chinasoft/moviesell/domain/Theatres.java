package com.chinasoft.moviesell.domain;

import java.io.Serializable;

/**
 * 用于保存单个电影院的详情
 * 
 * */
public class Theatres implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tno;
	private int cno;
	private int thallnumber;
	private int tseatnumber;
	private String tname;
	private String taddress;
	private String tintro;
	private String ttel;
	private String tspecialinfo;
	private String tparkloc;
	private String tbusinfo;

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getThallnumber() {
		return thallnumber;
	}

	public void setThallnumber(int thallnumber) {
		this.thallnumber = thallnumber;
	}

	public int getTseatnumber() {
		return tseatnumber;
	}

	public void setTseatnumber(int tseatnumber) {
		this.tseatnumber = tseatnumber;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTaddress() {
		return taddress;
	}

	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}

	public String getTintro() {
		return tintro;
	}

	public void setTintro(String tintro) {
		this.tintro = tintro;
	}

	public String getTtel() {
		return ttel;
	}

	public void setTtel(String ttel) {
		this.ttel = ttel;
	}

	public String getTspecialinfo() {
		return tspecialinfo;
	}

	public void setTspecialinfo(String tspecialinfo) {
		this.tspecialinfo = tspecialinfo;
	}

	public String getTparkloc() {
		return tparkloc;
	}

	public void setTparkloc(String tparkloc) {
		this.tparkloc = tparkloc;
	}

	public String getTbusinfo() {
		return tbusinfo;
	}

	public void setTbusinfo(String tbusinfo) {
		this.tbusinfo = tbusinfo;
	}

	public Theatres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theatres(int tno, int cno, int thallnumber, int tseatnumber,
			String tname, String taddress, String tintro, String ttel,
			String tspecialinfo, String tparkloc, String tbusinfo) {
		super();
		this.tno = tno;
		this.cno = cno;
		this.thallnumber = thallnumber;
		this.tseatnumber = tseatnumber;
		this.tname = tname;
		this.taddress = taddress;
		this.tintro = tintro;
		this.ttel = ttel;
		this.tspecialinfo = tspecialinfo;
		this.tparkloc = tparkloc;
		this.tbusinfo = tbusinfo;
	}

	@Override
	public String toString() {
		return "Theatres [tno=" + this.tno + ", cno=" + this.cno
				+ ", thallnumber=" + this.thallnumber + ", tseatnumber="
				+ this.tseatnumber + ", tname=" + this.tname + ", taddress="
				+ this.taddress + ", tintro=" + this.tintro + ", ttel="
				+ this.ttel + ", tspecialinfo=" + this.tspecialinfo
				+ ", tparkloc=" + this.tparkloc + ", tbusinfo=" + this.tbusinfo
				+ "]";
	}

}