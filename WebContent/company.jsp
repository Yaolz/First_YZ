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
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/css/company.css" rel="stylesheet">
</head>
<style>
.fontss{
font-size: 20px;
}
</style>
<body>
	<c:choose>
		<c:when test="${sessionScope.customer != null || sessionScope.company != null || sessionScope.designer != null || sessionScope.supply  != null}">
			<c:import url="/mycommon/top.jsp"></c:import>
		</c:when>
		<c:otherwise>
			<c:import url="/mycommon/topframe.jsp"></c:import>
		</c:otherwise>
	</c:choose>
	<input type="hidden" id="cus_id" value="${sessionScope.customer.id }" />
	<div class="carousel">
		<img src="<%=path%>/img/companyimg/company-banner.jpg" width="100%" style="margin-top: 59px;">
	</div>
	<div class="container fontss">
	<c:forEach items="${sessionScope.companypage }" var="com">
		<div class="company">
				<div class="col-lg-6 brands">
					<div class="brand">
						<img class="imgs"  style="padding-left: 10%;" src="<%=path%>/${com.logo }" width="80%" height="200">
						<p style="margin-left:40%;">${com.name }</p>
						<a style="margin-left: 40%;" class="btn btn-default" id="choose" role="button" href="<%=path %>/company/comdetail?id=${com.id }">查看详情&raquo;</a>
					</div>
				</div>
		</div>
		</c:forEach>
	</div>
	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="<%=path %>/common/companys?pageNo=${currPage - 1 }"><span
					aria-hidden="true">&larr;</span> 上一页</a></li>
			<li class="next"><a
				href="<%=path %>/common/companys?pageNo=${currPage + 1 }"><span
					aria-hidden="true">&rarr;</span>下一页 </a></li>
		</ul>
	</nav>

	<%@ include file="mycommon/bottom.jsp"%>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/customer/company_col.js"></script>
</body>
</html>