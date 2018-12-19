package com.chinasofti.moviesell.servlet.cities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasofti.moviesell.biz.ICitiesBiz;
import com.chinasofti.moviesell.biz.impl.CitiesBizImpl;

/**
 * Servlet implementation class FindByIdCitiesServlet
 */
public class FindByIdCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdCitiesServlet() {
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
		
		int cno = Integer.parseInt(request.getParameter("cno").toString());
		ICitiesBiz citiesBiz=new CitiesBizImpl();
		Cities  city= citiesBiz.findById(cno);
		
		request.setAttribute("findcity", city);
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_updatecity.jsp");
		dispatcher.forward(request, response);
		 
		
		
		
	
	
	}

}
