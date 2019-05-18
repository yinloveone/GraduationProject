<#assign path="${springMacroRequestContext.getContextPath()}"/>
<head>
    <meta charset="UTF-8"/>
    <title>欢迎你</title>
</head>
<#--   <script src="${path}/js/jquery-3.3.1.js"></script>
    <script src="${path}/bootstrap-4.1.3-dist/js/bootstrap.js"></script>
    <link href="${path}/bootstrap-4.1.3-dist/css/bootstrap.css" rel="stylesheet" />
    <script src="${path}/js/bootstrap-table.min.js"></script>
    <link href="${path}/css/bootstrap-table.min.css" rel="stylesheet" />
    <script src="${path}/js/bootstrap-table-zh-CN.min.js"></script>-->
<body class="bare-body">
<header class="bare-header">
    <img src="${path}/img/1.png" height="100px" width="100px"/>
</header>
<main class="bare-main">
    <div class="authForm">
        <div class="text-center">
            <h1>登录</h1>
        </div>
        <form action="/api/loginPage" method="post">
            <div class="form-group">
                <label class="control-label">用户名:</label>
                <input class="form-control" name="name" type="text"/>
            </div>
            <div class="form-group">
                <label class="control-label">密码:</label>
                <input class="form-control" name="password" type="password"/>
            </div>
            <div class="btn-panel">
                <button class="btn btn-main">登陆</button>
            </div>
            <div class="a-panel">
                <a>忘了密码?</a>
            </div>
        </form>

    </div>
</main>
</body>
<style>
    .authForm form{
        padding: 20px;
    }
    form{
        display: block;
        margin-top: 0em;
    }
    .a-panel{
        padding: 0;
        text-align: center;
    }
    .form-group{
        padding: 0 10px;
        margin-bottom: 15px;
    }
    .form-control{
        background-color: #fff;
        border: 1px solid #dee0e3;
        padding-left: 15px;
        padding-right: 15px;
        font-weight: 400;
        min-height: 44px;
        display: block;
        width: 100%;
        height: 34px;
        border-radius: 4px;
    }
    .btn-panel{
        padding: 10px;
        display: block;
        width: 100%;
        text-align: center;
    }
    .btn{
        display: inline-block;
        padding: 6px 12px;
        margin-bottom: 0;
        font-size: 14px;
        font-weight: 400;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        border: 1px solid transparent;
        border-radius: 4px;
    }
    .btn-panel .btn{
        margin: 5px;
        min-width: 175px;
    }
    .btn-main{
        transition: background-color .15s linear,color .15s linear;
        color: #FFF;
        border: 1px solid #227d51;
        border-radius: 50px;
        background-color: #227d51;
    }
    .control-label{
        display: inline-block;
        max-width: 100%;
        margin-bottom: 5px;
        font-size: 12px;
        font-weight: 700;
        color: #1A1938;

    }
    .authForm {
        max-width: 500px;
        margin: 0 auto;
        border: 1px solid #dee0e3;
        background-color: #FFF;
        border-radius: 3px;
        padding: 20px;
        box-sizing: border-box;
    }

    .bare-body{
        min-height: 100%;
        background-color: #f9fafb;
        color: #1A1938;
    }
    .text-center{
        text-align: center;
    }
    .bare-header{
        background-color: transparent;
        padding: 80px 0 25px;
        text-align: center;
    }
    .bare-main{
        padding-bottom: 100px;
        background-color: #f9fafb;
    }
    a{
        font-weight: 400;
        color: #227d51;
        text-decoration: none;
    }
</style>