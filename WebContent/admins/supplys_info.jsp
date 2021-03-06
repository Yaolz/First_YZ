<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%
		  String path=request.getContextPath();
		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   	<link rel="shortcut icon" href="<%=path %>/favicon.ico"> <link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet"> 
    
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight container">
        <div class="row">
                    <div class="ibox-content">
                           <table class="table table-bordered table-striped">
						      <colgroup>
						        <col class="col-xs-1">
						        <col class="col-xs-7">
						      </colgroup>
						      <thead>
						        <tr>
						          <th>建材商详情</th>
						          <th>描述</th>
						        </tr>
						      </thead>
								<tbody>
									<tr>
										<th scope="row">建材商名称:</th>
										<td>${requestScope.sup.name }</td>
									</tr>
									<tr>
										<th scope="row">建材商电话:</th>
										<td>${requestScope.sup.tel }</td>
									</tr>
									<tr>
										<th scope="row">建材商邮箱:</th>
										<td>${requestScope.sup.email }</td>
									</tr>
									<tr>
										<th scope="row">建材商负责人:</th>
										<td>${requestScope.sup.principal }</td>
									</tr>
									<tr>
										<th scope="row">建材商号码:</th>
										<td>${requestScope.sup.phone }</td>
									</tr>
									<tr>
										<th scope="row">是否审核:</th>
										<td>
											<c:choose>
												<c:when test="${requestScope.sup.status == 'Y' }">是</c:when>
												<c:when test="${requestScope.sup.status == 'N' }"><p style="color:red;">否</p></c:when>
												<c:otherwise>其他</c:otherwise>
											</c:choose>
										</td>
									</tr>
									<tr>
										<th scope="row">审核通过时间:</th>
										<td>${requestScope.sup.checked_time }</td>
									</tr>
									<tr>
										<th scope="row">建材商经度:</th>
										<td>${requestScope.sup.longitude }</td>
									</tr>
									<tr>
										<th scope="row">建材商纬度:</th>
										<td>${requestScope.sup.latitude }</td>
									</tr>
									<tr>
										<th scope="row">建材商地址:</th>
										<td>${requestScope.sup.address }</td>	
									</tr>
									<tr>
										<th scope="row">建材商成立日期:</th>
										<td>${requestScope.sup.open_date }</td>
									</tr>
									<tr>
										<th scope="row">建材商入驻日期:</th>
										<td>${requestScope.sup.created_time }</td>
									</tr>
									<tr>
										<th scope="row">最近登录时间:</th>
										<td>${requestScope.sup.last_login_time }</td>
									</tr>
									<tr>
										<th scope="row">公司简介:</th>
										<td>${requestScope.sup.des }</td>	
									</tr>
								</tbody>
							</table>
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