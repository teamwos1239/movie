package com.chinasoft.moviesell.domain;

/***********************************************************************
 * Module:  ticketorders.java
 * Author:  Administrator
 * Purpose: Defines the Class ticketorders
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/**
 * 用于保存订单
 * 
 * */
public class Ticketorders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ono;
	private int uno;
	private int sno;
	private String obizcode;
	private String opayway;
	private String ostatus;
	private Date otime;
	private String opayplatform;
	private int ocount;
	private int oquantity1;
	private int oquantity2;
	private String oconvertcode;
	private float opaymoney;
	private String oseats;
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getObizcode() {
		return obizcode;
	}
	public void setObizcode(String obizcode) {
		this.obizcode = obizcode;
	}
	public String getOpayway() {
		return opayway;
	}
	public void setOpayway(String opayway) {
		this.opayway = opayway;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public String getOpayplatform() {
		return opayplatform;
	}
	public void setOpayplatform(String opayplatform) {
		this.opayplatform = opayplatform;
	}
	public int getOcount() {
		return ocount;
	}
	public void setOcount(int ocount) {
		this.ocount = ocount;
	}
	public int getOquantity1() {
		return oquantity1;
	}
	public void setOquantity1(int oquantity1) {
		this.oquantity1 = oquantity1;
	}
	public int getOquantity2() {
		return oquantity2;
	}
	public void setOquantity2(int oquantity2) {
		this.oquantity2 = oquantity2;
	}
	public String getOconvertcode() {
		return oconvertcode;
	}
	public void setOconvertcode(String oconvertcode) {
		this.oconvertcode = oconvertcode;
	}
	public float getOpaymoney() {
		return opaymoney;
	}
	public void setOpaymoney(float opaymoney) {
		this.opaymoney = opaymoney;
	}
	public String getOseats() {
		return oseats;
	}
	public void setOseats(String oseats) {
		this.oseats = oseats;
	}
	public Ticketorders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ticketorders [ono=" + ono + ", uno=" + uno + ", sno=" + sno
				+ ", obizcode=" + obizcode + ", opayway=" + opayway
				+ ", ostatus=" + ostatus + ", otime=" + otime
				+ ", opayplatform=" + opayplatform + ", ocount=" + ocount
				+ ", oquantity1=" + oquantity1 + ", oquantity2=" + oquantity2
				+ ", oconvertcode=" + oconvertcode + ", opaymoney=" + opaymoney
				+ ", oseats=" + oseats + "]";
	}
	public Ticketorders(int ono, int uno, int sno, String obizcode,
			String opayway, String ostatus, Date otime, String opayplatform,
			int ocount, int oquantity1, int oquantity2, String oconvertcode,
			float opaymoney, String oseats) {
		super();
		this.ono = ono;
		this.uno = uno;
		this.sno = sno;
		this.obizcode = obizcode;
		this.opayway = opayway;
		this.ostatus = ostatus;
		this.otime = otime;
		this.opayplatform = opayplatform;
		this.ocount = ocount;
		this.oquantity1 = oquantity1;
		this.oquantity2 = oquantity2;
		this.oconvertcode = oconvertcode;
		this.opaymoney = opaymoney;
		this.oseats = oseats;
	}
	
	
	
 

}