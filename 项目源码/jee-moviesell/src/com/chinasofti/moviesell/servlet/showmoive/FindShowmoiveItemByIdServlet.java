package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;

/**
 * Servlet implementation class FindShowmoiveItemByIdServlet
 */
public class FindShowmoiveItemByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindShowmoiveItemByIdServlet() {
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
		//int sno=Integer.parseInt(request.getParameter("sno").toString());
		int sno=Integer.parseInt(request.getParameter("sno").toString());
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		
		String strSQL="SELECT * FROM v_showmoive v where sno="+sno;
		List<ShowmoiveItem> lstshowmoiveItem=showmovieBiz.findShowmoiveItemByCondition(strSQL);
		ShowmoiveItem showmoiveItem=lstshowmoiveItem.get(0);
		
		request.setAttribute("sellShowmoiveItem", showmoiveItem);

		

		List<String[]> lstSeat=new ArrayList<String[]>();
		
		String[] strSeat=showmoiveItem.getSseatsatust1().split("-");
		lstSeat.add(strSeat);
		
		strSeat=showmoiveItem.getSseatsatust2().split("-");
		lstSeat.add(strSeat);
		
		strSeat=showmoiveItem.getSseatsatust3().split("-");
		lstSeat.add(strSeat);
		
		strSeat=showmoiveItem.getSseatsatust4().split("-");
		lstSeat.add(strSeat);
		
		strSeat=showmoiveItem.getSseatsatust5().split("-");
		lstSeat.add(strSeat);
		
		strSeat=showmoiveItem.getSseatsatust6().split("-");
		lstSeat.add(strSeat);
		
		strSeat=showmoiveItem.getSseatsatust7().split("-");
		lstSeat.add(strSeat);
		
		strSeat=showmoiveItem.getSseatsatust8().split("-");
		lstSeat.add(strSeat);
		
		request.setAttribute("lstSeat", lstSeat);
		
		/*
		StringBuffer str = new StringBuffer();
		for(int i=1;i<=16;i++){
			str.append("2");
			str.append("-");
		}
		String strSeat=str.substring(0, str.length()-1);
		
		String[] seat=strSeat.split("-");

		seat[0]="0";
		seat[1]="0";
		seat[14]="0";
		seat[15]="0";
		seat[5]="1";
		seat[6]="1";
		
		List<String[]> lstSeat=new ArrayList<String[]>();

		lstSeat.add(seat);

		seat=strSeat.split("-");
		seat[0]="0";
		seat[1]="0";
		seat[14]="0";
		seat[15]="0";
		
		for (String strings : seat) {
			System.out.print(strings+"-");
		}
		lstSeat.add(seat);//2
		lstSeat.add(seat);//3
		lstSeat.add(seat);//4
		lstSeat.add(seat);//5
		lstSeat.add(seat);//6

		seat=strSeat.split("-");
		lstSeat.add(seat);//7
		lstSeat.add(seat);//8
//		lstSeat.add(seat);//9
		
		request.setAttribute("lstSeat", lstSeat);
		*/
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/chooseseat.jsp");
		dispatcher.forward(request, response);
	}

}
