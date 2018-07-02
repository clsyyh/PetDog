    $(function () {
        $.ajax({
            url:'selectNothandle',
            type:'post',
            success:function(response,statusText){
                //response Json字符串
                //data Json对象数组
                var data=$.parseJSON(response);
                var html="";
                /*
                首先判断是卖家订单还是买家订单
                 */
                var arr=[];
                var count=0;
                $.each(data,function (index,order) {
                    arr[index]=order.buyerId;
                    count++;
                });
                var i;
                for( i=0;i<count-1;i++){
                    if(arr[i]!=arr[i+1]){
                        break;
                    }
                }
                if(i==data.length-1){//买家订单
                        $.each(data,function (index,order) {
                            html+='<div class="oneOrder">' +
                                '        <div class="status">等待处理</div>' +
                                '        <div class="orderDog">' +
                                '            <div class="img">' +
                                '                <img src="getImage?id='+order.dog.id+'" width="121" height="121">'+
                                '            </div>' +
                                '            <div class="introduce">' +
                                '                    <p>'+order.dog.name+'</p><br/>' +
                                '                    <span>价格：</span>' +
                                '                    <span>'+order.dog.price+'</span>' +
                                '                    <br>' +
                                '                    <span>地区：</span>' +
                                '                    <span>'+order.dog.area+'</span>' +
                                '            </div>' +
                                '        </div>' +
                                '        <div class="sum"> ' +
                                '                   合计：' + order.sumprice +
                                '        </div>' +
                                '    </div>';
                        });
                    }
                else{//卖家订单
                        $.each(data,function (index,order) {
                            html+='<div class="oneOrder">' +
                                '      <div class="status">等待处理' +
                                '       </div>' +
                                '       <div class="orderDog">' +
                                '                <div class="img">' +
                                '                <img src="getImage?id='+order.dog.id+'" width="121" height="121">'+
                                '                 </div>' +
                                '                <div class="introduce">' +
                                '                    <p>'+order.dog.name+'</p><br/>' +
                                '                    <span>价格：</span>' +
                                '                    <span>'+order.dog.price+'</span><br/>' +
                                '                    <span>配送方式：'+order.deliverWay+'</span>  '+
                                '                    <span>总计：'+order.sumprice+'</span>'+
                                '                 </div>' +
                                '        </div>' +
                                '       <div class="buyerAd">' +
                                '               <span class="p5">收货人：'+order.shr+'&nbsp;&nbsp;&nbsp;'+order.tel+'</span>' +
                                '                <span class="p6">收货地址：'+order.shad+'</span>' +
                                '        </div>' +
                                '      <div class="hanSuc">' +
                                '                  <a href="/changeOrderStatus?id='+order.id+'"><button class="success">处理</button></a>' +
                                '       </div>' +
                                '   </div>';
                        });
                    }
                $('#nothandle').append(html);
            },
        });
    });




