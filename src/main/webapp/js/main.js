$(function () {
    $.ajax({
        url:'selectDogs',
        type:'post',
        success:function (response,status,xhr) {
            var data=$.parseJSON(response);
            var html="";
            var count=0;
            var length=data.length;
            $.each(data,function (index,dog) {
                count=count+1;
                html+=
                    '        <div class="cols">' +
                    '            <div class="oneDog">' +
                    '                <div class="img">' +
                    '                    <a href="/selectDetail?id='+dog.id+' "><img src="getImage?id='+dog.id+' " width="121px" height="121px"/></a>' +
                    '                </div>' +
                    '                <div class="introduce">' +
                    '                    <p>'+dog.name+'</p><br/>' +
                    '                    <span>价格：</span>' +
                    '                    <span>'+dog.price+'</span>' +
                    '                    <br>' +
                    '                    <span>地区：</span>' +
                    '                    <span>'+dog.area+'</span>' +
                    '                </div>' +
                    '            </div>' +
                    '        </div>';
                if(count==2||index==length-1){
                    $('#sectionDogs').append(html);
                    html='';
                    count=0;
                }
            });
        }
    });

    $('#sel').submit(function() {
        $(this).ajaxSubmit({
            url: "/searchDogs",
            type: "post",
            success: function (response, statusText) {
                $("#sectionDogs").html("");

                var data = $.parseJSON(response);
                var html = "";
                var count = 0;
                var length = data.length;
                $.each(data, function (index, dog) {
                    count = count + 1;
                    html +=
                        '        <div class="cols">' +
                        '            <div class="oneDog">' +
                        '                <div class="img">' +
                        '                    <a href="/selectDetail?id=' + dog.id + ' "><img  src="getImage?id=' + dog.id + ' " width="121px" height="121px"/></a>' +
                        '                </div>' +
                        '                <div class="introduce">' +
                        '                    <p>' + dog.name + '</p><br/>' +
                        '                    <span>价格：</span>' +
                        '                    <span>' + dog.price + '</span>' +
                        '                    <br>' +
                        '                    <span>地区：</span>' +
                        '                    <span>' + dog.area + '</span>' +
                        '                </div>' +
                        '            </div>' +
                        '        </div>';
                    if (count == 2 || index == length - 1) {
                        $('#sectionDogs').append(html);
                        html = '';
                        count = 0;
                    }
                });
            },
        });
        return false;
    });

    //Jsoup
    /*
    $.ajax({
        url:"Jsoup",
        type:'post',
        success:function(response,statusText){
            var data=$.parseJSON(response);
            var html="";
            $.each(data,function (index,element) {
                html+='<div><a href=" '+element+' ">狗狗健康'+index+'</a></div>';
            });
            $('#Jsoup').append(html);
        },
    });
    */


    $('#member,#logout').hide();

    if($.cookie('user')){
        $('#member,#logout').show();
        $('#login_a,#reg_a').hide();
        $('#member').html($.cookie('user'));
    }
    //删除cookie和session中的当前用户
    $('#logout').click(function () {
        $.removeCookie('user');
        window.location.href="/main";
        $.ajax({
            url:'/deleteUser',
            type:'post',
            success:function(response,statusText){
                if(response){
                    window.location.href="/main";
                }
            }
        });
    });

    $('#login_a').click(function() {
        window.location.href="/loginForm";
    });
    $('#reg_a').click(function() {
        window.location.href="/registerForm";
    });
    //用户弹出框登录注册,无法显示单选按钮
    /*
    $('#login').dialog({
        autoOpen:false,
        title:'用户登录',
        modal:false,
        width:500,
        height:500,
        resizable:false,
        draggable:false,
        buttons:{
            '登录':function () {
                $(this).ajaxSubmit({
                    url:'/login',
                    type:'post',
                    beforeSubmit:function(){
                        $('#login').dialog('widget').find('button').eq(1).button("disable");
                    },
                    success:function(response,statusText){
                        if(response==1){
                            $('#login').dialog('widget').find('button').eq(1).button("enable");
                            $.cookie('user', $('#logname').val());
                            setTimeout(function () {
                                $('#login').dialog('close');
                                $('#login').resetForm();

                                $('#member,#logout').show();
                                $('#login_a,#reg_a').hide();
                                $('#member').html($.cookie('user'));
                            },1000)
                        }else{
                            alert("用户名或密码错误，请重新登录！");
                        }
                    },
                });
            },
        }
    }).buttonset();

    $('#reg').dialog({
        autoOpen:false,
        title:'用户注册',
        modal:false,
        width:500,
        height:500,
        resizable:false,
        draggable:false,
        buttons:{
            '注册':function () {
                $(this).ajaxSubmit({
                    url:'/register',
                    type:'post',
                    beforeSubmit:function(){
                        $('#reg').dialog('widget').find('button').eq(1).button("disable");
                    },
                    success:function(response,statusText){
                        if(response){
                            $('#reg').dialog('widget').find('button').eq(1).button("enable");
                            setTimeout(function () {
                                $('#reg').dialog('close');
                                $('#reg').resetForm();
                            },1000)
                        }
                    }
                });
            }
        }
    }).buttonset();
*/

    $('.loginButton').click(function () {
        $('#login').ajaxSubmit({
            url:'/login',
            type:'post',
            success:function(response,statusText){
                if(response==1){
                    $.cookie('user', $('#logname').val());
                    //登录成功后跳转到主页面,重新加载主页面
                    window.location.href="/main";
                }else{
                    alert("用户名或密码错误，请重新登录！");
                }
            },
        });
        return false;
    });

    $('.regButton').click(function () {
        $('#reg').ajaxSubmit({
            url:'/register',
            type:'post',
            success:function(response,statusText){
                if(response){
                    //注册成功后跳转到登录页面
                    window.location.href="/loginForm";
                }
            },
        });
        return false;
    });

    $('#error').dialog({
        autoOpen:false,
        modal:false,
        width:180,
        height:50,
        resizable : false,
        draggable : false,
    }).parent().find('.ui-widget-header').hide();
    //点击“我的订单”时，首先验证用户是否登录，再显示下拉框
    $('.order_a').click(function () {
        if($.cookie('user')){
            var timer;
            $('.order_a').mouseover(function(){
                $('.order_ul').show();
            });
            $('.order_a').mouseout(function () {
                timer=setTimeout(function () {
                    $('.order_ul').hide();
                },1000);
            });
            $('.order_ul').mouseover(function () {
                clearTimeout(timer);
                $('.order_ul').show();
            });
            $('.order_ul').mouseout(function () {
                $('.order_ul').hide();
            });
        }else{
            //弹出提示框
            $('#error').dialog('open');
            setTimeout(function () {
                $('#error').dialog('close');
            }, 1000);
        }
    });
    //点击“我要购买”时，首先验证用户是否登录，再显示订单页面
    $('.p4').click(function () {
        if ($.cookie('user')) {
            var dogId = this.id.replace("dog_", "");
            window.location.href = "/showOrder?dogId=" + dogId;
        } else {
            //弹出提示框
            $('#error').dialog('open');
            setTimeout(function () {
                $('#error').dialog('close');
            }, 1000);

        }
    });

    //点击“上传信息”时，首先验证用户是否登录，再显示上传信息界面
    $('#upload').click(function () {
        if ($.cookie('user')){
            window.location.href="/showAddDog";
        } else {
            //弹出提示框
            $('#error').dialog('open');
            setTimeout(function () {
                $('#error').dialog('close');
            }, 1000);
        }
    });
    //点击“用户社区”
    $('#community').click(function () {
        window.location.href="question";
    });

    var timer;
    $('.user_a').mouseover(function(){
        $('.user_ul').show();
    });
    $('.user_a').mouseout(function () {
        timer=setTimeout(function () {
            $('.user_ul').hide();
        },1000);
    });
    $('.user_ul').mouseover(function () {
        clearTimeout(timer);
        $('.user_ul').show();
    });
    $('.user_ul').mouseout(function () {
        $('.user_ul').hide();
    });
    /*一个函数涉及到两个页面不可以
    所以不能在主页面点击“全部”后，获取到所有订单信息，然后在订单页面显示
     */
    $('.allOrders').click(function(){
        window.location.href="/showOrders";
    });
    $('.nothandle').click(function () {
        window.location.href="/showNothandle";
    });
    $('.handled').click(function () {
        window.location.href="showHandled";
    });

});