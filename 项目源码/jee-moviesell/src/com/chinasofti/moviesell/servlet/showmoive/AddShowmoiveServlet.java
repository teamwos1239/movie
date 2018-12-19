package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;

/**
 * Servlet implementation class AddShowmoiveServlet
 */
public class AddShowmoiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShowmoiveServlet() {
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

		Showmoive showmoive=new Showmoive();
		RequestToBean.polulate(request, showmoive);
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		
				
		String st=request.getParameter("stimeYuan").toString();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.CHINA);
		try {
			Date stime=dateFormat.parse(st);

			showmoive.setStime(stime);		
			boolean flag=showmovieBiz.add(showmoive);
			
			request.setAttribute("addshowmoiveflag", flag);
			RequestDispatcher dispatcher=request.getRequestDispatcher("FindAllTheatreMoviesServlet");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
