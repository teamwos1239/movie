package com.chinasoft.moviesell.domain.gai;


import com.chinasoft.moviesell.domain.Movies;
import com.chinasoft.moviesell.domain.Showmoive;
import com.chinasoft.moviesell.domain.Theatres;
import com.chinasoft.moviesell.domain.Ticketorders;
import com.chinasoft.moviesell.domain.Users;

public class OrderItem{
 	
	//订单对象
	private Ticketorders oOrder;
	//用户对象
	private Users oUser;
	//电影放映对象
	private Showmoive oShowmoive;
	//电影院对象
	private Theatres oTheatre;
	//电影对象
	private Movies oMovie;
	public Ticketorders getoOrder() {
		return oOrder;
	}
	public void setoOrder(Ticketorders oOrder) {
		this.oOrder = oOrder;
	}
	public Users getoUser() {
		return oUser;
	}
	public void setoUser(Users oUser) {
		this.oUser = oUser;
	}
	public Showmoive getoShowmoive() {
		return oShowmoive;
	}
	public void setoShowmoive(Showmoive oShowmoive) {
		this.oShowmoive = oShowmoive;
	}
	public Theatres getoTheatre() {
		return oTheatre;
	}
	public void setoTheatre(Theatres oTheatre) {
		this.oTheatre = oTheatre;
	}
	public Movies getoMovie() {
		return oMovie;
	}
	public void setoMovie(Movies oMovie) {
		this.oMovie = oMovie;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(Ticketorders oOrder, Users oUser, Showmoive oShowmoive,
			Theatres oTheatre, Movies oMovie) {
		super();
		this.oOrder = oOrder;
		this.oUser = oUser;
		this.oShowmoive = oShowmoive;
		this.oTheatre = oTheatre;
		this.oMovie = oMovie;
	}
	@Override
	public String toString() {
		return "OrderItem [oOrder=" + oOrder + ", oUser=" + oUser
				+ ", oShowmoive=" + oShowmoive + ", oTheatre=" + oTheatre
				+ ", oMovie=" + oMovie + "]";
	}
	
	
	
	
	
}
