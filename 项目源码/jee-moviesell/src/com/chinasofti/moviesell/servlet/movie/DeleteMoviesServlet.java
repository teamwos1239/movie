package com.chinasofti.moviesell.servlet.movie;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasofti.commonsframework.util.DeletePic;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;

/**
 * Servlet implementation class DeleteMoviesServelet
 */
public class DeleteMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMoviesServlet() {
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

		int mno = Integer.parseInt(request.getParameter("mno").toString());
		IMoviesBiz moviesBiz = new MoviesBizImpl();
		Movies movies = moviesBiz.findById(mno);
		String odlpath = movies.getMpicpath();
		boolean flag = moviesBiz.delete(mno);

		if (flag) {

			ServletContext servletContext = request.getServletContext();
			String proPath = servletContext.getRealPath("");

			File file = new File(proPath + "/pic/pictures/" + odlpath);

			try {
				DeletePic.deletefile(file.getAbsolutePath());

			} catch (Exception e) {
				e.printStackTrace();
			}

			List<Movies> lstSetMovies = moviesBiz.findAll();
			if (moviesBiz.findAll().size() >= 25) {
				lstSetMovies = lstSetMovies.subList(0, 23);
			} else {
			}
			servletContext.setAttribute("lstSetMovies", lstSetMovies);

		}

		request.setAttribute("delmoviesflag", flag);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ShowMoviesServlet");
		dispatcher.forward(request, response);

	}

}
