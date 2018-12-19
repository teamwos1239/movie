<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.chinasoft.moviesell.domain.gai.ShowmoiveItem"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选择座位</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_footer.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/chooseseat_main.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/footer_linkarea.css"/>
<script type="text/javascript" src="/jee-moviesell/js/index/top_nav.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/footer_linkarea.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/main_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 
 
 <script type="text/javascript" src="/jee-moviesell/js/seatchoose.js"></script> 
<script type="text/javascript" >

function gotop() {
	document.documentElement.scrollTop = document.body.scrollTop = 0;
	
}
function gotopover(){
	
	document.getElementById('to_top').style.backgroundColor='#5DB6E0'; 
}
	
function gotopout(){
	document.getElementById('to_top').style.backgroundColor='#666'; 
}
	

</script>
</head>
<c:if test="${sessionScope.logineduser==null||empty sessionScope.logineduser}">

	<script>
		location="/jee-moviesell/jsp/login.jsp";
	</script>
</c:if>
<c:if test="${sessionScope.selectedCity==null||empty sessionScope.selectedCity}">
		<%session.setAttribute("selectedCity", 1); %>
</c:if>
<body >
<!--   网页头部 -->
<div id="top" class="top">
	<div id="top_1" class="top_1">
		
        <div id="top_link" class="top_link"> 
        	<div id="top_city" class="top_city">
        	
        		<!--城市选择  --> 
        		城市
        		<%
					String[] citiesarr = {"北京", "天津", "重庆", "上海", "河北", "山东", "河南",
							"浙江", "辽宁", "内蒙古", "宁夏", "山西", "陕西", "广东", "海南", "福建",
							"青海", "四川", "云南", "吉林", "黑龙江", "新疆"};
					request.setAttribute("citiesarr", citiesarr);
					String pagePath=request.getServletPath().substring(1);
					request.setAttribute("pagePath",pagePath);
				%>
				<script type="text/javascript" charset="utf-8">
					function findProHelp(pagePath,proname){
						url="/jee-moviesell/SaveProSelectedServlet?pagePath="+pagePath+"&&proname="+proname;
						location=url;
					}
				</script>
        		
				<select id="select_pro" class="select_pro" onchange="findProHelp('${pagePath }',this.value);"> 
					<c:forEach items="${applicationScope.citiesarr}" var="province" varStatus="i">
						<c:if test="${sessionScope.selectedPro==province}">
							<option value="${province}" onclick="" selected="selected" >${province}</option>					
	       				</c:if>
	       				<c:if test="${sessionScope.selectedPro!=province}">
							<option value="${province}" onclick="" >${province}</option>					
	       				</c:if>
					</c:forEach>
				</select>
        		
        		
				<script type="text/javascript">
					function findCityHelp(pagePath,cno){
						location="/jee-moviesell/SaveCityHelperServlet?pagePath="+pagePath+"&&cno="+cno+"";
					}
				</script>
				
				<select id="select_city" class="select_city" name="" onchange="findCityHelp('${pagePath }',this.value);"> 
					<c:forEach items="${sessionScope.lstSetCities }" var="city" varStatus="i">
						
        				<c:if test="${sessionScope.selectedCity==city.cno}">
							<option value="${city.cno}" onclick="" selected="selected" >${city.cname }</option> 	
        				</c:if>
        				<c:if test="${sessionScope.selectedCity!=city.cno}">
							<option value="${city.cno}" onclick="" >${city.cname }</option>					
        				</c:if>
					</c:forEach>
				</select>
        	  	<!--城市选择  -->
				
			</div>
           	<span id="link1" class="link"><a href="/jee-moviesell/jsp/helper/helper_howtobuy.jsp" style="color:#999;text-decoration:none;">帮助中心</a></span> 
            <span id="link-1" class="link">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
            <span id="link2" class="link"><a href="/jee-moviesell/jsp/users/user_order.jsp" style="color:#999;text-decoration:none;">我的订单</a></span>
            <span id="link-2" class="link">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
			<c:if test="${sessionScope.logineduser==null||empty sessionScope.logineduser}">
           	 	<span id="link3" class="link"><a href="/jee-moviesell/jsp/enroll.jsp" style="color:#999;text-decoration:none;">注册</a></span> 
            	<span id="link-2" class="link">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
            	<span id="link3" class="link"><a href="/jee-moviesell/jsp/login.jsp" style="color:#999;text-decoration:none;">登录</a></span>  
			</c:if>
			
			<c:if test="${!empty sessionScope.logineduser}">
				
	            <span id="link3" class="link">&nbsp;&nbsp;&nbsp;&nbsp;<a href="/jee-moviesell/RemoveSessionServlet" style="color:#999;text-decoration:none;">注销登录</a></span> 
	            <span id="link3" class="link">&nbsp;&nbsp;&nbsp;&nbsp;<a href="/jee-moviesell/jsp/users/users.jsp" style="color:#999;text-decoration:none;">用户中心</a></span> 
	            <span id="link3" class="link">你好，[${sessionScope.logineduser.uemail }]</span> 
			</c:if>

		</div>
	</div>
    <br />
