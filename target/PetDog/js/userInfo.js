$(function () {
    $('#uploadphoto').click(function () {
        alert($('form input[type=file]').val());
        $.ajax({
            url:'uploadPhoto',
            type:'post',
            data:{
                id:$('form input[type=hidden]').val(),
                photo:$('form input[type=file]').val(),
            },
            success:function (response,statusText) {
                if(response){
                    window.location.href="/selectInfo";
                }
            }
        });
    });
});