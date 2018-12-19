package com.chinasoft.moviesell.domain;

/***********************************************************************
 * Module:  users.java
 * Author:  Administrator
 * Purpose: Defines the Class users
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/**
 * 用于保存用户的详细信息
 * 
 * */
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int uno;
	private String uemail;
	private String uname;
	private String usex;
	private Date ubirthday;
	private String upass;
	private int ulevel;
	private int uleveltime;
	private int uintegral;
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public Date getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(Date ubirthday) {
		this.ubirthday = ubirthday;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getUlevel() {
		return ulevel;
	}
	public void setUlevel(int ulevel) {
		this.ulevel = ulevel;
	}
	public int getUleveltime() {
		return uleveltime;
	}
	public void setUleveltime(int uleveltime) {
		this.uleveltime = uleveltime;
	}
	public int getUintegral() {
		return uintegral;
	}
	public void setUintegral(int uintegral) {
		this.uintegral = uintegral;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int uno, String uemail, String uname, String usex,
			Date ubirthday, String upass, int ulevel, int uleveltime,
			int uintegral) {
		super();
		this.uno = uno;
		this.uemail = uemail;
		this.uname = uname;
		this.usex = usex;
		this.ubirthday = ubirthday;
		this.upass = upass;
		this.ulevel = ulevel;
		this.uleveltime = uleveltime;
		this.uintegral = uintegral;
	}
	@Override
	public String toString() {
		return "Users [uno=" + uno + ", uemail=" + uemail + ", uname=" + uname
				+ ", usex=" + usex + ", ubirthday=" + ubirthday + ", upass="
				+ upass + ", ulevel=" + ulevel + ", uleveltime=" + uleveltime
				+ ", uintegral=" + uintegral + "]";
	}
 
  

}