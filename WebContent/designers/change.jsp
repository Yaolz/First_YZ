<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
    	String path=request.getContextPath();
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>管理员信息修改</title>
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
                    	<form id="form" method="post">
                    	<input type="hidden" name="id" value="${requestScope.des.id }">
                    	<p id="error" style="text-align: center; color:red;"></p>
	                       <div class="col-sm-3"></div>
                    		<div class="col-sm-6" style="margin-top:-10px;">
                    			 <div class="ibox-title">
                        			<h5>信息修改</h5>
                    			</div>
		                       <table class="table table-striped">
		                       	<colgroup>
							        <col class="col-xs-2">
							        <col class="col-xs-7">
							    </colgroup>
	                       	<tr>
	                       		<td scope="row">姓名:</td>
	                       		<td class="div_td"><input type="text" name="name"  value="${requestScope.des.name }" id="name"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">电话:</td>
	                       		<td class="div_td"><input type="text" name="phone" value="${requestScope.des.phone }" id="phone"
	                       		onkeyup="value=value.replace(/[^(\d)]/g,'')" maxlength="11"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">地址:</td>
	                       		<td class="div_td"><input type="text" name="address" value="${requestScope.des.address }" id="address"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">个人简介:</td>
	                       		<td class="div_td"><input type="text" name="d" value="${requestScope.des.des }" ></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">工作经验:</td>
	                       		<td class="div_td"><input type="text" name="experience" value="${requestScope.des.experience }"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row">擅长风格:</td>
	                       		<td class="div_td"><input type="text" name="style" value="${requestScope.des.style }"></td>
	                       	</tr>
	                       	<tr>
	                       		<td scope="row"></td>
	                       		<td class="div_td"><button class="btn btn-info " type="button" onclick="message();">确认修改</button></td>
	                       	</tr>
	                       </table>
	                       </div>
	                       <div class="col-sm-3"></div>
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
    <script src="<%=path %>/js/designer/message.js"></script>
</body>
</html>