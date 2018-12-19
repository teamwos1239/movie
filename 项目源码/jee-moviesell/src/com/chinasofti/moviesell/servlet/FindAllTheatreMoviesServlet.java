package com.chinasofti.moviesell.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;

/**
 * Servlet implementation class FindAllTheatreMoviesServlet
 */
public class FindAllTheatreMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindAllTheatreMoviesServlet() {
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


		// 找到所有的电影
		IMoviesBiz moviesBiz = new MoviesBizImpl();
		List<Movies> lstMovie = moviesBiz.findAll();

		request.setAttribute("findlstMovie", lstMovie);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_addshowmoive.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
