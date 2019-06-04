<!DOCTYPE html>
<#assign path="${springMacroRequestContext.getContextPath()}"/>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>欢迎你</title>
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
    <script src="${path}/js/jquery-confirm.min.js"></script>
    <script src="${path}/js/base.js"></script>
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
            <a class="nav-link " href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
        <li class="nav-item active">
            <a class="nav-link" href="#">
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
                    <form class="form-inline" id="search-courses">

                        <div class="form-group col-4">
                            <label  class="col-4">课程名字:</label>
                            <input type="text" name="courseName" class="form-control col-8">
                        </div>
                        <div class="form-group col-4">
                            <label  class="col-4">教练名字:</label>
                            <input type="text" name="coachName"  class="form-control col-8">
                        </div>
                        <div class="form-group col-4">
                            <label class="col-4">教室:</label>
                            <input type="text" name="roomName" class="form-control col-8">
                        </div>


                        <div class="form-group col-4 margin-top-30">
                            <label class="col-4">开课时间:</label>
                            <input type="text" name="courseTimeStart" class="form-control col-8 datetimepicker-input" id="datetimepicker1" data-toggle="datetimepicker" data-target="#datetimepicker1">
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
                            <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#addCourseModal"><i class="fa fa-plus"></i> 新增</button>
                        </div>

                        　<table id="tb_courses" class="table table-striped table-hover table-sm" data-filter-control="true">
                    </table>

                    </div>
                </div>
            </div>
        </div>
    </div>



</div>
<div class="modal fade" id="addCourseModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">新增课程</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form class="">

                    <div class="form-group flex-display">
                        <label class="col-4">课程名称:</label>
                        <input type="text" class="form-control col-8" id="addName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">上课教练:</label>
                        <select class="form-control col-8" id="addCoach">
                        </select>
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">教室:</label>
                        <select class="form-control col-8" id="addRoom">

                        </select>
                    </div>
                    <div class="form-group flex-display">
                    <label  class="col-4">开课时间:</label>
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    <input type="text" class="form-control col-7 datetimepicker-input" id="courseTimeStart" data-toggle="datetimepicker" data-target="#courseTimeStart">
                </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">下课时间:</label>
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                        </div>
                        <input type="text" class="form-control col-7 datetimepicker-input" id="courseTimeEnd" data-toggle="datetimepicker" data-target="#courseTimeEnd">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">课程容量:</label>
                        <input type="text" class="form-control col-8" id="courseCapacity">
                    </div>
                    <div class="form-group" style="display:flex;">
                        <label  class="col-4">课程类型:</label>
                        <select class="form-control col-8" id="courseType">
                            <option value="1">团体课程</option>
                            <option value="2">私教课程</option>
                        </select>
                    </div>

                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="addCourse()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal"><i class="fa fa-exclamation-circle"></i> 关闭</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="eidtCourseModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">编辑课程</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form class="">
                    <input style="display: none" id="courseId">

                    <div class="form-group flex-display">
                        <label class="col-4">课程名称:</label>
                        <input type="text" class="form-control col-8" id="eidtName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">上课教练:</label>
                        <select class="form-control col-8" id="eidtCoach">
                        </select>
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">教室:</label>
                        <select class="form-control col-8" id="eidtRoom">

                        </select>
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">开课时间:</label>
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                        </div>
                        <input type="text" class="form-control col-7 datetimepicker-input" id="eidtTimeStart" data-toggle="datetimepicker" data-target="#eidtTimeStart">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">下课时间:</label>
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                        </div>
                        <input type="text" class="form-control col-7 datetimepicker-input"
                               id="eidtTimeEnd" data-toggle="datetimepicker" data-target="#eidtTimeEnd">
                    </div>
                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="eidtCourse()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal"><i class="fa fa-exclamation-circle"></i> 关闭</button>
            </div>

        </div>
    </div>
</div>

