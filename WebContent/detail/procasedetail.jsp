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
<link href="<%=path %>/css/css/casedetail.css" rel="stylesheet">
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/css/company.css" rel="stylesheet">
<style type="text/css">
img{
	height:60%;
	width:80%;
	text-align: center;
}
</style>
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
	<input type="hidden" id="cus_id" value="${sessionScope.customer.id }" />
	<div class="tab-content container">
		<div role="tabpanel" class="tab-pane active" id="home">
			<div class="col-lg-2">
			</div>
			<div class="col-lg-8center-block">
				<img class="center-block"  src="<%=path %>/img/indeximg/${requestScope.supdetail.image}">
			</div>
			<div class="col-lg-2">
			</div>
		</div>
	</div>
	
	<div class="divs">
		<div class="col-lg-3">
		</div>
		<div class="div_si col-lg-6">
		<input type="hidden" id="pro_id" value="${requestScope.supdetail.id }">
			<span>商品名称：${requestScope.supdetail.name}</span>
			<span>价格：${requestScope.supdetail.price}</span>
			<span>折后价格：${requestScope.supdetail.sale_price}</span>
			<p>商品特色:${requestScope.supdetail.des}</p>
			<img src="<%=path %>/${requestScope.supdetail.image}" style="width:650px; height:450px;">
			<c:if test="${requestScope.saved == false }">
				<a onclick="prodetail_col();" id="save" type="button"
					class="btn btn-primary btn-lg a ctive">收藏</a>
			</c:if>
			<c:if test="${requestScope.saved == true }">
				<a id="save" type="button" class="btn btn-info btn-lg active" disabled="disabled">已收藏</a>
			</c:if>
		</div>
		<div class="col-lg-3">
		</div>
	</div>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/customer/prodetail_col.js"></script>
</body>
</html>