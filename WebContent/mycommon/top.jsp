<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar-wrapper">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="header clearfix"></div>
			<div class="navbar-header">
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/common/indexs"><span>首页</span></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse topfont">
				<ul class="nav navbar-nav">
					<li><a
						href="<%=request.getContextPath()%>/common/companys">装修公司</a></li>
					<li><a href="<%=request.getContextPath()%>/common/descase">设计案例</a></li>
					<li><a href="<%=request.getContextPath()%>/common/desi">设计师</a></li>
					<li><a href="<%=request.getContextPath()%>/common/supplys">建材商</a></li>
				</ul>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav nav-pills pull-right">
						<c:if test="${not empty sessionScope.company}">
							<li role="presentation"><a class="" href="<%=request.getContextPath()%>/company/home">
								尊敬的${sessionScope.company.name }公司，您好！</a></li>
						</c:if>
						<c:if test="${not empty sessionScope.supply}">
							<li role="presentation"><a class="" href="<%=request.getContextPath()%>/supply/home">
								尊敬的${sessionScope.supply.name }建材商，您好！</a></li>
						</c:if>
						<c:if test="${not empty sessionScope.designer }">
							<li role="presentation"><a class="" href="<%=request.getContextPath()%>/designer/home">
								亲爱的${sessionScope.designer.name }设计师，您好！</a></li>
						</c:if>
						<c:if test="${not empty sessionScope.customer }">
							<li role="presentation"><a class="" href="<%=request.getContextPath()%>/customer/home">
								亲爱的${sessionScope.customer.name }业主，您好！</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</nav>
</div>
