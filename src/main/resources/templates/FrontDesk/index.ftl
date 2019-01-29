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

        var currentPage = 1;

        getPageList();

        $("#articleList").on("click", ".canPre", function (e) {
            currentPage--;
            getPageList();
        })

        $("#articleList").on("click", ".canNext", function (e) {
            currentPage++;
            getPageList();
        })

        $("#articleList").on("click", ".pageBtn", function (e) {
            currentPage = $(e.target).attr("page");
            getPageList();
        })

        function getPageList() {
            getArticleList({"authorId": 1, "currentPage": currentPage}, function (result) {
                var str = "";
                var list = result.data.records;
                for (var i = 0; i < list.length; i++) {
                    str += "<div class=\"post post-layout-list\" data-aos=\"fade-up\">" +
                            "<div class=\"status_list_item icon_kyubo\">" +
                            "<div  class=\"status_user\">" +
                            "<div class=\"status_section\">" +
                            "<a href=\"detail.html?id=" + list[i].id + "\" class=\"status_btn\">" + list[i].title + "</a>" +
                            "<p class=\"section_p\">" + list[i].summary + "</p>" +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</div>"
                }

                var pageStr = "";
                for (var i = 1; i <= result.data.pages; i++) {

                    if (i == 1) {

                        if (currentPage == i) {

                            pageStr += "<li class=\"disabled\"><a href='javascript:;' aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span> </a></li>";
                        } else {

                            pageStr += "<li class=\"canPre\"><a href='javascript:;' aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span> </a></li>";
                        }
                    }

                    if (currentPage == i) {
                        pageStr += "<li class=\"active\"><a href='javascript:;'>" + i + "</a></li>";
                    } else {
                        pageStr += "<li class=\"pageBtn\"><a href='javascript:;' page=" + i + " + >" + i + "</a></li>";
                    }

                    if (i == result.data.pages) {

                        if (currentPage == i) {
                            pageStr += "<li class=\"disabled\"><a href='javascript:;' aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span> </a></li>";
                        } else {
                            pageStr += "<li class=\"canNext\"><a href='javascript:;' aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span> </a></li>";
                        }
                    }
                }

                /*        var pageDivStr = "<nav id=\"comments-navi\">" +
                                "                        <a class=\"prev page-numbers\" href=\"javascript:;\">" +
                                "                        <</a>" +
                                "                        <a class='page-numbers' href=\"javascript:;\">1</a>" +
                                "                        <a class='page-numbers' href=\"javascript:;\">2</a>" +
                                "                        <a class='page-numbers' href=\"javascript:;\">3</a>" +
                                "                        <span aria-current='page' class='page-numbers current'>4</span>" +
                                "          </nav>";*/

                var pageDivStr = "<ul class=\"pagination pagenav\" id=\"page\" style='margin-left:30%;'>" +
                        pageStr +
                        "</ul>"

                str += "<div class=\"post post-layout-list\" data-aos=\"fade-up\">" +
                        pageDivStr +
                        "</div>";

                $("#articleList").html(str);
            })
        }
    })
</script>

</body>

</html>