<#--头部 BEGIN-->
<#include "public/head.ftl">
<#--头部 END-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
            <div class="row">
                <form action="javascript:;" id="add-article-form" class="add-article-form">
                    <div class="col-md-9">
                        <h1 class="page-header">编辑页面</h1>
                        <div class="form-group">
                            <label for="article-content" class="sr-only">内容</label>
                            <script id="article-content" required name="content" type="text/plain"></script>
                        </div>
                        <input name="id" id="htmlPageId" type="hidden" required value=""/>
                    </div>
                    <div class="col-md-3">
                        <h1 class="page-header">操作</h1>
                        <div class="add-article-box">
                            <h2 class="add-article-box-title"><span>栏目</span></h2>
                            <div class="add-article-box-content">
                                <ul class="category-list" id="pageTypeList">
                                    <li><label><input name="type" class="pageType" type="radio" required
                                                      value="ABOUT"><em
                                            class="hidden-md">( <span>ABOUT</span> )</em></label></li>
                                </ul>
                            </div>
                            <div class="add-article-box-footer">
                                <button class="btn btn-primary" type="submit" name="submit">发布</button>
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

    //加载栏目列表
    /*    getCategoryList({"authorId": 1}, function (result) {
            var str = "";
            for (var i = 0; i < result.dataList.length; i++) {

                str += "<li>" +
                        "        <label>" +
                        "        <input name=\"tagId\" type=\"radio\" required value=\"" + result.dataList[i].id + "\">"
                        + result.dataList[i].name + " <em class=\"hidden-md\">( 栏目ID: <span>" + result.dataList[i].id + "</span> )</em></label>" +
                        "</li>"
            }
            $("#category-list").html(str);
        })*/

    $("#pageTypeList").on("click", ".pageType", function (e) {

        getHtmlPageByType({"type": $(e.target).val()}, function (result) {

            editor.ready(function () {
                editor.setContent(result.data.content);
            });
            $("#htmlPageId").val(result.data.id);
        })
    })

    $("#add-article-form").submit(function () {

        mergeHtmlPage($(this).serialize(), function (result) {

            if (result.data) {
                alert("修改成功！");
                window.location.href = "";
            }
        })
    })


</script>
</body>
</html>
