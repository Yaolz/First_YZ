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
	<div class="div_bor">
		<div class="div_font">设计师档案</div>
	</div>
	<div class="container container_div">
		<div class="div_img col-lg-4">
			<img src="<%=path%>/${requestScope.desi.headicon }">
			<ul>
				<li class="div_li"><span>200</span> <span>案例</span></li>
				<li class="div_li"><span>50</span> <span>咨询</span></li>
				<li><span>2</span> <span>粉丝</span></li>
			</ul>
		</div>
		<div class="div_right col-lg-8">
			<div class="div_size">
			<input type="hidden" id="des_id" value="${requestScope.desi.id }">
				<span>${requestScope.desi.name }</span> 
				<img src="<%=path%>/img/detail/v.gif">
				<span class="div_zhen" title="已认证">证</span> <a class="btn btn-primary btn-lg a ctive">在线预约</a>
				<c:if test="${requestScope.saved == false }">
					<a onclick="designer_col();" id="save" type="button"
						class="btn btn-primary btn-lg a ctive">收藏</a>
				</c:if>
				<c:if test="${requestScope.saved == true }">
					<a id="save" type="button" class="btn btn-info btn-lg active" disabled="disabled">已收藏</a>
				</c:if>
			</div>
			<div class="div_size">
				<span>电话:</span> <span>${requestScope.desi.phone }</span> 
			</div>
			<div class="div_size">
				<span>地址:${requestScope.desi.address }</span>
			</div>
			<div class="div_size">
				 <span>擅长风格:${requestScope.desi.style }</span>
			</div>
			<div class="div_size">
				<span>个人简介：</span> <span>${requestScope.desi.des }</span>
			</div>
		</div>
	</div>
	<div class="descase">
		<h2>所有设计案例:</h2>
		<c:forEach items="${requestScope.desicase}" var="desicase">
			<div class="col-lg-4">
				<img src="<%=path%>/${desicase.image_1}">
				<p>${desicase.name }</p>
				<p>${desicase.des }</p>
				<p>
					<a class="btn btn-default" href="<%=path%>/descase/casedetail?id=${desicase.id}" role="button">查看详情
						&raquo;</a>
				</p>
			</div>
		</c:forEach>
	</div>
	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="<%=path %>/designer/desdetail?pageNo=${currPage - 1 }&id=${requestScope.des.id }"><span
					aria-hidden="true">&larr;</span> 上一页</a></li>
			<li class="next"><a
				href="<%=path %>/designer/desdetail?pageNo=${currPage + 1 }&id=${requestScope.des.id }"><span
					aria-hidden="true">&rarr;</span>下一页 </a></li>
		</ul>
	</nav>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path %>/js/customer/designer_col.js"></script>
</body>
</html>