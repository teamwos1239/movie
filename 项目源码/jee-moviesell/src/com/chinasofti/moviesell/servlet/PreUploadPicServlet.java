package com.chinasofti.moviesell.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PreUploadPicServlet
 */
public class PreUploadPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreUploadPicServlet() {
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

		String mpicpath = "";
		if (request.getParameter("mpicpath") != null) {
			mpicpath = request.getParameter("mpicpath").toString();
		}
		ServletContext servletContext=request.getServletContext();
		//该项目的绝对路径
		String proPath=servletContext.getRealPath("");
		
		File file = new File(proPath+"/pic/pictures/" + mpicpath);


		//创建目录
		file.mkdir();
			
		HttpSession session=request.getSession();
		int mno = Integer.parseInt(request.getParameter("mno").toString());


		session.setAttribute("picPath", mpicpath);
		response.sendRedirect("jsp/admin/admin_addmoviepic.jsp?mno="+mno);
	}

}
