package com.chinasofti.moviesell.servlet.theatres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class DeleteTheatresServlet
 */
public class DeleteTheatresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTheatresServlet() {
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
	
		int tno = Integer.parseInt(request.getParameter("tno").toString());
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		boolean flag = theatresBiz.delete(tno);
		
		request.setAttribute("deltheatreflag", flag);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShowTheatresItemServlet");
		dispatcher.forward(request, response);
	}

}
