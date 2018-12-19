<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心_添加城市</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css" />
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css" />
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin.css" />
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" />
<link rel="stylesheet" type="text/css"
	href="/jee-moviesell/css/admin/admin_add.css" />

<script type="text/javascript" src="/jee-moviesell/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/admin/admin.js"></script>

<script type="text/javascript" src="/jee-moviesell/js/datepicker/WdatePicker.js"></script>

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
<%
	String[] citiesarr = {"北京","天津","上海","黑龙江","河北","重庆","山东",
		"内蒙古","浙江","广东","吉林","安徽","湖南","江苏","四川",
		"辽宁","山西","福建","贵州","海南","陕西","长春","湖北",
		"云南","甘肃","河南","江西","广西","大连","宁夏"};
	request.setAttribute("citiesarr", citiesarr);
%>

</head>

<body >
	<!--   网页头部 -->
	<div id="top" class="top">
	 	<c:if test="${!empty sessionScope.adminLogined}">  
		            <span class="link">&nbsp;&nbsp;&nbsp;&nbsp;<a href="/jee-moviesell/RemoveSessionServlet?admin=admin"  >注销登录</a></span> 
		            <span class="link">&nbsp;&nbsp;&nbsp;&nbsp;<a href="/jee-moviesell/jsp/admin/admin.jsp"  >管理中心</a></span> 
		            <span class="link">你好，[${sessionScope.adminLogined.aaccount }]</span> 
				 </c:if> 
				 <c:if test="${empty sessionScope.adminLogined}">
			 	<script>
			 		alert("您还未登陆");
			 		location='/jee-moviesell/jsp/admin/admin_login.jsp';
			 	</script>
		</c:if>
	
	
	
	</div>
	<div id="top_logo" class="top_logo">
		<div id="logo_div" class="logo_div">
			<img src="/jee-moviesell/pic/logo.png" width="251" height="59" id="logo"
				class="logo" style="margin-bottom: 11px;" /> <img
				src="/jee-moviesell/pic/20140912174327067135.jpg" id=" " class=" " />
		</div>
	</div>

	<div id="top_nav" class="top_nav"></div>
	<!--  网页头部结束 -->
	<div id="to_top" onClick="gotop(this);" onMouseOver="gotopover();"
		onMouseOut="gotopout()"></div>

	<!--网页主体  -->
	<div id="content" class="content">


		<div id="" class="content_main">

			<div id="" class="main_main">
				<div id="" class="main_left">
					<div id="" class="admin_img">
						<!-- 用户头像 -->
						<img src="/jee-moviesell/pic/admin/392945e641519b959d63dbf171ce.jpg"
							width="166" height="169">
					</div>

					<!--菜单部分  -->

					<div class="admin_menu" id="admin_menu">
						<div id="" class="admin_tit" onClick="adminmenuOnclick('dd1');"
							style="">用户管理</div>
						<ul id="dd1" class="admin_con" style="display: none;">
							<li><a href="/jee-moviesell/jsp/admin/admin.jsp" class="">查看所有用户</a></li>

						</ul>

						<div id="" class="admin_tit" onClick="adminmenuOnclick('dd2');"
							style="">订单管理</div>
						<ul id="dd2" class="admin_con" style="display: none;">
							<li><a href="/jee-moviesell/jsp/admin/admin_orders.jsp" class="">查看所有订单</a></li>

						</ul>
						<div id="" class="admin_tit" onClick="adminmenuOnclick('dd3');"
							style="">电影信息管理</div>
						<ul id="dd3" class="admin_con" style="display: none;">
							<li><a href="/jee-moviesell/jsp/admin/admin_showmovies.jsp" class="">查看所有电影</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addmovies.jsp" class="">添加电影</a></li>
						
							<li><a href="/jee-moviesell/jsp/admin/admin_showshowmoive.jsp" class="">查看电影放映信息</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addshowmoive.jsp" class="">添加电影放映信息 </a></li>
							
						</ul>
						<div id="" class="admin_tit" onClick="adminmenuOnclick('dd4');"
							style="">电影院管理</div>
						<ul id="dd4" class="admin_con" style="display: none;">
							<li><a href="/jee-moviesell/jsp/admin/admin_showtheatres.jsp" class="">查看所有电影院</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addtheatre.jsp" class="">添加电影院</a></li>
						</ul>
						<div id="admin_on" class="admin_tit"
							onClick="adminmenuOnclick('dd5');" style="">城市管理</div>
						<ul id="dd5" class=" admin_con" style="">
							<li><a href="/jee-moviesell/jsp/admin/admin_showcities.jsp" class="">查看所有城市</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addcity.jsp" class="o_on">添加城市</a></li>

						</ul>

					</div>

					<!--菜单部分  -->
				</div>
				<!--左部分结束  -->
				<!--右部分  -->
				<div id="content_right" class="content_right">
					<div id="main_tit" class="main_tit">管理中心</div>

					<div id="main_tit2" class="main_tit2">
						<img src="/jee-moviesell/pic/admin/arrow.png" width="14" height="17">添加城市
					</div>
					<p>请输入城市的详细信息</p>
					
					<script type="text/javascript">
					
						function addCityCkeck(){
							
							var cname=document.getElementById('cname').value;
							if(cname==""||cname.length==0){
								alert("城市名称不能为空！");
								return false;
							}
							return true;
							
						}
					</script> 

					<div id="main_main" class="main_main">

						<div id="addmovie" class="addmovie">
							<form id="loginform" name="loginform" action="/jee-moviesell/AddCitiesServlet" method="post" onsubmit="return addCityCkeck();">
								<table id="addmovie_tab">
									<tr>
										<td class="tab_left">&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td class="tab_left">城市名称：</td>
										<td><input type="text" class="" name="cname" id="cname" /></td>
										<td><span id="msg" style="font-size: 12px;"></span></td>
									</tr>
									<tr>
										<td class="tab_left">&nbsp;</td>
										<td>&nbsp;</td>
										<td style="font-size: 12px;"></td>
									</tr>

									<tr>
										<td class="tab_left">城市所在省份：</td>
										<td><select name="cprovince" id="" class="">
												<c:forEach items="${citiesarr }" var="city">
													<option value="${city }">${city }</option>


												</c:forEach>
										</select></td>
										<td style="font-size: 12px;"></td>
									</tr>
									<tr>
										<td class="tab_left">&nbsp;</td>
										<td>&nbsp;</td>
										<td style="font-size: 12px;"></td>
									</tr>

								</table>
								<div
									style="text-align: center; height: 85px; padding-top: 20px;">
									<input type="submit" value="确定 添加" id="enrollsubmit"
										style="background: #5DB6E0; text-shadow: none; border: 0; font-size: 18px; height: 37px; color: #fff; width: 95px;" />
								</div>


							</form>
						</div>
						<!--提示  -->
						
						<c:if test="${!empty requestScope.addcityflag}">
							<div class="addcityflag" id="addcityflag">
							<%
								out.print("<script>alert('"+request.getAttribute("addcityflag")+"');</script>");
							%>
							</div>
						</c:if> 
						
					</div>
				</div>
				<!--右部分 结束 -->

			</div>
		</div>

	</div>
	<!--网页主体 结束 -->


	<!--  网页尾部  -->
	<div id="footer" class="footer"></div>

	<!--  网页尾部结束  -->
	<script>
		attachUserMenu(admin_menu);
	</script>

</body>
</html>