<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>



<%
	Calendar calendar=Calendar.getInstance();
	out.print("month===="+(calendar.get(Calendar.MONTH)+1));
	out.print("day===="+calendar.get(Calendar.DAY_OF_MONTH));
	
%>
 

</body>
</html>