</div>
<div id="top_logo" class="top_logo"> 
    <div id="logo_div" class="logo_div">	
    	<img src="/jee-moviesell/pic/logo.png" width="251" height="59" id="logo" class="logo" style="margin-bottom: 11px;"/>
    	<img src="/jee-moviesell/pic/20140912174327067135.jpg"  id=" " class=" "/>
     </div>
</div>   

<div id="top_nav" class="top_nav"> 

	<ul id="nav_ul" class="nav_ul">
		<li><a href="/jee-moviesell/jsp/index.jsp"  >电影首页</a></li>
		<li><a href="javascript:location='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno=${sessionScope.selectedCity}';" >电影排期</a></li>
		<li><a href="#" >移动购票</a></li>
		<li><a href="#" >电影谈资</a></li>
	</ul>
	<ul id="nav_ul2" class="nav_ul">
		<li style="width: 34px;">&nbsp;</li>
		<li><a><img src="/jee-moviesell/pic/index/IMAX.png" width="130" height="54" class=" "  id=" " alt="IMAX" onclick="javascript:void(0);" style="cursor: pointer;" />   </a></li>
		<li style="width: 34px;">&nbsp;</li>
		<li><a><img src="/jee-moviesell/pic/index/hdcx-btn.png" width="174" height="43" class=" "  id=" " onclick="javascript:void(0);" style="cursor: pointer;" /></a></li>
	</ul>
</div>
<!--  网页头部结束 --> 
<div id="to_top" onclick="gotop(this);" onmouseover="gotopover();" onmouseout="gotopout()"></div>

