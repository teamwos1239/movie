package com.chinasoft.moviesell.domain;

/***********************************************************************
 * Module:  showmoive.java
 * Author:  Administrator
 * Purpose: Defines the Class showmoive
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/**
 * 用于保存电影放映相关信息
 * 
 * */
public class Showmoive implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sno;
	private int tno;
	private int mno;
	private int shallno;
	private Date stime;
	private float sprice;
	private String sseatsatust1;
	private String sseatsatust2;
	private String sseatsatust3;
	private String sseatsatust4;
	private String sseatsatust5;
	private String sseatsatust6;
	private String sseatsatust7;
	private String sseatsatust8;
	private String sseatsatust9;
	private String slanguage;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getShallno() {
		return shallno;
	}

	public void setShallno(int shallno) {
		this.shallno = shallno;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public float getSprice() {
		return sprice;
	}

	public void setSprice(float sprice) {
		this.sprice = sprice;
	}

	public String getSseatsatust1() {
		return sseatsatust1;
	}

	public void setSseatsatust1(String sseatsatust1) {
		this.sseatsatust1 = sseatsatust1;
	}

	public String getSseatsatust2() {
		return sseatsatust2;
	}

	public void setSseatsatust2(String sseatsatust2) {
		this.sseatsatust2 = sseatsatust2;
	}

	public String getSseatsatust3() {
		return sseatsatust3;
	}

	public void setSseatsatust3(String sseatsatust3) {
		this.sseatsatust3 = sseatsatust3;
	}

	public String getSseatsatust4() {
		return sseatsatust4;
	}

	public void setSseatsatust4(String sseatsatust4) {
		this.sseatsatust4 = sseatsatust4;
	}

	public String getSseatsatust5() {
		return sseatsatust5;
	}

	public void setSseatsatust5(String sseatsatust5) {
		this.sseatsatust5 = sseatsatust5;
	}

	public String getSseatsatust6() {
		return sseatsatust6;
	}

	public void setSseatsatust6(String sseatsatust6) {
		this.sseatsatust6 = sseatsatust6;
	}

	public String getSseatsatust7() {
		return sseatsatust7;
	}

	public void setSseatsatust7(String sseatsatust7) {
		this.sseatsatust7 = sseatsatust7;
	}

	public String getSseatsatust8() {
		return sseatsatust8;
	}

	public void setSseatsatust8(String sseatsatust8) {
		this.sseatsatust8 = sseatsatust8;
	}

	public String getSseatsatust9() {
		return sseatsatust9;
	}

	public void setSseatsatust9(String sseatsatust9) {
		this.sseatsatust9 = sseatsatust9;
	}

	public String getSlanguage() {
		return slanguage;
	}

	public void setSlanguage(String slanguage) {
		this.slanguage = slanguage;
	}

	public Showmoive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Showmoive(int sno, int tno, int mno, int shallno, Date stime,
			float sprice, String sseatsatust1, String sseatsatust2,
			String sseatsatust3, String sseatsatust4, String sseatsatust5,
			String sseatsatust6, String sseatsatust7, String sseatsatust8,
			String sseatsatust9, String slanguage) {
		super();

		this.sno = sno;
		this.tno = tno;
		this.mno = mno;
		this.shallno = shallno;
		this.stime = stime;
		this.sprice = sprice;
		this.sseatsatust1 = sseatsatust1;
		this.sseatsatust2 = sseatsatust2;
		this.sseatsatust3 = sseatsatust3;
		this.sseatsatust4 = sseatsatust4;
		this.sseatsatust5 = sseatsatust5;
		this.sseatsatust6 = sseatsatust6;
		this.sseatsatust7 = sseatsatust7;
		this.sseatsatust8 = sseatsatust8;
		this.sseatsatust9 = sseatsatust9;
		this.slanguage = slanguage;
	}

	@Override
	public String toString() {
		return "Showmoive [sno=" + this.sno + ", tno=" + this.tno + ", mno="
				+ this.mno + ", shallno=" + this.shallno + ", stime="
				+ this.stime + ", sprice=" + this.sprice + ", sseatsatust1="
				+ this.sseatsatust1 + ", sseatsatust2=" + this.sseatsatust2
				+ ", sseatsatust3=" + this.sseatsatust3 + ", sseatsatust4="
				+ this.sseatsatust4 + ", sseatsatust5=" + this.sseatsatust5
				+ ", sseatsatust6=" + this.sseatsatust6 + ", sseatsatust7="
				+ this.sseatsatust7 + ", sseatsatust8=" + this.sseatsatust8
				+ ", sseatsatust9=" + this.sseatsatust9 + ", slanguage="
				+ this.slanguage + "]";
	}

}