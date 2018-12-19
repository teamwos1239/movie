package com.chinasofti.moviesell.servlet.showmoive;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.moviesell.domain.Movies;
import com.chinasoft.moviesell.domain.Theatres;
import com.chinasoft.moviesell.domain.gai.ShowmoiveItem;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;

/**
 * Servlet implementation class FindShowmoiveItemByCondtionServlet
 */
public class FindShowmoiveItemByCondtionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindShowmoiveItemByCondtionServlet() {
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
		session.setAttribute("selectedCity",cno );//把选择的城市放到session中以便下次直接读取
		
		
		IShowmovieBiz showmovieBiz = new ShowmovieBizImpl();
		
		//----------------------------------
		List<ShowmoiveItem> lstShowmoiveItemAll = showmovieBiz.findShowmoiveItemByCname(cno);
		Set<Movies> movieSet=new HashSet<Movies>();
		Set<Theatres> theatreSet=new HashSet<Theatres>();
		//获得第一个电影院的信息
		int tno=0;
		if(lstShowmoiveItemAll.size()!=0)
			tno=lstShowmoiveItemAll.get(0).getTno();
		
		Map<Integer, String> thMap=new HashMap<Integer, String>();
		Map<Integer, String> moMap=new HashMap<Integer, String>();
		
		for (ShowmoiveItem showm : lstShowmoiveItemAll) {
			moMap.put(showm.getMno(), showm.getSmname());
			thMap.put(showm.getTno(), showm.getStname());
		}

		Iterator<Integer> itr=thMap.keySet().iterator();
		while (itr.hasNext()) {
			
			int i=itr.next();
			Theatres th=new Theatres(); 
			th.setTno(i);
			th.setTname(thMap.get(i));
			theatreSet.add(th);	
		}
		
		itr=moMap.keySet().iterator();
		while (itr.hasNext()) {
			
			int i=itr.next();
			Movies mo=new Movies(); 
			mo.setMno(i);
			mo.setMname(moMap.get(i));

			movieSet.add(mo);
		}
		 
		//选项菜单中的电影列表
		request.setAttribute("allMovieSet", movieSet);
		//选项菜单中的电影院列表
		request.setAttribute("allTheatreSet", theatreSet);
		//----------------------------------
		
		
		
		StringBuffer strBuffer = new StringBuffer("SELECT * FROM v_showmoive v where  cno="+cno);	
		int stimeFlag=0;
		if(request.getParameter("stimeFlag")!=null&&request.getParameter("stimeFlag").toString().trim().length() != 0){
			stimeFlag = Integer.parseInt(request.getParameter("stimeFlag").toString().trim());
		}	
		strBuffer.append(" and datediff(stime,now())="+stimeFlag);
		//返回时间标志
		request.setAttribute("stimeFlag", stimeFlag);
			
		int selectedDayTime=0;
		if(request.getParameter("selectedDayTime")!=null&&request.getParameter("selectedDayTime").toString().trim().length() != 0){
			selectedDayTime = Integer.parseInt(request.getParameter("selectedDayTime").toString().trim());
		
			switch (selectedDayTime) {
			case 0:
				break;
			case 1:
				strBuffer.append(" and hour(stime)<=12");
				break;
			case 2:
				strBuffer.append(" and hour(stime)>12 and hour(stime)<=18");
				break;
			case 3:
				strBuffer.append(" and hour(stime)>18");
				break; 
			}
		 
		}	
		//返回全天时间标志
		request.setAttribute("dayFlag", selectedDayTime);
		
		int versionFlag=0;
		if(request.getParameter("versionFlag")!=null&&request.getParameter("versionFlag").toString().trim().length() != 0){
			versionFlag = Integer.parseInt(request.getParameter("versionFlag").toString().trim());
			//3D 1 IMAX-3D 2 2D 3 IMAX-2D 4 XLAND 5
			switch (versionFlag) {
			case 0:
				break;
			case 1:
				strBuffer.append(" and smversion='3D'");
				break;
			case 2:
				strBuffer.append(" and smversion='IMAX-3D'");
				break;
			case 3:
				strBuffer.append(" and smversion='2D'");
				break; 
			case 4:
				strBuffer.append(" and smversion='IMAX-2D'");
				break; 
			case 5:
				strBuffer.append(" and smversion='XLAND'");
				break; 
			}
		}	
		//返回版本标志
		request.setAttribute("versionFlag", versionFlag);
		
		
		if(request.getParameter("mno")!=null&&request.getParameter("mno").toString().trim().length() != 0){
			int mno = Integer.parseInt(request.getParameter("mno").toString().trim());
			strBuffer.append("  and mno="+mno);
			IMoviesBiz moviesBiz=new MoviesBizImpl();
			Movies movies=moviesBiz.findById(mno);
			//返回电影信息
			request.setAttribute("selectedMovies", movies);
		}	
		
		
		if(request.getParameter("tno")!=null&&request.getParameter("tno").toString().trim().length() != 0){
			tno = Integer.parseInt(request.getParameter("tno").toString().trim());
			strBuffer.append("  and tno="+tno);
		}else{
			strBuffer.append("  and tno="+tno);			
		}
		
		
		String strSQL= strBuffer.toString();
		//特殊查询查询出来的结果
		List<ShowmoiveItem> lstShowmoiveItemItem = showmovieBiz.findShowmoiveItemByCondition(strSQL);
		request.setAttribute("lstShowmoiveItemItem", lstShowmoiveItemItem);
		Set<Movies> mainMovieSet=new HashSet<Movies>();
		 
		moMap=new HashMap<Integer, String>();		
		for (ShowmoiveItem showm : lstShowmoiveItemItem) {			
			moMap.put(showm.getMno(), showm.getSmname());
		}

		itr=moMap.keySet().iterator();
		while (itr.hasNext()) {			
			int i=itr.next();
			Movies mo=new Movies(); 
			mo.setMno(i);
			mo.setMname(moMap.get(i));
			mainMovieSet.add(mo);
		}
		
		//内容中的电影列表
		request.setAttribute("mainMovieSet", mainMovieSet);
		// 按电影院编号返回电影院信息
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		Theatres theatres=theatresBiz.findById(tno);
		//返回电影院信息
		request.setAttribute("selectedTheatres", theatres);
		
		
		//返回跳转标志
		request.setAttribute("flag", 1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/movietimes.jsp");
		dispatcher.forward(request, response); 
		
	}

}
