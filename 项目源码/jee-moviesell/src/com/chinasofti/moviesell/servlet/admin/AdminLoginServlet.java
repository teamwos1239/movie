package com.chinasofti.moviesell.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Administraors;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.IAdminBiz;
import com.chinasofti.moviesell.biz.impl.AdminBizImpl;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		
		Administraors admin=new Administraors();
		RequestToBean.polulate(request, admin);
		
		
		IAdminBiz adminBiz=new AdminBizImpl();
		
		boolean flag = adminBiz.checkLogin(admin);
		
		
		if(flag)
		{
			HttpSession session=request.getSession();
			session.setAttribute("adminLogined", admin);
			response.sendRedirect("jsp/admin/admin.jsp");
			
		}else{
			request.setAttribute("adminloginflag", flag);
			RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_login.jsp");
			dispatcher.forward(request, response);
		}
		 
	}

}
