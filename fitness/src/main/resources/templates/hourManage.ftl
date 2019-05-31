<!DOCTYPE html>
<#assign path="${springMacroRequestContext.getContextPath()}"/>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>学员管理</title>
    <link href="${path}/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${path}/css/sb-admin.css" rel="stylesheet">
    <link href="${path}/css/base.css" rel="stylesheet">
    <link href="${path}/css/bootstrap-table.min.css" rel="stylesheet">
    <link href="${path}/css/tempusdominus-bootstrap-4.css" rel="stylesheet">
    <link href="${path}/css/jquery-confirm.min.css" rel="stylesheet">
    <script src="${path}/js/jquery-3.3.1.js"></script>
    <script src="${path}/js/popper.min.js"></script>
    <script src="${path}/js/bootstrap-table.min.js"></script>
    <script src="${path}/js/bootstrap-table-zh-CN.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
    <script src="${path}/js/moment-with-locales.min.js"></script>
    <script src="${path}/js/moment-timezone-with-data-2012-2022.min.js"></script>
    <script src="${path}/js/tempusdominus-bootstrap-4.js"></script>
    <script src="${path}/js/base.js"></script>
    <script src="${path}/js/jquery-confirm.min.js"></script>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="#">Small LazyWorm</a>

    <button class="btn btn-link btn-sm order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fa fa-bars"></i>
    </button>
    <!-- Navbar -->
    <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fa fa-user-circle-o fa-2x"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">设置</a>
                <a class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">注销登陆</a>
            </div>
        </li>

    </ul>
</nav>
<div id="wrapper">
    <ul class="sidebar navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/api/index">
                <i class="fa fa-cubes"></i>
                <span>会员管理</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/api/coachManage">
                <i class="fa fa-cogs"></i>
                <span>教练管理</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/api/courseManage">
                <i class="fa fa-group"></i>
                <span>课程管理</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/api/cardManage">
                <i class="fa fa-asterisk"></i>
                <span>会员卡管理</span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="">
                <i class="fa fa-asterisk"></i>
                <span>课时管理</span></a>
        </li>
    </ul>
    <div id="content-wrapper">

        <div class="container-fluid">
            <div class="card mb-3">

                <div class="search-form" style="padding: 30px">
                    <form class="form-inline" id="searhHourForm">
                        <div class="form-group col-4">
                            <label  class="col-3">学生姓名:</label>
                            <input type="text" name="stuName" class="form-control col-9">
                        </div>
                        <div class="form-group col-4">
                            <label  class="col-3">教练姓名:</label>
                            <input type="text" name="coachName"  class="form-control col-9">
                        </div>
                        <div class="margin-top-30" style="text-align: right;width: 100%">
                            <button type="button" class="btn btn-outline-success" onclick="searchTable()"><i class="fa fa-check-square-o"></i> 查询</button>
                            <button type="button" class="btn btn-outline-danger" type="reset" onclick="resertForm()"><i class="fa fa-refresh"></i> 重置</button>
                        </div>

                    </form>

                </div>
                <div style="height: 1px;background-color: #dee2e6"></div>

                <div class="card-body">
                    <div class="table-responsive">
                        <div class="margin-bottom-15">
                            <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 新增</button>
                        </div>

                        　<table id="tb_hours" class="table table-striped table-hover table-sm" data-filter-control="true">
                    </table>

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">新增课时</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form class="padding-30">
                    <div class="form-group flex-display">
                        <label class="col-4">课时名字:</label>
                        <input type="text" class="form-control col-8" id="addHourName">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">教练名字:</label>
                        <select class="form-control col-8" id="addCoach">

                        </select>
                    </div>


                    <div class="form-group" style="display:flex;">
                        <label  class="col-4">学员姓名:</label>
                        <select class="form-control col-8" id="addStudent">

                        </select>
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">课时长度:</label>
                        <input type="text" class="form-control col-8" id="addHourCount">
                    </div>

                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="addCourseHour()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal"><i class="fa fa-exclamation-circle"></i> 关闭</button>
            </div>

        </div>
    </div>
</div>
</body>
<script src="${path}/js/sb-admin.min.js"></script>
<script>
    $(function(){
        InitMainTable();
        getCoachList();
        getStudentList();
    });
    function InitMainTable () {

        $('#tb_hours').bootstrapTable({
            url: 'courseHour/courseHourList',
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
            //showToggle: true,
            carView: false,
            detailView: false,
            //得到查询的参数
            queryParams : function (params) {
                //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
                var temp = {
                    rows: params.limit,                         //页面大小
                    page: (params.offset / params.limit) + 1,   //页码
                    stuName: $("#searhHourForm").find("input[name='stuName']").val(),
                    coachName: $("#searhHourForm").find("input[name='coachName']").val(),
                };
                return temp;
            },
            columns: [ {
                field: 'stuName',
                title: '学生姓名',

            }, {
                field: 'coachName',
                title: '教练姓名',

            }, {
                field: 'hourCount',
                title: '课时剩余',


            }, {
                field:'stuId',
                title: '操作',
                width: 120,
                align: 'center',
                formatter: actionFormatter

            }
            ]
        })
    }
    function addCourseHour() {
        var couseHour={
            hourName:$('#addHourName').val(),
            coachId:$('#addCoach').val(),
            stuId:$('#addStudent').val(),
            hourCount:$('#addHourCount').val()
        }
        $.ajax({
            type: 'POST',
            url: 'courseHour/addCourseHour',
            data: couseHour,
            dataType: "json",
            success: function (data) {
                $('#myModal').modal('hide');
                $.alert(data.msg);
                $('#tb_hours').bootstrapTable('refresh')
            },
            error: function () {
                $.alert("请求失败");

            },
        })
        $('#addHourName').val('');
        $('#addHourCount').val('')

    }
    function searchTable(){
        $('#tb_hours').bootstrapTable('refresh')
    }
    function actionFormatter(value, row, index){
        var id=value;
        var result="";
        result += "<a href='javascript:;' class='btn' onclick=\"ViewById('"+ id +"')\" title='会员卡转让'><i class='fa fa-pencil-square-o'></i></a>"
        return result;
    }
    function ViewById(id) {

    }
    function  resertForm(){
        $(':input','#searhHourForm')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
    }
    function getCoachList() {
        $.ajax({
            type:'GET',
            url:'course/getCoachList',
            dataType:"json",
            success: function (data){
                var list = data.data;
                if(null!=list) {
                    for (var i = 0; i < list.length; i++) {
                        var option = document.createElement("option");
                        $(option).val(list[i].coachId);
                        $(option).text(list[i].coachName);
                        $('#addCoach').append(option);
                    }
                }

            },
            error:function(){
                $.alert("请求失败");

            },
        })

    }
    function getStudentList(){
        $.ajax({
            type:'GET',
            url:'member/getStudentList',
            dataType:"json",
            success: function (data){
                var list = data.data;
                if(null!=list) {
                    for (var i = 0; i < list.length; i++) {
                        var option = document.createElement("option");
                        $(option).val(list[i].stuId);
                        $(option).text(list[i].stuName);
                        $('#addStudent').append(option);
                    }
                }

            },
            error:function(){
                $.alert("请求失败");

            },
        })
    }


</script>
</html>
