<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="/jee-moviesell/ShowCitiesServlet">
	<input type="submit" value="显示所有城市 "/>

</form>
<form action="/jee-moviesell/AddCitiesServlet">
	城市名称：<input type="text" name="cname"/>
	所在省份：<input type="text" name="cprovince"/>
	
	<input type="submit" value="添加 "/>

</form>

<form action="/jee-moviesell/DeleteCitiesServlet">
	城市cno：<input type="text" name="cno"/>
 
	
	<input type="submit" value="shanchu "/>

</form>


<form action="/jee-moviesell/UpdateCitiesServlet">
	
	<input type="submit" value="更新"/>

</form>


</body>
</html>