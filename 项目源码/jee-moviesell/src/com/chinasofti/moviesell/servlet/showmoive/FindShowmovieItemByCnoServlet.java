package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;

/**
 * Servlet implementation class FindShowmovieItemByCnoServlet
 */
public class FindShowmovieItemByCnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindShowmovieItemByCnoServlet() {
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

		HttpSession session=request.getSession();
		session.setAttribute("selectedCity",cno );
		
		
		IShowmovieBiz showmovieBiz = new ShowmovieBizImpl();

		List<ShowmoiveItem> lstShowmoiveItemItem = showmovieBiz.findShowmoiveItemByCname(cno);
		
		Set<String> movieSet=new HashSet<String>();
		Set<String> theatreSet=new HashSet<String>();
		
		
		for (ShowmoiveItem showm : lstShowmoiveItemItem) {
			movieSet.add(showm.getSmname());
			theatreSet.add(showm.getStname());
		}
		
		
		 
		request.setAttribute("lstShowmoiveItemItem", lstShowmoiveItemItem);
		request.setAttribute("movieSet", movieSet);
		request.setAttribute("theatreSet", theatreSet);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/movietimes.jsp");
		dispatcher.forward(request, response); 
	}

}
