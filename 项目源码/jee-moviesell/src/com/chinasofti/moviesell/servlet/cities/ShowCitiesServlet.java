package com.chinasofti.moviesell.servlet.cities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.ICitiesBiz;
import com.chinasofti.moviesell.biz.impl.CitiesBizImpl;

/**
 * Servlet implementation class ShowCitiesServlet
 */
public class ShowCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCitiesServlet() {
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
		int pageSize = 10;
		int currentPage = 0;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} else {
			currentPage = 1;
		}

		ICitiesBiz citiesBiz=new CitiesBizImpl();
		PageBean citiestPage=citiesBiz.findAllByPage(currentPage, pageSize);
		
		
		request.setAttribute("citiestPage", citiestPage); 
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_showcities.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

}
