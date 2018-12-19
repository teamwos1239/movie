package com.chinasofti.moviesell.servlet.cities;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class SaveProSelectedServlet
 */
public class SaveProSelectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveProSelectedServlet() {
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
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		String proname = request.getParameter("proname").toString();
		proname = new String(proname.getBytes("iso-8859-1"), "utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("selectedPro", proname);

		// 获取该省份的城市列表
		ICitiesBiz citiesBiz = new CitiesBizImpl();
		List<Cities> lstCities = citiesBiz.findAllByProName(proname);
		session.setAttribute("lstSetCities", lstCities);
		String pagePath = request.getParameter("pagePath").toString();

		if ("jsp/helper/helper_theatre.jsp".equals(pagePath)) {

			// 影城信息界面
			ITheatresBiz theatresBiz = new TheatresBizImpl();
			// 返回影城列表
			List<Theatres> lstTheatres = theatresBiz.findByCno(lstCities.get(0)
					.getCno());
			System.out.println();

			session.setAttribute("lstTheatresHelper", lstTheatres);

		}
	//	System.out.println("true or false conteian------------"+pagePath.contains("admin"));
//		if ("jsp/admin/admin_addshowmoive.jsp".equals(pagePath)) {
		if (pagePath.contains("admin")) {

			ITheatresBiz theatresBiz = new TheatresBizImpl();
			// 返回影城列表
			List<Theatres> findlstTheatres = theatresBiz.findByCno(lstCities
					.get(0).getCno());

			session.setAttribute("findlstTheatres", findlstTheatres);
		}
		response.sendRedirect(pagePath);
	}

}
