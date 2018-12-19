<%@page import="java.util.Date"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心_添加电影放映信息</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin_add.css" /> 

<script type="text/javascript" src="/jee-moviesell/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/admin/admin.js"></script>

<script type="text/javascript" src="/jee-moviesell/js/admin/admin_showmoive.js"></script>
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
 
<c:if test="${empty requestScope.findlstMovie || empty requestScope.findlstMovie }">
 <script>
 
 	location="/jee-moviesell/FindAllTheatreMoviesServlet";
 </script>


</c:if>   


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
    	<img src="/jee-moviesell/pic/logo.png" width="251" height="59" id="logo" class="logo" style="margin-bottom: 11px;"/>
    	<img src="/jee-moviesell/pic/20140912174327067135.jpg"  id=" " class=" "/>
     </div>
</div>   

<div id="top_nav" class="top_nav"> 
</div>
<!--  网页头部结束 --> 
<div id="to_top" onClick="gotop(this);" onMouseOver="gotopover();" onMouseOut="gotopout()"></div>

<!--网页主体  -->
<div id="content" class="content" >
	
	 
	<div id="" class="content_main">
		 
		<div id="" class="main_main">
			<div id="" class="main_left">
				<div id="" class="admin_img">
				  <!-- 用户头像 -->
        				<img src="/jee-moviesell/pic/admin/392945e641519b959d63dbf171ce.jpg" width="166" height="169">
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
						<div id="admin_on" class="admin_tit" onClick="adminmenuOnclick('dd3');"
							style="">电影信息管理</div>
						<ul id="dd3" class="admin_con" style="">
							<li><a href="/jee-moviesell/jsp/admin/admin_showmovies.jsp" class="">查看所有电影</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addmovies.jsp" class="">添加电影</a></li>
						
							<li><a href="/jee-moviesell/jsp/admin/admin_showshowmoive.jsp" class="">查看电影放映信息</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addshowmoive.jsp" class="o_on">添加电影放映信息 </a></li>
							
						</ul>
						<div id="" class="admin_tit" onClick="adminmenuOnclick('dd4');"
							style="">电影院管理</div>
						<ul id="dd4" class="admin_con" style="display: none;">
							<li><a href="/jee-moviesell/jsp/admin/admin_showtheatres.jsp" class="">查看所有电影院</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addtheatre.jsp" class="">添加电影院</a></li>
						</ul>
						<div id="" class="admin_tit"
							onClick="adminmenuOnclick('dd5');" style="">城市管理</div>
						<ul id="dd5" class=" admin_con" style="display: none;">
							<li><a href="/jee-moviesell/jsp/admin/admin_showcities.jsp" class="">查看所有城市</a></li>
							<li><a href="/jee-moviesell/jsp/admin/admin_addcity.jsp" class="">添加城市</a></li>

						</ul>

					</div>
				
				<!--菜单部分  -->
			</div>
			<!--左部分结束  -->
			<!--右部分  -->
			<div id="content_right" class="content_right">
				<div id="main_tit" class="main_tit">
					管理中心
				</div>				
			
				<div id="main_tit2" class="main_tit2">
				  <img src="/jee-moviesell/pic/admin/arrow.png" width="14" height="17">添加电影放映信息
				</div>				
				<p>请输入电影的详细放映信息</p>
			
				<div id="main_main" class="main_main">
				 	<div id="addmovie" class="addmovie">
				 
					 
						<script type="text/javascript" charset="utf-8">
							function findProHelp(pagePath,proname){
								url="/jee-moviesell/SaveProSelectedServlet?pagePath="+pagePath+"&&proname="+proname;
								location=url;
							}
						</script>
						<script type="text/javascript">
							function findCityHelp(pagePath,cno){
								location="/jee-moviesell/SaveCityHelperServlet?pagePath="+pagePath+"&&cno="+cno+"";
							}
						</script>
				 
				 	<form id="loginform" name="loginform" action="/jee-moviesell/AddShowmoiveServlet" method="post" onsubmit="return checkSub();">
			            <table id="addmovie_tab">
			                <tr>
			                    <td class="tab_left">电影院：</td>
			                    <td>
			                     	<%
										String pagePath=request.getServletPath().substring(1);
										request.setAttribute("pagePath",pagePath);
									%>
					        		
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
									<c:if test="${sessionScope.lstSetCities==null }">
										<script>
										
											findProHelp('jsp/admin/admin_addshowmoive.jsp','天津');
										</script>		 
									</c:if>
									
									<select id="select_city" class="select_city" name="" onchange="findCityHelp('${pagePath }',this.value);"> 
										<c:forEach items="${sessionScope.lstSetCities }" var="city" varStatus="i">
												<option value="${city.cno}" onclick="" >${city.cname }</option>					
										</c:forEach>
									</select>
			                     
			                     	<select id="select_theatre" class="select_theatre" name="tno">
										<c:forEach items="${sessionScope.findlstTheatres }" var="theatres" varStatus="i">
												<option value="${theatres.tno}" >${theatres.tname }</option>
				 						</c:forEach>
									</select>
			                    
			                    
			                    </td>
			                    <td><span id="msg" style="font-size:12px;"></span></td>
			                </tr>
			                <tr>
			                    <td class="tab_left">电影：</td>
			                    <td>
			                      	<select id=" " class=" " name="mno">
										<c:forEach items="${requestScope.findlstMovie }" var="movie" varStatus="i">
												<option value="${movie.mno}" selected="selected">${movie.mname }</option>
					 					</c:forEach>
									</select>
			                    
			                    </td>
			                    <td style="font-size:12px;"></td>
			                </tr>
			                <tr>
			                    <td class="tab_left">放映日期：</td>
			                    <td>
			                    	<input type="text" id="stime" name="stimeYuan" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" readonly/>
								</td>
			                    <td><span id="" class="" style="font-size:12px;"></span></td>
			                </tr>
								  

			                <tr>
			                    <td class="tab_left">厅：</td>
			                    <td><input value="" type="text" id="" name="shallno" /></td>
			                    <td></td>
			                </tr>
			                <tr>
			                  <td class="tab_left">电影票价格：</td>
			                  <td><input value="" type="text" class="" name="sprice" id="" /></td>
			                  <td></td>
		                 	</tr> 
			                <tr>
			                  <td class="tab_left">语言：</td>
			                  <td><input   type="text" class="" name="slanguage" id="" /></td>
			                  <td></td>
		                  	</tr>
		                 </table>
			                   	<input value="" type="hidden" class="" name="sseatsatust1" id="sseatsatust1" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust2" id="sseatsatust2" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust3" id="sseatsatust3" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust4" id="sseatsatust4" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust5" id="sseatsatust5" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust6" id="sseatsatust6" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust7" id="sseatsatust7" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust8" id="sseatsatust8" />  
			                   	<input value="" type="hidden" class="" name="sseatsatust9" id="sseatsatust9" />  
		                 
		                 <div id="seatSelect" class="">
		                 		<div id="seatSe_head" class="">
		                 			选择座位信息
		                 		</div>
		                 
			                 	<div id="seatSe_tit" class="seatSe_tit">		 	
									<div id="seat_tip" class="seat_tip">
										<span id="" class="">
											<img src="/jee-moviesell/pic/chooseseats/sit_div_img.jpg" width="26" height="26" />用户可选的座位
										</span>
										<span id="" class="">
											<img src="/jee-moviesell/pic/chooseseats/sit_div_img2.jpg" width="26" height="26" />已售出的座位
										</span>
										<span id="" class="">
											<img src="/jee-moviesell/pic/chooseseats/sit_div_img3.jpg" width="26" height="26" />您可选择令其不可预订的座位
										</span>
									</div>
									<div id="" class="yinmu" style="text-align: center;">
										<img src="/jee-moviesell/pic/chooseseats/sit_div (1).jpg"  />
									</div>
								</div>
			                 
			                 	<div id="seatSe_main" class="seatSe_main">
				                 	<c:forEach begin="1" end="9" varStatus="i">
										<div class="seat_row">
											${i.count}
										</div>
										<div class="seat_item_${i.count}">
											<c:forEach begin="1" end="16" varStatus="j">
													<div class="seat_item" id="">
														<div class="seat_img" id="seat_${i.count}_${j.count}" onclick="seatclick(this.id,'value_${i.count}_${j.count}',${i.count},${j.count});" >
														</div>
														${j.count}
														<input type="hidden" value="2" name="value_${i.count}" id="value_${i.count}_${j.count}"/>
												</div>
											</c:forEach>	
										</div>
										<div class="seat_row">
											${i.count}
										</div>
									</c:forEach>	
			                 	</div>
		                 </div>
			                <div  style="text-align: center;height: 85px;padding-top: 20px;">
			            	   
			            	    <input   type="submit" value="确定 添加" id="enrollsubmit" style="background: #5DB6E0;text-shadow: none;border: 0;font-size: 18px;height: 37px;color: #fff;width: 95px;"   />
			                </div>
			            </form>
			             <button id="enbtn" onclick="setSeat();">确定座位</button>
				 	</div>
					 <!--提示  -->
						
						<c:if test="${!empty requestScope.addshowmoiveflag}">
							<div class="addcityflag" id="addcityflag">
						
							<c:if test="${requestScope.addshowmoiveflag==true}">
								<script>
									alert('电影添加成功~');
								</script>
							
							</c:if> 
							<c:if test="${requestScope.addshowmoiveflag==false}">
								<script>
									alert('电影添加失败~');
								</script>
							</c:if> 
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
 <div id="footer" class="footer"> 
 </div>

<!--  网页尾部结束  -->
 
<script>attachUserMenu(admin_menu);</script>


</body>
</html>