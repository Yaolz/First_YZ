<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<script src="<%=path %>/js/jquery.min.js"></script>
<script type="text/javascript">
	function login() {
		var email = $("#email").val();
		var pwd = $("#pwd").val();
		var error = $("#error");
		if(email == null || email.trim() == "") {
			error.text("邮箱不能为空");
			return;
		}
		if(pwd == null || pwd.trim() == "") {
			error.text("密码不能为空");
			return;
		}
		$.post("First_YZ/admin/sup_login", 
			$("#form").serialize(),
			function (data) {
				if(data.info == "数据成功") {
					window.location = "/First_YZ/admin/sup_admin";
				} else {
					$("#error").text(data.info);
				}
			}, "JSON");
	}
</script>

<style type="text/css">
.login{
	border:1px solid #ddd;
	width:28%;
	margin-left:30%;
	margin-top:6%;
	padding-bottom: 7%;
	box-shadow: 1px 0px 3px #CCC;
	
}
.float{
	float: left;
	margin-left:12%;
}
.right{
	border-left:1px solid gray;
	margin-left:42%;
	padding-left: 7%;
}
.right h2{
	text-align: center;
	width:50%;
}
.logins{
	margin-top:12%;
	margin-left:18%;
}
.logins input{
	width:58%;
	height:35px;
	margin-top: 7%;
	
}
.ca{
	margin-left: 15%;
	padding-top:5%;
}
.login_div{
	margin-top: 7%;
}
.btn-info{
	color: #fff;
    background-color: #5bc0de;
    border-color: #46b8da;
}
</style>
</head>
<body>
	<form id="form" method="post">
		<div class="a container">
		<div class="login">
			<div class="login_div">
				<div class="float"><img src="<%=path %>/img/loginimg/logo.png"></div>
				<div class="right"><h3>超级管理员登录</h3></div>
			</div>
			<div>
				<div class="logins center-block">
				<p style="color: red;margin-left: 60px;"><span id="error" ></span></p>
						<div class="form-group input-group logins-input">
							<font>邮箱:&nbsp;&nbsp;</font>
							<input type="email" aria-describedby="basic-addon1" name="email" id="email">
						</div>
						<div class="form-group input-group logins-input">
							<font>密码:&nbsp;&nbsp;</font>
							<input type="password" aria-describedby="basic-addon1" name="pwd" id="pwd">
						</div>
						<div class="ca">
							<input class="btn btn-info" type="button" value="登录" onclick="login();">
						</div>
					</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>