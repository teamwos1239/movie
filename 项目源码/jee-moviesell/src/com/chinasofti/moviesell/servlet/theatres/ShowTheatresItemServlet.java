package com.chinasofti.moviesell.servlet.theatres;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.gai.TheatresItem;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class ShowTheatresItemServlet
 */
public class ShowTheatresItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTheatresItemServlet() {
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
		
		
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		List<TheatresItem> lstTheatresItem=theatresBiz.findTheatresItemAll();
		
		
		request.setAttribute("lstTheatresItem", lstTheatresItem); 
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_showtheatres.jsp");
		dispatcher.forward(request, response);
	}

}
