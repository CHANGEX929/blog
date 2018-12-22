<!doctype html>
<html lang="zh">

<#include "public/title.ftl">

<body class="home blog custom-background round-avatars">
<#--头部-->
	<#include "public/head.ftl">
<#--内容-->

<div class="container">
    <article itemscope="itemscope">
        <div class="posts-list js-posts" id="articleList">
        </div>
    </article>
</div>
<#--尾部-->
		<#include "public/foot.ftl">

<script type="text/javascript">
    $(function () {

        getArticleList({"authorId": 1}, function (result) {
            var str = "";
            for (var i = 0; i < result.dataList.length; i++) {
                str += "<div class=\"post post-layout-list\" data-aos=\"fade-up\">" +
                        "<div class=\"status_list_item icon_kyubo\">" +
                        "<div  class=\"status_user\"" +
                        "style=\"background-image: url(images/book.jpg);\">" +
                        "<div class=\"status_section\">" +
                        "<a href=\"detail.html?id=" + result.dataList[i].id + "\" class=\"status_btn\">" + result.dataList[i].title + "</a>" +
                        "<p class=\"section_p\">" + result.dataList[i].summary + "</p>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>"
            }
            $("#articleList").html(str);
        })
    })
</script>

</body>

</html>