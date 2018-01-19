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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>入驻审核</title>

<link rel="shortcut icon" href="<%=path%>/favicon.ico">
<link href="<%=path%>/css/bootstrap.min14ed.css?v=3.3.6"
	rel="stylesheet">
<link href="<%=path%>/css/font-awesome.min93e3.css?v=4.4.0"
	rel="stylesheet">
<link href="<%=path%>/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="<%=path%>/css/animate.min.css" rel="stylesheet">
<link href="<%=path%>/css/css/common.css" rel="stylesheet">
<link href="<%=path%>/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12 ">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>管理员审核</h5>
					</div>
					<div class="ibox-content inputs">
						<table class="table table-striped">
							<tr>
								<th style="text-align: center;">管理员姓名</th>
								<th style="text-align: center;">邮箱</th>
								<th style="text-align: center;">手机</th>
								<th style="text-align: center;">状态</th>
								<th style="text-align: center;">操作</th>

							</tr>
							<c:forEach items="${requestScope.adm }" var="adm"
								varStatus="status">
								<c:choose>
									<c:when test="${adm.role == '普通管理员' }">
										<tr>
											<td>${adm.name }</td>
											<td>${adm.email }</td>
											<td>${adm.phone }</td>
											<td><c:choose>
													<c:when test="${adm.status == 'Y' }">通过</c:when>
													<c:when test="${adm.status == 'N' }">
														<span style="color: red;">未通过</span>
													</c:when>
													<c:otherwise>其他</c:otherwise>
												</c:choose></td>
											<td><c:choose>
													<c:when test="${adm.status == 'Y' }">
														<a href="<%=path %>/admin/adm_status?id=${adm.id }">冻结</a>
													</c:when>
													<c:when test="${adm.status == 'N' }">
														<a href="<%=path %>/admin/adm_status?id=${adm.id }">激活</a>
													</c:when>
													<c:otherwise>其他</c:otherwise>
												</c:choose></td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		<nav aria-label="...">
			<ul class="pager">
				<li class="previous"><a
					href="<%=path %>/admin/admstatus?pageNo=${currPage - 1 }"><span
						aria-hidden="true">&larr;</span> 上一页</a></li>
				<li class="next"><a
					href="<%=path %>/admin/admstatus?pageNo=${currPage + 1 }"><span
						aria-hidden="true">&rarr;</span>下一页 </a></li>
			</ul>
		</nav>
	</div>
	<script src="<%=path%>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path%>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path%>/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="<%=path%>/js/content.min.js?v=1.0.0"></script>
	<script src="<%=path%>/js/plugins/iCheck/icheck.min.js"></script>
	<script src="<%=path%>/js/demo/peity-demo.min.js"></script>
</body>
</html>