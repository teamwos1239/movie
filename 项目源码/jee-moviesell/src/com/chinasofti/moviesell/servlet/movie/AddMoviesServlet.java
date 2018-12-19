package com.chinasofti.moviesell.servlet.movie;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class AddMoviesServlet
 */
public class AddMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMoviesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Movies movie = new Movies();
		RequestToBean.polulate(request, movie);

		IMoviesBiz moviesBiz = new MoviesBizImpl();

		boolean flag = false;

		String mname = movie.getMname();
		String strSQL = "select * from movies where mname='" + mname + "' ";
		List<Movies> lstAllMovies = moviesBiz.findByCondition(strSQL);
		String errorCode = "0000";
		if (lstAllMovies.size() == 0 || lstAllMovies == null) {
			flag = true;

			strSQL = "select * from movies where mpicpath='"
					+ movie.getMpicpath() + "'";
			lstAllMovies = moviesBiz.findByCondition(strSQL);
			if (lstAllMovies.size() == 0 || lstAllMovies == null) {

				flag = moviesBiz.add(movie);
				if (flag) {
					ServletContext servletContext = request.getServletContext();

					List<Movies> lstSetMovies = moviesBiz.findAll();
					servletContext.setAttribute("lstSetMovies", lstSetMovies);

					// SELECT * FROM movies where mname='rt';
					strSQL = "SELECT * FROM movies where mname='"
							+ movie.getMname() + "'";
					List<Movies> lstmovie = moviesBiz.findByCondition(strSQL);
					movie = lstmovie.get(0);

					request.setAttribute("addedMovie", movie);
				} else {
					errorCode = "0101";// 添加失败
				}
			} else {
				errorCode="0103";//该路径已存在
			}
		} else {
			flag = false;
			errorCode = "0102";// 该名称电影已存在
		}

		request.setAttribute("addmoviesflag", flag);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("jsp/admin/admin_addmovies.jsp?errorCode="
						+ errorCode);
		dispatcher.forward(request, response);
	}

}
