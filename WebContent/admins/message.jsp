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

<title>管理员信息</title>

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
<style>
 .div_td{
 text-align: left;
 }
 .div_td input{
 width: 60%;
 }
 .div_td button{
 	margin-left: 20px;
 }
.wrapper-content {
    padding: 0px;
}
</style>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12 ">
				<div class="ibox float-e-margins">
					<div>
						<div class="col-sm-3"></div>
                   		<div class="col-sm-6">
                   			 <div class="ibox-title">
                       			<h5>基本信息</h5>
                   			</div>
	                       <table class="table table-striped table-bordered">
	                       	<colgroup>
						        <col class="col-xs-2">
						        <col class="col-xs-6">
						    </colgroup>
								<tr>
									<th scope="row">&nbsp;&nbsp;&nbsp;姓名:</th>
									<td class="div_td"> <h3>${sessionScope.admin.name }</h3></td>
								</tr>
								<tr>
									<th scope="row">&nbsp;&nbsp;&nbsp;角色:</th>
									<td class="div_td"><h3>${sessionScope.admin.role }</h3></td>
								</tr>
								<tr>
									<th scope="row">&nbsp;&nbsp;&nbsp;邮箱:</th>
									<td class="div_td"><h3>${sessionScope.admin.email}</h3></td>
								</tr>
								<tr>
									<th scope="row">&nbsp;&nbsp;&nbsp;电话:</th>
									<td class="div_td"><h3>${sessionScope.admin.phone  }</h3></td>
								</tr>
								<tr>
									<th scope="row">&nbsp;&nbsp;&nbsp;创建时间:</th>
									<td class="div_td"><h3>${sessionScope.admin.created_time }</h3></td>
								</tr>
								<tr>
									<th scope="row">&nbsp;&nbsp;&nbsp;最近一次登录时间:</th>
									<td class="div_td"><h3>${sessionScope.admin.last_login_time }</h3></td>
								</tr>
								<tr>
							</table>
						</div>
						<div class="col-sm-4"></div>
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
</body>
</html>