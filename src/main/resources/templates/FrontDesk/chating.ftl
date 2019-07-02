<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>chating</title>
</head>
<style>
    body {
        overflow-y: hidden;
        overflow-x: hidden;
    }

    .chatingWindow {
        width: 100%;
        height: 100%;
        position: absolute;
    }

    .chatingWindow .header {
        width: 100%;
        height: 10%;
        position: absolute;
        background-color: #F7B401;
    }

    .chatingWindow .footer {
        width: 100%;
        height: 10%;
        position: absolute;
        bottom: 0px;
        background-color: #F7B401;
    }

    input[type=text] {
        margin-left: 3%;
        vertical-align: middle;
        font-size: 50px;
        border-radius: 25px;
        width: 80%;
        height: 100%;
        line-height: 100%;
    }

    input[type=button] {
        vertical-align: middle;
        border-radius: 25px;
        height: 100%;
        width: 10%;
        font-size: 25px;
    }

    .inputBar {
        margin-top: -6%;
        position: absolute;
        top: 50%;
        width: 100%;
        height: 60%;
    }

    #chatingContent {
        overflow-y: scroll;
        overflow-x: hidden;
        width: 100%;
        height: 80%;
        position: absolute;
        background-color: #C7DE95;
        top: 10%;
    }

    #chatingContent .littleContent {
        width: 100%;
        margin-top: 20px;
    }

    #chatingContent .littleContent .content1 {
        width: 50%;
        float: left;
        font-size: 50px;
        line-height: 80px;
        margin-top: 20px;
        margin-left: 10px;
    }

    #chatingContent .littleContent .content2 {
        width: 50%;
        float: right;
        font-size: 50px;
        line-height: 80px;
        margin-top: 20px;
        margin-right: 10px;
    }

    #chatingContent .littleContent .content1 span {
        text-align: left;
        padding: 20px;
        border-radius: 25px;
        background-color: #EBBEC5;
    }

    #chatingContent .littleContent .content2 span {
        text-align: right;
        padding: 20px;
        border-radius: 25px;
        background-color: #82B3D3;
    }
</style>
<body>
<div class="container">
    <div class="chatingWindow">
        <div class="header"></div>
        <div id="chatingContent">
            <div class="littleContent">
                <div class="content1"><span>你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！你好！</span>
                </div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content1"><span>你好！</span></div>
            </div>
            <div class="littleContent">
                <div class="content2"><span>你好！</span></div>
            </div>
        </div>
        <div class="footer" id="test" username = '小米'>
            <div class="inputBar"><input class="inputWindow" id="inputWindow" type="text"/><input class="sendMessage"
                                                                                                  type="button"
                                                                                                  value="发送"/></div>
        </div>
    </div>
</div>
</body>
</html>
<script type='text/javascript' src='../../js/jquery-3.3.1.min.js'></script>
<script type="text/javascript">
    $(function () {

        alert($("#test").attr("username"))

        $("#chatingContent").scrollTop($("#chatingContent")[0].scrollHeight);

        $(".sendMessage").click(function () {

            sendMessage();
        });


        $("#inputWindow").keyup(function () {
            if (event.keyCode == 13) {
                sendMessage();
            }
        });

        function sendMessage() {
            if ($("#inputWindow").val().length == 0) {
                return;
            }

            $("#chatingContent").append(" <div class=\"littleContent\">\n" +
                    "                <div class=\"content2\"><span>" + $("#inputWindow").val() + "</span></div>\n" +
                    "            </div>");
            $("#inputWindow").val("");
            $("#chatingContent").scrollTop($("#chatingContent")[0].scrollHeight);
        }
    })
</script>