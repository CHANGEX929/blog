<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>chating</title>
</head>
<style>
    .chatingWindow {
        border: 1px solid black;
        width: 600px;
        height: 800px;
        position: absolute;
        top: 20px;
        left: 50%;
    }

    .chatingWindow .header {
        border-bottom: 1px solid black;
        width: 600px;
        height: 60px;
        position: absolute;
    }

    .chatingWindow .footer {
        border-top: 1px solid black;
        width: 600px;
        height: 60px;
        position: absolute;
        bottom: 0px;
    }

    .chatingContent{
        position: absolute;
        top:60px;
    }
</style>
<body>
<div class="container">
    <div class="chatingWindow">
        <div class="header"></div>
        <li class = "chatingContent">
            <ul>1</ul>
            <ul>1</ul>
            <ul>1</ul>
            <ul>1</ul>
        </li>
        <div class="footer"></div>
    </div>
</div>
</body>
</html>