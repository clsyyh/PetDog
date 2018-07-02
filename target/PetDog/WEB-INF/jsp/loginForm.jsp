<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>萌犬当道</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.ui.js"></script>
    <script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.cookie.js"></script>
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
            <form id="login" action="/login" method="post">
                <h2>用户登录</h2><hr/>
                <table>
                    <tr>
                        <td> <label for="logname">登录名：</label></td>
                        <td> <input type="text" name="loginname" class="loginname" id="logname"></td>
                    </tr>
                    <tr>
                        <td><label for="pwd">密  码：</label></td>
                        <td><input type="text" name="password" class="password" id="pwd"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="zi">
                            <input type="radio" name="role" value="1"/>卖家
                            <input type="radio" name="role" value="0"/>买家
                        </td>
                    </tr>
                </table>
                <button class="loginButton">登录</button><br/>
                 <ul>
                    <li><a href="/registerForm">还未注册，前去注册！</a></li>
                    <li><a href="http://localhost:8080/">返回首页</a></li>
                </ul>

            </form>
        </div>
    </div>
</div>
</body>
</html>
