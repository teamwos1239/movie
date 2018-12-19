package com.chinasofti.moviesell.servlet.user;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.util.BaseEmailSend;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.IUsersBiz;
import com.chinasofti.moviesell.biz.impl.UsersBizImpl;

/**
 * Servlet implementation class UserEnrollServlet
 */
public class UserEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserEnrollServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Users user = new Users();
		RequestToBean.polulate(request, user);

		IUsersBiz usersBiz = new UsersBizImpl();
		List<Users> lstUsers = usersBiz.findAll();

		String uemail = user.getUemail();

		boolean errorFlag = true;
		for (Users users : lstUsers) {
			if (users.getUemail().equals(uemail)) {
				errorFlag = false;
				request.setAttribute("enrollEmailFlag", errorFlag);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/enroll.jsp");
				dispatcher.forward(request, response);

			}
		}

		if (errorFlag) {
			user.setUbirthday(new Date());
			user.setUname(user.getUemail());
			user.setUlevel(1);
			user.setUleveltime(9999);
			user.setUsex("男");

			boolean flag = usersBiz.add(user);

			if (flag) {
				response.sendRedirect("jsp/index.jsp");
				HttpSession session = request.getSession();

				BaseEmailSend.send("万达电影  欢迎注册万达", "恭喜，您已正式成为了我们的会员。", uemail);
				user = usersBiz.findUnoByEmail(user.getUemail());
				session.setAttribute("logineduser", user);

			} else {
				request.setAttribute("enrolluserflag", flag);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/enroll.jsp");
				dispatcher.forward(request, response);
			}
		}

	}

}