<!--网页主体  -->
<div id="content" class="content" >
	<br />
	 <div id="content_nav" class="content_nav">
	 	<a id="" href="javascript:location='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno=${sessionScope.selectedCity}';"  class="nav_off">① 选择影片场次  &#62;&#62;</a>
	 	<span id=""   class="nav_on">② 选择座位、卖品  &#62;&#62;</span>
	 	<span id=""   class="nav_off" >③ 确认订单并支付 &#62;&#62;</span>
	 	<span id=""   class="nav_off">④ 购票成功</span>
	 </div>
	 <br />
	 <br />
	 <div id="content_main" class="content_main">
		<div id="main_msg" class="main_msg">
			<span class="msg_tit">选择座位</span>
			<span class="msg_con">
			${requestScope.sellShowmoiveItem.stname }	,
			${requestScope.sellShowmoiveItem.smname }
			(${requestScope.sellShowmoiveItem.smversion }),
			 <%!String allDay; %>
			 <%!String allTime; %>
			 <%!Calendar nowTime=Calendar.getInstance(); %>
			 <%!Calendar stime=Calendar.getInstance(); %>
			 <%
				if(request.getAttribute("sellShowmoiveItem")!=null){
					SimpleDateFormat dateFormat=new SimpleDateFormat("MM月dd日",Locale.CHINA);
					SimpleDateFormat dateFormat2=new SimpleDateFormat("HH:mm",Locale.CHINA);
					
					nowTime.setTime(new Date());
					ShowmoiveItem showmoiveItem=(ShowmoiveItem)(request.getAttribute("sellShowmoiveItem"));
				  	stime.setTime(showmoiveItem.getStime());
				  	allTime=dateFormat2.format(stime.getTime());
				  	int nday=nowTime.get(Calendar.DAY_OF_MONTH);// 天
				  	int sday=stime.get(Calendar.DAY_OF_MONTH);
				  	int nmonth=nowTime.get(Calendar.MONTH);//月
				  	int smonth=stime.get(Calendar.MONTH);
				  	int nhour=nowTime.get(Calendar.HOUR_OF_DAY);//时
				  	int shour=stime.get(Calendar.HOUR_OF_DAY);
				  	int nminute=nowTime.get(Calendar.MINUTE);//分
				  	int sminute=stime.get(Calendar.MINUTE);
				  	
				  	if(nday==sday){
				  		//同一天
				  		allDay="今天";
				  	}else{
				  		//不同一天	
				  		if((nmonth+1)==smonth){
				  			//今天的下个月
				  			if(sday==1){
					  			//今天的下个月第一天
					  			allDay="明天";
				  				
				  			}else if(sday==2){
					  			//今天的下个月第二天
					  			allDay="预售"+dateFormat.format(stime.getTime());
				  			}
				  		}else{
				  			//同一个月
					  		if(nday==(sday-1)){
					  			//第二天
					  			allDay="明天";
					  		}else if(nday==(sday-2)){
					  			//第三天
					  			allDay="预售"+dateFormat.format(stime.getTime());
					  		}
				  		
				  		}
				  	}
				}
			  
			%>
			
			
			<%=allDay %>			
			,
			<%=allTime %>点,
			${requestScope.sellShowmoiveItem.shallno }号厅
			
			</span>
		</div>
		<div id="main_seats" class="main_seats">		 	
			<div id="" class="seat_tip">
				<span id="" class="">
					<img src="/jee-moviesell/pic/chooseseats/sit_div_img.jpg" width="26" height="26" />可选的座位
				</span>
				<span id="" class="">
					<img src="/jee-moviesell/pic/chooseseats/sit_div_img2.jpg" width="26" height="26" />已售出的座位
				</span>
				<span id="" class="">
					<img src="/jee-moviesell/pic/chooseseats/sit_div_img3.jpg" width="26" height="26" />您选择的座位
				</span>
			</div>
			<div id="" class="yinmu" style="text-align: center;">
				<img src="/jee-moviesell/pic/chooseseats/sit_div (1).jpg" width="900" height="60" />
			</div>
		
		</div>
		<div id="" class="seats_s">
		
				<c:forEach items="${requestScope.lstSeat}" var="seats" varStatus="i">
				<!--  -->
					<div class="seat_row">${i.count }</div>
					<c:forEach items="${seats}" var="seatFlag" varStatus="j">
					 	<div class="seat_item">
							<c:if test="${seatFlag==0}">
								<div class="seat_img0">
								</div> 
							</c:if>
							<c:if test="${seatFlag==1}">
								<div class="seat_img1">
								</div>${j.count}
							</c:if>
							<c:if test="${seatFlag==2}">
								<div class="seat_img" id="seat_${i.count }_${j.count}" onclick="seatclick(this.id,${i.count },${j.count});" >
								</div>${j.count}
							</c:if>
						</div>
					</c:forEach>	
					<div class="seat_row">${i.count }</div>
				<!--  -->
				</c:forEach>
				
				
				
		</div>
 		<div id="" class="seat_rebtn">
 			<button onclick="javascript:location.reload();">重新选座</button>
 		</div>
		<div id="msgs" class="msgs">
			
		</div>
		<input id="seatCount" name="" type="hidden" value="0"/>
		<div id="products" class="products">
			<div id="products_tit" class="products_tit">
				选择卖品
				<br />
			</div>			
			<div id="products_main" class="products_main">
				<div id="products_item1" class="products_item">
					<img src="/jee-moviesell/pic/chooseseats/20140430144712443267.jpg" width="100" height="100" style="float:left;" />
					<div id="" class="products_txt">
						<div class=""  style="font-size: 14px;color: black;height: 24px;line-height: 25px;">阿尔山双人套餐</div>
						<div class="" style="font-size: 12px;color: #EC5C27;height: 43px;line-height: 41px;">网购价：29.00元</div>
						<div class="" style="font-size: 14px;height: 24px;line-height: 25px;">
							购买：
								<button onclick="productjian('oquantity1');">-</button>
								<input id="oquantity1" type="text" name="oquantity1" value="0" id="pro1"/>
								<button onclick="productjia('oquantity1');">+</button>
						</div>
					</div>
				</div>
				<div id="products_item2" class="products_item">
					<img src="/jee-moviesell/pic/chooseseats/20140430144712443267.jpg" width="100" height="100" style="float:left;" />
					<div id="" class="products_txt">
						<div class=""  style="font-size: 14px;color: black;height: 24px;line-height: 25px;">阿尔山双人套餐</div>
						<div class="" style="font-size: 12px;color: #EC5C27;height: 43px;line-height: 41px;">网购价：29.00元</div>
						<div class="" style="font-size: 14px;height: 24px;line-height: 25px;">
							购买：
								<button onclick="productjian('oquantity2');">-</button>
								<input id="oquantity2" type="text" name="oquantity2" value="0" id="pro2"/>
								<button onclick="productjia('oquantity2');">+</button>
						</div>
					</div>
				</div>
					
			</div>			
		 
		</div>
		<!-- product区结束 -->
		
		<div id="" class="main_submit">
			<button onclick="javascript:sub(${requestScope.sellShowmoiveItem.sno});">下一步</button>
		</div>
	
	</div>
		
