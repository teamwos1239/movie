package com.chinasofti.moviesell.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.gai.OrderItem;
import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.ITicketordersBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;
import com.chinasofti.moviesell.biz.impl.TicketordersBizImpl;

/**
 * Servlet implementation class FindByIdOrderServlet
 */
public class FindByIdOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdOrderServlet() {
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
		
		int ono=Integer.parseInt(request.getParameter("ono").toString());
		
		
		ITicketordersBiz ticketordersBiz=new TicketordersBizImpl();
		String strSQl="SELECT * FROM ticketorders where ono="+ono;
		List<OrderItem> orderItem=ticketordersBiz.findOrderItemsByCondition(strSQl);
		OrderItem order=orderItem.get(0);

		Ticketorders order2=ticketordersBiz.findById(ono);
	
		
		int sno=order.getoShowmoive().getSno();
		//获得放映电影信息
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		List<ShowmoiveItem> lstShowmoiveItem=showmovieBiz.findShowmoiveItemByCondition("SELECT * FROM v_showmoive v where sno="+sno);
		ShowmoiveItem showmoiveItem=lstShowmoiveItem.get(0);
		
		
		//图片路径
		String picPath="";
		Movies movie=order.getoMovie();
		picPath=movie.getMpicpath();
		request.setAttribute("picPath", picPath);
		
		HttpSession session=request.getSession();
		//返回生成的订单
		session.setAttribute("createOrder", order2);
		
		//返回放映电影的信息
		request.setAttribute("orderShowmoiveItem", showmoiveItem);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/users/user_orderdetail.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
