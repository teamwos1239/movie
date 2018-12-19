<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<script type="text/javascript" src="/jee-moviesell/js/jsCheck.js"></script>
<link rel="stylesheet" type="text/css" href="/jee-moviesell/css/jsCheck.css" /> 


</head> 
<body onLoad="createCode();">

	<input type="text" id="input1" />
	<input type="button" id="checkCode" class="code" style="width: 60px"
		onClick="createCode()" />
	<a href="#" onClick="createCode()">看不清楚</a>
	<input id="Button1" onClick="validate();" type="button" value="确定" />
	<script></script>
</body>
</html>