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

	<!-- 平台标识 -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide" src="<%=path %>/img/indeximg/1.jpg"
					alt="First slide" style="margin-top: 59px;">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="<%=path%>/img/designerimg/1.jpg"
					alt="Second slide" style="margin-top: 59px;">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="<%=path %>/img/indeximg/3.jpg"
					alt="Third slide" style="margin-top: 59px;">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- 装修公司 -->
	<div class="company">
		<div class="container">
			<div class="row">
				<c:forEach items="${sessionScope.com }" var="com">
					<div class="col-lg-4" class="navbar-brand">
						<img  src="<%=path %>/${com.logo }"
							alt="Generic placeholder image" width="280" height="200">
						<h2 style="margin-left: 20%;">${com.name }</h2>
						<p style="margin-left: 20%;">${com.des }</p>
						<p style="margin-left: 20%;">
							<a class="btn btn-default" href="<%=path %>/company/comdetail?id=${com.id }" role="button">查看详情
								&raquo;</a>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div>
			<p class="text-right"><a class="fons" href="<%=path %>/common/companys">查看更多>></a></p>
		</div>
	</div>
	<!-- 设计案例 -->
	<div class="company">
		<div class="container">
			<div class="row">
				<c:forEach items="${sessionScope.comcase }" var="comcase">
					<div class="col-lg-4 brand" class="navbar-brand">
						<img src="<%=path %>/${comcase.image_1}" alt="" width="370"
							height="360">
						<h3 class="text-center">${comcase.style }</h3>
						<p style="margin-left: 20%;">${comcase.des }</p>
						<p style="margin-left: 35%;">
							<a  class="btn btn-default" href="<%=path%>/comcase/casedetail?id=${comcase.id }" role="button">查看详情
								&raquo;</a>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div>
			<p class="text-right"><a class="fons" href="<%=path %>/common/descase">查看更多>></a></p>
		</div>
	</div>
	<!-- 设计师 -->
	<div class="company">
		<div class="container">
			<div class="row">
				<c:forEach items="${sessionScope.des }" var="des">
					<div class="col-lg-4 " class="navbar-brand">
						<img class="img-circle" src="<%=path %>/${des.headicon }"
							alt="Generic placeholder image" width="200" height="200">
						<h2 style="margin-left: 16%;">${des.name }</h2>
						<p style="margin-left: 20%;"></p>
						<p style="margin-left: 16%;">
							<a class="btn btn-default" href="<%=path%>/designer/desdetail?id=${des.id }" role="button">查看详情
								&raquo;</a>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div>
			<p class="text-right"><a class="fons" href="<%=path%>/common/desi">查看更多>></a></p>
		</div>
	</div>

	<div class="company">
		<div class="container goods">
			<div class="row">
			<c:forEach items="${sessionScope.sup }" var="sup">
				<div class="col-lg-4">
					<a href="<%=path%>/supply/supidetail?id=${sup.id }"><img class="iu" onmouseout="this.className='iu'"
						onmouseover="this.className='ui'"
						data-original="<%=path %>/${sup.logo  }"
						src="<%=path %>/${sup.logo }" style="display: block;"></a>
						<p style="margin-left: 20%;">${sup.name }</p>
				</div>
			</c:forEach>
			</div>
		</div>
		<div>
			<p class="text-right"><a class="fons" href="<%=path %>/common/supplys">查看更多>></a></p>
		</div>
	</div>
	<%@ include file="mycommon/bottom.jsp"%>
	<script src="<%=path %>/assets/js/ie-emulation-modes-warning.js"></script>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
</body>
</html>
