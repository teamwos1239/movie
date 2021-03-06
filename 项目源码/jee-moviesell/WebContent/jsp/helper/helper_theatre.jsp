
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助中心_影城信息</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_footer.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/helpercss/helper_login.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/footer_linkarea.css"/>
<script type="text/javascript" src="/jee-moviesell/js/index/top_nav.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/footer_linkarea.js"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/helpercss/helper_theatre.css" /> 

<script src="/jee-moviesell/js/leftmenu.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/util/leftmenu.css">
 
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
	<div id="top_1" class="top_1">
		
        <div id="top_link" class="top_link"> 
        	<div id="top_city" class="top_city">
        	
        		<!--城市选择  --> 
        		城市
        		<%
					String[] citiesarr = {"北京","天津","上海","黑龙江","河北","重庆","山东",
        				"内蒙古","浙江","广东","吉林","安徽","湖南","江苏","四川",
        				"辽宁","山西","福建","贵州","海南","陕西","长春","湖北",
        				"云南","甘肃","河南","江西","广西","大连","宁夏"};
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
		<li><a><img src="/jee-moviesell/pic/index/IMAX.png" width="130" height="54" class=" "  id=" " alt="IMAX" onClick="javascript:void(0);" style="cursor: pointer;" />   </a></li>
		<li style="width: 34px;">&nbsp;</li>
		<li><a><img src="/jee-moviesell/pic/index/hdcx-btn.png" width="174" height="43" class=" "  id=" " onClick="javascript:void(0);" style="cursor: pointer;" /></a></li>
	</ul>
</div>
<!--  网页头部结束 --> 
<div id="to_top" onClick="gotop(this);" onMouseOver="gotopover();" onMouseOut="gotopout()"></div>

<!--网页主体  -->
<div id="content" class="content" >
	
		<br><br><br>
	<div id="content_nav" class="content_nav" >
		<span id="" class="nav_off" >
			您当前的位置：<a href="/jee-moviesell/jsp/index.jsp">首页</a>&#62;<a href="/jee-moviesell/jsp/helper/helper_howtobuy.jsp">帮助中心</a>&#62;
		</span>
		<span id="" class="nav_on" >
			影城信息
		</span>
	</div> 
	
	<div id="" class="content_main">
		<div id="" class="main_tit">
			帮助中心
		</div>
		<div id="" class="main_main">
			<div id="" class="main_left">
				<dl class="left1">
					<dt class="">常用帮助
					</dt>
					<dd>
						<div  class=""> 
                            <img src="/jee-moviesell/pic/hepler/duihuanma.png"/>
							<a href="#">兑换码帮助</a>
						</div>
					</dd>
					<dd>
						<div  class=""> 
                            <img src="/jee-moviesell/pic/hepler/duihuanma2.png"/>
							<a href="#">兑换码查询</a>
						</div>
					</dd>
					<dd>
						<div  class=""> 
                            <img src="/jee-moviesell/pic/hepler/yingcheng.png"/>
							<a href="/jee-moviesell/jsp/helper/helper_theatre.jsp">影城信息</a>
						</div>
					</dd>
					<dd>
						<div  class=""> 
                            <img src="/jee-moviesell/pic/hepler/lianxi.png"/>
							<a href="#">联系我们</a>
						</div>
					</dd>
					<dd>
						<div  class=""> 
                            <img src="/jee-moviesell/pic/hepler/yijian.png"/>
							<a href="#">投诉建议</a>
						</div>
					</dd>
				</dl>
				 				
				<div class="tit">
					帮助部分
				</div>
				<!--菜单部分  -->
				<div id="menu">
				<dl >
					<dt onClick="menuOnclick('dd1');">
					<img src="/jee-moviesell/pic/hepler/arrow.png" width="14" height="17">新手入门 </dt>
					<dd id="dd1" class="" style="">
						<div><a href="#">新用户注册</a></div>
						<div ><a href="/jee-moviesell/jsp/helper/helper_login.jsp" >用户登录</a></div>
						<div><a href="#">账号绑定</a></div>
						<div><a href="#">积分说明</a></div>
						<div><a href="#">常见问题</a></div>
					</dd>
				</dl>
				
				<dl>
			  <dt onClick="menuOnclick('dd2');">
					<img src="/jee-moviesell/pic/hepler/arrow.png" width="14" height="17">购票指南 </dt>
					<dd id="dd2" class="" style="">
						<div><a href="/jee-moviesell/jsp/helper/helper_howtobuy.jsp">购票流程</a></div>
						<div><a href="#">影城取票</a></div>
						<div><a href="#">退票</a></div>
						<div><a href="#">取票密码重发</a></div>
						<div><a href="#">常见问题</a></div>
						<div><a href="#">话费支付Q&#38;A</a></div>
					</dd>
				</dl>
				
				<dl>
			  <dt onClick="menuOnclick('dd3');">
					<img src="/jee-moviesell/pic/hepler/arrow.png" width="14" height="17">优惠卡券 </dt>
					<dd id="dd3" class="" style="">
						<div><a href="/jee-moviesell/jsp/helper/helper_membercard.jsp">会员(储蓄)卡</a></div>
						<div><a href="#">礼券</a></div>
						<div><a href="#">兑换码</a></div>
						<div><a href="#">优享卡</a></div>
						<div><a href="#">常见问题</a></div>
					</dd>
				</dl>
				
				<dl>
			  <dt onClick="menuOnclick('dd4');">
					<img src="/jee-moviesell/pic/hepler/arrow.png" width="14" height="17">会员服务 </dt>
					<dd id="dd4" class="" style="">
						<div><a href="#">会员服务介绍</a></div>
						<div><a href="/jee-moviesell/jsp/helper/helper_jindui.jsp">积分兑换</a></div>
						<div><a href="#">常见问题</a></div>
					</dd>
				</dl>
				</div>
				<script type="text/javascript" src="/jee-moviesell/js/leftmenu.js"></script>
				
				<!--菜单部分  -->
			</div>
			
			<div id="" class="main_right">
				<div id="" class="theatre_tit">
					影城信息
				</div>
				<div id="" class="theatre_name">
					 ${requestScope.selectTheatre.tname}
				</div>
				<div id="" class="theatre_other">
				
				<!--sessionScope.lstTheatresHelper==null&&   -->
			 		
			 		<c:if test="${sessionScope.lstTheatresHelper==null}">
						<script>
							var cityId=document.getElementById('select_city').value;
							findCityHelp('jsp/helper/helper_theatre.jsp',cityId);
						</script>
					</c:if> 
			 		
			 		<c:if test="${sessionScope.queryTheatreflag==1&&sessionScope.lstTheatresHelper!=null}">
						<script>
							var cityId=document.getElementById('select_city').value;
							findCityHelp('jsp/helper/helper_theatre.jsp',cityId);
						</script>
					</c:if> 
					
					<script type="text/javascript">
						function findTheatre(tno){
							location='/jee-moviesell/HelperFindTheatreServlet?tno='+tno;					
						}
					</script>
				
					查看其它影城
					<select name="" id="selectThe" class="" onchange="findTheatre(this.value)">
						<c:if test="${sessionScope.lstTheatresHelper!=null }">
							<c:forEach items="${sessionScope.lstTheatresHelper}" var="theatre" varStatus="i">
								<c:if test="${requestScope.selectTheatre.tno==theatre.tno}">
									<option value="${theatre.tno}" selected="selected">${theatre.tname }</option>
								</c:if>
								<c:if test="${requestScope.selectTheatre.tno!=theatre.tno}">
									<option value="${theatre.tno}">${theatre.tname }</option>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${sessionScope.lstTheatresHelper==null }">
									<option value="">暂无其他影城</option>
						</c:if>
						
					</select>
					 <c:if test="${requestScope.selectTheatre==null||empty requestScope.selectTheatre}">
						
						<script type="text/javascript">
							var x=document.getElementById('selectThe').value;
							findTheatre(x);
						</script>
					</c:if> 
					
				</div>
				
				
				<div id="" class="theatre_main">
					
					<div id="" class="">
						<div id="" class="zhu">友情提示：你只有先切换城市才能看到其它的影城</div>
					</div>
					<p></p>
					<div id="" class="">
						<div id="" class="">地址：</div>
						<div id="" class="cont">${requestScope.selectTheatre.taddress}</div>
					</div><p></p>
					<div id="" class="">
						<div id="" class="">电话：</div>
						<div id="" class="cont">${requestScope.selectTheatre.ttel}</div>
					</div><p></p>
					<div id="" class="">
						<div id="" class="">座位数：</div>
						<div id="" class="cont">${requestScope.selectTheatre.tseatnumber}</div>
					</div><p></p>
					<div id="" class="">
						<div id="" class="">停车位置：</div>
						<div id="" class="cont">${requestScope.selectTheatre.tparkloc}</div>
					</div><p></p>
					<div id="" class="">
						<div id="" class="">优惠信息：</div>
						<div id="" class="cont">${requestScope.selectTheatre.tspecialinfo}</div>
					</div><p></p>
					<div id="" class="">
						<div id="" class="">公交信息：</div>
						<div id="" class="cont">${requestScope.selectTheatre.tbusinfo}</div>
					</div>
					<div id="" class="theatre_img">
						<img alt="" src="/jee-moviesell/pic/hepler/yingchengda.png">
					</div>						
				</div>
			</div>
			<!--右部分结束  -->
		</div>	
	</div>	 
	 
