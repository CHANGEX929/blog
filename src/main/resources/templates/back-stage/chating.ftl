<#--头部 BEGIN-->
<#include "public/head.ftl">
<#--头部 END-->
<div class="chatContainer">
    <div class="chatBtn">
        <i class="iconfont icon-xiaoxi1"></i>
    </div>
    <div class="chat-message-num">10</div>
    <div class="chatBox" ref="chatBox">
        <div class="chatBox-head">
            <div class="chatBox-head-one">
                CHATING
                <div class="chat-close" style="margin: 10px 10px 0 0;font-size: 14px">关闭</div>
            </div>
            <div class="chatBox-head-two">
                <div class="chat-return">返回</div>
                <div class="chat-people">
                </div>
                <div class="chat-close">关闭</div>
            </div>
        </div>
        <div class="chatBox-info">
            <div class="chatBox-list">
                <div class="chat-list-people">
                    <div><img src="img/icon02.png" alt="头像"/></div>
                    <div class="chat-name">
                        <p>白兰地</p>
                    </div>
                    <div class="message-num">8</div>
                </div>
            </div>
            <div class="chatBox-kuang" ref="chatBoxkuang">
                <div class="chatBox-content">
                    <div class="chatBox-content-demo" id="chatBox-content-demo" userId="0">
                    </div>
                </div>
                <div class="chatBox-send">
                    <div class="div-textarea" contenteditable="true"></div>
                    <div>
                        <button id="chat-biaoqing" class="btn-default-styles">
                            <i class="iconfont icon-biaoqing"></i>
                        </button>
                        <label id="chat-tuxiang" title="发送图片" for="inputImage" class="btn-default-styles">
                            <input type="file" onchange="selectImg(this)" accept="image/jpg,image/jpeg,image/png"
                                   name="file" id="inputImage" class="hidden">
                            <i class="iconfont icon-tuxiang"></i>
                        </label>
                        <button id="chat-fasong" class="btn-default-styles"><i class="iconfont icon-fasong"></i>
                        </button>
                    </div>
                    <div class="biaoqing-photo">
                        <ul>
                            <li><span class="emoji-picker-image" style="background-position: -9px -18px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -40px -18px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -71px -18px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -102px -18px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -133px -18px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -164px -18px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -9px -52px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -40px -52px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -71px -52px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -102px -52px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -133px -52px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -164px -52px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -9px -86px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -40px -86px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -71px -86px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -102px -86px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -133px -86px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -164px -86px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -9px -120px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -40px -120px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -71px -120px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -102px -120px;"></span>
                            </li>
                            <li><span class="emoji-picker-image" style="background-position: -133px -120px;"></span>
                            </li>
                            <li><span class="emoji-picker-image" style="background-position: -164px -120px;"></span>
                            </li>
                            <li><span class="emoji-picker-image" style="background-position: -9px -154px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -40px -154px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -71px -154px;"></span></li>
                            <li><span class="emoji-picker-image" style="background-position: -102px -154px;"></span>
                            </li>
                            <li><span class="emoji-picker-image" style="background-position: -133px -154px;"></span>
                            </li>
                            <li><span class="emoji-picker-image" style="background-position: -164px -154px;"></span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<#--尾部 BEGIN-->
