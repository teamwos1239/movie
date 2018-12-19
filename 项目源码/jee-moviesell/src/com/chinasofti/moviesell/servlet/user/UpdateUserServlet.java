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
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		HttpSession session=request.getSession();
		Users loginuser=(Users) session.getAttribute("logineduser");
		
		Users user=new Users();
		RequestToBean.polulate(request, user);
		
		loginuser.setUbirthday(user.getUbirthday());
		loginuser.setUname(user.getUname());
		loginuser.setUsex(user.getUsex());
		
		IUsersBiz usersBiz=new UsersBizImpl();
		boolean flag = usersBiz.update(loginuser);
		
		request.setAttribute("updateuserflag", flag);
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/users/users_set.jsp");
		dispatcher.forward(request, response); 
	}

}
