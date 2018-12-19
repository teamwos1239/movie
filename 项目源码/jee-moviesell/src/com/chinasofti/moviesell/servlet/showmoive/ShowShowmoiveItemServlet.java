package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;

/**
 * Servlet implementation class ShowShowmoiveItemServlet
 */
public class ShowShowmoiveItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowShowmoiveItemServlet() {
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

		int pageSize = 24;
		int currentPage = 0;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} else {
			currentPage = 1;
		}

		IShowmovieBiz showmovieBiz = new ShowmovieBizImpl();

		String paixun="sno";
		HttpSession session=request.getSession();
		if(session.getAttribute("chooseD")!=null){
			String chose=session.getAttribute("chooseD").toString();
			
			if("放映编号".equals(chose)){
				paixun="sno";
			}
			if("放映时间".equals(chose)){
				paixun="stime";
			}
			if("电影".equals(chose)){
				paixun="mno";
			}
			if("电影院".equals(chose)){
				paixun="tno";
			}
		}
		
		PageBean showmoviePage = showmovieBiz.findAllByPage(currentPage,pageSize,paixun);

		request.setAttribute("showmoviePage", showmoviePage);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("jsp/admin/admin_showshowmoive.jsp");
		dispatcher.forward(request, response);

	}

}
