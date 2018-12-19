package com.chinasofti.moviesell.servlet.cities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.moviesell.biz.ICitiesBiz;
import com.chinasofti.moviesell.biz.impl.CitiesBizImpl;

/**
 * Servlet implementation class DeleteCitiesServlet
 */
public class DeleteCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCitiesServlet() {
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
		boolean flag = citiesBiz.delete(cno);
		
		request.setAttribute("delcityflag", flag);
		

		String path=request.getParameter("pagePath");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
