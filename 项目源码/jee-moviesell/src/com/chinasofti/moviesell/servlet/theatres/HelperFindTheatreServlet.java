package com.chinasofti.moviesell.servlet.theatres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class HelperFindTheatreServlet
 */
public class HelperFindTheatreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelperFindTheatreServlet() {
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
		int tno=1;
		if(request.getParameter("tno")==null||"".equals(request.getParameter("tno"))){
			
		}else{
			
		
			tno=Integer.parseInt(request.getParameter("tno").toString());
		}
		
		
		
		
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		Theatres theatre=theatresBiz.findById(tno);
		
		
//		HttpSession session=request.getSession();
//		session.setAttribute("selectTheatre", theatre);
		
		request.setAttribute("selectTheatre", theatre);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/helper/helper_theatre.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
