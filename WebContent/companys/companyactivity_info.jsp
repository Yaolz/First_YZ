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
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>公司活动详情</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="table-responsive">
                            <table class="table table-striped">
					             <colgroup>
							        <col class="col-xs-1">
							        <col class="col-xs-7">
							      </colgroup>
							      <thead>
							        <tr>
							          <th>活动详情</th>
							          <th>描述</th>
							        </tr>
							      </thead>
                                <tbody >
                                    <tr>
                                    	<th scope="row">活动名称:</th>
                                        <td>${requestScope.comacti.name }</td>
                                    </tr>
                                     <tr>
                                     	 <th scope="row">描述:</th>
                                     	 <td>${requestScope.comacti.des }</td>
                                    </tr>
                                    <tr>
                                      	<td colspan="2">
                                        	<img src="<%=path %>/${requestScope.comacti.image }" style="width:850px; height:450px;">
                                     	</td>
                                    </tr>
                                </tbody>
                            </table>
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
</body>
</html>