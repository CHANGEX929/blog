<#--头部 BEGIN-->
<#include "public/head.ftl">
<#--头部 END-->
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
        <h1 class="page-header">操作</h1>
        <ol class="breadcrumb">
            <li><a href="/Loginlog/delete/action/all">清除所有登录记录</a></li>
            <li><a href="/Loginlog/delete/action/current">清除本人登录记录</a></li>
        </ol>
        <h1 class="page-header">管理 <span class="badge">9</span></h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th><span class="glyphicon glyphicon-th-large"></span> <span class="visible-lg">ID</span></th>
                    <th><span class="glyphicon glyphicon-user"></span> <span class="visible-lg">用户</span></th>
                    <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">时间</span></th>
                    <th><span class="glyphicon glyphicon-adjust"></span> <span class="visible-lg">IP</span></th>
                    <th><span class="glyphicon glyphicon-remove"></span> <span class="visible-lg">删除</span></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="1">删除</a></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="2">删除</a></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="3">删除</a></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="4">删除</a></td>
                </tr>
                <tr>
                    <td>5</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="5">删除</a></td>
                </tr>
                <tr>
                    <td>6</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="6">删除</a></td>
                </tr>
                <tr>
                    <td>7</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="7">删除</a></td>
                </tr>
                <tr>
                    <td>8</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="8">删除</a></td>
                </tr>
                <tr>
                    <td>9</td>
                    <td class="article-title">admin</td>
                    <td>2016-1-11 15:09:11</td>
                    <td>192.168.1.1:1245</td>
                    <td><a rel="9">删除</a></td>
                </tr>
                </tbody>
            </table>
        </div>
        <footer class="message_footer">
            <nav>
                <ul class="pagination pagenav">
                    <li class="disabled"><a aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a></li>
                    <li class="active"><a>1</a></li>
                    <li class="disabled"><a aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a></li>
                </ul>
            </nav>
        </footer>
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
            if (event.srcElement.outerText === "删除") {
                if (window.confirm("此操作不可逆，是否确认？")) {
                    $.ajax({
                        type: "POST",
                        url: "/Loginlog/delete/action/one",
                        data: "id=" + id,
                        cache: false, //不缓存此页面
                        success: function (data) {
                            window.location.reload();
                        }
                    });
                }
                ;
            }
            ;
        });
    });
</script>
</body>
</html>