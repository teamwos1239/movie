package com.chinasofti.moviesell.servlet.cities;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.moviesell.domain.Cities;
import com.chinasofti.commonsframework.util.RequestToBean;
import com.chinasofti.moviesell.biz.ICitiesBiz;
import com.chinasofti.moviesell.biz.impl.CitiesBizImpl;

/**
 * Servlet implementation class AddCitiestServlet
 */
public class AddCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCitiesServlet() {
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
		
		Cities cities = new Cities();
		RequestToBean.polulate(request, cities);
		
		ICitiesBiz citiesBiz = new CitiesBizImpl();
		
		boolean flag=true;
		String errorMsg="城市添加成功";
		
		List<Cities> allCities=citiesBiz.findAll();
		for (Cities city : allCities) {
			if(city.getCname().equals(cities.getCname())){
				flag=false;
				errorMsg="城市添加失败，该名称城市已存在";
			}
		}
		if(flag){
			flag= citiesBiz.add(cities);
			if(flag){
			}else{
				errorMsg="城市添加失败";
			}
		}
		
		
		request.setAttribute("addcityflag", errorMsg);
		RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin/admin_addcity.jsp");
		dispatcher.forward(request, response);
		
	}

}
