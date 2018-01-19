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
	width: 800px;;
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
		<input type="hidden" id="cus_id" value="${sessionScope.customer.id }" />
	</div>
	<div class="divs">
		<div class="col-lg-3 center-block"></div>
		<div class="div_si col-lg-6">
			<input type="hidden" id="comcase_id"
				value="${requestScope.comdetail.id }">
			<p>案例名称：${requestScope.comdetail.name}</p>
			<p>装修风格：${requestScope.comdetail.style}</p>
			<p>简介:${requestScope.comdetail.des}</p>
			<c:if test="${requestScope.saved == false }">
				<a onclick="companycase_col();" id="save" type="button"
					class="btn btn-primary btn-lg a ctive">收藏</a>
			</c:if>
			<c:if test="${requestScope.saved == true }">
				<a id="save" type="button" class="btn btn-info btn-lg active" disabled="disabled">已收藏</a>
			</c:if>
		</div>
		<div class="col-lg-3 center-block"></div>
	</div>
	<div class="tab-content container">
		<div role="tabpanel" class="tab-pane active" id="home">
			<img class="center-block"
				src="<%=path %>/${requestScope.comdetail.image_1}" style="width:810px; height:500px;">
		</div>
		<div role="tabpanel" class="tab-pane" id="profile">
			<img class="center-block"
				src="<%=path %>/${requestScope.comdetail.image_2}"style="width:810px; height:500px;" >
		</div>
		<div role="tabpanel" class="tab-pane" id="messages">
			<img class="center-block"
				src="<%=path %>/${requestScope.comdetail.image_3}" style="width:810px; height:500px;">
		</div>
		<div role="tabpanel" class="tab-pane" id="settings">
			<img class="center-block" 
				src="<%=path %>/${requestScope.comdetail.image_4}" style="width:810px; height:500px;">
		</div>
		<div role="tabpanel" class="tab-pane" id="setting1">
			<img class="center-block"
				src="<%=path %>/${requestScope.comdetail.image_5}" style="width:810px; height:500px;">
		</div>
	</div>

	<div class="container">
		<div class="col-lg-3 center-block "></div>
		<div class="col-lg-6 center-block">
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#home"
					aria-controls="home" role="tab" data-toggle="tab">1</a></li>
				<li role="presentation"><a href="#profile"
					aria-controls="profile" role="tab" data-toggle="tab">2</a></li>
				<li role="presentation"><a href="#messages"
					aria-controls="messages" role="tab" data-toggle="tab">3</a></li>
				<li role="presentation"><a href="#settings"
					aria-controls="settings" role="tab" data-toggle="tab">4</a></li>
				<li role="presentation"><a href="#setting1"
					aria-controls="settings" role="tab" data-toggle="tab">5</a></li>
			</ul>
		</div>
		<div class="col-lg-3 center-block"></div>
	</div>

<div>
		<img src="../img/banquan.png" style="width:100%;">
	</div>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/customer/companycase_col.js"></script>
</body>
</html>