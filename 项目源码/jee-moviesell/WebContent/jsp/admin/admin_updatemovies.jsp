<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心_修改电影信息</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin_add.css" /> 

<script type="text/javascript" src="/jee-moviesell/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/admin/admin.js"></script>

<script type="text/javascript" src="/jee-moviesell/js/datepicker/WdatePicker.js"></script>
 
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
							<li><a href="/jee-moviesell/jsp/admin/admin_addshowmoive.jsp" class="">添加电影放映信息 </a></li>
							
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
				  <img src="/jee-moviesell/pic/admin/arrow.png" width="14" height="17">修改电影信息
				</div>				
				<p>请输入重新电影的详细信息</p>
			
				<div id="main_main" class="main_main">
				 
				 <div id="addmovie" class="addmovie">
				 	<form id="loginform" name="loginform" action="/jee-moviesell/UpdateMoviesServlet" method="post">
				 		<input type="hidden" value="${requestScope.findmovie.mno }" name="mno"/>
			            <table id="addmovie_tab">
			                <tr>
			                    <td class="tab_left">电影名称：</td>
			                    <td><input type="text" class="" name="mname" id="" value="${requestScope.findmovie.mname }"/></td>
			                    <td><span id="msg" style="font-size:12px;"></span></td>
			                </tr>
			                <tr>
			                    <td class="tab_left">电影类型：</td>
			                    <td><input type="text" class="" name="mtype" id="" value="${requestScope.findmovie.mtype }"/></td>
			                    <td style="font-size:12px;"></td>
			                </tr>
			                <tr>
			                    <td class="tab_left">上映日期：</td>
			                    <td><input value="${requestScope.findmovie.mstarttime }" type="text" id="" name="mstarttime" class="Wdate" onfocus="WdatePicker({position:{left:0,top:0}})" readonly/></td>
			                    <td><span id="" class="" style="font-size:12px;"></span></td>
			                </tr>
			                <tr>
			                    <td class="tab_left">放映结束日期：</td>
			                    <td><input value="${requestScope.findmovie.mendtime }" type="text" id="" name="mendtime" class="Wdate" onfocus="WdatePicker({position:{left:0,top:0}})" readonly/></td>
			                    <td></td>
			                </tr>
			                <tr>
			                  <td class="tab_left">导演：</td>
			                  <td><input value="${requestScope.findmovie.mdirector }" type="text" class="" name="mdirector" id="" /></td>
			                  <td></td>
		                  </tr>
			                <tr>
			                  <td class="tab_left">主角：</td>
			                  <td><textarea   name="mroles" cols="10" rows="20">${requestScope.findmovie.mroles }</textarea></td>
			                  <td></td>
		                  </tr>
			                
			                <tr>
			                  <td class="tab_left">国家：</td>
			                  <td><input value="${requestScope.findmovie.mcountry }" type="text" class="" name="mcountry" id="" /></td>
			                  <td></td>
		                  </tr>
			                <tr>
			                  <td class="tab_left">版本：</td>
			                  <td>
								<%
			                  	List<String> lstversion=new ArrayList<String>();
			                  	lstversion.add("2D");
			                  	lstversion.add("3D");
			                  	lstversion.add("IMAX-3D");
			                  	lstversion.add("IMAX-2D");
			                  	lstversion.add("XLAND");
			                  	session.setAttribute("lstversion", lstversion);
			                  %>
			                  
			                  <select name="mversion">
			                  	<c:forEach items="${sessionScope.lstversion}" var="version" varStatus="">
			                  		<c:if test="${version==requestScope.findmovie.mversion }">
			                  			<option value="${version }" selected="selected">${version }</option>
			                  		</c:if>
			                  		<c:if test="${version!=requestScope.findmovie.mversion }">
			                  			<option value="${version }" >${version }</option>
			                  		</c:if>
			                  	</c:forEach>
			                  </select>
			                  

								</td>
			                  <td></td>
		                  </tr>
			                <tr>
			                  <td class="tab_left">片长：</td>
			                  <td><input value="${requestScope.findmovie.mlength }" type="text" class="" name="mlength" id="" /></td>
			                  <td></td>
		                  </tr>
			                <tr>
			                  <td class="tab_left">影片剧情：</td>
			                  <td><textarea  name="minformation" cols="10" rows="20">${requestScope.findmovie.minformation }</textarea></td>
			                  <td></td>
		                  </tr>
			                <tr>
			                  <td class="tab_left">喜欢率：</td>
			                  <td><input value="${requestScope.findmovie.mlikerate }" type="text" class="" name="mlikerate" id="" /></td>
			                  <td></td>
		                  </tr>
			                <tr>
			                  <td class="tab_left">电影图片路径：</td>
			                  <td><input value="${requestScope.findmovie.mpicpath }" type="text" class="" name="mpicpath" id="" /></td>
			                  <td></td>
		                  </tr>
			                <tr>
			                  <td class="tab_left">特色：</td>
			                  <td><input value="${requestScope.findmovie.mspecial }" type="text" class="" name="mspecial" id="" /></td>
			                  <td></td>
		                  </tr>
		                 </table>
		                	<!--电影图片原来的目录名称  -->
		                 	<input type="hidden" name="oldpath" value="${requestScope.findmovie.mpicpath }"/>
			                <div  style="text-align: center;height: 85px;padding-top: 20px;">
			            	    <input type="submit" value="确定 修改" id="enrollsubmit" style="background: #5DB6E0;text-shadow: none;border: 0;font-size: 18px;height: 37px;color: #fff;width: 95px;"   />
			                </div>
			               
			            
			            </form>
				 	</div>
					 <!--提示  -->
					 
					 
						<button onclick="javascript:location='/jee-moviesell/jsp/admin/admin_updatemoviepic.jsp?mpicpath=${requestScope.findmovie.mpicpath }&&mno=${requestScope.findmovie.mno }'" id="queryPic" >查看电影照片</button>
						<c:if test="${!empty requestScope.updatemovieflag}">
							<div class="addcityflag" id="addcityflag">
								<c:if test="${requestScope.updatemovieflag==true}">
									<script>
										alert('电影修改成功~');
									</script>
									
								</c:if> 
								<c:if test="${requestScope.updatemovieflag==false}">
									<script>
										alert('电影修改失败~');
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