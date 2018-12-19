package com.tarena.day05;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDemo {

	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("该下课啦");
			}
		}, 10000);
		
		//当前时间的毫秒值
		long time=System.currentTimeMillis();
		long year=time/1000/60/60/24/365+1970;
		System.out.println(year);
		
		//Java提供API封装了时间的算法
		Date date=new Date();//包装了当前时间
		System.out.println(date.getYear()+1900);
		//Date表示年是用两位数表示(年后两位)，默认是20世纪
		
		
		//Date有千年虫问题，Java后来做了一个类Calendar
		//来代替了Date
		
		//Calendar不仅解决了千年虫问题，还封装了各种历法
		//但是历法我们用默认的葛里高历
		Calendar cal=Calendar.getInstance();
		//Calendar cal=new GregorianCalendar();
		int y=cal.get(Calendar.YEAR);
		System.out.println(y);
		
		cal.set(Calendar.YEAR,2012);
		System.out.println(cal.get(Calendar.YEAR));
		
		long now =42342354325L;
		Date nowDate=new Date();
		nowDate.setTime(now);
		Calendar calNow=Calendar.getInstance();
		calNow.setTime(nowDate);
		
		
		Calendar tommrowCal=Calendar.getInstance();
		int today=tommrowCal.get(Calendar.DAY_OF_MONTH);
		tommrowCal.set(Calendar.DAY_OF_MONTH, today+1);
		Date tommrowDate=tommrowCal.getTime();
		long tommrowLong=tommrowDate.getTime();
		
		
		//字符串和Date之间转换
		//用到一个类DateFormat 一般用SimpleDateFormat
		//按照一定格式将字符串和时间date相互转换
		SimpleDateFormat sdf=
			new SimpleDateFormat("yy年MM月dd日");
		String tommrowString=sdf.format(tommrowDate);
		System.out.println(tommrowString);
		String str="12年12月24日";
		try {
			System.out.println(sdf.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	
	
}
