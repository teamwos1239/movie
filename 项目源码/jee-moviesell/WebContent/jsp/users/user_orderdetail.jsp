<%@page import="com.chinasoft.moviesell.domain.Ticketorders"%>
<%@page import="com.chinasofti.moviesell.biz.impl.TicketordersBizImpl"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户中心_订单详情</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_footer.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/order_main.css" />
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/footer_linkarea.css" />
<script type="text/javascript" src="/jee-moviesell/js/index/top_nav.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/footer_linkarea.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/main_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" />

<script type="text/javascript">
	function gotop() {
		document.documentElement.scrollTop = document.body.scrollTop = 0;

	}
	function gotopover() {

		document.getElementById('to_top').style.backgroundColor = '#5DB6E0';
	}

	function gotopout() {
		document.getElementById('to_top').style.backgroundColor = '#666';
	}
</script>
</head>
<c:if test="${sessionScope.logineduser==null||empty sessionScope.logineduser}">

	<script>
		location="/jee-moviesell/jsp/login.jsp";
	</script>
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
			<img src="/jee-moviesell/pic/logo.png" width="251" height="59" id="logo"
				class="logo" style="margin-bottom: 11px;" /> <img
				src="/jee-moviesell/pic/20140912174327067135.jpg" id=" " class=" " />
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
			<li><a><img src="/jee-moviesell/pic/index/IMAX.png" width="130"
					height="54" class=" " id=" " alt="IMAX"
					onclick="javascript:void(0);" style="cursor: pointer;" /> </a></li>
			<li style="width: 34px;">&nbsp;</li>
			<li><a><img src="/jee-moviesell/pic/index/hdcx-btn.png" width="174"
					height="43" class=" " id=" " onclick="javascript:void(0);"
					style="cursor: pointer;" /></a></li>
		</ul>
	</div>
	<!--  网页头部结束 -->
	<div id="to_top" onclick="gotop(this);" onmouseover="gotopover();"
		onmouseout="gotopout()"></div>

	<!--网页主体  -->
	<div id="content" class="content">
		<div id="content_main" class="content_main">
			<table>
			<tr>
						<td colspan="3" class="tab_tit">订单详情</td>
					</tr>
					<tr>
					  	<td rowspan="12" class="rowimg">
						  <img src="/jee-moviesell/pic/pictures/${requestScope.picPath}/poster.jpg" width="174" height="232" />
						</td>
						<td class="row1">影片名称：</td>
						<td class="row2">${requestScope.orderShowmoiveItem.smname}</td>
					</tr>
					<tr>
					  <td class="row1">播放时间：</td>
						<td class="row2">${requestScope.orderShowmoiveItem.stime}</td>
					</tr>
					<tr>
					  <td class="row1">版本：</td>
						<td class="row2">${requestScope.orderShowmoiveItem.smversion}</td>
					</tr>
					<tr>
					  <td class="row1">时长：</td>
						<td class="row2">${requestScope.orderShowmoiveItem.smlength}分钟</td>
					</tr>
					<tr class="order_theatre">
					  <td class="row1">播放电影院：</td>
						<td class="row2"><a  href="javascript:location='/jee-moviesell/HelperFindTheatreServlet?tno=${requestScope.orderShowmoiveItem.tno}';">${requestScope.orderShowmoiveItem.stname}</a></td>
					</tr>
					<tr>
					  <td class="row1">厅：</td>
						<td class="row2">${requestScope.orderShowmoiveItem.shallno}号厅</td>
					</tr>
					<tr class="order_seates">
					  <td class="row1">座位：</td>
						<td class="row2">
						
						<%
							Ticketorders order=(Ticketorders)session.getAttribute("createOrder");
							//2-3,9-10
							String oseats=order.getOseats();
							//2-3 9-10
							String[] seatArr=oseats.split(",");
							for(String str:seatArr){
								String[] ij=str.split("-");
								String i=ij[0];
								String j=ij[1];
								
								out.print("<button value="+str+">第"+i+"排 第"+j+"座</button>");
							}
						%> 
						</td>
					</tr>
					<tr>
					  <td class="row1">购买电影票数量：</td>
						<td class="row2">${sessionScope.createOrder.ocount}张</td>
					</tr>
					<tr>
					  <td class="row1">电影票价格：</td>
						<td class="row2">${requestScope.orderShowmoiveItem.sprice}元</td>
					</tr>
					<tr>
					  <td class="row1">冰霜双人套餐的购买数量:</td>
						<td class="row2">${sessionScope.createOrder.oquantity1}份</td>
					</tr>
					<tr>
					  <td class="row1">阿尔山双人套餐的购买数量：</td>
						<td class="row2">${sessionScope.createOrder.oquantity2}份</td>
					</tr>
					<tr>
					  <td class="row1">总支付金额：</td>
						<td class="row2">
							${requestScope.orderShowmoiveItem.sprice}*${sessionScope.createOrder.ocount}+
							29*${sessionScope.createOrder.oquantity1}+29*${sessionScope.createOrder.oquantity2}=
						    ${sessionScope.createOrder.opaymoney}元</td>
					</tr>
					<tr>
					  <td class=""></td>
					  <td class="row1">兑换码：</td>
						<td class="row2">
						    ${sessionScope.createOrder.oconvertcode}</td>
					</tr>
				</table>
				<div id="" class="main_submitbtn">
			  		<button onclick="javascript:location='/jee-moviesell/jsp/users/user_order.jsp'">返回 我的订单</button>
				</div>

		</div>


	</div>


	<!--网页主体 结束 -->


	<!-- 下部链接 -->
	<div id="footer_linkarea" class="footer_linkarea">
		<table width="995" id="footer_tab" class="footer_tab">
			<tr>
				<td width="98" rowspan="3"><img
					src="/jee-moviesell/pic/footer/footer_1.png" title="投诉建议" width="98"
					height="149" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
				<td><img src="/jee-moviesell/pic/footer/footer_2.png" title="在线客服"
					width="188" height="42" style="cursor: pointer;"
					onclick="javascript:void(0);" /></td>
				<td><img src="/jee-moviesell/pic/footer/footer_3.png"
					title="客服热线：400-800-6060" width="201" height="40" /></td>
				<td width="249"><img src="/jee-moviesell/pic/footer/footer_4.png"
					title="万达生活" width="249" height="41" style="cursor: pointer;"
					onclick="javascript:void(0);" /></td>
				<td width="253" rowspan="3"><img
					src="/jee-moviesell/pic/footer/footer_11.png" title="二维码" width="253"
					height="151" /></td>
			</tr>
			<tr>
				<td><img src="/jee-moviesell/pic/footer/footer_5.png" title="兑换码使用帮助"
					width="187" height="44" style="cursor: pointer;"
					onclick="javascript:void(0);" /></td>
				<td><img src="/jee-moviesell/pic/footer/footer_6.png" title="IMAX"
					width="196" height="41" style="cursor: pointer;"
					onclick="javascript:void(0);" /></td>
				<td rowspan="2"><img src="/jee-moviesell/pic/footer/footer_10.png"
					title="万达观影指数" width="249" height="103" style="cursor: pointer;"
					onclick="javascript:void(0);" /></td>
			</tr>
			<tr>
				<td colspan="2"><img src="/jee-moviesell/pic/footer/footer_7.png"
					title="购票流程" width="126" height="48" style="cursor: pointer;"
					onclick="javascript:location='/jee-moviesell/jsp/helper/helper_howtobuy.jsp';" />&nbsp;&nbsp;<img
					src="/jee-moviesell/pic/footer/footer_8.png" title="取票流程" width="125"
					height="49" style="cursor: pointer;" onclick="javascript:void(0);" />&nbsp;<img
					src="/jee-moviesell/pic/footer/footer_9.png" title="退票流程" width="127"
					height="49" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
			</tr>
		</table>
	</div>
	<!--  下部链接结束-->



	<!--  网页尾部  -->
	<div id="footer" class="footer">
		<div id="footer_nav" class="footer_nav">
			<span id="footer_link" class="footer_link"> <span
				id="footer_link_left" class="footer_link_left"><a href="#">联系我们</a>
					│ <a href="#">电影情报 </a> │ <a href="#">友情链接</a></span> <span
				id="footer_link_right" class="footer_link_right"><a href="#">
						万达集团 </a> │ <a href="#">万达院线官网 </a> </span>

			</span>
		</div>

		<div id="footer_info" class="footer_info">
			&nbsp;&nbsp;&nbsp;&nbsp;Copyright © 2011-2013 Wandafilm.com ALL
			rights reserved 冀ICP备13013593 增值电信业务经营许可证B2-20130186 <img
				src="/jee-moviesell/pic/cnnic.png" width="51" height="20"
				style="cursor: pointer;" onclick="javascript:void(0);" /> <img
				src="/jee-moviesell/pic/cert.png" width="51" height="20"
				style="cursor: pointer;" onclick="javascript:void(0);" />
		</div>
	</div>

	<!--  网页尾部结束  -->

	<script>
		function imgover(ul_content_msg) {

			document.getElementById(ul_content_msg).style.display = "block";

		}

		function imgout(ul_content_msg) {
			document.getElementById(ul_content_msg).style.display = "none";
			//document.getElementById("sh1").style="display:none";

		}
	</script>
	<script>
		attachXMenu(nav_ul);
	</script>
	<script>
		attachFooter(footer_tab);
	</script>
			
	<script type="text/javascript" src="/jee-moviesell/js/seatchoose.js"></script>
</body>
</html>