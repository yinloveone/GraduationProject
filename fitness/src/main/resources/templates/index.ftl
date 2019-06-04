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
        <li class="nav-item active">
            <a class="nav-link" href="#">
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
        <li class="nav-item">
            <a class="nav-link" href="/api/hourManage">
                <i class="fa fa-asterisk"></i>
                <span>课时管理</span></a>
        </li>
    </ul>
    <div id="content-wrapper">

        <div class="container-fluid">
            <div class="card mb-3">

                <div class="search-form" style="padding: 30px">
                    <form class="form-inline" id="searhForm">
                        <div class="form-group col-4">
                            <label  class="col-3">姓名:</label>
                            <input type="text" name="stuName" class="form-control col-9">
                        </div>
                        <div class="form-group col-4">
                            <label  class="col-3">类型:</label>
                            <input type="text"  class="form-control col-9">
                        </div>
                        <div class="form-group col-4">
                            <label class="col-3">电话:</label>
                            <input type="text" name="phone" class="form-control col-9">
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

                        　<table id="tb_roles" class="table table-striped table-hover table-sm" data-filter-control="true">
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
                <h4 class="modal-title">新增学员</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form class="padding-30">

                    <div class="form-group flex-display">
                        <label class="col-4">姓名:</label>
                        <input type="text" class="form-control col-8" id="addName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">电话:</label>
                        <input type="text" class="form-control col-8" id="addPhone">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">邮箱:</label>
                        <input type="text" class="form-control col-8" id="addEmail">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">生日:</label>
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                        </div>
                        <input type="text" class="form-control col-7 datetimepicker-input" id="datetimepicker1" data-toggle="datetimepicker" data-target="#datetimepicker1">
                    </div>
                    <div class="form-group" style="display:flex;">
                        <label  class="col-4">会员类型:</label>
                        <select class="form-control col-8" id="addCard">
                            <option value="1">月卡</option>
                            <option value="2">季卡</option>
                            <option value="3">年卡</option>
                        </select>
                    </div>

                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="addStudent()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal"><i class="fa fa-exclamation-circle"></i> 关闭</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="changeModel">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">会员卡转让</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <label>转让人信息：</label>
                <form class="">
                    <input style="display: none" id="cardId" />
                    <div class="form-group flex-display">
                        <label class="col-4">姓名:</label>
                        <input type="text" class="form-control col-8" id="updateName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">电话:</label>
                        <input type="text" class="form-control col-8" id="updatePhone">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">邮箱:</label>
                        <input type="text" class="form-control col-8" id="updateEmail">
                    </div>
                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="updateStudent()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal"><i class="fa fa-exclamation-circle"></i> 关闭</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="addTimeModel">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">会员卡续费</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">

                <form class="">
                    <input style="display: none" id="stuId" />
                    <div class="form-group flex-display">
                        <label class="col-4">续费时长：</label>
                        <select class="form-control col-8" id="sumTime">
                            <option value="1">一个月</option>
                            <option value="2">一个季度</option>
                            <option value="3">一年</option>
                        </select>
                    </div>
                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="addMemberTime()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal"><i class="fa fa-exclamation-circle"></i> 关闭</button>
            </div>

        </div>
    </div>
</div>


