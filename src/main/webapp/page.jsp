<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <!--  It is a good idea to bundle all CSS in one file. The same with JS -->

    <!--  JQUERY -->
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>

    <!--  BOOTSTRAP -->
    <link rel="stylesheet" type="text/css" href="jquery/bootstrap_3.3.0/css/bootstrap.min.css">
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <!--  PAGINATION plugin -->
    <link rel="stylesheet" type="text/css" href="jquery/bs_pagination-master/css/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="jquery/bs_pagination-master/js/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="jquery/bs_pagination-master/localization/en.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        $(function() {

            $("#demo_pag1").bs_pagination({
                currentPage:1, //当前页数
                rowsPerPage:10, //每页显示条数
                totalRows:1000, //总条数
                totalPages: 100, //总页数，必填数据
                visiblePageLinks:5, //一组最多显示的页数

                showGoToPage:true, //显示前往某一页的快捷方式
                showRowsPerPage:true, //显示每页显示的条数信息
                showRowsInfo:true, //显示记录信息
                onChangePage: function (event, pageObj) {  //pageObj存储着关于页数等信息，即上面的属性
                    alert(pageObj.currentPage)
                } //当用户切换页号，自动执行该部分代码,可以返回切换页号后的页数和每页条数
            });

        });
    </script>
</head>
<body>
<!--  Just create a div and give it an ID -->

<div id="demo_pag1"></div>
</body>
</html>
