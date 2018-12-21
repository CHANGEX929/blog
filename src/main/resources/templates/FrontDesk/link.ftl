<!doctype html>
<html lang="zh">

<#include "public/title.ftl">

<body class="home blog custom-background round-avatars">
<#--头部-->
	<#include "public/head.ftl">
<#--内容-->
<div id="main" class="content">
    <div class="container">
        <style>
            body.custom-background {
                background: #fff
            }

            .container {
                padding: 10px 0px;
            }
        </style>
        <section class="post_content">
            <header class="post_header">
                <h1 class="post_title">分类</h1>
            </header>
            <div class="links">
            <#--<h3 class="catalog-title">CHANGEX-SITE</h3>-->
                <div class="catalog-description"></div>
                <div class="catalog-share" id="count"></div>
                <div class="userItems" id="categoryList">
                <#--        <div class="userItem">
                        <div class="userItem--inner">
                            <div class="userItem-content"><img alt='' src='images/8e5da64c712d2bb59235d8d746108cb1.jpeg'
                                                               class='avatar avatar-64 photo' height='64' width='64'/>
                                <div class="userItem-name">
                                    <a class="link link--primary" href="#" target="_blank">Akina</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="userItem">
                        <div class="userItem--inner">
                            <div class="userItem-content"><img alt='' src='images/89aeed9e656e1f7fbb04691aa3b38252.jpeg'
                                                               class='avatar avatar-64 photo' height='64' width='64'/>
                                <div class="userItem-name">
                                    <a class="link link--primary" href="#" target="_blank">Dearzd</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="userItem">
                        <div class="userItem--inner">
                            <div class="userItem-content"><img alt='' src='images/d52a89521eb0cdb4efb343fb63ce3986.jpeg'
                                                               class='avatar avatar-64 photo' height='64' width='64'/>
                                <div class="userItem-name">
                                    <a class="link link--primary" href="#" target="_blank">Meow</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="userItem">
                        <div class="userItem--inner">
                            <div class="userItem-content"><img alt='' src='images/22278c1d83002246dca48b52e306b1c9.jpeg'
                                                               class='avatar avatar-64 photo' height='64' width='64'/>
                                <div class="userItem-name">
                                    <a class="link link--primary" href="#" target="_blank">Tokin</a>
                                </div>
                            </div>
                        </div>
                    </div>-->
                </div>
            </div>
        </section>
    </div>
</div>

<#--尾部-->
		<#include "public/foot.ftl">

</body>

<script type="text/javascript">
    $(function () {
        //显示栏目
        getCategoryList({"authorId": 1}, function (result) {

            var str = ""

            for (var i = 0; i < result.dataList.length; i++) {
                str += "    <div class=\"userItem\">\n" +
                        "                        <div class=\"userItem--inner\">\n" +
                        "                            <div class=\"userItem-content\"><img alt='' src=''\n" +
                        "                                                               class='avatar avatar-64 photo' height='64' width='64'/>\n" +
                        "                                <div class=\"userItem-name\">\n" +
                        "                                    <a class=\"link link--primary\" href=\"\" >" + result.dataList[i].name + "</a>\n" +
                        "                                </div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </div>";
            }

            $("#categoryList").html(str);
            $("#count").html(result.dataList.length + " items in collection");
        });
    })
</script>

</html>