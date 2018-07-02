<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>萌犬当道</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.ui.js"></script>
    <script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.cookie.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
    <link rel="stylesheet" type="text/css" href="../css/denglu.css">
</head>
</html>
<body>
<div id="all">
    <div id="middle">
        <div id="left">

        </div>
        <div id="right">
            <form id="reg" action="/register" method="post">
                <h2>用户注册</h2><hr>
                <table>
                    <tr>
                        <td><label for="loginname">登录名：</label></td>
                        <td>  <input type="text" name="loginname" class="loginname" id="loginname"></td>
                    </tr>
                    <tr>
                        <td> <label for="password">密  码：</label></td>
                        <td> <input type="text" name="password" class="password" id="password"></td>
                    </tr>

                </table>
                <button class="regButton">注册</button><br/><br/>
                <a href="http://localhost:8080/">返回首页</a>
            </form>

        </div>
    </div>
</div>
</body>
</html>
