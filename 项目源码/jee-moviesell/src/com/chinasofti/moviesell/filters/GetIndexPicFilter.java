package com.chinasofti.moviesell.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;

/**
 * Servlet Filter implementation class GetIndexPicFilter
 */
public class GetIndexPicFilter implements Filter {

	private ServletContext servletContext;
	
    /**
     * Default constructor. 
     */
    public GetIndexPicFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		this.servletContext=req.getServletContext();
		
		
		if(this.servletContext.getAttribute("lstSetMovies")==null){
			
			
			IMoviesBiz moviesBiz=new MoviesBizImpl();
			//返回最新的前24个
			

			List<Movies> lstSetMovies=moviesBiz.findAll();
			if(moviesBiz.findAll().size()>=25){
				lstSetMovies=lstSetMovies.subList(0, 23);
			}else{
				
			}
			
			servletContext.setAttribute("lstSetMovies", lstSetMovies);
			
		}else{
			
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
