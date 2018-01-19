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

    <title>公司活动添加</title>

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
 width: 18%;
 }
 .div_td button{
 	margin-left: 20px;
 }
 .wrapper-content {
  padding: 0px;
}
.div_min{
 text-align: left;
}
 .div_min input{
 width: 18%;
 }
</style>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12 ">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>信息</h5>
                    </div>
                    <div class="ibox-content inputs">
                    <form action="<%=path %>/comactivity/addactivity" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="company_id" value="${sessionScope.company.id }" />
                    <input type="hidden" name="id" value="${sessionScope.company.id }" />
                    <span id="error"></span>
	                       <table class="table table-striped">
	                       	<colgroup>
							        <col class="col-xs-2">
							        <col class="col-xs-6">
							</colgroup>
	                       	<tr>
	                       		<td class="t_d">活动名称:</td>
	                       		<td class="div_min"><input type="text" name="name" id="name" placeholder="请输入活动名称" ></td>
	                       	</tr>
	                       	<tr>
	                       		<td class="t_d">活动配图:</td>
	                       		<td class="div_td"><input type="file" name="image"  id="image"></td>
	                       	</tr>
	                       	<tr>
	                       		<td class="t_d">活动描述:</td>
	                       		<td class="div_td"><input type="text" name="des" id="des" placeholder="请输入活动描述"></td>
	                       	</tr>
	                       	<tr>
	                       		<td class="t_d"></td>
	                       		<td class="div_td"><button class="btn btn-info " type="submit" >确认添加</button></td>
	                       	</tr>
	                       </table>
	                      </form>
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
    <script src="<%=path%>/js/jQuery.form.min.js"></script>
   	<script src="<%=path %>/js/company/activity.js"></script>
</body>
</html>