package com.chinasofti.moviesell.servlet.cities;

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
 * Servlet implementation class FindCityByTnoServlet
 */
public class FindCityByTnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCityByTnoServlet() {
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
		
		int tno = Integer.parseInt(request.getParameter("tno").toString());
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		int cno=theatresBiz.findById(tno).getCno();
		
		ICitiesBiz citiesBiz=new CitiesBizImpl();
		Cities  city= citiesBiz.findById(cno);
		
		
		List<Theatres> lstTheatres=theatresBiz.findByCno(cno);
		request.setAttribute("findlstTheatre", lstTheatres);
		
		
		request.setAttribute("findUserTheatrecity", city);
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/users/users_set.jsp");
		dispatcher.forward(request, response);
		 
		
	}

}
