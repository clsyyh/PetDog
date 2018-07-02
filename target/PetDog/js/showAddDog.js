$(function(){
     $('#uploadDog').validate({
        submitHandler:function(form){
            $(form).ajaxSubmit({
                url:'/addDog',
                type:'post',
                beforeSubmit:function (formData,jpForm,options) {
                    $('#reg').dialog('widget').find('button').eq(1).button('disable');
                },
                success:function (response,statusText) {
                    if(response){
                        $('#reg').dialog('widget').find('button').eq(1).button('enable');
                        setTimeout(function () {
                            $('#reg').resetForm();
                            window.location.href="/main";
                        },1000);
                    }
                }
            });
        }
    });
    /*
    $('.button').click(function () {
        $('#uploadDog').ajaxSubmit({
            url:'/addDog',
            type:'post',
            beforeSubmit:function (formData,jpForm,options) {
                $('#reg').dialog('widget').find('button').eq(1).button('disable');
            },
            success:function (response,statusText) {
                if(response){
                    $('#reg').dialog('widget').find('button').eq(1).button('enable');
                    setTimeout(function () {
                        $('#reg').resetForm();
                        window.location.href="/selectDog";
                    },1000);
                }
            }
        });
        return false;
    });
    */
    /*
    $('#reg').dialog({
        title:'宠物狗信息',
        autoOpen:true,
        modal:false,
        closeOnEscape:false,
        resizable:false,
        draggable:true,
        width:1300,
        buttons:{
            '上传':function(){
                $(this).submit();
            }
        }
    }).validate({
    /*
        submitHandler:function(form){
            $(form).ajaxSubmit({
                url:'/addDog',
                type:'post',
                beforeSubmit:function (formData,jpForm,options) {
                    $('#reg').dialog('widget').find('button').eq(1).button('disable');
                },
                success:function (response,statusText) {
                    if(response){
                        $('#reg').dialog('widget').find('button').eq(1).button('enable');
                        setTimeout(function () {
                           $('#reg').resetForm();
                           window.location.href="/selectDog";
                        },1000);
                    }
                }
            })
        }
    });
*/
});