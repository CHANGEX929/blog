<!doctype html>
<html lang="zh">

<#include "public/title.ftl">

<body class="home blog custom-background round-avatars" itemscope itemtype="http://schema.org/Organization">
<#--头部-->
		<#include "public/head.ftl">
<#--内容-->
<div class="container">
    <article style="padding-top: 50px;" id="post-1202"
             class="js-gallery post-1202 post type-post status-publish format-standard has-post-thumbnail hentry category-uncategorized tag-11 tag-22 tag-29">
        <style>
            .container {
                padding: 10px 0px;
            }

            .post {
                margin: 0 auto
            }
        </style>
        <section class="post_content">
            <header class="post_header">
                <h1 class="post_title" id="title"></h1>
            </header>
            <div class="post-body js-gallery" id="content">

            </div>
            <div class="meta split split--responsive cf">
                <div class="split__title">
                    <time datetime="2017-10-02 01:44" id="createDate"></time>
                    <span class=""><a href="javascript:;" rel="tag" id="keyWord"></a><a href="javascript:;"
                                                                                        rel="tag"
                                                                                        id="tagName"></a></span>
                </div>
            <#--              <div id="social-share"><span class="entypo-share"><i class="iconfont">&#xe614;</i>分享</span></div>
                          <div class="slide">
                              <a class="btn-slide" title="switch down"><i class="iconfont">&#xe615;</i>折叠评论区</a>
                          </div>-->
            </div>
        </section>
    </article>
</div>
<#--<svg id="upTriangleColor" width="100%" height="40" viewBox="0 0 100 102" preserveAspectRatio="none">
    <path d="M0 0 L50 100 L100 0 Z"></path>
</svg>-->
<div id="social">
    <ul>
        <li>
            <a href="" title="qzone" target="_blank"><i class="iconfont">&#xe67f;</i></a>
        </li>
        <li>
            <a href="" title="weibo" target="_blank"><i class="iconfont">&#xe680;</i></a>
        </li>
        <li>
            <a href="" title="douban" target="_blank"><i class="iconfont">&#xe681;</i></a>
        </li>
        <li>
            <a href="" title="twitter" target="_blank"><i class="iconfont">&#xe683;</i></a>
        </li>
    </ul>
</div>
<#--<svg id="dwTriangleColor" width="100%" height="40" viewBox="0 0 100 102" preserveAspectRatio="none">
    <path d="M0 0 L50 100 L100 0 Z"></path>
</svg>-->
<div class="wrapper">
</div>

<div class="p-header">
    <figure class="p-image"
            style="background-image: url(images/2.jpg);"></figure>
</div>


<#--尾部-->
		<#include "public/foot.ftl">
<script type="text/javascript">
    window.onscroll = function () {
        var scrollTop = document.body.scrollTop;
        if (scrollTop >= 200) {
            document.getElementById("NextPrevPosts").style.display = "none"
        } else {
            document.getElementById("NextPrevPosts").style.display = "block"
        }
    }

    $(function () {
        getArticleById({"id": getQueryString("id")}, function (result) {

            var createDate = result.data.createDate
            createDate = String(createDate).split("T")[0];

            $("#title").html(result.data.title);
            $("#content").html(result.data.content);
            $("#keyWord").html(result.data.keyWord);
            $("#createDate").html(createDate);
            $("#tagName").html(result.data.tagName);

        })
    })
</script>
<script type='text/javascript' src='js/prism.js'></script>
<script type='text/javascript' src='js/gravatar.js'></script>

</body>

</html>