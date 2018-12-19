package com.chinasoft.moviesell.domain;

import java.io.Serializable;

/**
 * 用于存放管理员的信息
 * 
 * */
public class Administraors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ano;
	private String aaccount;
	private String apass;

	public Administraors(int ano, String aaccount, String apass) {
		super();
		this.ano = ano;
		this.aaccount = aaccount;
		this.apass = apass;
	}

	@Override
	public String toString() {
		return "Administraors [ano=" + this.ano + ", aaccount=" + this.aaccount
				+ ", apass=" + this.apass + "]";

	}

	public Administraors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAaccount() {
		return aaccount;
	}

	public void setAaccount(String aaccount) {
		this.aaccount = aaccount;
	}

	public String getApass() {
		return apass;
	}

	public void setApass(String apass) {
		this.apass = apass;
	}

}