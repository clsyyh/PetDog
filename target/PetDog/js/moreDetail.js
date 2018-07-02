$(function(){
    $('.p2').click(function () {
        $('#tel').dialog('open');
    });
    $('#tel').dialog({
        autoOpen:false,
        title:'电话咨询',
        modal:false,
        width:500,
        height:500,
        resizable:false,
        draggable:false,
    });
    $('.p3').click(function () {
        $('#weChat').dialog('open')
    });
    $('#weChat').dialog({
        autoOpen:false,
        title:'微信咨询',
        modal:false,
        width:500,
        height:500,
        resizable:false,
        draggable:false,
    });
        /*
       $.ajax({
           url:'/showOrder',
           type:'post',
           success:function(response,statusText){
                window.location.href="/order";
               if(response==0){
                   $('.adr1').show();
                   $('.adr2').hide();
               }else{
                   $('.adr2').show();
                   $('.adr1').hide();
               }
           }
       })
       */

    var name='';
    var area='';
    var tel='';
    var detail='';
    $('#address').dialog({
        autoOpen:false,
        madel:false,
        title:"添加新地址",
        width:500,
        height:500,
        resizeable:false,
        draggable:false,
        buttons:{
            "保存":function(){
                $(this).ajaxSubmit({
                    url:"addAddress",
                    type:"post",
                    beforeSubmit:function () {
                        $('#address').dialog('widget').find('button').eq(1).button("disable");
                    },
                    success:function(response,statusText){
                        name=$('form input[name=name]').val();
                        area=$('form input[name=area]').val();
                        detail=$('form input[name=detail]').val();
                        tel=$('form input[name=tel]').val();

                        $('#address').dialog('widget').find('button').eq(1).button("enable");
                        setTimeout(function () {
                            $('#address').dialog('close');
                            $('#address').resetForm();
                        },1000);
                        //在新增地址后，在订单页面直接显示所增地址
                        $('.address').html("");
                        var html="";
                        html+='<div class="adr2"' +
                            '  <span class="p5">收货人：'+name+'&nbsp;&nbsp;&nbsp;'+tel+'</span>' +
                            '  <span class="p6">收货地址：'+area+' '+detail+'</span>' +
                            '</div>';
                        $('.address').html(html);
                    }
                })
            }
        },
    });
    $('.adr1').click(function () {
        $('#address').dialog('open');
    });

    $('input[id^=way]').click(function () {
        var wayPrice=0;
        var way=this.id;
        if(way=="way1"){
            wayPrice=0;
        }
        if(way=="way2"){
            wayPrice=500;
        }
        if(way=="way3"){
           wayPrice=1000;
        }
        var dogPrice=parseInt( $('h2').attr("id").replace("price_","") );
        var sumPrice=wayPrice+dogPrice;
        $('.sumPrice').append(sumPrice+'￥');
        $('form input[name=sumPrice]').val(sumPrice);
    });

    $('.sub_order').click(function () {
        $('#orderForm').ajaxSubmit({
            url:"addOrder",
            type:"post",
            success:function(response,statusText){
                if(response==1){
                    //订单提交成功后，返回到主页面
                    window.location.href="/main";
                }
            },
        });
        return false;
    });
})