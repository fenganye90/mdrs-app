/**
 * 权限列表，成功获取后，添加到table表中
 */
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        var tbody=$("#tbody");
        $.get(uri+"/auth/getRoleList",function(data){
            if(data!=null){
                tbody.empty();
                $.each(data, function (index, item) {
                    var td=$("<tr><td>"+item.code+"</td>"
                    +"<td>"+item.roleName+"</td>"
                    +"<td>"+item.description+"</td>"
                    +"<td>"+DateUtils.formatDate(item.createTime)+"</td>"
                    +"<td>"
                    +"<button class='layui-btn layui-btn-xs' onclick='updateRole("+item.id+")'><i class='layui-icon'>&#xe642;</i></button>"
                        +"<button class='layui-btn layui-btn-danger layui-btn-xs' onclick='delRole("+item.id+")'><i class='layui-icon'>&#xe640;</i></button></td></tr>");
                    tbody.append(td);
                });
            }
        });
    });
});

function updateRole(id) {
    //isNaN是数字返回false
    if(id!=null && !isNaN(id)){
        window.location.href=uri+"/auth/updateRole/"+id;
    }else{
        layer.alert("请求参数有误，请您稍后再试");
    }
}
function delRole(id) {
    if(null!=id){
        layer.confirm('您确定要删除'+name+'角色吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post(uri+"/auth/delRole",{"id":id},function(data){
                if(data=="ok"){
                    //回调弹框
                    layer.alert("删除成功！",function(){
                        layer.closeAll();
                        //加载load方法
                        load();//自定义
                    });
                }else{
                    layer.alert(data);//弹出错误提示
                }
            });
        }, function(){
            layer.closeAll();
        });
    }
}

