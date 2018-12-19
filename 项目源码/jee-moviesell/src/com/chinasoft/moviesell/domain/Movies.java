package com.chinasoft.moviesell.domain;

import java.io.Serializable;
import java.util.*;

/**
 * 用于保存单个电影的详情信息
 * 
 * */
public class Movies implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int mno;
	private String mname;
	private String mtype;
	private Date mstarttime;
	private Date mendtime;
	private String mroles;
	private String mdirector;
	private String mcountry;
	private String mversion;
	private int mlength;
	private String minformation;
	private int mlikerate;
	private String mpicpath;
	private String mspecial;

	public String toString() {
		return "Movies [mno=" + this.mno + ", mname=" + this.mname + ", mtype="
				+ this.mtype + ", mstarttime=" + this.mstarttime
				+ ", mendtime=" + this.mendtime + ", mroles=" + this.mroles
				+ ", mdirector=" + this.mdirector + ", mcountry="
				+ this.mcountry + ", mversion=" + this.mversion + ", mlength="
				+ this.mlength + ", minformation=" + this.minformation
				+ ", mlikerate=" + this.mlikerate + ", mpicpath=" + this.mpicpath
				+ ", mspecial=" + this.mspecial + "]";

	}

	/**
	 * @return the mno
	 */
	public int getMno() {
		return mno;
	}

	/**
	 * @param mno
	 *            the mno to set
	 */
	public void setMno(int mno) {
		this.mno = mno;
	}

	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}

	/**
	 * @param mname
	 *            the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}

	/**
	 * @return the mtype
	 */
	public String getMtype() {
		return mtype;
	}

	/**
	 * @param mtype
	 *            the mtype to set
	 */
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	/**
	 * @return the mstarttime
	 */
	public Date getMstarttime() {
		return mstarttime;
	}

	/**
	 * @param mstarttime
	 *            the mstarttime to set
	 */
	public void setMstarttime(Date mstarttime) {
		this.mstarttime = mstarttime;
	}

	/**
	 * @return the mendtime
	 */
	public Date getMendtime() {
		return mendtime;
	}

	/**
	 * @param mendtime
	 *            the mendtime to set
	 */
	public void setMendtime(Date mendtime) {
		this.mendtime = mendtime;
	}

	/**
	 * @return the mroles
	 */
	public String getMroles() {
		return mroles;
	}

	/**
	 * @param mroles
	 *            the mroles to set
	 */
	public void setMroles(String mroles) {
		this.mroles = mroles;
	}

	/**
	 * @return the mdirector
	 */
	public String getMdirector() {
		return mdirector;
	}

	/**
	 * @param mdirector
	 *            the mdirector to set
	 */
	public void setMdirector(String mdirector) {
		this.mdirector = mdirector;
	}

	/**
	 * @return the mcountry
	 */
	public String getMcountry() {
		return mcountry;
	}

	/**
	 * @param mcountry
	 *            the mcountry to set
	 */
	public void setMcountry(String mcountry) {
		this.mcountry = mcountry;
	}

	/**
	 * @return the mversion
	 */
	public String getMversion() {
		return mversion;
	}

	/**
	 * @param mversion
	 *            the mversion to set
	 */
	public void setMversion(String mversion) {
		this.mversion = mversion;
	}

	/**
	 * @return the mlength
	 */
	public int getMlength() {
		return mlength;
	}

	/**
	 * @param mlength
	 *            the mlength to set
	 */
	public void setMlength(int mlength) {
		this.mlength = mlength;
	}

	/**
	 * @return the minformation
	 */
	public String getMinformation() {
		return minformation;
	}

	/**
	 * @param minformation
	 *            the minformation to set
	 */
	public void setMinformation(String minformation) {
		this.minformation = minformation;
	}

	/**
	 * @return the mlikerate
	 */
	public int getMlikerate() {
		return mlikerate;
	}

	/**
	 * @param mlikerate
	 *            the mlikerate to set
	 */
	public void setMlikerate(int mlikerate) {
		this.mlikerate = mlikerate;
	}

	/**
	 * @return the mposter
	 */
	public String getMpicpath() {
		return mpicpath;
	}

	/**
	 * @param mposter
	 *            the mposter to set
	 */
	public void setMpicpath(String mpicpath) {
		this.mpicpath = mpicpath;
	}

	/**
	 * @return the mspecial
	 */
	public String getMspecial() {
		return mspecial;
	}

	/**
	 * @param mspecial
	 *            the mspecial to set
	 */
	public void setMspecial(String mspecial) {
		this.mspecial = mspecial;
	}

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movies(int mno, String mname, String mtype, Date mstarttime,
			Date mendtime, String mroles, String mdirector, String mcountry,
			String mversion, int mlength, String minformation, int mlikerate,
			String mpicpath, String mspecial) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mtype = mtype;
		this.mstarttime = mstarttime;
		this.mendtime = mendtime;
		this.mroles = mroles;
		this.mdirector = mdirector;
		this.mcountry = mcountry;
		this.mversion = mversion;
		this.mlength = mlength;
		this.minformation = minformation;
		this.mlikerate = mlikerate;
		this.mpicpath = mpicpath;
		this.mspecial = mspecial;
	}

}