package com.chinasofti.moviesell.servlet.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.Users;
import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;

/**
 * Servlet implementation class CreateOrderServlet
 */
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrderServlet() {
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
			
		
		int sno=Integer.parseInt(request.getParameter("sno").toString());
		//获得放映电影信息
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		List<ShowmoiveItem> lstShowmoiveItem=showmovieBiz.findShowmoiveItemByCondition("SELECT * FROM v_showmoive v where sno="+sno);
		ShowmoiveItem showmoiveItem=lstShowmoiveItem.get(0);
		
		
		//图片路径
		String picPath="";
		IMoviesBiz moviesBiz=new MoviesBizImpl();
		Movies movie=moviesBiz.findById(showmoiveItem.getMno());
		picPath=movie.getMpicpath();
		request.setAttribute("picPath", picPath);
		
		
		Ticketorders order=new Ticketorders();
		order.setSno(sno);
		
		HttpSession session=request.getSession();
		Users user=(Users) session.getAttribute("logineduser");
		
		order.setUno(user.getUno());
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyMMddHHmmss",Locale.CHINA);
		Date nowtime=new Date();
		
		String obizcode=session.getId()+dateFormat.format(nowtime);
		order.setObizcode(obizcode);
		
		
		String opayway="支付宝";
		order.setOpayway(opayway);
		String ostatus="已支付";
		order.setOstatus(ostatus);
		Date otime=nowtime;
		order.setOtime(otime);
		String opayplatform="网上";
		order.setOpayplatform(opayplatform);
		
		//2-2,4-9,9-10
		String seatString=request.getParameter("seatString").toString();
		//2-2  4-9 9-0
		String[] seats=seatString.split(",");
		
		int ocount=seats.length;
		order.setOcount(ocount);
		
		int oquantity1=Integer.parseInt(request.getParameter("oquantity1").toString());
		int oquantity2=Integer.parseInt(request.getParameter("oquantity2").toString());
		order.setOquantity1(oquantity1);
		order.setOquantity2(oquantity2);
		
		int rCode=(int) (Math.random() * 30.0) + 10;

		dateFormat=new SimpleDateFormat("mmss",Locale.CHINA);
		String oconvertcode=dateFormat.format(nowtime)+rCode;
		order.setOconvertcode(oconvertcode);
		
		float movieM=showmoiveItem.getSprice();
		float opaymoney=movieM*ocount+29*oquantity1+29*oquantity2;
		order.setOpaymoney(opaymoney);
		
		String oseats=seatString;
		order.setOseats(oseats);

		//返回生成的订单
		session.setAttribute("createOrder", order);
		
		//返回放映电影的信息
		request.setAttribute("orderShowmoiveItem", showmoiveItem);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/order.jsp");
		dispatcher.forward(request, response);
		
	}
	

}
