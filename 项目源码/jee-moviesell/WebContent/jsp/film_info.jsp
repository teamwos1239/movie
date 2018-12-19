<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影片详细信息页</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_footer.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/film_info_main.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/footer_linkarea.css"/>
<script type="text/javascript" src="/jee-moviesell/js/index/top_nav.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/footer_linkarea.js"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 
 
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


<c:if test="${requestScope.findindexmovie==null||empty requestScope.findindexmovie}">
	<script>
	
		location="/jee-moviesell/FilmInfoMovieServlet?mno=1";
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
		<li><a><img src="/jee-moviesell/pic/index/IMAX.png" width="130" height="54" class=" "  id=" " alt="IMAX" onClick="javascript:void(0);" style="cursor: pointer;" />   </a></li>
		<li style="width: 34px;">&nbsp;</li>
		<li><a><img src="/jee-moviesell/pic/index/hdcx-btn.png" width="174" height="43" class=" "  id=" " onClick="javascript:void(0);" style="cursor: pointer;" /></a></li>
	</ul>
</div>
<!--  网页头部结束 --> 
<div id="to_top" onclick="gotop(this);" onmouseover="gotopover();" onmouseout="gotopout()"></div>

  
<!--网页主体  -->
<div id="content" class="content" >
	<br>
	<div id="content_nav" class="content_nav">  
		 <div id="content_nav_1" class="content_nav_1">您当前的位置：首页&#62;正在热映&#62;</div>
		 <div id="content_nav_2" class="content_nav_2">${requestScope.findindexmovie.mname}</div> 
	</div>  
	 
	<div id="content_tit" class="content_tit">  
		<span id="content_tit_left" class="content_tit_left">  
			<span id="content_tit_left1" class="content_tit_left1">  
				&nbsp;&nbsp;${requestScope.findindexmovie.mname}
			</span>
			<span id="content_tit_left2" class="content_tit_left2">  
				&nbsp;&nbsp;&nbsp;${requestScope.findindexmovie.mspecial}
			</span>
		</span>
	
		<span id="content_tit_right" class="content_tit_right">  
			<button onclick="javascript:location='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno=${sessionScope.selectedCity}&&mno=${requestScope.findindexmovie.mno }';">我要购票</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发表影评&nbsp;分享给好友
		</span>	
	</div>	 	 
	<div id="content_poster" class="content_poster" title="${requestScope.findindexmovie.mname}" style="background: url('/jee-moviesell/pic/pictures/${requestScope.findindexmovie.mpicpath}/infoposter.jpg') no-repeat;width:1056px; height: 406px;  ">  
		<a href="#" style="display: block; width: 100%; height: 100%;"></a> 
	</div>
	 
	<!--主要信息  -->
	<div id="content_main" class="content_main" >  
		<div id="content_main_msg" class="content_main_msg">  
			<div id="main_msg_left" class="main_msg_left">
				<div id="main_msg_left_tit" class="main_msg_left_tit">
					上映日期：${requestScope.findindexmovie.mstarttime} <font color="#5DB6E0" size="2px">1024人想看</font>
				</div>
				<br>
				<ul>
	                <li>导演：${requestScope.findindexmovie.mdirector}</li>
	             	<li>主演：${requestScope.findindexmovie.mroles}</li>
	              	<li>类型：${requestScope.findindexmovie.mtype}</li>
	              	<li>国家：${requestScope.findindexmovie.mcountry}</li>
	              	<li>版本： ${requestScope.findindexmovie.mversion}</li>
	              	<li>片长：${requestScope.findindexmovie.mlength}</li>
              	</ul>
          	</div>
          	<button onclick="javascript:location='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno=${sessionScope.selectedCity}&&mno=${requestScope.findindexmovie.mno }';" >购票</button>
			<div id="main_msg_right" class="main_msg_right">
				<div ><font style="color: black;">万达观影指数</font><span style="height:100%;width:10px;margin-left:73px;">&nbsp;</span> 我要参与</div>
				<div style="font-size: 12px;margin-top: 3px;">100位已观影用户感受</div>
                
                <img src="/jee-moviesell/pic/filminfo/2014-11-02_013729.png" width="264" height="163">
			</div>
		</div>
            <br> 
            <br> 
              
		<div id="content_main_juqing" class="content_main_juqing" >  
			<div id="main_juqing_tit" class="main_juqing_tit" > 
				影片剧情：
			</div>
			<div id="main_juqing_main" class="main_juqing_main">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.findindexmovie.minformation} 
			</div>
		</div>
		<div id="content_main_juzhao" class="content_main_juzhao" >  
			<div id="main_juzhao_tit" class="main_juzhao_tit" > 
				影片剧照：
			</div>
			<div id="" class="main_juzhao_img">
				<c:forEach begin="1" end="10" varStatus="i">
				
					<a class="" href="#"><img src="/jee-moviesell/pic/pictures/${requestScope.findindexmovie.mpicpath}/info${i.count}.jpg" width="500" height="360"></a>
				</c:forEach>
				
			</div>
		</div>
		
		<div id="" class="main_pinglun">
			<div id="main_pinglun_tit" class="main_pinglun_tit" >
				发影评 ● 晒票根（条）
			</div>
			<div class="pinglu_main">
				 暂无评论
			</div>
			<div class="main_pinglun_xuhao">
				&#60;&#32;<a class="pinglu_on xuhao" href="#">1</a><a class="xuhao" href="#">2</a><a class="xuhao" href="#">3</a><a class="xuhao" href="#">4</a><a class="xuhao" href="#">5</a><a class="xuhao" href="#">6</a><a class="xuhao" href="#">7</a><a class="xuhao" href="#">8</a>&#62;共8页
			</div>			
		</div>
		
			
		<div id="" class="main_fapinglun">
			<div id="main_fapinglun_tit" class="main_fapinglun_tit" >
				发影评 ● 晒票根（条）
			</div>
			<textarea rows="10" cols="14" class="fapinglun_txt"></textarea> 
			<button class="" name="" onclick="javascript:void(0);">发表</button>
			<span>你还可以输入1-140字</span>
		</div>
		
		
		
	</div>
	<!--主要信息结束  -->
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