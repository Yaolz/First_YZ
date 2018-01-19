<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form id="form" method="post">
		<input type="hidden" name="com_id" value="${requestScope.com.id }">
		<input type="hidden" name="app_name" value="${requestScope.com.name }">
			<table class="table">
				<tr>
					<td>您的称呼：</td>
					<td><input type="text" name="name" id="name"
							placeholder="请输入您的称呼"></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input type="text" name="phone" id="phone"
							placeholder=“请输入您的手机号方便联系”
							onkeyup="value=value.replace(/[^(\d)]/g,'')" maxlength="11"></td>
				</tr>
				<tr>
					<td>所在小区：</td>
					<td><input type="text" name="plot_name" id="plot_name"
							placeholder=“请输入您所要装修的小区”></td>
				</tr>
				<tr>
					<td>建筑面积：</td>
					<td><input type="text" name="area" id="area"
							placeholder=“请输入您的建筑面积”
							onkeyup="value=value.replace(/[^(\d)]/g,'')"></td>
				</tr>
				<tr>
					<td>装修方式：</td>
					<td><input type="text" name="way" id="way"></td>
				</tr>
				<tr>
					<td>装修预算：</td>
					<td>
						
						<select name="budget" class="form-control">
							<option>8-15万</option>
							<option>15-25万</option>
							<option>25万以上</option>
						</select>
					</td>
				</tr>
			</table>
			<button class="btn btn-succse" type="button" onclick="company_app();">确认预约</button>
		</form>
	</div>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/customer/app.js"></script>
</body>
</html>