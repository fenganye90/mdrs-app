/**
 * 修改用户密码
 * */
//获取路径uri
$(function(){
    //监控（发送验证码）
    layui.use(['form' ,'layer'], function() {
        var form = layui.form;
        var layer = layui.layer;
        //确认修改密码
        form.on("submit(setPwd)",function () {
            setPwd();
            return false;
        });
    })
})

function setPwd(){
    var pwd=$("#pwd").val();
    var isPwd=$("#isPwd").val();
    if(pwd!=isPwd){
        //tips层-右
        $("#isPwd").val("");
        $("#isPwd").val("");
        layer.tips("两次输入的密码不一致", '#isPwd', {
            tips: [2, '#78BA32'], //还可配置颜色
            tipsMore: true
        });
        return false;
    }
    if("ok"!=ValidateUtils.checkSimplePassword(pwd) || "ok"!=ValidateUtils.checkSimplePassword(isPwd)){
        //tips层-右
        $("#pwd").val("");
        $("#pwd").val("");
        $("#isPwd").val("");
        $("#isPwd").val("");
        layer.alert("密码格式有误，请您重新输入");
        return false;
    }
    $.post(uri+"/user/setPwd",{"pwd":pwd,"isPwd":isPwd},function(data){
        console.log("data:"+data);
        if(data.code=="1000"){
            layer.alert("操作成功",function () {
                layer.closeAll();
                window.location.href=uri+"/logout";
            });
        }else{
            layer.alert(data.message,function () {
                layer.closeAll();
                //window.location.href="/index";
            });
        }
    });
}
