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
    <script type="text/javascript" src="../js/userInfo.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
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
<div id="userInfo">
    <div class="section_tip">个人基本信息</div>
    <div class="section_form">
        <form id="info" action="/addOrUpdateInfo" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${requestScope.user.id}" />
            <table border="1" width="1334" height="432">
                <tr>
                    <td>登录名：&nbsp;&nbsp;&nbsp;</td>
                    <td> <input type="text" name="loginname" value="${requestScope.user.loginname}"/></td>

                    <td rowspan="3"><img src="/getUserImage?id=${requestScope.user.id}" width="180" height="230"/></td>
                </tr>
                <tr>
                    <td>姓名：&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="text" name="name" value="${requestScope.user.name}"/> </td>
                </tr>
                <tr>
                    <td>性别：&nbsp;&nbsp;&nbsp;</td>
                    <td>
                        <select name="sex" size="0">
                            <option>请选择性别---</option>
                            <option value="1" <c:if test="${requestScope.user.sex==1}">selected</c:if> >女</option>
                            <option value="0" <c:if test="${requestScope.user.sex==0}">selected</c:if> >男</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>出生日期：&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="text" name="birthday" value="<f:formatDate value="${requestScope.user.birthday}"
                        type="date" pattern="yyyy-mm-dd"/> "/> </td>

                    <td><input type="file" name="pictureFile"></td>
                </tr>
                <tr>
                    <td>电话：&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="text" name="tel" value="${requestScope.user.tel}"/> </td>

                    <!--使用Ajax实现只上传照片-->
                    <td><input type="submit" value="上传照片" id="uploadphoto"/></td>
                </tr>
                <tr>
                    <td>邮箱：&nbsp;&nbsp;&nbsp;</td>
                    <td colspan="2"><input type="text" name="email" value="${requestScope.user.email}"/> </td>
                </tr>
                <tr>
                    <td>微信：&nbsp;&nbsp;&nbsp;</td>
                    <td colspan="2"><input type="text" name="weChat" value="${requestScope.user.weChat}"/> </td>
                </tr>
                <tr>
                    <td colspan="3" align="middle">
                        <input type="submit" value="提交"/>
                    </td>
                </tr>
            </table>

        </form>
    </div>
</div>

<div id="error">
    请您先登录！
</div>
</body>
</html>