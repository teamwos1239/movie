<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_footer.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_main.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/footer_linkarea.css"/>
<script type="text/javascript" src="/jee-moviesell/js/index/top_nav.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/footer_linkarea.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/main_menu.js"></script>
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
				<c:if test="${sessionScope.lstSetCities==null }">
					<script>
					
						findProHelp('jsp/index.jsp','天津');
					</script>		
				</c:if>
				
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
		<li><a href="#"  >电影首页</a></li>
		<li><a href="javascript:location='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno=${sessionScope.selectedCity}';" >电影排期</a></li>
		<li><a href="" >移动购票</a></li>
		<li><a href="" >电影谈资</a></li>
	</ul>
	<ul id="nav_ul2" class="nav_ul">
		<li style="width: 34px;">&nbsp;</li>
		<li><a><img src="/jee-moviesell/pic/index/IMAX.png" width="130" height="54" class=" "  id=" " alt="IMAX" onclick="javascript:void(0);" style="cursor: pointer;" />   </a></li>
		<li style="width: 34px;">&nbsp;</li>
		<li><a><img src="/jee-moviesell/pic/index/hdcx-btn.png" width="174" height="43" class=" "  id=" " onclick="javascript:void(0);" style="cursor: pointer;" /></a></li>
	</ul>
</div>
<!--  网页头部结束 --> 
<div id="to_top" onclick="gotop(this);" onmouseover="gotopover();" onmouseout="gotopout()"></div>

