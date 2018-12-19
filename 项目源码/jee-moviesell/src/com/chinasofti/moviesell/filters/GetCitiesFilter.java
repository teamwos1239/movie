package com.chinasofti.moviesell.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class GetCitiesFilter
 */
public class GetCitiesFilter implements Filter {
	
	private ServletContext servletContext;


	/**
	 * Default constructor.
	 */
	public GetCitiesFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		this.servletContext=req.getServletContext();
		
		
		if(this.servletContext.getAttribute("citiesarr")==null){
			String[] citiesarr = {"北京","天津","上海","黑龙江","河北","重庆","山东",
        				"内蒙古","浙江","广东","吉林","安徽","湖南","江苏","四川",
        				"辽宁","山西","福建","贵州","海南","陕西","长春","湖北",
        				"云南","甘肃","河南","江西","广西","大连","宁夏"};	
			
		//	String[] citiesarr = {"北京", "天津"};
			servletContext.setAttribute("citiesarr", citiesarr);
			
		}
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.servletContext=fConfig.getServletContext();
	}

}