</body>
<script src="${path}/js/sb-admin.min.js"></script>
</html>
<script>

    $(function(){
        $('#datetimepicker1').datetimepicker({
            format: 'L'
        });
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
            //showToggle: true,
            carView: false,
            detailView: false,
            //得到查询的参数
             queryParams : function (params) {
                 //这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
                 var temp = {
                             rows: params.limit,                         //页面大小
                             page: (params.offset / params.limit) + 1,   //页码
                             stuName: $("#searhForm").find("input[name='stuName']").val(),
                             phone: $("#searhForm").find("input[name='phone']").val(),
                 };
                 return temp;
             },
                 columns: [ {
                         field: 'stuName',
                                 title: '姓名',

                     }, {
                         field: 'phone',
                                 title: '手机',

                     }, {
                         field: 'email',
                                 title: '邮箱',


                     },
                     {
                         field: 'birthday',
                        title: '生日',
                     formatter: function (value,row,index) {

                         return changeDateFormat(Date.parse(value));
                        }
                     },
                     {
                     field: 'cardName',
                     title:'会员卡类型'
                 },{
                     field:'stuId',
                     title: '操作',
                     width: 120,
                     align: 'center',
                     formatter: actionFormatter

                 }
                 ]
        })
    }
    function searchTable(){
        $('#tb_roles').bootstrapTable('refresh')
    }
    function actionFormatter(value, row, index){
        var id=value;
        var result="";
        result += "<a href='javascript:;' class='btn' onclick=\"ViewById('"+ id +"')\" title='会员卡转让'><i class='fa fa-arrow-right'></i></a>"
        result += "<a href='javascript:;' class='btn' onclick=\"addTime('"+ id +"')\" title='会员卡续费'><i class='fa fa-pencil-square-o'></i></a>"

        return result;
    }
    function ViewById(id) {
        $('#changeModel').modal('show');
        $('#cardId').val(id+"");

    }
    function addTime(id){
        $('#addTimeModel').modal('show');
        $('#stuId').val(id);


    }
    function updateStudent() {
        debugger
        var updateStudent ={
            stuId:$('#cardId').val(),
            stuName:$('#updateName').val(),
            phone:$('#updatePhone').val(),
            email:$('#updateEmail').val()
        }
        $.ajax({
            type:'POST',
            url:'member/updateStudent',
            data:updateStudent,
            dataType:"json",
            success: function (data){
                $.alert(data.msg);
                $('#changeModel').modal('hide');
                $('#tb_roles').bootstrapTable('refresh')
            },
            error:function(){
                $.alert("请求失败");
                $('#changeModel').modal('hide');
            },
        })
        $('#updateName').val('');
            $('#updatePhone').val('');
           $('#updateEmail').val('');
    }
    function addMemberTime(){
        var  student={
            stuId:$('#stuId').val(),
            cardId:$('#sumTime').val()
        }
        $.ajax({
            type:'POST',
            url:'member/addMemberTime',
            data:student,
            dataType:"json",
            success: function (data){
                $.alert(data.msg);
                $('#addTimeModel').modal('hide');
                $('#tb_roles').bootstrapTable('refresh')
            },
            error:function(){
                $.alert("请求失败");
                $('#addTimeModel').modal('hide');
            },
        })

    }
    function  resertForm(){
        $(':input','#searhForm')
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
    }
    function addStudent() {
        var student={
            stuName:$('#addName').val(),
            phone:$('#addPhone').val(),
            email:$('#addEmail').val(),
            birthday:$('#datetimepicker1').val(),
            cardId:$('#addCard').val(),
        }


       $.ajax({
            type:'POST',
            url:'member/addStudent',
            data:student,
            dataType:"json",
            success: function (data){
                $.alert(data.msg);
                $('#myModal').modal('hide');
                $('#tb_roles').bootstrapTable('refresh')
             },
            error:function(){
               $.alert("请求失败");
                $('#myModal').modal('hide');
            },
    })

                $('#addName').val("");
                $('#addPhone').val("");
                $('#addEmail').val("");
                $('#datetimepicker1').val("");
                $('#addCard').val("");
    }


    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            return date.getFullYear() + "-" + month + "-" + currentDate;
        }
    }



</script>
<style>
    .dropdown-toggle{
        background-color:#007bff;
        border-color:#007bff;
    }
    .dropdown-toggle:hover{
        background-color:#007bff;
    }
    .dropdown-toggle:focus{
        background-color:#007bff;
    }
    .dropdown-toggle:active{
        background-color:#007bff;
    }
    .btn-secondary:not(:disabled):not(.disabled).active, .btn-secondary:not(:disabled):not(.disabled):active, .show>.btn-secondary.dropdown-toggle{
        background-color:#007bff;
    }
</style>