<!--网页主体  -->
<div id="content" class="content" >
	<!--  左部分-->

	<div id="content_left" class="content_left">
		 
	 	<div id="lunbo" class="lunbo">
	 	  <script>
				var widths=750; //设置幻灯片宽度
				var heights=80; //设置幻灯片高度
				var counts=5; //设置幻灯片数量
				//设置图片路径
				img1=new Image ();img1.src="/jee-moviesell/pic/index/lunbo/20141017000610746849.jpg";
				img2=new Image ();img2.src="/jee-moviesell/pic/index/lunbo/20141023151205615759.jpg";
				img3=new Image ();img3.src="/jee-moviesell/pic/index/lunbo/20141027151415513040.jpg";
				img4=new Image ();img4.src="/jee-moviesell/pic/index/lunbo/20141028155926625409.jpg";
				img5=new Image ();img5.src="/jee-moviesell/pic/index/lunbo/20141028201359682777.jpg";
				
				
				//设置图片的URL
				url1=new Image ();url1.src='#';
				url2=new Image ();url2.src='#';
				url3=new Image ();url3.src='#';
				url4=new Image ();url4.src='#';
				url5=new Image ();url5.src='#';
				
				
				var nn=1;
				var key=0;
				function change_img()
				{if(key==0){key=1;}
				else if(document.all)
				{document.getElementById("pic").filters[0].Apply();document.getElementById("pic").filters[0].Play(duration=2);}
				eval('document.getElementById("pic").src=img'+nn+'.src');
				eval('document.getElementById("url").href=url'+nn+'.src');
				for (var i=1;i<=counts;i++){document.getElementById("xxjdjj"+i).className='axx';}
				document.getElementById("xxjdjj"+nn).className='bxx';
				nn++;if(nn>counts){nn=1;}
				//设置图片切换间隔时间
				tt=setTimeout('change_img()',3000);}  //图片切换时间毫秒
				function changeimg(n){nn=n;window.clearInterval(tt);change_img();}
				document.write('<style>');
				document.write('.axx{padding:1px 10px;border-left:#cccccc 1px solid;}');
				document.write('a.axx:link,a.axx:visited{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#1587E0;}');
				document.write('a.axx:active,a.axx:hover{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#80BBD9;}');
				document.write('.bxx{padding:1px 7px;border-left:#cccccc 1px solid;}');
				document.write('a.bxx:link,a.bxx:visited{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#80BBD9;}');
				document.write('a.bxx:active,a.bxx:hover{text-decoration:none;color:#fff;line-height:12px;font:9px sans-serif;background-color:#80BBD9;}');
				document.write('</style>');
				document.write('<div style="width:'+widths+'px;height:'+heights+'px;overflow:hidden;text-overflow:clip;">');
				document.write('<div><a id="url"><img id="pic" style="border:0px;filter:progid:dximagetransform.microsoft.wipe(gradientsize=1.0,wipestyle=4, motion=forward)" width='+widths+' height='+heights+' /></a></div>');
				document.write('<div style="filter:alpha(style=1,opacity=10,finishOpacity=80);background: #80BBD9;width:100%-2px;text-align:right;top:-12px;position:relative;margin:1px;height:12px;padding:0px;margin:0px;border:0px;">');
				for(var i=1;i<counts+1;i++){document.write('<a href="javascript:changeimg('+i+');" id="xxjdjj'+i+'" class="axx" target="_self"> </a>');}
				document.write('</div></div>');
				change_img();
				</script>
	 	
	 	
	 	</div>
	 	<div id="content_main" class="content_main">
	 		<div id="main_menu" class="main_menu">
		 		<ul id="main_menu_ul" class="main_menu_ul" onmouseover="" onmouseout="">
		 			<li id="on" class="" onclick="" onmouseover="" onmouseout="">正在热映</li>
		 			<li id="" class="" onclick="" onmouseover="" onmouseout="">即将上映</li>
		 			<li id="" class="" onclick="" onmouseover="" onmouseout="">观影日历</li>
		 		</ul>
	 		</div>
	 		<div id="main_content" class="main_content">
		 		<ul id="" class="">
		 			<c:forEach items="${applicationScope.lstSetMovies }" var="movie" varStatus="i">
			 			
			 			<li id="" class="" >
		 					<div id="" class="ul_content" onmousemove="imgover('ul_content_msg${i.count}');" onmouseout="imgout('ul_content_msg${i.count}');">
			 					<div id="ul_content_msg${i.count}" class="ul_content_msg">
			 						<div id="" class="hidden_txt1" >${movie.mtype }</div>
						        	<img src="/jee-moviesell/pic/index/filmInfo.png" width="58" height="57" title="影片详情" style="cursor:pointer;" onclick="javascript:location='/jee-moviesell/FilmInfoMovieServlet?mno=${movie.mno}';"/>
						            <img src="/jee-moviesell/pic/index/buyTicket.png" width="58" height="57" title="购买" style="cursor:pointer;" onclick="javascript:location='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno=${sessionScope.selectedCity}&&mno=${movie.mno }';"/>
						            <div id="" class="hidden_txt2">${movie.mspecial }</div>
								</div>	 					
		 						<div id="" class="ul_content_content">
			 						<img src="/jee-moviesell/pic/pictures/${movie.mpicpath}/poster.jpg" width="174" height="232" />
			 						<div id="" class="ul_content_n"></div>
			 						<a id="" class="" href="/jee-moviesell/FilmInfoMovieServlet?mno=${movie.mno}">${movie.mname}</a>
		 						</div>
		 					</div>
						</li> 
		 			
		 			</c:forEach>
					
		 		</ul>	 			
	 		</div>
	 	</div>
	</div>   
	<!--  左部分结束-->
	<!--  右部分--> 
	<div id="content_right" class="content_right">
	    <div id="right_div" class="right_div">
		    <table width="283px" border="0" cellspacing="1" cellpadding="0" id="right_tab" class="right_tab">
			  <tr>
			    <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat 30px 3px;text-align: center;"> 
					<br />
                    <br />
					<a href="#">快速购票</a>
				</td>
			    <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat -118px 2px;text-align: center;">  
					<br />
					<br />
					<a href="#">我的订单</a>
				</td>
			     <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat -277px 2px;text-align: center;">  
					<br />
					<br />
					<a href="#">积分兑换</a>
				</td>
			  </tr>
			  <tr>
			    <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat 28px -85px;text-align: center;">  
					<br />
					<br />
					<a href="#">兑换码查询</a>
				</td>
			    <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat -119px -85px;text-align: center;">  
					<br />
					<br />
					<a href="#">兑换码帮助</a>
				</td>
			    <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat -280px -85px;text-align: center;">  
					<br />
					<br />
					<a href="/jee-moviesell/jsp/helper/helper_theatre.jsp">影城信息</a>
				</td>
			  </tr>
			  <tr>
			    <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat 32px -295px;text-align: center;">  
					<br />
					<br />
					<a href="#">满意度调查</a>
				</td>
			    <td style="background:url(/jee-moviesell/pic/index/home-right-icons.png) no-repeat 32px -204px;text-align: center;">  
					<br />
					<br />
					<a href="#">会员卡激活</a>
				</td>
			     <td>
					 
				</td>
			  </tr>
			</table>
	    </div>
	    <br />
	    
    	<div id="right_broadcast" class="right_broadcast" >
    		<div id="right_broadcast_tit" class="right_broadcast_tit" >服务公告</div>
    		<div id="right_broadcast_main" class="right_broadcast_main" >
    			<ul id="right_broadcast_ul" class="right_broadcast_ul" >
 					  <li><a href="#" class="">万达影城储值卡线上支付安全升...</a></li>
 					  <li><a href="#" class="">万达影城观影须知</a></li>
 					  <li><a href="#" class="">7月24日凌晨设备维护公告</a></li>
    			
    			</ul>
    		</div>
    	</div>
    	<br />
    	<div id="right_hot" class="right_hot">
    		<div id="right_hot_tit" class="right_hot_tit">热门活动</div>
    		<div id="roll">
				<table id="table_roll">
					<tr> 
						<td>
							<!--------------------demo start------------------>
							<div id=demo
								style="overflow: hidden; width: 240px; color: #ffffff; height: 157px;">
								<table cellpadding=0 width="100%" align=left border=0 cellspacing="0">
									<tr>
										<!--------------------demo1--------------------->
										<td id=demo1 valign=top>
											<table cellspacing=0 cellpadding=0 align=center border=0>
												<tr>
													<td align="center"><img src="/jee-moviesell/pic/index/lunbo/20140929174737537325.jpg" onclick="javascript:void(0);"/></td>
													<td align="center"><img src="/jee-moviesell/pic/index/lunbo/20141008172846739565.jpg" onclick="javascript:void(0);"/></td>
													<td align="center"><img src="/jee-moviesell/pic/index/lunbo/20141027151216406904.jpg" onclick="javascript:void(0);"/></td>
												</tr>
											</table>
										</td>
										<!------------demo2--------------------->
										<td id=demo2 width="0"></td>
									</tr>
								</table>
							</div> <!--------------------demo end------------------>
							 <script>
								var dir = 1//每步移动像素，大＝快
								var speed = 6//循环周期（毫秒）大＝慢
								demo2.innerHTML = demo1.innerHTML
								function Marquee() { 
									if (dir > 0
											&& (demo2.offsetWidth - demo.scrollLeft) <= 0)
										demo.scrollLeft = 0
									if (dir < 0 && (demo.scrollLeft <= 0))
										demo.scrollLeft = demo2.offsetWidth
									demo.scrollLeft += dir
		
									demo.onmouseover = function() {
										clearInterval(MyMar)
									}//暂停移动
									demo.onmouseout = function() {
										MyMar = setInterval(Marquee, speed)
									}//继续移动
								}
								function r_left() {
									if (dir = -1)
										dir = 1
								}//换向左移
								function r_right() {
									if (dir = 1)
										dir = -1
								}//换向右移
		
								var MyMar = setInterval(Marquee, speed)
							</script>
						</td>
						 
					</tr>
				</table>
			</div>    		
    	</div>
    	<br />

    	<div id="right_baidu" class="right_baidu">
    		<img src="/jee-moviesell/pic/index/20140604170941728609.jpg" width="240" height="157" style="cursor: pointer;" onclick="javascript:void(0);"/>
    	</div>
        <br />

    	<div id="right_banner" class="right_banner">
    		<img src="/jee-moviesell/pic/index/banner.jpg" width="238" height="157" style="cursor: pointer;" onclick="javascript:void(0);"/>
    		
    	</div>
    
    
	</div>    
	<!--  右部分结束-->
