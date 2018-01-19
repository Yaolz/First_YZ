<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar-wrapper">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="header clearfix"></div>
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath() %>/common/indexs">首页</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a 
					href="<%=request.getContextPath()%>/common/companys">装修公司</a></li>
					<li><a href="<%=request.getContextPath()%>/common/descase">设计案例</a></li>
					<li><a href="<%=request.getContextPath()%>/common/desi">设计师</a></li>
					<li><a href="<%=request.getContextPath()%>/common/supplys">建材商</a></li>
				</ul>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav nav-pills pull-right">
						<li role="presentation"><a
							href="<%=request.getContextPath()%>/common/regss">注册</a></li>
						<li role="presentation"><a
							href="<%=request.getContextPath()%>/common/logins">登录</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
</div>
