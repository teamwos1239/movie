package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chinasoft.moviesell.domain.Movies;
import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.Theatres;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class FindByIdShowmoiveServlet
 */
public class FindByIdShowmoiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdShowmoiveServlet() {
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
		
		
		int sno=Integer.parseInt(request.getParameter("sno").toString());
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		
		Showmoive showmoive=showmovieBiz.findById(sno);
		
		//找到所有的电影院
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		List<Theatres> lstTheatres=theatresBiz.findAll();
		
		//找到所有的电影		
		IMoviesBiz moviesBiz=new MoviesBizImpl();
		List<Movies> lstMovie=moviesBiz.findAll();
		
		request.setAttribute("findshowmoive", showmoive);
		request.setAttribute("findlstTheatres", lstTheatres);
		request.setAttribute("findlstMovie", lstMovie);
		
		
		List<String[]> lstSeat=new ArrayList<String[]>();
		String[] seat=showmoive.getSseatsatust1().split("-");
		lstSeat.add(seat);
		
		seat=showmoive.getSseatsatust2().split("-");
		lstSeat.add(seat);

		seat=showmoive.getSseatsatust3().split("-");
		lstSeat.add(seat);
		
		seat=showmoive.getSseatsatust4().split("-");
		lstSeat.add(seat);
		
		seat=showmoive.getSseatsatust5().split("-");
		lstSeat.add(seat);
		
		seat=showmoive.getSseatsatust6().split("-");
		lstSeat.add(seat);
		
		seat=showmoive.getSseatsatust7().split("-");
		lstSeat.add(seat);
		
		seat=showmoive.getSseatsatust8().split("-");
		lstSeat.add(seat);
		
		seat=showmoive.getSseatsatust9().split("-");
		lstSeat.add(seat);

		System.out.println("lstSeat");
		request.setAttribute("findlstSeat", lstSeat);
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_updatshowmoive.jsp");
		dispatcher.forward(request, response);
	}

}
