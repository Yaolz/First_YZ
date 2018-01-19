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

<title>商品添加</title>

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
						<h5>信息</h5>
					</div>
					<div class="ibox-content inputs">
						<form id="form" method="post" enctype="multipart/form-data">
						<span id="error"></span>
							<input type="hidden" name="supply_id" value="${requestScope.sup.id }" />
							 <input type="hidden" name="id" value="${requestScope.sup.id }" />
							<table class="table table-striped">
								<tr>
									<td>商品名称:<input type="text" name="name" id="name"
										placeholder="请输入商品名称"></td>
								</tr>
								<tr>
									<td>商品原价:<input type="text" name="price" id="price" placeholder="请输入原价"
										onkeyup="value=value.replace(/[^(\d)]/g,'')"></td>
								</tr>
								<tr>
									<td>折后价格:<input type="text" name="sale_price" id="sale_price"
										placeholder="请输入折后价"
										onkeyup="value=value.replace(/[^(\d)]/g,'')"></td>
								</tr>
								<tr>
									<td>商品描述:<input type="text" name="des" id="des"
										placeholder="请输入案例描述"></td>
								</tr>
								<tr>
									<td><input style="margin-left: 43%;" type="file" name="image"></td>
								</tr>
								<tr>
									<td><button class="btn btn-info " type="button" onclick="add_pro();">确认添加</button></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=path%>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path%>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path%>/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="<%=path%>/js/content.min.js?v=1.0.0"></script>
	<script src="<%=path%>/js/plugins/iCheck/icheck.min.js"></script>
	<script src="<%=path%>/js/demo/peity-demo.min.js"></script>
	<script src="<%=path%>/js/jQuery.form.min.js"></script>
	<script src="<%=path %>/js/supply/product.js"></script>
</body>
</html>