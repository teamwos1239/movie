<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心_查看所有电影放映信息</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/ss/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 

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
	

function deleteCheck(sno){
	
	if(confirm('确定删除吗？')){
		location='/jee-moviesell/DeleteShowmoiveServlet?sno='+sno;
	}
		
	
}
</script>
</head>


<c:if test="${requestScope.showmoviePage==null }">

	<script type="text/javascript">
			location = "/jee-moviesell/ShowShowmoiveItemServlet?currentPage=" + 1;
	</script>
</c:if>



<script type="text/javascript">
	function gotoPage(page) {
		var url = "/jee-moviesell/ShowShowmoiveItemServlet?currentPage=" + page;
		location = url;

	}
</script>

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
<div id="content" class="content" style="height: 1291px;"  >
	
	 
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
							<li><a href="/jee-moviesell/jsp/admin/admin_showshowmoive.jsp" class="o_on">查看电影放映信息</a></li>
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
			  <img src="/jee-moviesell/pic/admin/arrow.png" width="14" height="17">查看所有电影放映信息</div>				
			
			
				<div id="main_main" class="main_main">
				
					<div id="" class="" >
						<script type="text/javascript">
						
							function chooseChange(pagePath,chosed){
								url="/jee-moviesell/SavePaiXunServlet?pagePath="+pagePath+"&&chosed="+chosed;
								location=url;
								
							}
						</script>
						<%
							String[] pai={"放映编号","放映时间","电影","电影院"};						
							request.setAttribute("pai", pai); 
							String pagePath=request.getServletPath().substring(1);
							request.setAttribute("pagePath",pagePath);
						%>
					
						排序方式： 	
						<select id="paixun" onchange="chooseChange('/jee-moviesell/ShowShowmoiveItemServlet?currentPage=${requestScope.showmoviePage.currentPage}',this.value);">
							<c:forEach items="${pai}" var="chooose">
								<c:if test="${sessionScope.chooseD==chooose}">
									<option value="${chooose }" selected="selected">${chooose }</option>
								</c:if>
								<c:if test="${sessionScope.chooseD!=chooose}">
									<option value="${chooose }">${chooose }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>				
				
				
					<div class="page_to" style="margin: 5px;">

						跳转至：
						<select name="select" id="select"
						onchange="javascript:gotoPage(this.value);">
		
							<c:forEach var="i" begin="1"
								end="${requestScope.showmoviePage.totalPage }">
								<c:if test="${i!=requestScope.showmoviePage.currentPage}">
									<option value="${i}">第${i}页</option>
								</c:if>
								<c:if test="${i==requestScope.showmoviePage.currentPage}">
									<option value="${i}" selected="selected">第${i}页</option>
								</c:if>
							</c:forEach>
						</select>  
					</div>
				
				
					<table >
					  <tr class="tab_tit">
					    <td>序号</td>
					    <td>放映编号</td>
					    <td>电影院名称</td>
					    <td>电影名称</td>
					    <td>放映时间</td>
					    <td>电影票价格</td>
					    <td>厅</td>
					    <td>操作</td>
				      </tr>
				      
				       <c:if test="${requestScope.showmoviePage.list!=null}">
						  <c:forEach items="${requestScope.showmoviePage.list}" var="showmoiveItem"  varStatus="i">
							   <tr class="tab_main">
						    <td>${i.count }</td>
						    <td>${showmoiveItem.sno}</td>
						    <td>${showmoiveItem.stname }</td>
						    <td>${showmoiveItem.smname }</td>
						    <td>${showmoiveItem.stime }</td>
						    <td>${showmoiveItem.sprice }</td>
						    <td>${showmoiveItem.shallno }</td>
						    <td><button onclick="deleteCheck(${showmoiveItem.sno});">删除</button><button onclick="javascript:location='/jee-moviesell/FindByIdShowmoiveServlet?sno=${showmoiveItem.sno}';">修改</button></td>
						  </tr>
						  </c:forEach>
					  </c:if>
					  <c:if test="${empty requestScope.showmoviePage.list}">
							  <tr class="tab_main">
									<td colspan="5">暂无记录</td>
						      </tr>
					  </c:if>
					</table>
					
					
					
					<c:if test="${!empty requestScope.delshowmoiveflag}">
							<div class="addcityflag" id="addcityflag">
						
							<c:if test="${requestScope.delshowmoiveflag==true}">
								<script>								
									alert('电影放映信息删除成功~');
								</script>
							</c:if> 
							<c:if test="${requestScope.delshowmoiveflag==false}">
								<script>
									alert('电影放映信息删除失败~');
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