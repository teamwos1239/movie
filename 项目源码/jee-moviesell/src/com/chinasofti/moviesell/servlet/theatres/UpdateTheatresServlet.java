package com.chinasofti.moviesell.servlet.theatres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class UpdateTheatresServlet
 */
public class UpdateTheatresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTheatresServlet() {
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

		Theatres theatres=new Theatres();
		RequestToBean.polulate(request, theatres);
		
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		boolean flag = theatresBiz.update(theatres);
		
		request.setAttribute("updatetheatreflag", flag);
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_updatetheatre.jsp");
		dispatcher.forward(request, response);
	}

}
