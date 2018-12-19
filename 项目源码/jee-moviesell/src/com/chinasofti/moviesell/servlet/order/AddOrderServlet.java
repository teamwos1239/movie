package com.chinasofti.moviesell.servlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.Users;
import com.chinasofti.commonsframework.util.BaseEmailSend;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.ITicketordersBiz;
import com.chinasofti.moviesell.biz.IUsersBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;
import com.chinasofti.moviesell.biz.impl.TicketordersBizImpl;
import com.chinasofti.moviesell.biz.impl.UsersBizImpl;

/**
 * Servlet implementation class AddOrderServlet
 */
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("createOrder") != null) {

			Ticketorders order = (Ticketorders) request.getSession()
					.getAttribute("createOrder");

			int sno = order.getSno();
			ITicketordersBiz ticketordersBiz = new TicketordersBizImpl();

			boolean flag = ticketordersBiz.add(order);

			if (flag) {
				response.sendRedirect("jsp/paysucess.jsp");
			
			// 2-2,4-9,9-10
			String seatString = order.getOseats();
			// 2-2 4-9 9-0
			String[] seats = seatString.split(",");

			// 修改原来的座位信息
			IShowmovieBiz showmovieBiz = new ShowmovieBizImpl();
			Showmoive showmoive = showmovieBiz.findById(sno);

			String[][] seatTheatre = new String[8][16];
			// 0 0 0 0 0 0 0 0
			seatTheatre[0] = showmoive.getSseatsatust1().split("-");
			seatTheatre[1] = showmoive.getSseatsatust2().split("-");
			seatTheatre[2] = showmoive.getSseatsatust3().split("-");
			seatTheatre[3] = showmoive.getSseatsatust4().split("-");
			seatTheatre[4] = showmoive.getSseatsatust5().split("-");
			seatTheatre[5] = showmoive.getSseatsatust6().split("-");
			seatTheatre[6] = showmoive.getSseatsatust7().split("-");
			seatTheatre[7] = showmoive.getSseatsatust8().split("-");

			for (String str : seats) {
				// 2 2
				String[] ij = str.split("-");
				int i = Integer.parseInt(ij[0]);
				int j = Integer.parseInt(ij[1]);
				seatTheatre[i - 1][j - 1] = "1";
			}

			String seatstatus = "";
			for (String str : seatTheatre[0]) {
				seatstatus += str + "-";
			}

			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust1(seatstatus);

			seatstatus = "";
			for (String str : seatTheatre[1]) {
				seatstatus += str + "-";
			}

			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust2(seatstatus);

			seatstatus = "";
			for (String str : seatTheatre[2]) {
				seatstatus += str + "-";
			}

			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust3(seatstatus);

			seatstatus = "";
			for (String str : seatTheatre[3]) {
				seatstatus += str + "-";
			}

			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust4(seatstatus);

			seatstatus = "";
			for (String str : seatTheatre[4]) {
				seatstatus += str + "-";
			}

			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust5(seatstatus);

			seatstatus = "";
			for (String str : seatTheatre[5]) {
				seatstatus += str + "-";
			}

			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust6(seatstatus);

			seatstatus = "";
			for (String str : seatTheatre[6]) {
				seatstatus += str + "-";
			}

			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust7(seatstatus);

			seatstatus = "";
			for (String str : seatTheatre[7]) {
				seatstatus += str + "-";
			}
			seatstatus = seatstatus.substring(0, seatstatus.length() - 1);
			showmoive.setSseatsatust8(seatstatus);

			showmovieBiz.update(showmoive); 

			IUsersBiz usersBiz=new UsersBizImpl();
			Users user=usersBiz.findById(order.getUno());
			String uemail=user.getUemail();
//			Users users
			
			BaseEmailSend.send("万达电影  您已购买成功", "您已购买成功，您的电影兑换码是："+order.getOconvertcode(),uemail);
			
			HttpSession session = request.getSession();
			session.removeAttribute("createOrder");
			} else {
				response.sendRedirect("jsp/index.jsp");
			}

		}else{
			response.sendRedirect("jsp/index.jsp");
		}

	}

}
