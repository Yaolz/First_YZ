<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="<%=path%>/css/index.css" rel="stylesheet">
</head>
<body  style="background-color: #efefef;">
	<nav class="navbar navbar-default">
		<!-- Nav tabs -->
		<div class="container">
			<ul class="nav nav-tabs" role="tablist">
				<li><a class="navbar-brand" href="<%=path%>/common/indexs"><font>首页</font></a>
				<li>
				<li role="presentation" class="active"><a href="#home"
					aria-controls="home" role="tab" data-toggle="tab">普通用户</a></li>
				<li role="presentation"><a href="#profile"
					aria-controls="profile" role="tab" data-toggle="tab">装修公司</a></li>
				<li role="presentation"><a href="#messages"
					aria-controls="messages" role="tab" data-toggle="tab">设计师</a></li>
				<li role="presentation"><a href="#settings"
					aria-controls="settings" role="tab" data-toggle="tab">建材商</a></li>
			</ul>
		</div>
	</nav>
	<!-- Tab panes -->
	<div class="tab-content container">
		<div role="tabpanel" class="tab-pane active" id="home">
			<div class="col-lg-7">
				<img src="<%=path %>/img/loginimg/deng.png" style="display: block;">
			</div>
			<div class="col-lg-5 center-block login">
				<form id="customer">
					<div style="width:100%;text-align: center;">
						<h1>登录</h1>
						<span style="color: red;" id="error_pt"></span>
					</div>
					<input type="hidden" value="pt" id="pt" name="pt" />
					<div class="logins center-block">
						<div class="form-group input-group logins-input">
							<input type="email" class="form-control" placeholder="请输入用户邮箱"
								aria-describedby="basic-addon1" name="email" id="email_pt">
						</div>
						<div class="form-group input-group logins-input">
							<input type="password" class="form-control" placeholder="请输入密码"
								aria-describedby="basic-addon1" name="pwd" id="pwd_pt">
						</div>
						<input class="btn" type="button" value="登录" onclick="customer();">
					</div>
				</form>
			</div>
		</div>
		<div role="tabpanel" class="tab-pane" id="profile">
			<div class="col-lg-7">
				<img src="<%=path %>/img/loginimg/deng.png" style="display: block;">
			</div>
			<div class="col-lg-5 center-block login">
				<form id="company">
					<div style="width:100%;text-align: center;">
						<h1>登录</h1>
						<span style="color: red;" id="error_gs"></span>
					</div>
					<input type="hidden" value="gs" id="gs" name="gs" />
					<div class="logins center-block">
						<div class="form-group input-group logins-input">
							<input type="email" class="form-control" placeholder="请输入公司邮箱"
								aria-describedby="basic-addon1" name="email" >
						</div>
						<div class="form-group input-group logins-input">
							<input type="password" class="form-control" placeholder="请输入密码"
								aria-describedby="basic-addon1" name="pwd" >
						</div>
						<input class="btn" type="button" value="登录" onclick="company();">
					</div>
				
				</form>
			</div>
		</div>
		<div role="tabpanel" class="tab-pane" id="messages">
			<div class="col-lg-7">
				<img src="<%=path %>/img/loginimg/deng.png" style="display: block;">
			</div>
			<div class="col-lg-5 center-block login">
				<form id="designer">
					<div style="width:100%;text-align: center;">
						<h1>登录</h1>
						<span style="color: red;" id="error_sj"></span>
					</div>
					<input type="hidden" value="sj" id="sj" name="sj">
					<div class="logins center-block">
						<div class="form-group input-group logins-input">
							<input type="email" class="form-control" placeholder="请输入设计师邮箱"
								aria-describedby="basic-addon1" name="email" id="email_sj">
						</div>
						<div class="form-group input-group logins-input">
							<input type="password" class="form-control" placeholder="请输入密码"
								aria-describedby="basic-addon1" name="pwd" id="pwd_sj">
						</div>
						<input class="btn" type="button" value="登录" onclick="designer();">
					</div>
				</form>
			</div>
		</div>
		<div role="tabpanel" class="tab-pane" id="settings">
			<div class="col-lg-7">
				<img src="<%=path %>/img/loginimg/deng.png" style="display: block;">
			</div>
			<div class="col-lg-5 center-block login">
				<form id="supply">
					<div style="width:100%;text-align: center;">
						<h1>登录</h1>
						<span style="color: red;" id="error_jc"></span>
					</div>
					<input type="hidden" value="jc" id="jc" name="jc">
					<div class="logins center-block">
						<div class="form-group input-group logins-input">
							<input type="email" class="form-control" placeholder="请输入建材商邮箱"
								aria-describedby="basic-addon1" name="email" id="email_jc">
						</div>
						<div class="form-group input-group logins-input">
							<input type="password" class="form-control" placeholder="请输入密码"
								aria-describedby="basic-addon1" name="pwd" id="pwd_jc">
						</div>
						<input class="btn" type="button" value="登录" onclick="supply();">
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="mycommon/bottom.jsp"%>
	<script src="<%=path%>/js/login.js"></script>
	<script src="<%=path%>/js/jquery.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
</body>
</html>