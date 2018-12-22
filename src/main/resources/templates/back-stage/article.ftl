<#--头部 BEGIN-->
<#include "public/head.ftl">
<#--头部 END-->
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
        <form action="/Article/checkAll" method="post">
            <h1 class="page-header">操作</h1>
            <ol class="breadcrumb">
                <li><a href="add-article.html?article">增加文章</a></li>
            </ol>
            <h1 class="page-header">管理 <span class="badge" id="articleCount"></span></h1>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th><span class="glyphicon glyphicon-th-large"></span> <span class="visible-lg">选择</span></th>
                        <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">标题</span></th>
                        <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">栏目</span></th>
                        <th class="hidden-sm"><span class="glyphicon glyphicon-tag"></span> <span
                                class="visible-lg">标签</span></th>
                        <th class="hidden-sm"><span class="glyphicon glyphicon-comment"></span> <span
                                class="visible-lg">评论</span></th>
                        <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">日期</span></th>
                        <th><span class="glyphicon glyphicon-lock"></span> <span class="visible-lg">是否加密</span></th>
                        <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                    </tr>
                    </thead>
                    <tbody id="article">
                    </tbody>
                </table>
            </div>
            <footer class="message_footer">
                <nav>
                    <div class="btn-toolbar operation" role="toolbar">
                        <div class="btn-group" role="group"><a class="btn btn-default" onClick="select()">全选</a> <a
                                class="btn btn-default" onClick="reverse()">反选</a> <a class="btn btn-default"
                                                                                      onClick="noselect()">不选</a></div>
                        <div class="btn-group" role="group">
                            <button type="submit" class="btn btn-default" data-toggle="tooltip" data-placement="bottom"
                                    title="删除全部选中" name="checkbox_delete">删除
                            </button>
                        </div>
                    </div>
                    <ul class="pagination pagenav">
                        <li class="disabled"><a aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a></li>
                    </ul>
                </nav>
            </footer>
        </form>
    </div>
  </div>
</section>
<#--尾部 BEGIN-->
<#include "public/foot.ftl">
<#--尾部 END-->
<script>
    //是否确认删除
    $(function () {
        $("#main table tbody tr td a").click(function () {
            var name = $(this);
            var id = name.attr("rel"); //对应id
            if (event.srcElement.outerText == "删除") {
                if (window.confirm("此操作不可逆，是否确认？")) {
                    $.ajax({
                        type: "POST",
                        url: "/Article/delete",
                        data: "id=" + id,
                        cache: false, //不缓存此页面
                        success: function (data) {
                            window.location.reload();
                        }
                    });
                }
            }
        });

        getArticleList({"authorId": 1}, function (result) {

            var str = "";
            for (var i = 0; i < result.dataList.length; i++) {
                var lockValue;
                if (result.dataList[i].isSecret == 1) {
                    lockValue = "否";
                } else {
                    lockValue = "是";
                }
                str += "<tr>\n" +
                        "   <td><input type=\"checkbox\" class=\"input-control\" name=\"checkbox[]\" value=\"\"/></td>\n" +
                        "   <td class=\"article-title\">" + result.dataList[i].title + "</td>\n" +
                        "   <td>" + result.dataList[i].tagName + "</td>\n" +
                        "   <td class=\"hidden-sm\">" + result.dataList[i].keyWord + "</td>\n" +
                        "   <td class=\"hidden-sm\">" + result.dataList[i].readNum + "</td>\n" +
                        "   <td>" + result.dataList[i].createDate + "</td>\n" +
                        "   <td>" + lockValue + "</td>\n" +
                        "   <td><a href=\"update-article.html?article&id=" + result.dataList[i].id + "\">修改</a> <a rel=\"6\" articleId='" + result.dataList[i].id + "' class='deleteArticleBtn'>删除</a></td>\n" +
                        "</tr>";
            }
            $("#article").html(str);
            $("#articleCount").html(result.dataList.length);
        })

        $("#article").on("click", ".deleteArticleBtn", function (e) {
            var id = $(e.target).attr("articleId");
            if (confirm("确认？")) {
                deleteArticle({"id": id}, function (result) {
                    alert("删除成功");
                    window.location.reload();
                })
            }
        })

    });
</script>
</body>
</html>
