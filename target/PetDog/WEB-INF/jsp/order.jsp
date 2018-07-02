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
    <script type="text/javascript" src="../js/moreDetail.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<div id="order">
    <div class="tip">
        确认订单
    </div>
    <div class="order_pre">
        <div class="address">
                <c:if test="${requestScope.address==null}">
                    <div class="adr1" <%--style="display: none"--%>>添加地址+</div>
                </c:if>
                <c:if test="${requestScope.address!=null}">
                    <div class="adr2" <%--style="display: none"--%>>
                        <span class="p5">收货人：${requestScope.userName}&nbsp;&nbsp;&nbsp;${requestScope.address.tel}</span>
                        <span class="p6">收货地址：${requestScope.address.area}${requestScope.address.detail}</span>
                    </div>
                </c:if>
        </div>
        <hr/>
        <div class="dog">
        <!--所要购买的狗狗的信息-->
                <div class="img">
                    <img src="getImage?id=${requestScope.dog.id} " width="121px" height="121px"/>
                </div>
                <div class="right">
                    <span class="p1">${requestScope.dog.name}</span>
                    <h2 id="price_${requestScope.dog.price}">淘狗价：${requestScope.dog.price}</h2>
                </div>
        </div>
    </div>
    <div class="order_main">
        <form id="orderForm" method="post" action="/addOrder">
            <div class="way">
                <label>配送方式：</label>
                <input type="radio" value="1" id="way1" name="deliverWay"/>自提
                <input type="radio" value="2" id="way2" name="deliverWay"/>省内配送(500)
                <input type="radio" value="3" id="way3" name="deliverWay"/>省外配送(1000)
            </div>
            <div class="pay">
                <label>付款方式：</label>
                <input type="radio" value="1" id="pay1" name="payWay"/>微信支付
                <input type="radio" value="2" id="pay2" name="payWay"/>支付宝支付
            </div>
            <input type="hidden" value="" name="sumPrice">
            <input type="hidden" value="${requestScope.dog.id}" name="dogId">
            <input type="hidden" name="shr" value="${requestScope.userName}">
            <input type="hidden" value="${requestScope.address.tel}" name="tel">
            <input type="hidden" name="shad" value="${requestScope.address.area}${requestScope.address.detail}">
            <div class="sum">
                <span class="sumPrice">合计：</span>
                &nbsp;&nbsp;&nbsp;
                <button class="sub_order">提交订单</button>
            </div>
        </form>
    </div>
</div>

<!--增加收货地址表单-->
<form action="/addAddress" method="post" id="address">
    <label>收货人</label>
    <input type="text" name="name">
    <br/>
    <label>联系电话</label>
    <input type="text" name="tel">
    <br/>
    <label>所在地区</label>
    <input type="text" name="area">
    <br/>
    <label>详细地址</label>
    <input type="text" name="detail">
</form>
</body>
</html>
