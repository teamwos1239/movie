package com.chinasofti.moviesell.servlet.cities;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Theatres;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;


/**
 * Servlet implementation class SaveCityHelperServlet
 */
public class SaveCityHelperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCityHelperServlet() {
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
		
		
		int cno = Integer.parseInt(request.getParameter("cno").toString());

		String pagePath=request.getParameter("pagePath").toString();
		HttpSession session=request.getSession();
		session.setAttribute("selectedCity",cno );
		if("jsp/helper/helper_theatre.jsp".equals(pagePath)){ 
			
		
			//影城信息界面 
			ITheatresBiz theatresBiz=new TheatresBizImpl();
			//返回影城列表
			List<Theatres> lstTheatres=theatresBiz.findByCno(cno);
			System.out.println();
			
			session.setAttribute("lstTheatresHelper", lstTheatres);
			
			
		}
		
		
		response.sendRedirect(pagePath);
		
	}
	

}
