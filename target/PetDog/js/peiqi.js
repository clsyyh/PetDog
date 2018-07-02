$(function () {
    $.ajax({
        url:'Jsoup3',
        type:'post',
        success:function (response,statusText) {
            //var data=$.parseJSON(response);

            //把json字符串转换为js对象

            var jsObj=eval("("+response+")");
            var dataObj=jsObj.data;//data是一个对象
            alert(dataObj);
            var commentList=dataObj.oriCommList;//oriCommlist是一个对象数组
            alert(commentList);
            var html="";
            $.each(commentList,function (index,obj) {
                //获取到所有评论内容
                alert(obj.content);
                html+='<p>'+obj.content+'</p>';
            });
            $('.peiqicomm').append(html);
        }
    });
});