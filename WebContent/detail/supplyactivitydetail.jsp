<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/css/css/casedetail.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<style type="text/css">
img {
	height: 60%;
	width: 80%;
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${sessionScope.customer != null || sessionScope.company != null || sessionScope.designer != null || sessionScope.supply  != null}">
				<c:import url="/mycommon/top.jsp"></c:import>
			</c:when>
			<c:otherwise>
				<c:import url="/mycommon/topframe.jsp"></c:import>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="divs">
		<div class="col-lg-3 center-block"></div>
		<div class="div_si col-lg-6">
			<p>活动名称：${requestScope.supact.name}</p>
			<p>活动发布时间：${requestScope.supact.created_time}</p>
			<p>简介:${requestScope.supact.des}</p>
		</div>
		<div class="col-lg-3 center-block"></div>
	</div>
	<div class="tab-content container">
		<div ><img src="<%=path %>/${requestScope.supact.image}" class="center-block"></div>
	</div>
	<div>
		<img src="../img/banquan.png" style="width:100%;">
	</div>

	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/customer/companycase_col.js"></script>
</body>
</html>