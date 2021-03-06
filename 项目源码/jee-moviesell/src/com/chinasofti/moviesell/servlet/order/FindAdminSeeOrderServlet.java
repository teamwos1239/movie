package com.chinasofti.moviesell.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.gai.OrderItem;
import com.chinasofti.moviesell.biz.ITicketordersBiz;
import com.chinasofti.moviesell.biz.impl.TicketordersBizImpl;

/**
 * Servlet implementation class FindAdminSeeOrderServlet
 */
public class FindAdminSeeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAdminSeeOrderServlet() {
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

		ITicketordersBiz ticketordersBiz=new TicketordersBizImpl();
		
		List<OrderItem> lstOrderItem=ticketordersBiz.findOrderItemAll();
		
		
		request.setAttribute("lstOrderItem", lstOrderItem); 
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_orders.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
