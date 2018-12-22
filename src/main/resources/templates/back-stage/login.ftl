<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CHANGEX-SITE</title>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="stylesheet" type="text/css" href="../../css/login.css">
    <link rel="apple-touch-icon-precomposed" href="../../images/icon/icon.png">
    <link rel="shortcut icon" href="../images/webicon.png">
    <script type='text/javascript' src='../../js/jquery-3.3.1.min.js'></script>

</head>


<body class="user-select">
<div class="container">
    <div class="siteIcon"><img src="../../images/webicon.png" alt="" data-toggle="tooltip" data-placement="top"
                               title="欢迎使用CHANGEX-SITE管理系统" draggable="false"/></div>
    <form id="loginForm" action="javascript:;" method="post" autocomplete="off" class="form-signin">
        <h2 class="form-signin-heading">管理员登录</h2>
        <label for="userName" class="sr-only">用户名</label>
        <input type="text" id="userName" name="userName" class="form-control" placeholder="请输入用户名" autofocus
               autocomplete="off">
        <label for="userPwd" class="sr-only">密码</label>
        <input type="password" id="userPwd" name="passWord" class="form-control" placeholder="请输入密码"
               autocomplete="off" maxlength="18">
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="signinSubmit">登录</button>
    </form>
    <div class="footer">
        <p>
            <a href="article.html?article" data-toggle="tooltip" data-placement="left" title="不知道自己在哪?"> →回到后台</a>
            <a href="../index.html" data-toggle="tooltip" data-placement="left" title="不知道自己在哪?"> →回到前台</a>
        </p>
    </div>
</div>
<#--尾部 BEGIN-->
<#include "public/foot.ftl">
<#--尾部 END-->
<script type="text/javascript">

    /*   $(function () {
           alert();
       })*/

    $('[data-toggle="tooltip"]').tooltip();
    window.oncontextmenu = function () {
        //return false;
    };
    $('.siteIcon img').click(function () {
        window.location.reload();
    });
    $('#signinSubmit').click(function () {
        if ($('#userName').val() === '') {
            $(this).text('用户名不能为空');
        } else if ($('#userPwd').val() === '') {
            $(this).text('密码不能为空');
        } else {
            $(this).attr("disabled", true);
            login($("#userName").val(), $("#userPwd").val());
            $(this).text('请稍后...');
        }
    });

    //登陆
    function login(userName, passWord) {
        doLogin({"userName": userName, "passWord": getPassWord(passWord)}, function (result) {
            if (result.data) {
                window.location.href = "article.html?article";
            } else {
                $('#signinSubmit').attr("disabled", false);
                $("#userName").val("");
                $("#userPwd").val("");
                $('#signinSubmit').text('登陆失败，请重试');
            }
        });
    }


</script>
</body>
</html>
