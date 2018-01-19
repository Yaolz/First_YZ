<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       <%
    	String path=request.getContextPath();
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>收藏列表</title>

    <link rel="shortcut icon" href="<%=path %>/favicon.ico"> <link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>所有预约列表</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>


                    <div class="ibox-content">

                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>用户预约</th>
                                        <th>小区</th>
                                        <th>价位</th>
                                        <th>用户联系电话</th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach items="${requestScope.app }" var="app">
	                                    <tr>
	                                        <td>${app.name }</td>
	                                        <td>${app.plot_name }</td>
	                                        <td>${app.budget }</td>
	                                        <td>${app.phone }</td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>

        </div>

	<nav aria-label="...">
			<ul class="pager">
				<li class="previous"><a
					href="<%=path %>/app/company?pageNo=${currPage - 1 }"><span
						aria-hidden="true">&larr;</span> 上一页</a></li>
				<li class="next"><a
					href="<%=path %>/app/company?pageNo=${currPage + 1 }"><span
						aria-hidden="true">&rarr;</span>下一页 </a></li>
			</ul>
		</nav>
    </div>
    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
</body>
</html>