package com.chinasofti.moviesell.servlet.movie;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;

/**
 * Servlet implementation class UpdateMoviesServlet
 */
public class UpdateMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		Movies movie=new Movies();
		RequestToBean.polulate(request, movie);
		
		IMoviesBiz moviesBiz=new MoviesBizImpl();
		boolean flag = moviesBiz.update(movie);
		if(flag){
			
			//将原来图片转移到新地址
			
			ServletContext servletContext=request.getServletContext();
			//该项目的绝对路径
			String proPath=servletContext.getRealPath("");

			String oldpath=request.getParameter("oldpath").toString();
					
			File oldfile = new File(proPath+"/pic/pictures/" + oldpath);
			File newfile = new File(proPath+"/pic/pictures/" + movie.getMpicpath());
			oldfile.renameTo(newfile);
			
		}
				
		request.setAttribute("updatemovieflag", flag);
		RequestDispatcher dispatcher=request.getRequestDispatcher("FindByIdMoviesServlet?mno="+movie.getMno());
		dispatcher.forward(request, response);
		
		
	}

}
