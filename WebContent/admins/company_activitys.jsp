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

    <title>装修公司活动列表</title>

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
                        <h5>所有公司活动</h5>
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
                                        <th>活动名称</th>
                                        <th>活动描述</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                               	 <c:forEach items="${requestScope.comactivity }" var="com" varStatus="status">
                                    <tr>
                                        <td>${com.name }</td>
                                        <td>${com.des }</td>
                                        <td>
                                        		<c:choose>
													<c:when test="${com.status == 'Y' }">可用</c:when>
													<c:when test="${com.status == 'N' }"><p style="color:red;">不可用</p></c:when>
													<c:otherwise>其他</c:otherwise>
												</c:choose>
                                        	
                                        </td>
                                        <td>
                                            <a href="<%=path %>/comactivity/companyactivity_info?id=${com.id }"><i class="fa fa-check text-navy">查看详情</i></a>
                                        </td>
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
					href="<%=path %>/comactivity/activitys?pageNo=${currPage - 1 }&id=${requestScope.com.id }"><span
						aria-hidden="true">&larr;</span> 上一页</a></li>
				<li class="next"><a
					href="<%=path %>/comactivity/activitys?pageNo=${currPage + 1 }&id=${requestScope.com.id }"><span
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