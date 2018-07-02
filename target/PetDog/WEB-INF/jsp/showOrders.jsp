<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <meta charset="utf-8">
    <title>萌犬当道</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.ui.js"></script>
    <script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/jquery.cookie.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
    <script type="text/javascript" src="../js/showOrders.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<div id="header">
    <div class="header_main">

        <div class="header_logo">
            <img alt="狗铺子" src="../images/dog.jpg"/>
            <p>宠物狗交易平台</p>
        </div>



        <div class="header_nav">
            <ul>
                <li class="list_li"><a href="http://localhost:8080/">首页</a></li><li class="list_li"><a href="/knowledge"  >狗狗百科</a></li><li class="list_li"><a href="javascript:void(0);" id="community" >用户社区</a></li><li class="list_li"><a href="javascript:void(0);" id="upload">发布信息</a></li><li class="list_li">
                <a href="javascript:void(0);" class="user_a">个人中心</a>
                <ul class="user_ul">
                    <li><a href="/selectInfo">个人信息</a></li>
                    <li><a href="/showChangePwd">修改密码</a></li>
                </ul>
            </li><li class="list_li">
                <a href="javascript:void(0);" class="order_a">我的订单</a>
                <ul class="order_ul">
                    <li><a href="javascript:void(0);" class="allOrders">全部</a></li>
                    <li><a href="javascript:void(0);" class="nothandle">待处理</a></li>
                    <li><a href="javascript:void(0);" class="handled">已处理</a></li>
                </ul>
            </li>
            </ul>
        </div>

        <div class="header_member">
            <span id="reg_a">注册</span>
            <span id="member">用户</span>
            |
            <span id="login_a">登录</span>
            <span id="logout">登出</span>
        </div>

    </div>
</div>
<div id="orders">

</div>
<div id="error">
    请您先登录！
</div>
</body>
</html>