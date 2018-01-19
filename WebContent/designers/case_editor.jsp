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
input{
width:30%;
}
.div_td{
	text-align: center;;
}
</style>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight container">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>设计案例详情</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="table-responsive">
                        <form id="form" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${requestScope.desinfo.id }">
                            <table class="table table-striped">
                            	<colgroup>
							        <col class="col-xs-2">
							        <col class="col-xs-6">
								</colgroup>
                                <tbody >
                                    <tr>
                                        <td scope="row" class="div_td">案例名称:</td>
                                      	<td >
                                      	<input type="text" name="name" id="name" value="${requestScope.desinfo.name }">
                                        </td>
                                    </tr>
                                     <tr>
                                     	 <td scope="row" class="div_td">小区名称:</td>
                                      	<td>
                                      	<input type="text" name="plot_name" id="plot_name" value="${requestScope.desinfo.plot_name }">
                                        </td>
                                    </tr>
                                     <tr>
                                     	<td scope="row" class="div_td">装修风格:</td>
                                      	<td>
                                      	<input type="text" name="style" id="style" value="${requestScope.desinfo.style }">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td scope="row" class="div_td">案例描述:</td>
                                      	<td>
                                      	<input type="text" name="des" id="des" value="${requestScope.desinfo.des }">
                                        </td>
                                    </tr>
                                    <tr>
                                    	 <td scope="row" class="div_td">案例图片1:</td>
                                      	<td>
                                      	<img src="<%=path %>/${requestScope.desinfo.image_1 }" style="width:300px;">
                                        	<input type="file" name="image_1" value="${requestScope.desinfo.image_1 }">
                                     	</td>
                                    </tr>
                                    <tr>
                                    	 <td scope="row" class="div_td">案例图片2:</td>
                                      	<td>
                                      	<img src="<%=path %>/${requestScope.desinfo.image_2 }" style="width:300px;">
                                        	<input type="file" name="image_2" value="${requestScope.desinfo.image_2 }">
                                     	</td>
                                    </tr>
                                    <tr>
                                    	 <td scope="row" class="div_td">案例图片3:</td>
                                      	<td>
                                      	<img src="<%=path %>/${requestScope.desinfo.image_3 }" style="width:300px;">
                                        	<input type="file" name="image_3" value="${requestScope.desinfo.image_3 }">
                                     	</td>
                                    </tr>
                                    <tr>
                                    	 <td scope="row" class="div_td">案例图片4:</td>
                                      	<td>
                                      	<img src="<%=path %>/${requestScope.desinfo.image_4 }" style="width:300px;">
                                        	<input type="file" name="image_4" value="${requestScope.desinfo.image_4 }">
                                     	</td>
                                    </tr>
                                    <tr>
                                    	 <td scope="row" class="div_td">案例图片5:</td>
                                      	<td>
                                      	<img src="<%=path %>/${requestScope.desinfo.image_5 }" style="width:300px;">
                                        	<input type="file" name="image_5" value="${requestScope.desinfo.image_5 }">
                                     	</td>
                                    </tr>
                                    <tr>
                                    	 <td scope="row"></td>
                                    	<td>
                                    		<button class="btn btn-info " type="button" onclick="editor_case();">确认修改</button>
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
	<script src="<%=path %>/js/designer/case.js"></script>
</body>
</html>