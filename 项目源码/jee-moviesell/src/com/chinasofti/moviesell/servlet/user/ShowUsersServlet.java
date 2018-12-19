package com.chinasofti.moviesell.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.IUsersBiz;
import com.chinasofti.moviesell.biz.impl.UsersBizImpl;

/**
 * Servlet implementation class ShowUsersServlet
 */
public class ShowUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUsersServlet() {
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

		int pageSize = 10;
		int currentPage = 0;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} else {
			currentPage = 1;
		}
		

		IUsersBiz usersBiz=new UsersBizImpl();
		
		PageBean userPage=usersBiz.findAllByPage(currentPage, pageSize);
		
		
		request.setAttribute("userPage", userPage);
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

}