</div>
<!--网页主体 结束 -->

<!-- 下部链接 -->
<div id="footer_linkarea" class="footer_linkarea">
 <table width="995" id="footer_tab" class="footer_tab" >
      <tr>
        <td width="98" rowspan="3"><img src="/jee-moviesell/pic/footer/footer_1.png" title="投诉建议" width="98" height="149" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_2.png" title="在线客服" width="188" height="42" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_3.png" title="客服热线：400-800-6060" width="201" height="40"  /></td>
        <td width="249"><img src="/jee-moviesell/pic/footer/footer_4.png" title="万达生活" width="249" height="41" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td width="253" rowspan="3"><img src="/jee-moviesell/pic/footer/footer_11.png" title="二维码" width="253" height="151" /></td>
      </tr>
      <tr>
        <td><img src="/jee-moviesell/pic/footer/footer_5.png" title="兑换码使用帮助" width="187" height="44" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_6.png" title="IMAX" width="196" height="41" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td rowspan="2"><img src="/jee-moviesell/pic/footer/footer_10.png" title="万达观影指数" width="249" height="103" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
      </tr>
      <tr>
        <td colspan="2"><img src="/jee-moviesell/pic/footer/footer_7.png" title="购票流程" width="126" height="48" style="cursor: pointer;" onclick="javascript:location='/jee-moviesell/jsp/helper/helper_howtobuy.jsp';" />&nbsp;&nbsp;<img src="/jee-moviesell/pic/footer/footer_8.png" title="取票流程" width="125" height="49" style="cursor: pointer;" onclick="javascript:void(0);" />&nbsp;<img src="/jee-moviesell/pic/footer/footer_9.png" title="退票流程" width="127" height="49" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
      </tr>
    </table>
</div>
<!--  下部链接结束-->







<!--  网页尾部  -->
<div id="footer" class="footer"> 
  <div id="footer_nav" class="footer_nav"> 
	   <span id="footer_link" class="footer_link"> 
       	<span id="footer_link_left" class="footer_link_left"><a href="#">联系我们</a>  │   <a href="#">电影情报 </a> │   <a href="#">友情链接</a></span> 
       	<span id="footer_link_right" class="footer_link_right"><a href="#"> 万达集团  </a>  │   <a href="#">万达院线官网 </a> </span>
       
       </span>
  </div>
	
	<div id="footer_info" class="footer_info" >
  	&nbsp;&nbsp;&nbsp;&nbsp;Copyright © 2011-2013 Wandafilm.com ALL rights reserved     冀ICP备13013593     增值电信业务经营许可证B2-20130186
    <img src="/jee-moviesell/pic/cnnic.png" width="51" height="20"  style="cursor:pointer;" onclick="javascript:void(0);"/>
    <img src="/jee-moviesell/pic/cert.png" width="51" height="20"  style="cursor:pointer;" onclick="javascript:void(0);"/>
    </div>
</div>

<!--  网页尾部结束  -->
 
<script>
	
		function imgover(ul_content_msg){ 
			 
			document.getElementById(ul_content_msg).style.display="block";  
				
		}
		
		function imgout(ul_content_msg){
			document.getElementById(ul_content_msg).style.display="none";
			//document.getElementById("sh1").style="display:none";
			
			
		}
    
	</script>
<script>attachXMenu(nav_ul);</script>
<script>attachFooter(footer_tab);</script>

</body>
</html>