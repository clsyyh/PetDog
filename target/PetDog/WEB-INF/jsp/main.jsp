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
    <script type="text/javascript" src="../js/cycle.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
</head>
<body>

<%--<div id="header">
    <div class="header_main">
        <div>
            <div class="header_logo">
                <img alt="狗铺子" src="../images/dog.jpg"/>
                <p>宠物狗交易平台</p>
            </div>
            <div class="header_member">
                <span id="reg_a">注册</span>
                <span id="member">用户</span>
                |
                <span id="login_a">登录</span>
                <span id="logout">登出</span>
            </div>
        </div>

        <div class="header_nav">
            <ul>
                <li class="list_li"><a href="http://localhost:8080/">首页</a></li>
                <li class="list_li"><a href="/knowledge"  >狗狗百科</a></li>
                <li class="list_li"><a href="javascript:void(0);" id="community" >用户社区</a></li>
                <li class="list_li"><a href="javascript:void(0);" id="upload">发布信息</a></li>
                <li class="list_li">
                        <a href="javascript:void(0);" class="user_a">个人中心</a>
                        <ul class="user_ul">
                            <li><a href="/selectInfo">个人信息</a></li>
                            <li><a href="/showChangePwd">修改密码</a></li>
                        </ul>
                </li>
                <li class="list_li">
                        <a href="javascript:void(0);" class="order_a">我的订单</a>
                        <ul class="order_ul">
                            <li><a href="javascript:void(0);" class="allOrders">全部</a></li>
                            <li><a href="javascript:void(0);" class="nothandle">待处理</a></li>
                            <li><a href="javascript:void(0);" class="handled">已处理</a></li>
                        </ul>
                </li>
            </ul>
        </div>

    </div>
</div>--%>
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
            </li><li class="list_li"><a href="/peiqi">小猪佩奇</a> </li>
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





<div id="sectionSearch">
    <!--
    <div class="section_search">
        <input type="text" class="search" />
        &nbsp;&nbsp;&nbsp;
        <button id="button">搜索</button>
    </div>
    -->
    <div class="search">
        <p>快速定制狗狗求购信息</p>
        <hr>
        <form action="/searchDogs" method="post" id="sel">
            <!--
            <input list="kinds" name="kind" type="text" value="品种">
            <datalist id="kinds">
                <option value="秋田犬">秋田犬</option>
                <option value="拉布拉多">拉布拉多</option>
                <option value="柴犬">柴犬</option>
                <option value="吉娃娃">吉娃娃</option>
                <option value="哈士奇">哈士奇</option>
                <option value="金毛">金毛</option>
                <option value="牛头梗">牛头梗</option>
                <option value="萨摩耶">萨摩耶</option>
                <option value="斑点犬">斑点犬</option>
            </datalist>
            <br/>
            <br/>
            <input list="areas" name="area" type="text" value="区域">
            <datalist id="areas">
                <option value="北京市">北京市</option>
                <option value="天津市">天津市</option>
                <option value="河北省">河北省</option>
                <option value="江苏省">江苏省</option>
                <option value="陕西省">陕西省</option>
                <option value="安徽省">安微省</option>
                <option value="福建省">福建省</option>
                <option value="江西省">江西省</option>
                <option value="吉林省">吉林省</option>
            </datalist>
            <br/>
            <br/>
            <input list="prices" name="price" type="text" value="价格">
            <datalist id="prices">
                <option value="">不限</option>
                <option value="2500">2000-3000</option>
                <option value="3500">3000-4000</option>
                <option value="4500">4000-5000</option>
                <option value="5500">5000以上</option>
            </datalist>
            -->
            <select name="kind" size="0" class="select">
                <option value="犬种" selected>犬种</option>
                <option value="秋田犬">秋田犬</option>
                <option value="拉布拉多">拉布拉多</option>
                <option value="柴犬">柴犬</option>
                <option value="吉娃娃">吉娃娃</option>
                <option value="哈士奇">哈士奇</option>
                <option value="金毛">金毛</option>
                <option value="牛头梗">牛头梗</option>
                <option value="萨摩耶">萨摩耶</option>
                <option value="斑点犬">斑点犬</option>
                <option value="藏獒">藏獒</option>
                <option value="西施犬">西施犬</option>
            </select>
            <br/>
            <br/>
            <select name="area" size="0" class="select">
                <option value="区域" selected>区域</option>
                <option value="北京市">北京市</option>
                <option value="天津市">天津市</option>
                <option value="河北省">河北省</option>
                <option value="江苏省">江苏省</option>
                <option value="陕西省">陕西省</option>
                <option value="安徽省">安微省</option>
                <option value="福建省">福建省</option>
                <option value="江西省">江西省</option>
                <option value="吉林省">吉林省</option>
                <option value="湖南省">湖南省</option>
                <option value="哈尔滨">哈尔滨</option>

            </select>
            <br/>
            <br/>
            <select name="price" size="0" class="select">
                <option value="价格" selected>价格</option>
                <option value="">不限</option>
                <option value="2500">2000-3000</option>
                <option value="3500">3000-4000</option>
                <option value="4500">4000-5000</option>
                <option value="5500">5000以上</option>
            </select>
            <br/>
            <br/>
            <input type="submit" value="快速定制萌宠"/>
        </form>
    </div>
    <div class="cycle">
        <div class="wrap" id="wrap">
            <ul id="pic">
                <li><img src="../images/1.jpg" alt=""></li>
                <li><img src="../images/2.jpg" alt=""></li>
                <li><img src="../images/3.jpg" alt=""></li>
                <li><img src="../images/4.jpg" alt=""></li>
                <li><img src="../images/5.jpg" alt=""></li>
            </ul>
            <ol id="list">
                <li class="on">1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
                <li>5</li>
            </ol>
        </div>
    </div>
</div>
<!--
<div id="Jsoup">

</div>
-->
<div id="sectionDogs">

</div>
<div id="error">
    请您先登录！
</div>
</body>
</html>
