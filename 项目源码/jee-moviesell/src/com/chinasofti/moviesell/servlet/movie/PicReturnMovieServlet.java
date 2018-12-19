package com.chinasofti.moviesell.servlet.movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;

/**
 * Servlet implementation class PicReturnMovieServlet
 */
public class PicReturnMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PicReturnMovieServlet() {
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

		int mno = Integer.parseInt(request.getParameter("mno").toString());

		IMoviesBiz moviesBiz = new MoviesBizImpl();
		Movies movies = moviesBiz.findById(mno);
		request.setAttribute("addedMovie", movies);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("jsp/admin/admin_addmovies.jsp");
		dispatcher.forward(request, response);

	}

}
