<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心_修改电影的相关图片</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin_add.css" /> 
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/admin/admin_addpic.css" /> 

<script type="text/javascript" src="/jee-moviesell/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/admin/admin.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/admin/admin_updatepic.js"></script>

 
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
<style type="text/css">
.content{
		height: 2559px;
	}

</style>
</head>


<c:if test="${requestScope.errorCode!=null&&requestScope.errorCode=='0000'}">
	<script>alert('图片上传成功！');
		//location.reload();
	</script>
	
</c:if>
<c:if test="${requestScope.errorCode!=null&&requestScope.errorCode=='1010'}">
	<script>alert('保存错误');</script>
</c:if>
<c:if test="${requestScope.errorCode!=null&&requestScope.errorCode=='1105'}">
	<script>alert('图片格式不正确,只能是jpg');</script>
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
				<%
					if(request.getParameter("mno")!=null&&request.getParameter("mpicpath")!=null){
						
						int mno=Integer.parseInt(request.getParameter("mno").toString());
						String mpicpath=request.getParameter("mpicpath").toString();
						
						session.setAttribute("updatemno", mno);
						session.setAttribute("updatempicpath", mpicpath);
					}
				%>
			
				<div id="main_tit2" class="main_tit2">
					<img src="/jee-moviesell/pic/admin/arrow.png" width="14" height="17">修改电影的相关图片
					<button onclick="javascript:location='/jee-moviesell/FindByIdMoviesServlet?mno=${sessionScope.updatemno }';" id="" class="" >返回修改电影信息页面</button>
				</div>				
				<p>请选择电影的图片</p>
				<div id="main_main" class="main_main">
					<input type="hidden" value="${sessionScope.updatempicpath }" name="path"/>
					<input type="hidden" value="${sessionScope.updatemno }" name="mno"/>
					
				  	<table id="picUpload">
						<tr>
							<td  class="tit">电影小海报（主页显示）：</td>
							<td  class="inp">
					  		<form action="/jee-moviesell/UpdatePicServlet" method="post" id="" class="" onsubmit="return checkForm('poster');" enctype="multipart/form-data">
								<input type="hidden" name="picName" value="poster"/>
								<input type="hidden" value="${sessionScope.updatemno }" name="mno"/>
								<input type="hidden" name="picDir" value="${sessionScope.updatempicpath }"/>
								<input type="file" id="poster" name="filepath" />
								<br>
								<input class="inSubmit" type="submit" value="修改该图片"/>
							</form>		
								
							</td>
							<td  class="">174*232 jpg</td>
							<td  class="im"><img id="posterimg" src="/jee-moviesell/pic/pictures/${sessionScope.updatempicpath }/poster.jpg"></td>
						</tr>	 
						<tr>
							<td class="tit">电影大海报：</td>
							<td class="inp">
								<form action="/jee-moviesell/UpdatePicServlet" method="post" id="" class="" onsubmit="return checkForm('infoposter');" enctype="multipart/form-data">
									<input type="hidden" name="picName" value="infoposter"/>
								<input type="hidden" value="${sessionScope.updatemno }" name="mno"/>
									<input type="hidden" name="picDir" value="${sessionScope.updatempicpath }"/>
									<input type="file" id="infoposter" name="filepath" />
									<br>
									<input class="inSubmit" type="submit" value="修改该图片"/>
								</form>		
							</td>
							<td class="">1056*406 jpg</td>
							<td class="im"><img id="infoposterimg" src="/jee-moviesell/pic/pictures/${sessionScope.updatempicpath }/infoposter.jpg"></td>
						</tr>			
						<c:forEach begin="1" end="10" varStatus="i">
							<tr>
								<td class="tit">电影剧照${i.count}：</td>
								<td class="inp">
									<form action="/jee-moviesell/UpdatePicServlet" method="post" id="" class="" onsubmit="return checkForm('info${i.count}');" enctype="multipart/form-data">
										<input type="hidden" name="picName" value="info${i.count}"/>
								<input type="hidden" value="${sessionScope.updatemno }" name="mno"/>
										<input type="hidden" name="picDir" value="${sessionScope.updatempicpath }"/>
										<input type="file" id="info${i.count}" name="filepath" />
										<br>
										<input class="inSubmit" type="submit" value="修改该图片"/>
									</form>		
								</td>
								<td class="">500*360 jpg</td>
								<td class="im"><img src="/jee-moviesell/pic/pictures/${sessionScope.updatempicpath }/info${i.count}.jpg"></td>
							</tr>			
						</c:forEach>
				  		
				  	</table>
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