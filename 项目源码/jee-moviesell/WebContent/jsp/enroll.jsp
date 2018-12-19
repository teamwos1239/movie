<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册_成为会员</title>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_top.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/login_footer.css"/>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/index_top.css"/>

<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/allstyle.css"/>
<script type="text/javascript" src="/jee-moviesell/js/jsCheck.js"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/jsCheck.css" /> 
 
</head>

<body  onload="createCode();">

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
				
				<select id="select_city" class="select_city" name="" onchange="findCityHelp('jsp/helper/helper_howtobuy.jsp',this.value);"> 
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
            <span id="link2" class="link"><a href="#" style="color:#999;text-decoration:none;">我的订单</a></span>
            <span id="link-2" class="link">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
            <span id="link3" class="link"><a href="/jee-moviesell/jsp/index.jsp" style="color:#999;text-decoration:none;">首页</a></span> 
        </div>
	</div> 
	<br/>
</div>
<div id="top_logo" class="top_logo"> 
    <div id="logo_div" class="logo_div">	
    	<img src="/jee-moviesell/pic/logo.png" width="251" height="59" id="logo" class="logo" style="margin-bottom: 11px;"/>
     </div>
</div>   

<div id="top_nav" class="top_nav"> 
</div>
<!--  网页头部结束 -->

<div id="content" class="content" style="font-size:16px; color:#666; font-family: '微软雅黑';">
	<div id="main" class="main" style="margin-left:10%; width:70%; margin:0 auto;border-left: 1.5px #999 solid; border-right:1.5px #999 solid; padding:0 20px;">
   		<br />
        <h2 style="color: #666; font-weight:normal; ">欢迎加入万达电影网</h2>
        <div style="width: 100%;height: 2px;background: #5DB6E0;"></div>
        <br />
        <br/>
        <div style="margin-left:30%;"><!--/jee-moviesell/UserEnrollServlet  -->
            <form id="loginform" name="loginform" action="/jee-moviesell/UserEnrollServlet" method="post" onsubmit="return formCheck();">
            <table>
                <tr>
                    <td style="text-align:right">邮箱：</td>
                    <td><input type="text" name="uemail" id="uemail" style="height: 26px; width:200px; color:#909090; line-height:28px;"/></td>
                    <td><span id="msg" style="font-size:12px;">请输入您的邮箱</span></td>
                </tr>
                <tr>
                	<td colspan="3"><br /> </td>
                </tr>
                <tr>
                    <td style="text-align:right">验证码：</td>
                    <td>
                    	<input type="text" name="ucheck" id="input1" style="height: 26px; width:105px; color:#909090; line-height:28px;" />
                    	<input type="button" id="checkCode" class="code" style="cursor:pointer;width: 75px;margin-left: 9px;border: 1px #5EB7E2 solid;height: 31px;font-size: 20px;" onclick="createCode()" />
                    </td>
                    <td style="font-size:12px;"><a href="#" onclick="createCode()">看不清楚</a></td>
                </tr>
                <tr>
                	<td colspan="3"><br /> </td>
                </tr>
                
                <tr>
                	<td colspan="3"><br /> </td>
                </tr>
                
                <tr>
                    <td style="text-align:right">密码：</td>
                    <td><input type="password" name="upass" id="upass" style="height: 26px; width:200px; color:#909090; line-height:28px;"/></td>
                    <td></td>
                </tr>
                <tr>
                	<td colspan="3"><br /> </td>
                </tr>
                
                <tr>
                    <td style="text-align:right">确认密码：</td>
                    <td><input type="password" name="upass2" id="upass2" style="height: 26px; width:200px; color:#909090; line-height:28px;"/></td>
                    <td></td>
                </tr>
                <tr>
                	<td colspan="3"><br /> </td>
                </tr>
                
                
             </table>
                
                <div  style="margin-left: 21%;">
            	    <input type="submit" value="注册" id="enrollsubmit" style="background: #5DB6E0;text-shadow: none;border: 0;font-size: 18px;height: 34px;color: #fff;width: 76px;"   />
                </div>
               
            
            </form>
            
             <div id="enrollMsg" class="enrollMsg">
				<c:if	test="${!empty requestScope.enrolluserflag}">
					<div class="enrolluserflag" id="enrolluserflag">
							<c:if test="${requestScope.enrolluserflag==true}">
								<script>
									alert('用户注册成功~');
								</script>
							</c:if>
							<c:if test="${requestScope.enrolluserflag==false}">
								<script>
									alert('用户注册失败~');
								</script>
							</c:if>
					</div>
				</c:if>
				
				<c:if test="${!empty requestScope.enrollEmailFlag&&requestScope.enrollEmailFlag==false}">
					<script>
						alert("该邮箱已经被注册了！");
					</script>
				</c:if>
				    
            </div>
            
        </div>
        <br />
        <br />
        <span style="font-size:12px;">已有账号?
            <a href="/jee-moviesell/jsp/login.jsp" style="text-decoration:none; color:#2E92CF;">直接登录</a>&nbsp;|&nbsp;使用其它网站账号登录:
            <img src="/jee-moviesell/pic/sina.png" width="29" height="23" style="cursor:pointer;" onclick="javascript:void(0);"/>
            <img src="/jee-moviesell/pic/doubai.png" width="25" height="21"  style="cursor:pointer;" onclick="javascript:void(0);"/>
            <img src="/jee-moviesell/pic/zhifubao.png" width="20" height="20"  style="cursor:pointer;" onclick="javascript:void(0);"/>
        </span>
        
    </div>
    <br />
    <br />
</div>


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
<script type="text/javascript">
 
	
</script>


</body>
</html>