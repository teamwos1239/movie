package com.chinasofti.moviesell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.chinasoft.moviesell.domain.Movies;
import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.Theatres;
import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.Users;
import com.chinasoft.moviesell.domain.gai.OrderItem;
import com.chinasofti.commonsframework.util.Log;
import com.chinasofti.commonsframework.util.PageBean;
import com.chinasofti.moviesell.biz.IMoviesBiz;
import com.chinasofti.moviesell.biz.IShowmovieBiz;
import com.chinasofti.moviesell.biz.ITheatresBiz;
import com.chinasofti.moviesell.biz.IUsersBiz;
import com.chinasofti.moviesell.biz.impl.MoviesBizImpl;
import com.chinasofti.moviesell.biz.impl.ShowmovieBizImpl;
import com.chinasofti.moviesell.biz.impl.TheatresBizImpl;
import com.chinasofti.moviesell.biz.impl.UsersBizImpl;
import com.chinasofti.moviesell.dao.ITicketordersDao;

public class TicketordersDaoImpl implements ITicketordersDao {

	public int insert(Ticketorders order, QueryRunner queryRunner,
			Connection connection) throws SQLException {

		int uno = order.getUno();
		int sno = order.getSno();
		String obizcode = order.getObizcode();
		String opayway = order.getOpayway();
		String ostatus = order.getOstatus();
		Date otime = order.getOtime();
		String opayplatform = order.getOpayplatform();
		int ocount = order.getOcount();
		int oquantity1 = order.getOquantity1();
		int oquantity2 = order.getOquantity2();
		String oconvertcode = order.getOconvertcode();
		float opaymoney = order.getOpaymoney();
		String oseats=order.getOseats();
		
		/*
		 * 
		 * obizcode,opayway,ostatus,otime,opayplatform,ocount,oquantity1,oquantity2
		 * ,oconvertcode,opaymoney;
		 */

		String strSQL = "insert into ticketorders values(null, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?, ?,?)";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { uno, sno, obizcode, opayway, ostatus,
				otime, opayplatform, ocount, oquantity1, oquantity2,
				oconvertcode, opaymoney,oseats };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public Ticketorders selectById(int ono, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from ticketorders where ono=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { ono };
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanHandler对象
		BeanHandler<Ticketorders> ticketordersHandler = new BeanHandler<Ticketorders>(
				Ticketorders.class);
		// 执行查询操作
		Ticketorders order = queryRunner.query(connection, strSQL,
				ticketordersHandler, params);
		// 返回
		return order;
	}

	public List<Ticketorders> selectAll(QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from ticketorders order by ono";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		// 创建一个BeanListHandler对象
		BeanListHandler<Ticketorders> ticketorderslstHandler = new BeanListHandler<Ticketorders>(
				Ticketorders.class);
		// 执行查询操作
		List<Ticketorders> lstTicketorders = queryRunner.query(connection,
				strSQL, ticketorderslstHandler, params);
		// 返回
		return lstTicketorders;
	}

	public int update(Ticketorders order, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "update ticketorders set uno=?,sno=?,obizcode=?,opayway=?,ostatus=?,otime=?,opayplatform=?,ocount=?,oquantity1=?,oquantity2=?,oconvertcode=?,opaymoney=?,oseats=?  where ono=?";

		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { order.getUno(), order.getSno(),
				order.getObizcode(), order.getOpayway(), order.getOstatus(),
				order.getOtime(), order.getOpayplatform(), order.getOcount(),
				order.getOquantity1(), order.getOquantity2(),
				order.getOconvertcode(), order.getOpaymoney(),order.getOseats(), order.getOno() };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public int delete(int ono, QueryRunner queryRunner, Connection connection)
			throws SQLException {
		String strSQL = "delete from ticketorders where ono=?";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] { ono };
		Log.out(this.getClass().getSimpleName(), params);

		int affectedRows = queryRunner.update(connection, strSQL, params);
		return affectedRows;
	}

	public List<OrderItem> selectOrderAll(QueryRunner queryRunner,
			Connection connection) throws SQLException {
		String strSQL = "select * from ticketorders order by ono";
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		BeanListHandler<Ticketorders> ticketorderslstHandler = new BeanListHandler<Ticketorders>(
				Ticketorders.class);
		List<Ticketorders> lstTicketorders = queryRunner.query(connection,strSQL, ticketorderslstHandler, params);


		List<OrderItem> lstOrderItems=new ArrayList<OrderItem>();
		IUsersBiz usersBiz=new UsersBizImpl();
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		IMoviesBiz moviesBiz=new MoviesBizImpl();
		
		for (Ticketorders ticketorders : lstTicketorders) {
			//订单对象
			Ticketorders oOrder=new Ticketorders();
			oOrder=ticketorders;
			
			//用户对象
			Users oUser=new Users();
			oUser=usersBiz.findById(ticketorders.getUno());
			//电影放映对象
			Showmoive oShowmoive=new Showmoive();
			oShowmoive=showmovieBiz.findById(ticketorders.getSno());
			
			//电影院对象
			Theatres oTheatre=new Theatres();
			oTheatre=theatresBiz.findById(oShowmoive.getTno());
			//电影对象
			Movies oMovie=new Movies();
			oMovie=moviesBiz.findById(oShowmoive.getMno());
			
			OrderItem orderItem=new OrderItem(oOrder, oUser, oShowmoive, oTheatre, oMovie);
			lstOrderItems.add(orderItem);
		}
		
		return lstOrderItems;
	}

	public List<OrderItem> selectOrderByConditon(String strSQL,
			QueryRunner queryRunner, Connection connection) throws SQLException {
		Log.out(this.getClass().getSimpleName(), strSQL);
		Object[] params = new Object[] {};
		Log.out(this.getClass().getSimpleName(), params);

		BeanListHandler<Ticketorders> ticketorderslstHandler = new BeanListHandler<Ticketorders>(
				Ticketorders.class);
		List<Ticketorders> lstTicketorders = queryRunner.query(connection,strSQL, ticketorderslstHandler, params);


		List<OrderItem> lstOrderItems=new ArrayList<OrderItem>();
		IUsersBiz usersBiz=new UsersBizImpl();
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		IMoviesBiz moviesBiz=new MoviesBizImpl();
		
		for (Ticketorders ticketorders : lstTicketorders) {
			//订单对象
			Ticketorders oOrder=new Ticketorders();
			oOrder=ticketorders;
			
			//用户对象
			Users oUser=new Users();
			oUser=usersBiz.findById(ticketorders.getUno());
			//电影放映对象
			Showmoive oShowmoive=new Showmoive();
			oShowmoive=showmovieBiz.findById(ticketorders.getSno());
			
			//电影院对象
			Theatres oTheatre=new Theatres();
			oTheatre=theatresBiz.findById(oShowmoive.getTno());
			//电影对象
			Movies oMovie=new Movies();
			oMovie=moviesBiz.findById(oShowmoive.getMno());
			
			OrderItem orderItem=new OrderItem(oOrder, oUser, oShowmoive, oTheatre, oMovie);
			lstOrderItems.add(orderItem);
		}
		
		return lstOrderItems;
	}

	public PageBean selectByPage(String strSQLCount,String strSQL,int currentPage, int pageSize, QueryRunner queryRunner,
			Connection connection) throws SQLException {
		
		PageBean pageBean = new PageBean();

		Object[] params1 = new Object[] {  };
 
		PreparedStatement preparedStatement = connection.prepareStatement(strSQLCount);
		Log.out(this.getClass().getSimpleName(), strSQLCount);
		Log.out(this.getClass().getSimpleName(), params1);
		for (int i = 0; i < params1.length; i++) {
			preparedStatement.setObject(i+1, params1[i]);
		}
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			pageBean.setTotalRows(resultSet.getInt(1));
		}
			
	 
		
		// SELECT * FROM ticketorders s limit ?,?  从0开始
		// SELECT * FROM ticketorders where uno=3 limit 0,9
		Log.out(this.getClass().getSimpleName(), strSQL);

		int start = (currentPage - 1) * pageSize ;
		
		Object[] params = new Object[] {start,pageSize};
		Log.out(this.getClass().getSimpleName(), params);

		BeanListHandler<Ticketorders> ticketorderslstHandler = new BeanListHandler<Ticketorders>(
				Ticketorders.class);
		// strSql+  "limit ?,?"
		List<Ticketorders> lstTicketorders = queryRunner.query(connection,strSQL, ticketorderslstHandler, params);


		List<OrderItem> lstOrderItems=new ArrayList<OrderItem>();
		IUsersBiz usersBiz=new UsersBizImpl();
		IShowmovieBiz showmovieBiz=new ShowmovieBizImpl();
		ITheatresBiz theatresBiz=new TheatresBizImpl();
		IMoviesBiz moviesBiz=new MoviesBizImpl();
		
		for (Ticketorders ticketorders : lstTicketorders) {
			//订单对象
			Ticketorders oOrder=new Ticketorders();
			oOrder=ticketorders;
			
			//用户对象
			Users oUser=new Users();
			oUser=usersBiz.findById(ticketorders.getUno());
			//电影放映对象
			Showmoive oShowmoive=new Showmoive();
			oShowmoive=showmovieBiz.findById(ticketorders.getSno());
			
			//电影院对象
			Theatres oTheatre=new Theatres();
			oTheatre=theatresBiz.findById(oShowmoive.getTno());
			//电影对象
			Movies oMovie=new Movies();
			oMovie=moviesBiz.findById(oShowmoive.getMno());
			
			OrderItem orderItem=new OrderItem(oOrder, oUser, oShowmoive, oTheatre, oMovie);
			lstOrderItems.add(orderItem);
		}
		pageBean.setList(lstOrderItems);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		return pageBean;
	}

	 
}