</body>
<script src="${path}/js/sb-admin.min.js"></script>
<script>

    $(function(){
        $('.datetimepicker-input').datetimepicker({
        });
        getCoachList();
        getRoomList();
        InitMainTable();
    });
    function InitMainTable () {

        $('#tb_courses').bootstrapTable({
            url: 'course/courseList',
            contentType : "application/x-www-form-urlencoded",
            dataType:"json",
            method: 'POST',
            striped: true,
            cache: false,
            pagination: true,
            sortable: true,
            sortOrder: "asc",
            sidePagination: 'server',
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
                    courseName: $("#search-courses").find("input[name='courseName']").val(),
                    coachName: $("#search-courses").find("input[name='coachName']").val(),
                    roomName:$("#search-courses").find("input[name='roomName']").val(),
                  //  courseTimeStart:$("#search-courses").find("input[name='courseTimeStart']").val(),
                };
                return temp;
            },
            columns: [ {
                field: 'courseName',
                title: '课程名称',

            }, {
                field: 'courseTimeStart',
                title: '开课时间',
                formatter: function (value,row,index) {

                    return timestampToTime(Date.parse(value));
                }
            },
                {
                field: 'courseTimeEnd',
                title: '下课时间',
            formatter: function (value,row,index) {

                return timestampToTime(Date.parse(value));
            }
        },


            {
               field: 'roomName' ,
                title: '上课教室',
            },{
              field: 'coachName',
              title: '教练名字',
            },{
              field: 'courseType',
                title:'课程类型',
                    formatter: function (value,row,index) {
                        if(value==1){
                            return '团体课';
                        }else{
                            return '私教课';
                        }
                    }

            },{
              field: 'courseCapacity' ,
              title: '课程容量'
            },
                {
                    field:'courseId',
                    title: '操作',
                    width: 120,
                    align: 'center',
                    formatter: actionFormatter

                }
            ]
        })
    }
    function actionFormatter(value,row,index){
        var id=value;
        var result="";
        result += "<a href='javascript:;' class='btn' onclick=\"ViewById('"+ id +"')\" title='编辑'><i class='fa fa-pencil-square-o'></i></a>"
        result += "<a href='javascript:;' class='btn' onclick=\"deleteById('"+ id +"')\" title='撤销课程'><i class='fa fa-trash'></i></a>"
        return result;
    }
    function ViewById(id){

        $('#courseId').val(id);
        $.ajax({
            type:'GET',
            url:'course/getCourse/'+id,
            dataType:"json",
            success: function (data){
                if(data.code==0){
                    $('#eidtName').val(data.data.courseName);
                    $('#eidtCoach').val(data.data.coachId);
                    $('#eidtRoom').val(data.data.roomId);
                    $('#eidtTimeStart').val(timestampToTime(data.data.courseTimeStart));
                    $('#eidtTimeEnd').val(timestampToTime(data.data.courseTimeEnd));
                    $('#eidtCourseModal').modal('show');

                }else{
                    alert(data.msg);
                }

            },
            error:function(){
                alert("请求失败");

            },
        })

    }
    function eidtCourse(){
        var course = {
            courseId:$('#courseId').val(),
            courseName: $('#eidtName').val(),
            coachId:$('#eidtCoach').val(),
            roomId: $('#eidtRoom').val(),
            courseTimeStart:$('#eidtTimeStart').val(),
            courseTimeEnd:$('#eidtTimeEnd').val(),
        }

    }
    function deleteById(id) {
        $.confirm({
            title: '确认!',
            content: '确认要删除这个课程吗？',
            type: 'blue',
            icon: 'glyphicon glyphicon-question-sign',
            buttons: {
                ok: {
                    text: '确认',
                    btnClass: 'btn-primary',
                    action: function () {
                        var course = {
                            courseId: id,
                            isDelete: 1,
                        }
                        $.ajax({
                            type: 'POST',
                            url: 'course/deleteCourse',
                            data: course,
                            dataType: "json",
                            success: function (data) {
                                $.alert(data.msg);
                                $('#tb_courses').bootstrapTable('refresh')
                            },
                            error: function () {
                                $.alert("请求失败");

                            },
                        })
                    }
                },
                cancel: {
                    text: '取消',
                    btnClass: 'btn-primary'
                }
            }
        });

    }
    function timestampToTime(data) {    //时间戳为10位需*1000，时间戳为13位的话不需乘1000在转成yymmdd
        var date = new Date(data);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? ('0' + m) : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        var h = date.getHours();
        h = h < 10 ? ('0' + h) : h;
        var minute = date.getMinutes();
        var second = date.getSeconds();
        minute = minute < 10 ? ('0' + minute) : minute;
        second = second < 10 ? ('0' + second) : second;
        return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
    };
    function  resertForm(){
        $(':input','.form-inline')
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
    }
    function addCourse() {
        var course = {
            courseName: $('#addName').val(),
            coachId:$('#addCoach').val(),
            roomId: $('#addRoom').val(),
            courseCapacity:$('#courseCapacity').val(),
            courseSurplus:$('#courseCapacity').val(),
            courseType:$('#courseType').val(),
            courseTimeStart:$('#courseTimeStart').val(),
            courseTimeEnd:$('#courseTimeStart').val(),
        }
        $.ajax({
            type:'POST',
            url:'course/addCourse',
            dataType:"json",
            data:course,
            success: function (data){
                $.alert(data.msg);
                if(data.code==0){
                    $('#tb_courses').bootstrapTable('refresh')
                }
            },
            error:function(){
                $.alert("请求失败");

            },

        })
    }
    function searchTable() {
        $('#tb_courses').bootstrapTable('refresh')
    }
    function getCoachList() {
        $.ajax({
            type:'GET',
            url:'course/getCoachList',
            dataType:"json",
            async: false,
            success: function (data){
                var list = data.data;
                if(null!=list) {
                    for (var i = 0; i < list.length; i++) {
                        var option = document.createElement("option");
                        $(option).val(list[i].coachId);
                        $(option).text(list[i].coachName);
                        $('#addCoach').append(option);
                       // $('#eidtCoach').append(option);
                    }
                    for (var i = 0; i < list.length; i++) {
                        var option = document.createElement("option");
                        $(option).val(list[i].coachId);
                        $(option).text(list[i].coachName);
                       // $('#addCoach').append(option);
                        $('#eidtCoach').append(option);
                    }
                }

            },
            error:function(){
                $.alert("请求失败");

            },
        })

    }
    function getRoomList() {
        $.ajax({
            type:'GET',
            url:'course/getRoomList',
            dataType:"json",
            async: false,
            success: function (data){
                var list = data.data;
                if(null!=list) {
                    for (var i = 0; i < list.length; i++) {
                        var option = document.createElement("option");
                        $(option).val(list[i].roomId);
                        $(option).text(list[i].roomName);
                        $('#addRoom').append(option);
                       // $('#eidtRoom').append(option)
                    }
                    for (var i = 0; i < list.length; i++) {
                        var option = document.createElement("option");
                        $(option).val(list[i].roomId);
                        $(option).text(list[i].roomName);
                       // $('#addRoom').append(option);
                        $('#eidtRoom').append(option)
                    }
                }

            },
            error:function(){
                alert("请求失败");

            },
        })

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
</html>