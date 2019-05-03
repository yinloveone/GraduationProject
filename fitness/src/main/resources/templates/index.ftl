<!DOCTYPE html>
<#assign path="${springMacroRequestContext.getContextPath()}"/>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>欢迎你</title>
    <link href="${path}/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${path}/css/sb-admin.css" rel="stylesheet">
    <link href="${path}/css/bootstrap-table.min.css" rel="stylesheet">
    <script src="${path}/js/jquery-3.3.1.js"></script>
    <script src="${path}/js/popper.min.js"></script>
    <script src="${path}/js/bootstrap-table.min.js"></script>
    <script src="${path}/js/bootstrap-table-zh-CN.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="#">Small LazyWorm</a>

    <button class="btn btn-link btn-sm text-primary order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fa fa-bars"></i>
    </button>
    <!-- Navbar -->
    <ul class="navbar-nav ml-auto">
       <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user-circle-o fa-2x"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
            </div>
        </li>

    </ul>
</nav>
<div id="wrapper">
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">
                <i class="fa fa-cubes"></i>
                <span>会员管理</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fa fa-cogs"></i>
                <span>教练管理</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fa fa-group"></i>
                <span>课程管理</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fa fa-asterisk"></i>
                <span>私教课管理</span></a>
        </li>
    </ul>
    <div id="content-wrapper">

        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="#">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Overview</li>
            </ol>

            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i>
                    Data Table Example</div>
                <div class="card-body">
                    <div class="table-responsive">
                        　<table id="tb_roles" data-filter-control="true">
                    </table>




                    </div>
                </div>
            </div>
        </div>
    </div>



</div>

</body>
<script src="${path}/js/sb-admin.min.js"></script>
</html>
<script>

    $(function(){
        InitMainTable();
    });
    function InitMainTable () {

       $('#tb_roles').bootstrapTable({
            url: 'member/studentList',
            contentType : "application/x-www-form-urlencoded",
            dataType:"json",
            method: 'POST',
            striped: true,
            cache: false,
            pagination: true,
            sortable: true,
            sortOrder: "asc",
            sidePagination: 'server',
            pageNumber: 1,
            pageSize: 5,
            pageList: [5,10,15],
            search: false,
           /* strictSearch: true,
            showColumns: true,
            showRefresh: true,*/
            minimumCountColumns: 2,
            clickToSelect: true,
            uniqueId: "ID",
            showToggle: true,
            carView: false,
            detailView: false,
            //得到查询的参数
             queryParams : function (params) {
                 //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
                 var temp = {
                             rows: params.limit,                         //页面大小
                             page: (params.offset / params.limit) + 1,   //页码
                             sort: params.sort,      //排序列名
                             sortOrder: params.order //排位命令（desc，asc）
                 };
                 return temp;
             },
                 columns: [{
                         checkbox: true,
                         visible: true                  //是否显示复选框
                 }, {
                         field: 'stuName',
                                 title: '姓名',
                                 sortable: true
                     }, {
                         field: 'phone',
                                 title: '手机',
                                 sortable: true
                     }, {
                         field: 'email',
                                 title: '邮箱',
                                 sortable: true,

                     },  {
                         field: 'sex',
                                 title: '性别',
                                 sortable: true
                     }, {
                         field: 'age',
                                 title: '年龄'
                     }, {
                         field: 'birthday',
                                 title: '出生日期',

                     }, {
                         field: 'height',
                                 title: '身高'
                     } ]
        })
    }


</script>