</div>
<!--网页主体 结束 -->


<!-- 下部链接 -->
<div id="footer_linkarea" class="footer_linkarea">
 <table width="995" id="footer_tab" class="footer_tab" >
      <tr>
        <td width="98" rowspan="3"><img src="/jee-moviesell/pic/footer/footer_1.png" title="投诉建议" width="98" height="149" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_2.png" title="在线客服" width="188" height="42" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_3.png" title="客服热线：400-800-6060" width="201" height="40"  /></td>
        <td width="249"><img src="/jee-moviesell/pic/footer/footer_4.png" title="万达生活" width="249" height="41" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
        <td width="253" rowspan="3"><img src="/jee-moviesell/pic/footer/footer_11.png" title="二维码" width="253" height="151" /></td>
      </tr>
      <tr>
        <td><img src="/jee-moviesell/pic/footer/footer_5.png" title="兑换码使用帮助" width="187" height="44" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_6.png" title="IMAX" width="196" height="41" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
        <td rowspan="2"><img src="/jee-moviesell/pic/footer/footer_10.png" title="万达观影指数" width="249" height="103" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
      </tr>
      <tr>
        <td colspan="2"><img src="/jee-moviesell/pic/footer/footer_7.png" title="购票流程" width="126" height="48" style="cursor: pointer;" onclick="javascript:location='/jee-moviesell/jsp/helper/helper_howtobuy.jsp';" />&nbsp;&nbsp;<img src="/jee-moviesell/pic/footer/footer_8.png" title="取票流程" width="125" height="49" style="cursor: pointer;" onClick="javascript:void(0);" />&nbsp;<img src="/jee-moviesell/pic/footer/footer_9.png" title="退票流程" width="127" height="49" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
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
    <img src="/jee-moviesell/pic/cnnic.png" width="51" height="20"  style="cursor:pointer;" onClick="javascript:void(0);"/>
    <img src="/jee-moviesell/pic/cert.png" width="51" height="20"  style="cursor:pointer;" onClick="javascript:void(0);"/>
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