<#--头部 BEGIN-->
<#include "public/head.ftl">
<#--头部 END-->
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
        <h1 class="page-header">修改栏目</h1>
        <form id="updateForm" action="javascript:;" method="post">
            <input id="id" name="id" type="text" hidden>
            <div class="form-group">
                <label for="category-name">栏目名称</label>
                <input type="text" id="category-name" name="name" value="前端技术" class="form-control"
                       placeholder="在此处输入栏目名称" required autocomplete="off">
                <span class="prompt-text">这将是它在站点上显示的名字。</span></div>
            <div class="form-group">
                <label for="category-alias">栏目别名</label>
                <input type="text" id="category-alias" name="alias" value="web" class="form-control"
                       placeholder="在此处输入栏目别名" required autocomplete="off">
                <span class="prompt-text">“别名”是在URL中使用的别称，它可以令URL更美观。通常使用小写，只能包含字母，数字和连字符（-）。</span></div>
            <button class="btn btn-primary" type="submit" name="submit">更新</button>
        </form>
    </div>
  </div>
</section>
<#--尾部 BEGIN-->
<#include "public/foot.ftl">
<#--尾部 END-->

<script type="text/javascript">
    $(function () {
        $("#category-name").val(getQueryString("name"));
        $("#category-alias").val(getQueryString("alias"));
        $("#id").val(getQueryString("id"));

        $("#updateForm").submit(function () {
            updateCategory($("#updateForm").serialize(), function (result) {
                if (result) {
                    alert("修改成功");
                    window.location.href = "category.html?category";
                } else {
                    alert("修改失败");
                }
            })
        });
    })
</script>
</body>
</html>
