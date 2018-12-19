<%@page import="com.chinasoft.moviesell.domain.gai.ShowmoiveItem"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影排期</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_footer.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/movietimes_main.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/footer_linkarea.css"/>
<script type="text/javascript" src="/jee-moviesell/js/index/top_nav.js"></script>
<script type="text/javascript" src="/jee-moviesell/js/index/footer_linkarea.js"></script> 
<script type="text/javascript" src="/jee-moviesell/js/index/movietimes_choose.js"></script> 
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/gotop.css" /> 
<style type="text/css">
	a{
		cursor:pointer; 
		
	}
</style>

 
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

<script type="text/javascript">
	
	function find(c){
		document.getElementById('selectedCno').value=c;
		location='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno='+c;
		
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
					
					<select id="select_city" class="select_city" name="" onchange="find(this.value);"> 
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
					<input id="selectedCno" name="cno" type="hidden" value="${sessionScope.selectedCity}"/>
				</div>
			
			<c:if test="${requestScope.flag==null||empty requestScope.flag}">
					
				<script>
				//	if(document.getElementById('select_city').value.length!=0&&document.getElementById('select_city').value!='')	
					//	find(document.getElementById('select_city').value);
				
					var selec=document.getElementById('select_city');
					if(selec.getElementsByTagName('option').length==0){
						
					}else{
						find(document.getElementById('select_city').value);
					}
				</script>
								
			</c:if>
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
		<li><a href="#" >电影排期</a></li>
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

<%!Calendar calendar=Calendar.getInstance(); %>
<%
	Date trialTime = new Date();
	calendar.setTime(trialTime);
	
	
	String[] cArr={
			"今日上映"+(calendar.get(Calendar.MONTH)+1)+"月"+calendar.get(Calendar.DAY_OF_MONTH)+"日",
			"明日上映"+(calendar.get(Calendar.MONTH)+1)+"月"+(calendar.get(Calendar.DAY_OF_MONTH)+1)+"日",
			"预售"+(calendar.get(Calendar.MONTH)+1)+"月"+(calendar.get(Calendar.DAY_OF_MONTH)+2)+"日"
	};
	
	request.setAttribute("cArr", cArr);
%>




<!--网页主体  -->
<div id="content" class="content" >
  <table id="content_tab" class="content_tab" cellspacing="0" cellpadding="0">
    <tr>
      <th style="width: 174px;">放映日期</th> 
      <th style="width: 217px;">影城</th> 
      <th style="width: 174px;">影片</th> 
      <th style="width: 81px;">时间</th>
      <th style="width: 174px;">版本  <a href="" class="version" id="version"></a></th> 
    </tr>
    <tr>
      <td>
      	<div id="" class="filmdate"> 
      		<c:if test="${requestScope.stimeFlag==null||empty requestScope.stimeFlag}">
      			<%
      				request.setAttribute("stimeFlag", 0);
      			%>
      		</c:if>
      		
      		<c:forEach items="${requestScope.cArr}" var="cal" varStatus="i">
      			<c:if test="${requestScope.stimeFlag==(i.count-1) }">
		      		<a onclick="onclickSelect('${(i.count-1)}','stimeSelected'); " name="" id="" class="onc">${cal }</a>
	      		</c:if>
	      		<c:if test="${requestScope.stimeFlag!=(i.count-1) }">
		      		<a onclick="onclickSelect('${(i.count-1)}','stimeSelected'); " name="" id="" class="">${cal }</a>
	      		</c:if>
      		</c:forEach>
      	
      		<input id="stimeSelected" name="stimeSelected" type="hidden" value="${requestScope.stimeFlag }"/>
      		
      	</div>
      </td>
      <td>
      	<div id="" class="filmtheatre">
	      	<c:forEach items="${requestScope.allTheatreSet }" var="theatreSet">
	      		<c:if test="${requestScope.selectedTheatres.tname==theatreSet.tname }">
			      	<a  name="" id="" onclick="onclickSelect('${theatreSet.tno}','selectedTno'); " class="onc">${theatreSet.tname}</a>
	      		</c:if>
	      		<c:if test="${requestScope.selectedTheatres.tname!=theatreSet.tname }">
			      	<a  name="" id="" onclick="onclickSelect('${theatreSet.tno}','selectedTno'); " class="">${theatreSet.tname}</a>
	      		</c:if>
	      	</c:forEach>
	      	<input id="selectedTno" name="tno" type="hidden" value="${requestScope.selectedTheatres.tno}"/>
      		
	      	
      	</div>
      </td>
      <td>
		 <div id="" class="filmname">
		 	<c:if test="${requestScope.selectedMovies==null||empty requestScope.selectedMovies }">
			 	<a href="javascript: void(0);" class="onc" id="all" onclick="onclickSelect('','selectedMno');">&nbsp;全部</a>
			</c:if>
		 	<c:if test="${requestScope.selectedMovies!=null&&!empty requestScope.selectedMovies }">
			 	<a href="javascript: void(0);" class="" id="all" onclick="onclickSelect('','selectedMno');">&nbsp;全部</a>
			</c:if>
		 
		 
		 	<c:forEach items="${requestScope.allMovieSet }" var="movieSet">
		 	
		 		<c:if test="${requestScope.selectedMovies.mname==movieSet.mname }">
			      	<a  name="" id="" onclick="onclickSelect('${movieSet.mno}','selectedMno'); " class="onc">${movieSet.mname}</a>
	      		</c:if>
	      		<c:if test="${requestScope.selectedMovies.mname!=movieSet.mname }">
			      	<a  name="" id="" onclick="onclickSelect('${movieSet.mno}','selectedMno'); " class="">${movieSet.mname}</a>
	      		</c:if>
		 	
		 	</c:forEach>  
		 	
	      	<input id="selectedMno" name="mno" type="hidden" value="${requestScope.selectedMovies.mno}"/>
	     </div>
      </td>
      <td>
      
      	<%
      		String[] filmtimeArr={"全部","上午","下午","晚上"};
   		 	request.setAttribute("filmtimeArr", filmtimeArr);
      	%>
	      <div id="" class="filmtime">
	      
	      	<c:if test="${requestScope.dayFlag==null||empty requestScope.dayFlag}">
      			<%
      				request.setAttribute("dayFlag", 0);
      			%>
      		</c:if>
      		
      		<c:forEach items="${requestScope.filmtimeArr}" var="daytime" varStatus="i">
      			<c:if test="${requestScope.dayFlag==(i.count-1) }">
		      		<a onclick="onclickSelect('${(i.count-1)}','selectedDayTime'); " name="" id="" class="onc">${daytime }</a>
	      		</c:if>
	      		<c:if test="${requestScope.dayFlag!=(i.count-1) }">
		      		<a onclick="onclickSelect('${(i.count-1)}','selectedDayTime'); " name="" id="" class="">${daytime }</a>
	      		</c:if>
      		</c:forEach>
	        	
	      	<input id="selectedDayTime" name="selectedDayTime" type="hidden" value="${requestScope.dayFlag}"/>
	    
	      </div>
      	</td>
	    <td style="vertical-align: middle;">
	    		<%
	    			String[] versionArr1={"全部","3D","IMAX-3D"};
	    			String[] versionArr2={"2D","IMAX-2D","XLAND"};
	       		 	request.setAttribute("versionArr1", versionArr1);
	       		 	request.setAttribute("versionArr2", versionArr2);
	    		%>
	    
		    	<c:if test="${requestScope.versionFlag==null||empty requestScope.versionFlag}">
	      			<%
	      				request.setAttribute("versionFlag", 0);
	      			%>
	      		</c:if>
	      		
	      		<div id="" class="row1">
			      	
			      	<c:forEach items="${requestScope.versionArr1}" var="ver" varStatus="i">
	      				<c:if test="${requestScope.versionFlag==(i.count-1) }">
			      			<a onclick="onclickSelect('${(i.count-1)}','selectedVersion'); " name="" id="" class="onc">${ver }</a>
		      			</c:if>
		      			<c:if test="${requestScope.versionFlag!=(i.count-1) }">
			      			<a onclick="onclickSelect('${(i.count-1)}','selectedVersion'); " name="" id="" class="">${ver }</a>
		      			</c:if>
	      			</c:forEach>
			      	
			      	
	      		</div>
	      		<div id="" class="row2">      		
			      	
			      	<c:forEach items="${requestScope.versionArr2}" var="ver"  varStatus="i">
	      				<c:if test="${requestScope.versionFlag==(i.count+2) }">
			      			<a onclick="onclickSelect('${(i.count+2)}','selectedVersion'); " name="" id="" class="onc">${ver }</a>
		      			</c:if>
		      			<c:if test="${requestScope.versionFlag!=(i.count+2) }">
			      			<a onclick="onclickSelect('${(i.count+2)}','selectedVersion'); " name="" id="" class="">${ver }</a>
		      			</c:if>
	      			</c:forEach>
			      	
	      		</div>  
	      		<input id="selectedVersion" name="selectedVersion" type="hidden" value="${requestScope.versionFlag}"/>
	      </td>
	    </tr>
  	</table>
	  
	<div id="" class="content_tui">
		不晚于影片开场前1小时可办理退票 | 了解更多退票政策 
	</div>
	 <br>
	 <br>
	 
	 
	 <c:forEach items="${requestScope.mainMovieSet }" var="movieS" varStatus="i">
	 	<br>
		<br>
		<div id="content_nav" class="content_nav">
			<c:forEach items="${requestScope.cArr}" var="cal" varStatus="i">
      			<c:if test="${requestScope.stimeFlag==(i.count-1) }">
		      		${cal }
	      		</c:if>
      		</c:forEach>
			 &#62;&#62;  <a href="javascript:location='/jee-moviesell/HelperFindTheatreServlet?tno=${requestScope.selectedTheatres.tno }';" onMouseMove="" onMouseOut="">${requestScope.selectedTheatres.tname }</a>&#62;&#62; <a href="javascript:location='/jee-moviesell/FilmInfoMovieServlet?mno=${movieS.mno}';" onMouseMove="" onMouseOut="">${movieS.mname}</a>
		</div>
		<br>
		<br>
		<div id="content_theatres" class="content_theatres">
			<table width="200" border="0" cellpadding="0" cellspacing="0" id="choose_tab" class="choose_tab">
			  <tr id="" class="tab_header">
			    <td>放映时间</td>
			    <td>厅</td> 
			    <td>影厅空位</td>
			    <td>语言</td>
			    <td>版本</td>
			    <td>片长</td>
			    <td>优惠信息</td>
			    <td>网购价</td>
			    <td>购票</td>
			  </tr>
			  
				 <c:forEach items="${requestScope.lstShowmoiveItemItem }" var="showmoiveItemItem" varStatus="j">
				 	
				 	<c:if test="${showmoiveItemItem.smname==movieS.mname }">
						<tr id="" class="tab_content">
							<td class="row_time">
					<%-- 		  <%!String birhtady; %>
							  <%

								SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm",Locale.CHINA);
								if(request.getAttribute("showmoiveItemItem")!=null){
									ShowmoiveItem showmoiveItem=(ShowmoiveItem)request.getAttribute("showmoiveItemItem");
									birhtady=dateFormat.format(showmoiveItem.getStime());
								}
						 		%>
							
							 <%=birhtady%> --%>
							${showmoiveItemItem.stime }
							</td>
							<td>${showmoiveItemItem.shallno }</td>
							<td class="row_seats"><span style="float: left;margin-left: 5px;">余157/</span><span class="i">246</span><span class="tab_seat"  >座</span></td>
							<td class="row_language">${showmoiveItemItem.slanguage}</td>
							<td class="row_version">${showmoiveItemItem.smversion}</td>
							<td class="row_length">${showmoiveItemItem.smlength}分钟</td>
							<td class="row_special">
							<span class="tab_ka"  >卡</span>
							<span class="tab_quan"  >券</span>
							</td>
							<td class="row_price">
								<p style="color: #DD4B39">${showmoiveItemItem.sprice}元</p>
							</td>
							<td class="row_btn">
							<button class="" onclick="javascript:location='/jee-moviesell/FindShowmoiveItemByIdServlet?sno=${showmoiveItemItem.sno}';">购票</button>
							</td>
						</tr>
					</c:if>
			   </c:forEach>
			</table>

		</div>		
	 </c:forEach>
	  
</div>
<!--网页主体 结束 -->

<br>
<br>
<br>
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
        <td colspan="2"><img src="/jee-moviesell/pic/footer/footer_7.png" title="购票流程" width="126" height="48" style="cursor: pointer;" onclick="javascript:location='/jee-moviesell/jsp/helper/helper_howtobuy.jsp';"/>&nbsp;&nbsp;<img src="/jee-moviesell/pic/footer/footer_8.png" title="取票流程" width="125" height="49" style="cursor: pointer;" onClick="javascript:void(0);" />&nbsp;<img src="/jee-moviesell/pic/footer/footer_9.png" title="退票流程" width="127" height="49" style="cursor: pointer;" onClick="javascript:void(0);" /></td>
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
<script>attachChoose(content_tab);</script> 

</body>
</html>