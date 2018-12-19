package com.chinasofti.moviesell.servlet.theatres;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class AddTheatresServlet
 */
public class AddTheatresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTheatresServlet() {
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

		Theatres theatre = new Theatres();
		RequestToBean.polulate(request, theatre);

		ITheatresBiz theatresBiz = new TheatresBizImpl();

		String flag = "添加成功";
		boolean flagg = true;
		String tname = theatre.getTname();
		List<Theatres> lsTheatres = theatresBiz.findAll();
		for (Theatres theatreIt : lsTheatres) {
			if (theatreIt.getTname().equals(tname)) {
				flagg = false;
			}
		}
		if (flagg) {

			flagg = theatresBiz.add(theatre);
			if (flagg) {
				flag = "电影院添加成功";
			} else {
				flag = "电影院添加失败";
			}

			request.setAttribute("addtheatreflag", flag);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("jsp/admin/admin_addtheatre.jsp");
			dispatcher.forward(request, response);
		} else {

			flag = "电影院添加失败，该名称的电影院已存在";
			request.setAttribute("addtheatreflag", flag);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("jsp/admin/admin_addtheatre.jsp");
			dispatcher.forward(request, response);

		}

	}

}
