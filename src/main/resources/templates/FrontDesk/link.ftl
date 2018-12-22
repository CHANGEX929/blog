<!doctype html>
<html lang="zh">

<#include "public/title.ftl">

<body class="home blog custom-background round-avatars">
<#--头部-->
	<#include "public/head.ftl">
<#--内容-->
<div class="container">
    <style>
        body.custom-background {
            background: #fff
        }

        .container {
            padding: 10px 0px;
        }
    </style>
    <section style="padding-top: 50px;" class="post_content">
        <header class="post_header">
            <h1 class="post_title">分类</h1>
        </header>
        <div class="links">
        <#--<h3 class="catalog-title">CHANGEX-SITE</h3>-->
            <div class="catalog-description"></div>
            <div class="catalog-share" id="count"></div>
            <div class="userItems" id="categoryList">
            </div>
        </div>
    </section>
</div>

<#--尾部-->
		<#include "public/foot.ftl">

</body>

<script type="text/javascript">
    $(function () {
        //显示栏目
        getCategoryList({"authorId": 1}, function (result) {

            var str = ""

            for (var i = 0; i < result.dataList.length; i++) {
                str += "    <div class=\"userItem\">\n" +
                        "                        <div class=\"userItem--inner\">\n" +
                        "                            <div class=\"userItem-content\"><img alt='' src=''\n" +
                        "                                                               class='avatar avatar-64 photo' height='64' width='64'/>\n" +
                        "                                <div class=\"userItem-name\">\n" +
                        "                                    <a class=\"link link--primary\" href=\"search.html?tagId=" + result.dataList[i].id + "&searchType=tagId&tagName=" + result.dataList[i].name + "\" >" + result.dataList[i].name + "</a>\n" +
                        "                                </div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </div>";
            }

            $("#categoryList").html(str);
            $("#count").html(result.dataList.length + " items in collection");
        });
    })
</script>

</html>