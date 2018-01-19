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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/css/supply.css" rel="stylesheet">
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
	<div class="carousel">
		<img src="<%=path%>/img/supply/no1.png" width="100%" style="margin-top: 59px;">
	</div>
	<c:forEach items="${sessionScope.supplypage }" var="sup">
		<div class="container bgcolor" style="font-size:20px; ">
			<div class="col-lg-4" style="padding-top: 70px;">
				<ul class="list-inline">
					<li><div>
							<img src="<%=path%>/${sup.logo}">
						</div>
					</li>
				</ul>
			</div>
			<div class="col-lg-8">
					<ul class="list-inline" style="padding-top: 20px;">
						<li><span>${sup.name }</span></li>
						<li>
							<div>
								<span
									style="background-color: #60aa2e; width: auto; padding: 0 5px; margin-left: 5px;">已认证
								</span>
							</div>
						</li>
						<li>
							<div>
								<p>
									<a class="btn btn-default" href="<%=path%>/supply/supidetail?id=${sup.id }" role="button">查看详情
										&raquo;</a>
								</p>
							</div>
						</li>
						<li>
							<div>
								<span>${sup.des }</span>
							</div>
						</li>
					</ul>
					<ul class="list-inline" style="padding-top: 20px;">
						<li>
							<img src="<%=path %>/img/supply/4.png">
						</li>
						<li>资质认证：贰级</li>
						<li>
							<img src="<%=path %>/img/supply/3.png">
						</li>
						<li>推荐</li>
					</ul>
					<ul class="list-inline" style="padding-top: 20px;">
						<li>
							<img src="<%=path %>/img/supply/2.png">
						</li>
						<li>营业执照已认证</li>
						<li>
							<img src="<%=path %>/img/supply/1.png">
						</li>
						<li>装修保证金:3000元</li>
					</ul>
					<ul class="list-inline" style="padding-top: 20px;">
						<li>服务区域：不限</li>
					</ul>
					<ul class="list-inline" style="padding-top: 20px;">
						<li>办公地址：</li>
						<li>${sup.address }</li>
					</ul>
				</div>
			</div>
	</c:forEach>

	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="<%=path %>/common/supplys?pageNo=${currPage - 1 }"><span
					aria-hidden="true">&larr;</span> 上一页</a></li>
			<li class="next"><a
				href="<%=path %>/common/supplys?pageNo=${currPage + 1 }"><span
					aria-hidden="true">&rarr;</span>下一页 </a></li>
		</ul>
	</nav>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
</html>