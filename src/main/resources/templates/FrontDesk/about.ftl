<!doctype html>
<html lang="zh">

<#include "public/title.ftl">

<body class="home blog custom-background round-avatars">
<#--头部-->
	<#include "public/head.ftl">
<#--内容-->

<div class="container">
    <article itemscope="itemscope" id="pageContent">

    </article>
</div>
<#--尾部-->
<#include "public/foot.ftl">

<script type="text/javascript">
    $(function () {
        getHtmlPageByType({"type": "ABOUT"}, function (result) {

            $("#pageContent").html(result.data.content);
        })
    })
</script>