<#include "public/foot.ftl">
<#--尾部 END-->
<script>
    $(function () {
        queryUser();

        console.log("开始websocket");
        var wsurl = 'ws://127.0.0.1:80/websocket';
        var websocket;
        var i = 0;
        if (window.WebSocket) {
            websocket = new WebSocket(wsurl);
            //连接建立
            websocket.onopen = function (evevt) {
                console.log("Connected to WebSocket server.");
            }
            //收到消息
            websocket.onmessage = function (event) {
                console.log(event + "event")
                var pset = JSON.stringify(event.data);
                var msg = JSON.parse(event.data); //解析收到的json消息数据
                //var type = msg.type; // 消息类型
                var umsg = msg.sendMsg; //消息文本
                var sendId = msg.senderId; //发送人
                var receiverId = msg.receiverId;
                var storage = window.localStorage;
                var nowUserId = storage.nowUserId;
                i++;
                if (nowUserId == receiverId) {


                    $(".chatBox-content-demo").append("<div class=\"clearfloat\">\n" +
                            "                            <div class=\"author-name\">\n" +
                            "                                <small class=\"chat-date\">" + msg.createDate + "</small>\n" +
                            "                            </div>\n" +
                            "                            <div class=\"left\">\n" +
                            "                                <div class=\"chat-message\">" + umsg + "</div>\n" +
                            "                                <div class=\"chat-avatars\"><img src=\"img/icon02.png\" alt=\"头像\"/></div>\n" +
                            "                            </div>\n" +
                            "                        </div>");
                    $('#message').val('');
                }
                window.location.hash = '#' + i;
            }
            //发生错误
            websocket.onerror = function (event) {
                i++;
                console.log("Connected to WebSocket server error");
                window.location.hash = '#' + i;
            }
            //连接关闭
            websocket.onclose = function (event) {
                i++;
                console.log('websocket Connection Closed. ');
                window.location.hash = '#' + i;
            }

            function send(e) {


                try {
                    websocket.send(e);
                } catch (ex) {
                    console.log(ex);
                }
            }

            //按下enter键发送消息
            $(window).keydown(function (event) {
                if (event.keyCode == 13) {
                    console.log('user enter');
                    send();
                }
            });
            //点发送按钮发送消息
            //      发送信息
            $("#chat-fasong").click(function () {
                var textContent = $(".div-textarea").html().replace(/[\n\r]/g, '<br>')
                if (textContent != "") {
                    $(".chatBox-content-demo").append("<div class=\"clearfloat\">" +
                            "<div class=\"author-name\"><small class=\"chat-date\">2017-12-02 14:26:58</small> </div> " +
                            "<div class=\"right\"> <div class=\"chat-message\"> " + textContent + " </div> " +
                            "<div class=\"chat-avatars\"><img src=\"img/icon01.png\" alt=\"头像\" /></div> </div> </div>");
                    //发送后清空输入框
                    $(".div-textarea").html("");
                    //聊天框默认最底部
                    $(document).ready(function () {
                        $("#chatBox-content-demo").scrollTop($("#chatBox-content-demo")[0].scrollHeight);
                    });
                    $(".div-textarea").html().replace(/[\n\r]/g, '<br>');
                    var receiverId = $("#chatBox-content-demo").attr("userId");
                    var storage = window.localStorage;
                    var senderId = storage.nowUserId;
                    var msg = "{\"sendMsg\":\"" + textContent + "\",\"receiverId\":" + receiverId + ",\"sendType\": 10010,\"senderId\":" + senderId + "}";
                    send(msg);
                }

            });
        }
        else {
            alert('该浏览器不支持web socket');
        }

    })
    screenFuc();

    function screenFuc() {
        var topHeight = $(".chatBox-head").innerHeight();//聊天头部高度
        //屏幕小于768px时候,布局change
        var winWidth = $(window).innerWidth();
        if (winWidth <= 768) {
            var totalHeight = $(window).height(); //页面整体高度
            $(".chatBox-info").css("height", totalHeight - topHeight);
            var infoHeight = $(".chatBox-info").innerHeight();//聊天头部以下高度
            //中间内容高度
            $(".chatBox-content").css("height", infoHeight - 46);
            $(".chatBox-content-demo").css("height", infoHeight - 46);

            $(".chatBox-list").css("height", totalHeight - topHeight);
            $(".chatBox-kuang").css("height", totalHeight - topHeight);
            $(".div-textarea").css("width", winWidth - 106);
        } else {
            $(".chatBox-info").css("height", 495);
            $(".chatBox-content").css("height", 448);
            $(".chatBox-content-demo").css("height", 448);
            $(".chatBox-list").css("height", 495);
            $(".chatBox-kuang").css("height", 495);
            $(".div-textarea").css("width", 260);
        }
    }

    (window.onresize = function () {
        screenFuc();
    })();
    //未读信息数量为空时
    var totalNum = $(".chat-message-num").html();
    if (totalNum == "") {
        $(".chat-message-num").css("padding", 0);
    }
    $(".message-num").each(function () {
        var wdNum = $(this).html();
        if (wdNum == "") {
            $(this).css("padding", 0);
        }
    });


    //打开/关闭聊天框
    $(".chatBtn").click(function () {
        $(".chatBox").toggle(10);
    })
    $(".chat-close").click(function () {
        $(".chatBox").toggle(10);
    })
    //进聊天页面
    $(".chatBox-list").on("click", "p", function (e) {

        openChatWindow(e);
    });
    //进聊天页面
    $(".chatBox-list").on("click", "img", function (e) {

        openChatWindow(e);
    });

    function openChatWindow(e) {
        //获取用户名
        var userName = $(e.target).html();
        var userId = $(e.target).attr("userId");
        $(".chatBox-head-one").toggle();
        $(".chatBox-head-two").toggle();
        $(".chatBox-list").fadeToggle();
        $(".chatBox-kuang").fadeToggle();

        //传名字
        $(".ChatInfoName").html(userName);
        //传头像
        $(".ChatInfoHead>img").attr("src", $(this).children().eq(0).children("img").attr("src"));
        //传id
        $("#chatBox-content-demo").attr("userId", userId);
        //聊天框默认最底部
        $(document).ready(function () {
            $("#chatBox-content-demo").scrollTop($("#chatBox-content-demo")[0].scrollHeight);
        });
        queryChats(userId);
    }

    //返回列表
    $(".chat-return").click(function () {
        $(".chatBox-head-one").toggle(1);
        $(".chatBox-head-two").toggle(1);
        $(".chatBox-list").fadeToggle(1);
        $(".chatBox-kuang").fadeToggle(1);
    });


    //      发送表情
    $("#chat-biaoqing").click(function () {
        $(".biaoqing-photo").toggle();
    });
    $(document).click(function () {
        $(".biaoqing-photo").css("display", "none");
    });
    $("#chat-biaoqing").click(function (event) {
        event.stopPropagation();//阻止事件
    });

    $(".emoji-picker-image").each(function () {
        $(this).click(function () {
            var bq = $(this).parent().html();
            console.log(bq)
            $(".chatBox-content-demo").append("<div class=\"clearfloat\">" +
                    "<div class=\"author-name\"><small class=\"chat-date\">2017-12-02 14:26:58</small> </div> " +
                    "<div class=\"right\"> <div class=\"chat-message\"> " + bq + " </div> " +
                    "<div class=\"chat-avatars\"><img src=\"img/icon01.png\" alt=\"头像\" /></div> </div> </div>");
            //发送后关闭表情框
            $(".biaoqing-photo").toggle();
            //聊天框默认最底部
            $(document).ready(function () {
                $("#chatBox-content-demo").scrollTop($("#chatBox-content-demo")[0].scrollHeight);
            });
        })
    });

    //      发送图片
    function selectImg(pic) {
        if (!pic.files || !pic.files[0]) {
            return;
        }
        var reader = new FileReader();
        reader.onload = function (evt) {
            var images = evt.target.result;
            $(".chatBox-content-demo").append("<div class=\"clearfloat\">" +
                    "<div class=\"author-name\"><small class=\"chat-date\">2017-12-02 14:26:58</small> </div> " +
                    "<div class=\"right\"> <div class=\"chat-message\"><img src=" + images + "></div> " +
                    "<div class=\"chat-avatars\"><img src=\"img/icon01.png\" alt=\"头像\" /></div> </div> </div>");
            //聊天框默认最底部
            $(document).ready(function () {
                $("#chatBox-content-demo").scrollTop($("#chatBox-content-demo")[0].scrollHeight);
            });
        };
        reader.readAsDataURL(pic.files[0]);

    }

    /*
     访问后台js
     */

    //查询用户
    function queryUser() {
        console.log("来了");
        $.ajax({
            url: "/users/queryUserList",
            type: "post",
            dataType: "json",
            beforeSend: function () {
                $("#programBar").modal("show");
            },
            success: function (result) {
                console.log(result);
                var str = "";
                var list = result.data;
                for (var i = 0; i < list.length; i++) {

                    str += "<div class=\"chat-list-people\">\n" +
                            "   <div class><img userId = \"" + list[i].id + "\" src=\"images/icon03.png\" alt=\"头像\"/></div>\n" +
                            "         <div class=\"chat-name\" >\n" +
                            "                <p userid=\"" + list[i].id + "\">" + list[i].userName + "</p>\n" +
                            "          </div>\n" +
                            "    <div class=\"message-num\">" + list[i].countMsg + "</div>\n" +
                            " </div>";
                }

                $(".chatBox-list").html(str);
            },
            error: function () {
                alert("系统繁忙");
            },
            complete: function () {
                $("#programBar").modal("hide");
            }
        });


    }

    function queryChats(senderId) {
        console.log("queryChats");
        var storage = window.localStorage;
        var receiverId = storage.nowUserId;//接收id
        console.log(receiverId + "--" + senderId);
        $.ajax({
            url: "/chat/queryChats",
            type: "post",
            data: "{\"receiverId\":" + receiverId + ",\"senderId\":" + senderId + "}",
            dataType: "json",
            contentType: "application/json",
            beforeSend: function () {
                $("#programBar").modal("show");
            },
            success: function (result) {
                console.log(result + "result");
                var str = "";
                var list = result.data;
                for (var i = 0; i < list.length; i++) {
                    var direction = "left";
                    if (list[i].senderId == receiverId) {
                        direction = "right";
                    }
                    str += "<div class=\"clearfloat\">\n" +
                            "<div class=\"author-name\">\n" +
                            "<small class=\"chat-date\">2017-12-02 14:26:58</small>\n" +
                            "</div>\n" +
                            "<div class=" + direction + ">\n";

                    if (direction == "right") {
                        str +=  "<div class=\"chat-message\">" + list[i].sendMsg + "</div>\n" +
                                "<div class=\"chat-avatars\"><img src=\"img/icon03.png\" alt=\"头像\"/></div>\n" +
                                "</div>\n" +
                                "</div>";
                    } else {
                        str +=  "<div class=\"chat-avatars\"><img src=\"img/icon03.png\" alt=\"头像\"/></div>\n" +
                                "<div class=\"chat-message\">" + list[i].sendMsg + "</div>\n" +
                                "</div>\n" +
                                "</div>";
                    }

                }
                $("#chatBox-content-demo").html(str);
            },
            error: function () {
                alert("系统繁忙");
            },
            complete: function () {
                $("#programBar").modal("hide");
            }
        });
    }


</script>


</body>
</html>
