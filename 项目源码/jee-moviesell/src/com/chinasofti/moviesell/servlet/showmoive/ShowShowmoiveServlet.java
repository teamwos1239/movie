package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;

/**
 * Servlet implementation class ShowShowmoiveServlet
 */
public class ShowShowmoiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowShowmoiveServlet() {
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
		
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		List<Showmoive> lstShowmoive=showmovieBiz.findAll();
		
		request.setAttribute("lstShowmoive", lstShowmoive); 
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_showshowmoive.jsp");
		dispatcher.forward(request, response);
		
	}

}
