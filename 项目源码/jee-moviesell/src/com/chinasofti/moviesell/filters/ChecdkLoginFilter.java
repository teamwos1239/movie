package com.chinasofti.moviesell.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CheckLoginFilter
 * 
 * @param <E>
 */
@WebFilter("/CheckLoginFilter")
public class ChecdkLoginFilter<E> implements Filter {

	/**
	 * Default constructor.
	 */
	public ChecdkLoginFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 获取客户端请求目的地址
		String targetPath = req.getServletPath();
		String target = targetPath.substring(targetPath.lastIndexOf("/") + 1);

		// 设置一个筛选资源
		List<String> lstAccessPath = new ArrayList<String>();
		lstAccessPath.add("index.jsp");
		lstAccessPath.add("login.jsp");
		lstAccessPath.add("LoginServlet");

		if (lstAccessPath.contains(target)) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			if (session.getAttribute("account") == null) {
				res.sendRedirect("/jee-Filter/jsp/login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
