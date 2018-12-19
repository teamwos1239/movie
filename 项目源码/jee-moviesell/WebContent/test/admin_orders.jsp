<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心_查看所有订单</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
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
	

</script>
</head>

<body style="background-color: #F1F7F7;" > 
<!--   网页头部 -->
<div id="top" class="top">
 
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

						<div id="admin_on" class="admin_tit" onClick="adminmenuOnclick('dd2');"
							style="">订单管理</div>
						<ul id="dd2" class="admin_con" style="">
							<li><a href="/jee-moviesell/jsp/admin/admin_orders.jsp" class="o_on">查看所有订单</a></li>

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
			  <img src="/jee-moviesell/pic/admin/arrow.png" width="14" height="17">查看所有订单 </div>				
			
			
				<div id="main_main" class="main_main">
					<table >
					  <tr class="tab_tit">
					    <td>序号</td>
					    <td>流水账号</td>
					    <td>用户编号</td>
					    <td>电影名称</td>
					    <td>订单状态</td>
					    <td>支付方式</td>
					    <td>支付金额</td>
					    <td>下单时间</td>
					  </tr> 
					   <c:if test="${requestScope.lstOrderItem!=null}">
						  <c:forEach items="${requestScope.lstOrderItem}" var="orderItem"  varStatus="i">
							 <tr class="tab_main">
						    <td>${i.count }</td>
						    <td>${orderItem.oOrder.obizcode }</td>
						    <td>${orderItem.oOrder.uno }</td>
						    <td>${orderItem.oMovie.mname }</td>
						    <td>${orderItem.oOrder.ostatus }</td>
						    <td>${orderItem.oOrder.opayway }</td>
						    <td>${orderItem.oOrder.opaymoney }</td>
						    <td>${orderItem.oOrder.otime }</td>
						  </tr>
						  </c:forEach>
					  </c:if>
					  <c:if test="${empty requestScope.lstOrderItem}">
							  <tr class="tab_main">
									<td colspan="5">暂无记录</td>
						      </tr>
							  
					  </c:if>
					  
					  
					</table>
					<div class="page_to">
		        <div>&#60;&#60;</div>
						<c:forEach begin="1" end="10"   varStatus="i">		
								<c:if test="${i.count==1 }">
									<div class="page_on"><a href="">${i.count }</a></div>
								</c:if>
								<c:if test="${i.count!=1 }">
									<div class=""><a href="">${i.count }</a></div>
								</c:if>
								
										
						</c:forEach>
						<div>&#62;&#62;</div>
						&nbsp;&nbsp;&nbsp;共30 页
					</div>
					<div style="text-align: center;">
						<button class="querybtn" onClick="javascript:location='/jee-moviesell/FindAdminSeeOrderServlet';" >
							检索
						</button>
					</div>
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