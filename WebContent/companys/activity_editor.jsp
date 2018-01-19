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
<style>
 .wrapper-content {
    padding: 0px;
}
.div_td{
	text-align: center;
}
</style>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight container">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>修改活动</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="table-responsive">
                        <form id="form" action="" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${requestScope.comacti.id }">
                            <table class="table table-striped">
                            	<colgroup>
							        <col class="col-xs-2">
							        <col class="col-xs-6">
							    </colgroup>
                                <tbody>
                                    <tr>
                                    	<td scope="row"  class="div_td">活动名称:</td>
                                      	<td>
                                      		<input type="text" name="name" id="name" value="${requestScope.comacti.name }">
                                        </td>
                                    </tr>
                                     <tr>
                                     	<td scope="row"  class="div_td">活动描述:</td>
                                      	<td>
                                      	<input type="text" name="des" id="des" value="${requestScope.comacti.des }">
                                        </td>
                                    </tr>
                                    <tr>
                                    	<td scope="row"  class="div_td">活动图片:</td>
                                      	<td>
                                      	<img src="<%=path %>/${requestScope.comacti.image } " style="width:300px;">
                                        	<input type="file" name="image" id="image" value="${requestScope.comacti.image }">
                                     	</td>
                                    </tr>
                                    <tr>
                                    	<td scope="row"></td>
                                      	<td>
                                        	<button class="btn btn-info " type="button" onclick="editor_act()">确认修改</button>
                                     	</td>
                                    </tr>
                                </tbody>
                            </table>
                            </form>
                        </div>
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
    <script src="<%=path %>/js/company/activity.js"></script>
</body>
</html>