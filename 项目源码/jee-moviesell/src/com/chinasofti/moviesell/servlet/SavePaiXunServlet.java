package com.chinasofti.moviesell.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SavePaiXunServlet
 */
public class SavePaiXunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePaiXunServlet() {
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
		
		//存放排序的选择到session
		request.setCharacterEncoding("utf-8");
		String chosed = request.getParameter("chosed").toString();
		chosed = new String(chosed.getBytes("iso-8859-1"), "utf-8");

		HttpSession session=request.getSession();
		session.setAttribute("chooseD",chosed);
		
		
		String pagePath = request.getParameter("pagePath").toString();
		response.sendRedirect(pagePath);
	}

}
