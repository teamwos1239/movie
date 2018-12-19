package com.chinasofti.moviesell.biz;

import java.util.List;

import com.chinasoft.moviesell.domain.Administraors;


public interface IAdminBiz {

	public abstract boolean add(final Administraors admin);
	public abstract Administraors findById(final int ano);
	public abstract List<Administraors> findAll();
	public abstract boolean update(final Administraors admin);
	public abstract boolean delete(final int ano);
	public abstract boolean checkLogin(final  Administraors admin);
}
