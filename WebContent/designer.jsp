<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	String path=request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/index.css" rel="stylesheet">
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.customer != null || sessionScope.company != null || sessionScope.designer != null || sessionScope.supply  != null}">
			<c:import url="/mycommon/top.jsp"></c:import>
		</c:when>
		<c:otherwise>
			<c:import url="/mycommon/topframe.jsp"></c:import>
		</c:otherwise>
	</c:choose>
<div class="carousel"><img src="<%=path %>/img/designerimg/1.jpg" width="100%" style="margin-top: 59px;"></div>
<div class="container">
		<div class="company">
		<c:forEach items="${sessionScope.designerpage }" var="des">
		<div class="col-lg-4" class="navbar-brand">
			<img class=""
				src="<%=path %>/${des.headicon }"
				alt="Generic placeholder image" width="220" height="220">
			<h2 style="margin-left: 20%;">${des.name}</h2>
			<p style="margin-left: 20%;">
				<a class="btn btn-default" href="<%=path%>/designer/desdetail?id=${des.id }" role="button">
				查看详情 &raquo;</a>
			</p>
		</div>
	</c:forEach>
	</div>
	</div>
	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="<%=path %>/common/desi?pageNo=${currPage - 1 }"><span
					aria-hidden="true">&larr;</span> 上一页</a></li>
			<li class="next"><a
				href="<%=path %>/common/desi?pageNo=${currPage + 1 }"><span
					aria-hidden="true">&rarr;</span>下一页 </a></li>
		</ul>
	</nav>
	
	<%@ include file="mycommon/bottom.jsp"%>
	<script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
</body>
</html>