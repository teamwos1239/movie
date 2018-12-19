package com.chinasofti.moviesell.servlet.theatres;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasoft.moviesell.domain.Theatres;
import com.chinasofti.moviesell.biz.ICitiesBiz;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.CitiesBizImpl;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class FindCityByIdUserServlet
 */
public class FindTheatresByCnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindTheatresByCnoServlet() {
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
		if(request.getParameter("cno")!=null){
			
		
		int cno = Integer.parseInt(request.getParameter("cno").toString());
		ICitiesBiz citiesBiz=new CitiesBizImpl();
		Cities city=citiesBiz.findById(cno);
		
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		
		List<Theatres> lstTheatres=theatresBiz.findByCno(cno);
		
		request.setAttribute("findUserTheatrecity", city);
		request.setAttribute("findlstTheatre", lstTheatres);
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/users/users_set.jsp");
		dispatcher.forward(request, response);
		
		}else{
			
			response.sendRedirect("jsp/users/users_set.jsp");
		}
	}

}
