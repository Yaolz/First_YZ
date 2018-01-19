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

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>建材商信息</title>

    <link rel="shortcut icon" href="<%=path %>/favicon.ico"> <link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/css/common.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>
<style>
 .div_td{
 text-align: left;
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
	                    		<div class="col-sm-5">
	                    		 <div class="ibox-title">
                        			<h5>建材商信息</h5>
                   				 </div>
			                       <table class="table table-striped table-bordered">
			                       	<colgroup>
								        <col class="col-xs-2">
								        <col class="col-xs-6">
							     	</colgroup>
			                       	<tr>
			                       		<th scope="row">姓名:</th>
		 	                       		<td class="div_td"><h3>${sessionScope.supply.name }</h3></td>
			                       	</tr>
			                       	<tr>
			                       		<th scope="row">电话::</th>
			                       		<td class="div_td"><h3>${sessionScope.supply.tel }</h3></td>
			                       	</tr>
			                       	<tr>
			                       		<th scope="row">邮箱:</th>
			                       		<td class="div_td"><h3>${sessionScope.supply.email }</h3></td>
			                       	</tr>
			                       	<tr>
			                       		<th scope="row">负责人:</th>
			                       		<td class="div_td"><h3>${sessionScope.supply.principal }</h3></td>
			                       	</tr>
			                       	<tr>
			                       		<th scope="row">负责人电话:</th>
			                       		<td class="div_td"><h3>${sessionScope.supply.phone }</h3></td>
			                       	</tr>
			                       	<tr>
			                       		<th scope="row">成立日期:</th>
			                       		<td class="div_td"><h3>${sessionScope.supply.open_date }</h3></td>
			                       	</tr>
			                       	<tr>
			                       		<th scope="row">个人简介:</th>
			                       		<td class="div_td"><h3>${sessionScope.supply.des }</h3></td>
			                       	</tr>
			                       </table>
			                   </div>
			                   <div class="col-sm-4"></div>
		                </div>
           	 	</div>
		 	</div>
      	</div>
    </div>
    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
</body>
</html>