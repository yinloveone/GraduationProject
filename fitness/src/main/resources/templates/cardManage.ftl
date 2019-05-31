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
        <li class="nav-item  active">
            <a class="nav-link" href="#">
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
                    <form class="form-inline" id="search-card">
                        <div class="form-group col-4">
                            <label  class="col-4">卡名:</label>
                            <input type="text" name="cardName" class="form-control col-8">
                        </div>
                        <div class="form-group col-4">
                            <label  class="col-4">是否有效:</label>
                            <select class="form-control col-8" id="cardValid">
                                <option value="1">有效</option>
                                <option value="2">无效</option>
                            </select>
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
                            <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#addCardModal"><i class="fa fa-plus"></i> 新增</button>
                        </div>
                        <table id="tb_cards" class="table table-striped table-hover table-sm" data-filter-control="true">
                        </table>

                     </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addCardModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">增加会员卡</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form>
                    <div class="form-group flex-display">
                        <label class="col-4">会员卡名字:</label>
                        <input type="text" class="form-control col-8" id="cardName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">价格:</label>
                        <input type="text" class="form-control col-8" id="cardPrice">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">卡的类型:</label>
                        <select class="form-control col-8" id="cardType">
                            <option value="1">月卡</option>
                            <option value="2">季卡</option>
                            <option value="3">年卡</option>
                        </select>
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">是否有效:</label>
                        <select class="form-control col-8" id="addValid">
                            <option value="1">有效</option>
                            <option value="2">无效</option>
                        </select>
                    </div>
                </form>
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="addCard()"><i class="fa fa-check-square-o"></i> 提交</button>
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">关闭</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="updateCardModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">会员卡编辑</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form>
                    <input type="text" style="display: none" id="updateCardId">
                    <div class="form-group flex-display">
                        <label class="col-4">会员卡名字:</label>
                        <input type="text" class="form-control col-8" id="updateCardName">
                    </div>
                    <div class="form-group flex-display">
                        <label class="col-4">价格:</label>
                        <input type="text" class="form-control col-8" id="updatePrice">
                    </div>
                    <div class="form-group flex-display">
                        <label  class="col-4">是否有效:</label>
                        <select class="form-control col-8" id="updateValid">
                            <option value="1">有效</option>
                            <option value="0">无效</option>
                        </select>
                    </div>
                </form>
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" onclick="updateCard()"><i class="fa fa-check-square-o"></i> 提交</button>

                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">关闭</button>
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

        $('#tb_cards').bootstrapTable({
            url: 'card/CardList',
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
                    cardName: $("#search-card").find("input[name='cardName']").val(),
                    isValid: $("#cardValid").val(),
                };
                return temp;
            },
            columns: [ {
                field: 'cardName',
                title: '会员卡名称',

            }, {
                field: 'price',
                title: '价钱',

            }, {
                field: 'isValid',
                title: '是否有效',
                formatter: function (value,rows,index) {
                    if(value==1){
                        return '有效';
                    }else{
                        return '无效';
                    }
                }


            }, {
                    field:'cardId',
                    title: '操作',
                    width: 120,
                    align: 'center',
                    formatter: actionFormatter

                }
            ]
        })
    }
    function actionFormatter(value,rows,index) {
        var id=value;
        var result="";
        result += "<a href='javascript:;' class='btn' onclick=\"ViewById('"+ id +"')\" title='编辑'><i class='fa fa-pencil-square-o'></i></a>"
        result += "<a href='javascript:;' class='btn' onclick=\"deleteById('"+ id +"')\" title='删除会员卡'><i class='fa fa-trash'></i></a>"
        return result;
    }
    function ViewById(id){
        $('#updateCardId').val(id);

        $.ajax({
            type: 'GET',
            url: 'card/getCard/'+id,
            dataType: "json",
            success: function (data) {
                $('#updateCardName').val(data.data.cardName),
                $('#updatePrice').val(data.data.price),
                $('#updateValid').val(data.data.isValid),
                $('#updateCardModal').modal('show');

            },
            error: function () {
                $.alert("请求失败");

            },
        })
    }
    function deleteById(id) {
        $.confirm({
            title: '确认!',
            content: '确认要删除此会员卡吗？',
            type: 'blue',
            icon: 'glyphicon glyphicon-question-sign',
            buttons: {
                ok: {
                    text: '确认',
                    btnClass: 'btn-primary',
                    action: function () {
                        var card = {
                            cardId: id,
                            isDelete: 1,
                        }
                        $.ajax({
                            type: 'POST',
                            url: 'course/deleteCard',
                            data: card,
                            dataType: "json",
                            success: function (data) {
                                $.alert(data.msg);
                                $('#tb_cards').bootstrapTable('refresh')
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
    function addCard() {
        var card = {
            cardName:$('#cardName').val(),
            price:$('#cardPrice').val(),
            cardType:$('#cardType').val(),
            isValid:$('#addValid').val(),
        }
        $.ajax({
            type: 'POST',
            url: 'card/addCard',
            data: card,
            dataType: "json",
            success: function (data) {
                $('#addCardModal').modal('hide');
                $.alert(data.msg);
                $('#tb_cards').bootstrapTable('refresh')
            },
            error: function () {
                $.alert("请求失败");

            },
        })

    }
    function updateCard() {
        var card = {
            cardId:$('#updateCardId').val(),
            cardName:$('#updateCardName').val(),
            price:$('#updatePrice').val(),
            isValid:$('#updateValid').val(),
        }
        $.ajax({
            type: 'POST',
            url: 'card/updateCard',
            data: card,
            dataType: "json",
            success: function (data) {
                $('#updateCardModal').modal('hide');
                $.alert(data.msg);
                $('#tb_cards').bootstrapTable('refresh')
            },
            error: function () {
                $.alert("请求失败");

            },
        })
    }
    function searchTable(){
        $('#tb_cards').bootstrapTable('refresh')
    }
    function  resertForm(){
        $(':input','#search-card')
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
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