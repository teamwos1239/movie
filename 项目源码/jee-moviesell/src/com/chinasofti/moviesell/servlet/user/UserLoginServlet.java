package com.chinasofti.moviesell.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.IUsersBiz;
import com.chinasofti.moviesell.biz.impl.UsersBizImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		
		Users user=new Users();
		RequestToBean.polulate(request, user);
		
		
		IUsersBiz usersBiz=new UsersBizImpl();
		
		Users logineduser = usersBiz.checkLogin(user);
		
		
		if(logineduser!=null)
		{
			response.sendRedirect("jsp/index.jsp");
			
			HttpSession session=request.getSession();
			session.setAttribute("logineduser",logineduser);
			
		}else{
			request.setAttribute("userloginflag", false);
			RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
