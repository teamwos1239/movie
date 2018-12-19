<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心_管理员登录页</title>
<link rel="stylesheet" type="text/css"
	href="/jee-moviesell/css/index_top.css" />
<link rel="stylesheet" type="text/css"
	href="/jee-moviesell/css/allstyle.css" />
<link rel="stylesheet" type="text/css"
	href="/jee-moviesell/css/admin/admin.css" />
<link rel="stylesheet" type="text/css"
	href="/jee-moviesell/css/admin/admin_login.css" />


<link rel="stylesheet" type="text/css"
	href="/jee-moviesell/css/gotop.css" />

<script type="text/javascript" src="/jee-moviesell/js/admin/admin.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/jsCheck.js"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/jsCheck.css" /> 


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

<body onload="createCode();">
	<!--   网页头部 -->
	<div id="top" class="top">
	 	 
	
	</div>
	<div id="top_logo" class="top_logo">
		<div id="logo_div" class="logo_div">
			<img src="/jee-moviesell/pic/logo.png" width="251" height="59"
				id="logo" class="logo" style="margin-bottom: 11px;" /> <img
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
			<div id="admin_login_tit" class="admin_login_tit">管理员登录</div>


			<div id="admin_login_main" class="admin_login_main">
				<form class="" id="" method="post" action="/jee-moviesell/AdminLoginServlet" onsubmit="return adminForm();">
					<input type="hidden" name="ano" value="-1"/>
					<table>
						<tr>
							<td>请输入您的账号：</td>
							<td><input type="text" name="aaccount"/></td>
						</tr>
						<tr>
							<td>请输入您的密码：</td>
							<td><input type="password" name="apass" /></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="text" id="input1" style="height: 26px; width:105px; color:#909090; line-height:28px;"/>
                   				<input type="button" id="checkCode" class="code" onclick="createCode()"  style="cursor:pointer;width: 75px;margin-left: 9px;border: 1px #5EB7E2 solid;height: 31px;font-size: 20px;"/>
                  				<a href="#" onclick="createCode()" style="color: #5EB7E2;font-size: 15px;text-decoration: underline;">看不清楚</a>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" class="btn"
								value="管理员登录" /></td>
						</tr>
						<tr>
							<td colspan="2">
								<c:if	test="${!empty requestScope.adminloginflag}">
									<div class="addcityflag" id="addcityflag">
												<c:if test="${requestScope.adminloginflag==false}">
														<script>
															alert('账号或密码错误');
														</script>
												</c:if>
									</div>
								</c:if>
							</td>
						</tr>
					</table>
				</form>

			</div>
		</div>

	</div>
	<!--网页主体 结束 -->



	<!--  网页尾部  -->
	<div id="footer" class="footer"></div>

	<!--  网页尾部结束  -->



</body>
</html>