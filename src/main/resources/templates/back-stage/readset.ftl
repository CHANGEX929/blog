<#--头部 BEGIN-->
<#include "public/head.ftl">
<#--头部 END-->
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
        <div class="row">
            <form action="/Setting/read" method="post" autocomplete="off" draggable="false">
                <div class="col-md-9">
                    <h1 class="page-header">用户设置</h1>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>站点标题</span></h2>
                        <div class="add-article-box-content">
                            <input type="text" name="title" class="form-control" placeholder="请输入站点标题" required
                                   autofocus autocomplete="off">
                        </div>
                    </div>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>副标题</span></h2>
                        <div class="add-article-box-content">
                            <input type="text" name="ftitle" class="form-control" placeholder="请输入站点副标题"
                                   autocomplete="off">
                            <span class="prompt-text">用简洁的文字描述本站点。</span></div>
                    </div>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>站点地址（URL）</span></h2>
                        <div class="add-article-box-content">
                            <input type="text" name="siteurl" class="form-control" placeholder="在此处输入站点地址（URL）" required
                                   autocomplete="off">
                        </div>
                    </div>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>站点关键字</span></h2>
                        <div class="add-article-box-content">
                            <textarea class="form-control" name="keywords" autocomplete="off"></textarea>
                            <span class="prompt-text">关键字会出现在网页的keywords属性中。</span></div>
                    </div>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>站点描述</span></h2>
                        <div class="add-article-box-content">
                            <textarea class="form-control" name="describe" rows="4" autocomplete="off"></textarea>
                            <span class="prompt-text">描述会出现在网页的description属性中。</span></div>
                    </div>
                </div>
                <div class="col-md-3">
                    <h1 class="page-header">站点</h1>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>电子邮件地址</span></h2>
                        <div class="add-article-box-content">
                            <input type="email" name="email" class="form-control" placeholder="在此处输入邮箱"
                                   autocomplete="off"/>
                            <span class="prompt-text">这个电子邮件地址仅为了管理方便而填写</span></div>
                    </div>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>ICP备案号</span></h2>
                        <div class="add-article-box-content">
                            <input type="email" name="email" class="form-control" placeholder="在此处输入备案号"
                                   autocomplete="off"/>
                        </div>
                    </div>
                    <div class="add-article-box">
                        <h2 class="add-article-box-title"><span>保存</span></h2>
                        <div class="add-article-box-content">
                            <span class="prompt-text">请确定您对所有选项所做的更改</span>
                        </div>
                        <div class="add-article-box-footer">
                            <button class="btn btn-primary" type="submit" name="submit">更新</button>
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
</body>
</html>