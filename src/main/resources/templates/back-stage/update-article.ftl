<#--头部 BEGIN-->
<#include "public/head.ftl">
<#--头部 END-->
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
             <div class="row">
                 <form action="javascript:;" id="update-article-form" class="add-article-form">
                     <div class="col-md-9">
                         <h1 class="page-header">修改文章</h1>
                         <div class="form-group">
                             <label for="article-title" class="sr-only">标题</label>
                             <input type="text" id="article-title" name="title" class="form-control"
                                    placeholder="在此处输入标题" required autofocus autocomplete="off">
                             <input type="text" name="authorId" value="1" hidden/>
                             <input type="text" id="id" name="id" value="" hidden/>
                         </div>
                         <div class="form-group">
                             <label for="article-content" class="sr-only">内容</label>
                             <script id="article-content" required name="content" type="text/plain"></script>
                         </div>
                         <div class="add-article-box">
                             <h2 class="add-article-box-title"><span>描述</span></h2>
                             <div class="add-article-box-content">
                                 <textarea class="form-control" id="article-summary" name="summary"
                                           autocomplete="off"></textarea>
                                 <span class="prompt-text">描述是可选的手工创建的内容总结，并可以在网页描述中使用</span>
                             </div>
                         </div>
                     </div>
                     <div class="col-md-3">
                         <h1 class="page-header">操作</h1>
                         <div class="add-article-box">
                             <h2 class="add-article-box-title"><span>栏目</span></h2>
                             <div class="add-article-box-content">
                                 <ul class="category-list" id="category-list">
                                 </ul>
                             </div>
                         </div>
                         <div class="add-article-box">
                             <h2 class="add-article-box-title"><span>标签</span></h2>
                             <div class="add-article-box-content">
                                 <input id="article-keyWord" type="text" class="form-control" placeholder="输入新标签"
                                        name="keyWord"
                                        autocomplete="off">
                                 <span class="prompt-text">多个标签请用英文逗号,隔开</span></div>
                         </div>
                         <div class="add-article-box">
                             <h2 class="add-article-box-title"><span>标题图片</span></h2>
                             <div class="add-article-box-content">
                                 <input type="text" class="form-control" placeholder="点击按钮选择图片" id="pictureUpload"
                                        name="picUrl" autocomplete="off">
                             </div>
                             <div class="add-article-box-footer">
                                 <button class="btn btn-default" type="button" ID="upImage">选择</button>
                             </div>
                         </div>
                         <div class="add-article-box">
                             <h2 class="add-article-box-title"><span>发布</span></h2>
                             <div class="add-article-box-content">
                                 <p><label>状态：</label><span class="article-status-display">已发布</span></p>
                                 <p><label>公开度：</label><input type="radio" name="isSecret" value="1"
                                                              checked/>公开
                                     <input type="radio" name="isSecret" value="0"/>加密</p>
                             </div>
                             <div class="add-article-box-footer">
                                 <button class="btn btn-primary" type="submit" name="submit">修改</button>
                             </div>
                         </div>
                     </div>
                 </form>
             </div>
         </div>
  </div>
</section>
<#--尾部 BEGIN-->
<#include "public/foot.ftl">
<#--尾部 END-->


<script type="text/javascript">
    var editor = UE.getEditor('article-content');
    window.onresize = function () {
        window.location.reload();
    }
    var _uploadEditor;
    $(function () {
        //重新实例化一个编辑器，防止在上面的editor编辑器中显示上传的图片或者文件
        _uploadEditor = UE.getEditor('uploadEditor');
        _uploadEditor.ready(function () {
            //设置编辑器不可用
            //_uploadEditor.setDisabled();
            //隐藏编辑器，因为不会用到这个编辑器实例，所以要隐藏
            _uploadEditor.hide();
            //侦听图片上传
            _uploadEditor.addListener('beforeInsertImage', function (t, arg) {
                //将地址赋值给相应的input,只去第一张图片的路径
                $("#pictureUpload").attr("value", arg[0].src);
                //图片预览
                //$("#imgPreview").attr("src", arg[0].src);
            })
            //侦听文件上传，取上传文件列表中第一个上传的文件的路径
            _uploadEditor.addListener('afterUpfile', function (t, arg) {
                $("#fileUpload").attr("value", _uploadEditor.options.filePath + arg[0].url);
            })
        });
    });
    //弹出图片上传的对话框
    $('#upImage').click(function () {
        var myImage = _uploadEditor.getDialog("insertimage");
        myImage.open();
    });

    //弹出文件上传的对话框
    function upFiles() {
        var myFiles = _uploadEditor.getDialog("attachment");
        myFiles.open();
    }

    $(function () {
        //加载文章数据
        getArticleById({"id": getQueryString("id")}, function (result) {

            $("#article-title").val(result.data.title);
            $("#id").val(result.data.id);
            $("#article-summary").val(result.data.summary);
            $("#article-keyWord").val(result.data.keyWord);
            $("#pictureUpload").val(result.data.picUrl);
            editor.ready(function () {
                editor.setContent(result.data.content);
            });
            $(":radio[name='isSecret'][value='" + result.data.isSecret + "']").prop("checked", "checked");

            var tagId = result.data.tagId;
            //加载栏目列表
            getCategoryList({"authorId": 1}, function (result1) {
                var str = "";
                for (var i = 0; i < result1.dataList.length; i++) {

                    if (tagId == result1.dataList[i].id) {
                        str += "<li>" +
                                "        <label>" +
                                "        <input name=\"tagId\" type=\"radio\" checked required value=\"" + result1.dataList[i].id + "\">"
                                + result1.dataList[i].name + " <em class=\"hidden-md\">( 栏目ID: <span>" + result1.dataList[i].id + "</span> )</em></label>" +
                                "</li>"
                    } else {
                        str += "<li>" +
                                "        <label>" +
                                "        <input name=\"tagId\" type=\"radio\" required value=\"" + result1.dataList[i].id + "\">"
                                + result1.dataList[i].name + " <em class=\"hidden-md\">( 栏目ID: <span>" + result1.dataList[i].id + "</span> )</em></label>" +
                                "</li>"
                    }
                }
                $("#category-list").html(str);
            });
        });

        $("#update-article-form").submit(function () {

            updateArticle($("#update-article-form").serialize(), function (result) {

                if (result.id != 0) {
                    alert("修改成功");
                    window.location.href = "article.html?article";
                }
            })
        });

    })
</script>
</body>
</html>