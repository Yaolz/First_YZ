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

    <title>案例添加</title>

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
 .div_td input{
 width: 50%;
 }
 .div_td button{
 	margin-left: 5px;
 }
 .wrapper-content {
    padding: 0px;
}
table tr {
    text-align: right;
}
</style>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12 ">
                    <form id="form" method="post" enctype="multipart/form-data">
                    <span id="error"></span>
                    <input type="hidden" name="company_id" value="${sessionScope.company.id }" />
                    <input type="hidden" name="id" value="${sessionScope.company.id }" />
                    			 <div class="ibox-title">
                        			<h5>添加案例</h5>
                    			</div>
		                       <table class="table table-striped">
	                       	<colgroup>
							        <col class="col-xs-3">
							        <col class="col-xs-5">
							</colgroup>
	                       	<tr>
	                       		<td scope="row">案例名称:</td>
	                       		<td class="div_td"><input type="text" name="name" id="name" placeholder="请输入案例名称"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">小区名称:</td>
	                       		<td class="div_td"><input type="text" name="plot_name" id="plot_name" placeholder="请输入小区名称"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">使用风格:</td>
	                       		<td class="div_td"><input type="text" name="style" id="style" placeholder="请输入风格"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">案例实图1:</td>
	                       		<td class="div_td"><input type="file" name="image_1" ></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">案例实图2:</td>
	                       		<td class="div_td"><input type="file" name="image_2" ></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">案例实图3:</td>
	                       		<td class="div_td"><input type="file" name="image_3" ></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">案例实图4:</td>
	                       		<td class="div_td"><input type="file" name="image_4" ></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">案例实图5:</td>
	                       		<td class="div_td"><input type="file" name="image_5" ></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">案例描述:</td>
	                       		<td class="div_td"><input type="text" name="des" id="des" placeholder="请输入案例描述"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row"></td>
	                       		<td class="div_td"><button class="btn btn-info " type="button" onclick="add_case();">确认添加</button></td>
	                       	</tr>
	                       </table>
	                      </form>
                	</div>
           	 	</div>
		 	</div>
    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
    <script src="<%=path%>/js/jQuery.form.min.js"></script>
	<script src="<%=path %>/js/company/case.js"></script>
</body>
</html>