package com.chinasofti.moviesell.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasoft.moviesell.domain.Theatres;
import com.chinasofti.moviesell.biz.ICitiesBiz;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.CitiesBizImpl;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class FindCproCnoByTnoServlet
 */
public class FindCproCnoByTnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCproCnoByTnoServlet() {
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
		
		
		int tno=Integer.parseInt(request.getParameter("old_tno"));
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		Theatres theatre=theatresBiz.findById(tno);
		
		//找到该电影院所在城市的编号
		int cno=theatre.getCno();
		
		ICitiesBiz citiesBiz=new CitiesBizImpl();
		Cities city=citiesBiz.findById(cno);
		//找到该电影院所在省份的名称
		String strprovince=city.getCprovince();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("selectedPro", strprovince);
		session.setAttribute("selectedCity", cno);


		String pagePath=request.getParameter("pagePath").toString();
		request.setAttribute("findccbtflag",1);
		RequestDispatcher dispatcher=request.getRequestDispatcher(pagePath);
		dispatcher.forward(request, response);
		
		
	}

}
