<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>CHANGEX-SITE</title>
    <link rel="shortcut icon" href="../images/webicon.png">
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="stylesheet" type="text/css" href="../../css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="../../images/icon/icon.png">
    <link rel="stylesheet" type="text/css" href="../../font_Icon/iconfont.css">
    <link rel="stylesheet" type="text/css" href="../../css/chat.css">
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type='text/javascript' src='../../js/jquery-3.3.1.min.js'></script>
</head>

<body class="user-select">
<section class="container-fluid">
    <header>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false"><span
                            class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                        <span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="/">CHANGEX</a></div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                    <#-- <li><a href="">消息 <span class="badge">1</span></a></li>-->
                        <li class="dropdown">

                        <#--      <a class="dropdown-toggle dropdown-menu dropdown-menu-left" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                                 href="article.html?article">文章</a>

                              <a class="dropdown-toggle dropdown-menu dropdown-menu-left" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                                 href="category.html?category">栏目</a>-->

                        <#--      <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                                 aria-haspopup="true" aria-expanded="false">
                                  admin
                                  <span class="caret"></span>
                              </a>-->

                        <#--  <ul class="dropdown-menu dropdown-menu-left">
                              <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>
                              <li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>
                          </ul>-->
                        </li>
                        <li><a href="javascript:;" id="logOutBtn">注销</a></li>
                    <#-- <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>-->
                    </ul>
                    <form action="javascript:;" method="post" class="navbar-form navbar-right" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索"
                                   maxlength="15">
                            <span class="input-group-btn">
              <button class="btn btn-default" type="submit">搜索</button>
              </span></div>
                    </form>
                </div>
            </div>
        </nav>
    </header>
    <div class="row">
        <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
        <#--    <ul class="nav nav-sidebar">
                <li <#if RequestParameters['report']??>

                    class="active"

                </#if>><a href="index.html?report">报告</a></li>
            </ul>-->
            <ul class="nav nav-sidebar">
                <li<#if RequestParameters['article']??>

                    class="active"

                </#if>><a href="article.html?article">文章</a></li>
            <#--            <li  <#if RequestParameters['notice']??>

                            class="active"

                        </#if>><a href="notice.html?notice">公告</a></li>-->
            <#--           <li  <#if RequestParameters['comment']??>

                           class="active"

                       </#if>><a href="comment.html?comment">评论</a></li>-->
            <#-- <li><a data-toggle="tooltip" data-placement="bottom" title="网站暂无留言功能">留言</a></li>-->
            </ul>
            <ul class="nav nav-sidebar">
                <li <#if RequestParameters['category']??>

                    class="active"

                </#if>><a href="category.html?category">栏目</a></li>
            <#--            <li <#if RequestParameters['other']??>

                            class="active"

                        </#if>><a class="dropdown-toggle" id="otherMenu" data-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false">其他</a>
                            <ul class="dropdown-menu" aria-labelledby="otherMenu">
                                <li><a href="flink.html?other">友情链接</a></li>
                                <li><a data-toggle="modal" data-target="#areDeveloping">访问记录</a></li>
                            </ul>
                        </li>-->
            </ul>
            <ul class="nav nav-sidebar">
                <li <#if RequestParameters['htmlPage']??>

                    class="active"

                </#if>><a href="htmlPage.html?htmlPage">页面</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li <#if RequestParameters['linker']??>

                    class="active"

                </#if>><a href="flink.html?linker">友情连接</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li <#if RequestParameters['chat']??>

                    class="active"

                </#if>><a href="chating.html?chat">聊天</a></li>
            </ul>
        <#--           <ul class="nav nav-sidebar">
                       <li <#if RequestParameters['user']??>

                           class="active"

                       </#if>><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true"
                              aria-expanded="false">用户</a>
                           <ul class="dropdown-menu" aria-labelledby="userMenu">
                               <li><a data-toggle="modal" data-target="#areDeveloping">管理用户组</a></li>
                               <li><a href="manage-user.html?user">管理用户</a></li>
                               <li role="separator" class="divider"></li>
                               <li><a href="loginlog.html?user">管理登录日志</a></li>
                           </ul>
                       </li>
                       <li  <#if RequestParameters['set']??>

                           class="active"

                       </#if>><a class="dropdown-toggle" id="settingMenu" data-toggle="dropdown" aria-haspopup="true"
                              aria-expanded="false" href="setting.html">设置</a>
                           <ul class="dropdown-menu" aria-labelledby="settingMenu">
                               <li><a href="setting.html?set">基本设置</a></li>
                               <li><a href="readset.html?set">阅读设置</a></li>
                               <li role="separator" class="divider"></li>
                               <li><a data-toggle="modal" data-target="#areDeveloping">安全配置</a></li>
                               <li role="separator" class="divider"></li>
                               <li class="disabled"><a>扩展菜单</a></li>
                           </ul>
                       </li>
                   </ul>-->
        </aside>