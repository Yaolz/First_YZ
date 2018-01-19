<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
</head>
<body>
	<form action="<%=path %>/admin/reg" method="post">
		邮箱：<input type="email" name="email"><br>
		密码：<input type="password" name="pwd"><br>
		名字：<input type="text" name="name"><br>
		手机号：<input type="text" name="phone"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>