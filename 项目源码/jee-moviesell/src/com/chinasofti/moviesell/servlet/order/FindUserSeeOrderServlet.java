package com.chinasofti.moviesell.servlet.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.ITicketordersBiz;
import com.chinasofti.moviesell.biz.impl.TicketordersBizImpl;

/**
 * Servlet implementation class FindUserSeeOrderServlet
 */
public class FindUserSeeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserSeeOrderServlet() {
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
		
		Users user=(Users) request.getSession().getAttribute("logineduser");
		
		int uno=user.getUno();
		
		int pageSize = 5;
		int currentPage = 0;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} else {
			currentPage = 1;
		}
		
		ITicketordersBiz ticketordersBiz=new TicketordersBizImpl();
		PageBean orderItemPage=ticketordersBiz.findAllByUnoPage(uno, currentPage, pageSize);
		request.setAttribute("usreOrderPage", orderItemPage);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/users/user_order.jsp");
 		dispatcher.forward(request, response);
		
		
		
		
	}

}
