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
    <script src="${path}/js/base.js"></script>
    <script src="${path}/js/jquery-confirm.min.js"></script>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="#">Small LazyWorm</a>

    <button class="btn btn-link btn-sm  order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fa fa-bars"></i>
    </button>
    <!-- Navbar -->
    <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
        <li class="nav-item active">
            <a class="nav-link" href="#">
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
    </ul>
    <div id="content-wrapper">

        <div class="container-fluid">
            <div class="card mb-3">

                <div class="search-form" style="padding: 30px">
                    <form class="form-inline" id="search-coachs">
                        <div class="form-group col-4">
                            <label  class="col-3">姓名:</label>
                            <input type="text" name="coachName" class="form-control col-9">
                        </div>
                        <div class="form-group col-4">
                            <label  class="col-3">等级:</label>
                            <select class="form-control col-8" id="searchGrade">
                                <option value="1">初级</option>
                                <option value="2">中级</option>
                                <option value="3">高级</option>
                           </select>
                        </div>
                        <div class="form-group col-4">
                            <label class="col-3">电话:</label>
                            <input type="text" name="coachPhone" class="form-control col-9">
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
                            <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#addCoachModal"><i class="fa fa-plus"></i> 新增</button>
                        </div>
                        <table id="tb_coachs" class="table table-striped table-hover table-sm" data-filter-control="true">

                    </div>
                </div>
            </div>
        </div>
    </div>



</div>
<div class="modal fade" id="addCoachModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">新增教练</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body padding-30">
                <form class="">

                    <div class="form-group flex-display">
                        <label class="col-4">姓名:</label>
                        <input type="text" class="form-control col-8" id="addCoachName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">电话:</label>
                        <input type="text" class="form-control col-8" id="addCoachPhone">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">生日:</label>
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                        </div>
                        <input type="text" class="form-control col-7 datetimepicker-input"
                               id="coachBirthday" data-toggle="datetimepicker" data-target="#coachBirthday">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">性别:</label>
                        <select class="form-control col-8" id="addCoachSex">
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">级别:</label>
                        <select class="form-control col-8" id="addCoachGrade">
                            <option value="1">初级</option>
                            <option value="2">中级</option>
                            <option value="3">高级</option>
                        </select>
                    </div>
                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="addCoach()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal"><i class="fa fa-exclamation-circle"></i> 关闭</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="updateCoachModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">编辑教练信息</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body padding-30">
                <form class="">
                    <input type="text" style="display: none" id="coachId">
                    <div class="form-group flex-display">
                        <label class="col-4">姓名:</label>
                        <input type="text" class="form-control col-8" id="updateCoachName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">电话:</label>
                        <input type="text" class="form-control col-8" id="updateCoachPhone">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">生日:</label>
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                        </div>
                        <input type="text" class="form-control col-7 datetimepicker-input" id="updateBirthday" data-toggle="datetimepicker" data-target="#updateBirthday">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">级别:</label>
                        <select class="form-control col-8" id="updateCoachGrade">
                            <option value="1">初级</option>
                            <option value="2">中级</option>
                            <option value="3">高级</option>
                        </select>
                    </div>
                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="updateCoach()"><i class="fa fa-check-square-o"></i> 提交</button>
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
        $('#datetimepicker').datetimepicker({
            format: 'L'
        });
        InitMainTable();
    });
    function InitMainTable(){
        $('#tb_coachs').bootstrapTable({
            url: 'coach/coachList',
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
                    coachName: $("#search-coachs").find("input[name='coachName']").val(),
                    phone: $("#search-coachs").find("input[name='coachPhone']").val(),
                    grade:$("#searchGrade").val()
                };
                return temp;
            },
            columns: [ {
                field: 'coachName',
                title: '姓名',

            }, {
                field: 'phone',
                title: '手机',

            }, {
                field: 'sex',
                title: '性别',
                formatter: function (value, row, index){
                    if(value==1){
                        return '女';
                    }else {
                        return '男';
                    }
                }


            }, {
                field: 'birthday',
                title: '生日',
                formatter: function (value,row,index) {

                   return changeDateFormat(Date.parse(value));
                }
            },{
                field: 'grade',
                title:'等级',
                formatter: function (value, row, index){
                    if(value==1){
                        return '初级';
                    }else if(value==2){
                        return '中级';
                    }else {
                        return '高级';
                    }
                }
            },{
                field:'coachId',
                title: '操作',
                width: 120,
                align: 'center',
                formatter: actionFormatter

            }
            ]
        })
    }

    function actionFormatter(value, row, index){
        var id=value;
        var result="";
        result += "<a href='javascript:;' class='btn' onclick=\"ViewById('"+ id +"')\" title=''><i class='fa fa-pencil-square-o'></i></a>"
        return result;
    }
    function addCoach(){
        var coach={
            coachName:$('#addCoachName').val(),
            sex:$('#addCoachSex').val(),
            birthday:$('#coachBirthday').val(),
            grade:$('#addCoachGrade').val(),
            phone:$('#addCoachPhone').val()
        }
        $.ajax({
            type:'POST',
            url:'coach/addCoach',
            data:coach,
            dataType:"json",
            success: function (data){
                $.alert(data.msg);
                $('#addCoachModal').modal('hide');
                $('#tb_coachs').bootstrapTable('refresh')
            },
            error:function(){
                $.alert("请求失败");
                $('#addCoachModal').modal('hide');
            },
        })

        $('#addCoachName').val("");
        $('#coachBirthday').val("");
        $('#addCoachPhone').val("");

    }
    function ViewById(id) {
        $('#coachId').val(id);
        $.ajax({
            type:'GET',
            url:'coach/getCoach/'+id,
            dataType:"json",
            success: function (data){
                $('#updateCoachName').val(data.data.coachName)
                $('#updateCoachPhone').val(data.data.phone)
                $('#updateBirthday').val(data.data.birthdayStr)
                $('#updateCoachGrade').val(data.data.grade)
                $('#updateCoachModal').modal('show')
            },
            error:function(){
                $.alert("请求失败");
            },
        })

    }
    function updateCoach() {
        var coach={
            coachId:$('#coachId').val(),
            coachName:$('#updateCoachName').val(),
            grade:$('#updateCoachGrade').val(),
            phone:$('#updateCoachPhone').val()
        }
        $.ajax({
            type:'POST',
            url:'coach/updateCoach',
            data:coach,
            dataType:"json",
            success: function (data){
                $.alert(data.msg);
                $('#updateCoachModal').modal('hide');
                $('#tb_coachs').bootstrapTable('refresh')
            },
            error:function(){
                $.alert("请求失败");
                $('#updateCoachModal').modal('hide');
            },
        })
        
    }
    function  resertForm(){
        $(':input','.form-inline')
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
    }
    /**
     * 时间戳格式化函数
     * @param  {string} format    格式
     * @param  {int}    timestamp 要格式化的时间 默认为当前时间
     * @return {string}           格式化的时间字符串
     */
    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            return date.getFullYear() + "-" + month + "-" + currentDate;
        }
    }
    function searchTable() {
        $('#tb_coachs').bootstrapTable('refresh')
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