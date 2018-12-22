<!doctype html>
<html lang="zh">

<#include "public/title.ftl">

<body class="home blog custom-background round-avatars">
<#--头部-->
	<#include "public/head.ftl">
<#--内容-->

<div class="container">

    <h1 class="page-title" id="title"></h1>

    <p class="Searchmeta">共计 <span id="articleCount"></span> 篇文章</p>

    <div class="location">当前位置：
        <a href="index.html">首页</a> &raquo; <span id="showSearch"></span>
    </div>

    <div id="articleList">

    </div>

    <div class="mt+">
        <div class="pagination js-pagination">

            <div class="js-next pagination__load"></div>

        </div>
    </div>

</div>

<#--尾部-->
		<#include "public/foot.ftl">

</body>

<script type="text/javascript">
    $(function () {

        var searchType = getQueryString("searchType");

        if (searchType == "keyWord") {

            getArticleListByKeyWord({"keyWord": getQueryString("keyWord")}, function (result) {

                showData("以'" + getQueryString("keyWord") + "'为关键字", " 搜索结果 » " + getQueryString("keyWord"), result);
            });
        }

        if (searchType == "tagId") {

            getArticleListByTagId({"tagId": getQueryString("tagId")}, function (result) {

                showData("分类：" + getQueryString("tagName"), "<a href='link.html'>分类</a> » " + getQueryString("tagName"), result);
            })
        }


        function showData(title, showSearch, result) {

            $("#title").html(title);
            $("#showSearch").html(showSearch);
            $("#articleCount").html(result.dataList.length);

            var str = "";
            for (var i = 0; i < result.dataList.length; i++) {

                var createDate = result.dataList[i].createDate
                createDate = String(createDate).split("T")[0];

                str += "        <div class=\"posts-list js-posts\">\n" +
                        "            <div class=\"archive-post\">\n" +
                        "                <div class=\"type\">\n" +
                        "                    <div class=\"mask\"><i class=\"iconfont\">&#xe603;</i></div>\n" +
                        "                </div>\n" +
                        "                <h2 class=\"archive-title\" style=\"color: #\">\n" +
                        "          <span>\n" +
                        "          <a href=\"detail.html?id=" + result.dataList[i].id + "\">" + result.dataList[i].title + "</a>\n" +
                        "          </span>\n" +
                        "                    <div class=\"post-time\">" + createDate + "</div>\n" +
                        "                </h2>\n" +
                        "                <div class=\"post-category\">\n" +
                        "                    <a href=\"javascript:;\" rel=\"category tag\">" + result.dataList[i].tagName + "</a>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>"
            }

            $("#articleList").html(str);
        }

    })
</script>

</html>