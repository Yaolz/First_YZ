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
                        <h5>所有收藏列表</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>


                    <div class="ibox-content">

                        <div class="row">
                            <div class="col-sm-3">
                                <button type="button" class="btn btn-sm btn-primary">添加</button>
                            </div>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>小区</th>
                                        <th>风格</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>公司1</td>
                                        <td>江山里</td>
                                        <td>110</td>
                                        <td>
                                            <a href="companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                            <a href="companys.jsp#"><i class="fa fa-check text-navy">取消</i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>公司1</td>
                                        <td>江山里</td>
                                        <td>110</td>
                                        <td>
                                          <a href="companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                          <a href="companys.jsp#"><i class="fa fa-check text-navy">取消</i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>公司1</td>
                                        <td>江山里</td>
                                        <td>110</td>
                                        <td>
                                           <a href="companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                            <a href="companys.jsp#"><i class="fa fa-check text-navy">取消</i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>公司1</td>
                                        <td>江山里</td>
                                        <td>110</td>
                                        <td>
                                            <a href="companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                            <a href="companys.jsp#"><i class="fa fa-check text-navy">取消</i></a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-sm-12">
                <nav aria-label="Page navigation" class="pull-right">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
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