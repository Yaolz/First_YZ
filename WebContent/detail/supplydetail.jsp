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
<link href="<%=path%>/css/css/detail.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">

</head>
<style>
.div_right div {
    border-bottom: 1px dotted #eaeaea;
    line-height: 40px;
}
.uls{
margin-left: 30px;
}
</style>
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
	<input type="hidden" id="cus_id" value="${sessionScope.customer.id }"/>
	</div>
	<div class="div_bor">
		<div class="div_font">建材商</div>
	</div>
	<div class="container container_div">
		<div class="div_img col-lg-4">
			<img src="<%=path%>/${requestScope.supi.logo }" style="width:100%;">
			<ul class="uls">
				<li class="div_li"><span>200</span> <span>案例</span></li>
				<li class="div_li"><span>50</span> <span>咨询</span></li>
				<li><span>2</span> <span>粉丝</span></li>
			</ul>
		</div>
		<div class="div_right col-lg-8">
			<div class="div_size">
			<input type="hidden" id="sup_id" value="${requestScope.supi.id }">
				<span>${requestScope.supi.name }</span> <img
					src="<%=path%>/img/detail/v.gif"> <span class="div_zhen"
					title="已认证">证</span> <a class="btn btn-primary btn-lg a ctive">在线预约</a>
				<c:if test="${requestScope.saved == false }">
					<a onclick="supply_col();" id="save" type="button"
						class="btn btn-primary btn-lg active">收藏</a>
				</c:if>
				<c:if test="${requestScope.saved == true }">
					<a id="save" type="button" class="btn btn-info btn-lg active" disabled="disabled">已收藏</a>
				</c:if>
			</div>
			<div class="div_size">
				<span>负责人:${requestScope.supi.principal }</span>  
			</div>
			<div>
				<span class="div_size">地址:${requestScope.supi.address }</span>
			</div>
			<div>
				<span class="div_size">成立日期:${requestScope.supi.open_date }</span>
			</div>
			<div>
				<span class="div_size">固定电话:${requestScope.supi.tel }</span>
			</div>
			<div class="div_size">
				<span>公司简介：</span> <span>${requestScope.supi.des }</span>
			</div>
		</div>
	</div>
		<div class="container">
	<h2>建材商最新活动:</h2>
			<div class="row">
				<c:forEach items="${requestScope.supact }" var="supact">
					<div class="col-lg-4" class="navbar-brand">
						<img  src="<%=path %>/${supact.image }"
							alt="Generic placeholder image" width="280" height="200" class="center-block">
						<h2 style="margin-left: 20%;">${supact.name }</h2>
						<p style="margin-left: 20%;">${supact.des }</p>
						<p style="margin-left: 20%;">
							<a class="btn btn-default" href="<%=path %>/supactivity/supdetail?id=${supact.id }" role="button">查看活动
								&raquo;</a>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	<div class="descase">
		<h2>所有商品:</h2>
		<c:forEach items="${requestScope.proicase}" var="proicase">
			<div class="col-lg-4">
				<img src="<%=path%>/${proicase.image}">
				<p>${proicase.name }</p>
				<p>
					<a class="btn btn-default" href="<%=path%>/product/prodetail?id=${proicase.id}" role="button">查看详情
						&raquo;</a>
				</p>
			</div>
		</c:forEach>
	</div>
	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="<%=path %>/supply/supidetail?pageNo=${currPage - 1 }&id=${requestScope.supi.id}"><span
					aria-hidden="true">&larr;</span> 上一页</a></li>
			<li class="next"><a
				href="<%=path %>/supply/supidetail?pageNo=${currPage + 1 }&id=${requestScope.supi.id}"><span
					aria-hidden="true">&rarr;</span>下一页 </a></li>
		</ul>
	</nav>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/customer/supply_col.js"></script>
</body>
</html>