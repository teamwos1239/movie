package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;

/**
 * Servlet implementation class DeleteShowmoiveServlet
 */
public class DeleteShowmoiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShowmoiveServlet() {
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
		
		int sno = Integer.parseInt(request.getParameter("sno").toString());
		
		
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		boolean flag=showmovieBiz.delete(sno);
				
		
		request.setAttribute("delshowmoiveflag", flag);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShowShowmoiveItemServlet");
		dispatcher.forward(request, response);
	}

}
