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


<title>设计案例列表</title>

<link rel="shortcut icon" href="<%=path%>/favicon.ico">
<link href="<%=path%>/css/bootstrap.min14ed.css?v=3.3.6"
	rel="stylesheet">
<link href="<%=path%>/css/font-awesome.min93e3.css?v=4.4.0"
	rel="stylesheet">
<link href="<%=path%>/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="<%=path%>/css/animate.min.css" rel="stylesheet">
<link href="<%=path%>/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>设计案例列表</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>


					<div class="ibox-content">

						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>名称</th>
										<th>小区</th>
										<th>风格</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.descase }" var="des"
										varStatus="status">
										<tr>
											<td>${des.name }</td>
											<td>${des.plot_name }</td>
											<td>${des.style }</td>
											<td>
											<c:choose>
													<c:when test="${des.status == 'Y' }">可用</c:when>
													<c:when test="${des.status == 'N' }"><p style="color:red;">不可用</p></c:when>
													<c:otherwise>其他</c:otherwise>
												</c:choose>
											</td>
											<td>
												<a href="<%=path %>/descase/editor_page?id=${des.id }"><i
													class="fa fa-check text-navy">修改案例</i></a>
												<a href="<%=path %>/descase/designercase_info?id=${des.id }"><i
													class="fa fa-check text-navy">查看详情</i></a>
													<c:choose>
													<c:when test="${des.status == 'Y' }"><a href="<%=path %>/descase/des_status?id=${des.id }"><i
													class="fa fa-check text-navy">冻结</i></a></c:when>
													<c:when test="${des.status == 'N' }"><a href="<%=path %>/descase/des_status?id=${des.id }"><i
													class="fa fa-check text-navy">激活</i></a> </p></c:when>
													<c:otherwise>其他</c:otherwise>
												</c:choose>
												</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>

		</div>

		<nav aria-label="...">
			<ul class="pager">
				<li class="previous"><a
					href="<%=path %>/descase/cases_page?pageNo=${currPage - 1 }&id=${requestScope.des.id }"><span
						aria-hidden="true">&larr;</span> 上一页</a></li>
				<li class="next"><a
					href="<%=path %>/descase/cases_page?pageNo=${currPage + 1 }&id=${requestScope.des.id }"><span
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