</div>
<!--网页主体 结束 -->


<!-- 下部链接 -->
<div id="footer_linkarea" class="footer_linkarea">
 <table width="995" id="footer_tab" class="footer_tab" >
      <tr>
        <td width="98" rowspan="3"><img src="../pic/footer/footer_1.png" title="投诉建议" width="98" height="149" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_2.png" title="在线客服" width="188" height="42" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_3.png" title="客服热线：400-800-6060" width="201" height="40"  /></td>
        <td width="249"><img src="/jee-moviesell/pic/footer/footer_4.png" title="万达生活" width="249" height="41" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td width="253" rowspan="3"><img src="/jee-moviesell/pic/footer/footer_11.png" title="二维码" width="253" height="151" /></td>
      </tr>
      <tr>
        <td><img src="/jee-moviesell/pic/footer/footer_5.png" title="兑换码使用帮助" width="187" height="44" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td><img src="/jee-moviesell/pic/footer/footer_6.png" title="IMAX" width="196" height="41" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
        <td rowspan="2"><img src="/jee-moviesell/pic/footer/footer_10.png" title="万达观影指数" width="249" height="103" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
      </tr>
      <tr>
        <td colspan="2"><img src="/jee-moviesell/pic/footer/footer_7.png" title="购票流程" width="126" height="48" style="cursor: pointer;" onclick="javascript:location='/jee-moviesell/jsp/helper/helper_howtobuy.jsp';" />&nbsp;&nbsp;<img src="/jee-moviesell/pic/footer/footer_8.png" title="取票流程" width="125" height="49" style="cursor: pointer;" onclick="javascript:void(0);" />&nbsp;<img src="/jee-moviesell/pic/footer/footer_9.png" title="退票流程" width="127" height="49" style="cursor: pointer;" onclick="javascript:void(0);" /></td>
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
    <img src="/jee-moviesell/pic/cnnic.png" width="51" height="20"  style="cursor:pointer;" onclick="javascript:void(0);"/>
    <img src="/jee-moviesell/pic/cert.png" width="51" height="20"  style="cursor:pointer;" onclick="javascript:void(0);"/>
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
<script>attachMenu(main_menu_ul);</script>
</body>
</html>