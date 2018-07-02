$(function () {
    $('.button').click(function(){
        $('#changePwd').ajaxSubmit({
            url:'changePwd',
            type:'post',
            success:function(response,statusText){
                if(response){
                    alert("修改成功！");
                    setTimeout(function () {
                        $('#changePwd').resetForm();
                    },1000);
                    window.location.href="/showChangePwd";
                }
            },
        });
        return false;
    });
});
