/**
 * 权限列表
 */
var pageCurr;
$(function() {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        tableIns=table.render({
            elem: '#userList'
            ,url:uri+'/user/getUsers'
            ,cellMinWidth: 80
            ,page: true,
            request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            },response:{
                statusName: 'code' //数据状态的字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,countName: 'totals' //数据总数的字段名称，默认：count
                ,dataName: 'list' //数据列表的字段名称，默认：data
            }
            ,cols: [[
                {type:'numbers'}
                /*,{field:'id', title:'ID', width:90, unresize: true, sort: true}*/
                ,{field:'username', title:'用户名'}
                ,{field:'defaultUrl', title:'登录位置'}
                ,{field:'realName', title: '真实姓名'}
                ,{field:'roleNames', title: '角色名称', minWidth:50}
                ,{field:'insertTime', title: '添加时间'}
                ,{field:'type', title: '用户类型'}
                ,{field:'flag', title:'禁用',width:90,templet:'#jobTpl'}
                ,{fixed:'right', title:'操作', width:120,align:'center', toolbar:'#optBar'}
            ]]
            ,  done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                //console.log(curr);
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

        //监听禁用操作
        form.on('switch(isJobTpl)', function(obj){
            //console.log(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
            setJobUser(obj,this.value,this.name,obj.elem.checked);
        });
        //监听工具条
        table.on('tool(userTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                //编辑
                getUserAndRoles(data,data.id);
            }
        });
        //监听提交
        form.on('submit(userSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
        });

    });
    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#insertTimeStart'
        });
        laydate.render({
            elem: '#insertTimeEnd'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });
    });
});
//设置用户是否禁用
function setJobUser(obj,id,name,checked){
    var isForbidden=checked ? 0 : 1;
    var userIsForbidden=checked ? "启用":"禁用";
    //是否禁用
    layer.confirm('您确定要把用户：'+name+'设置为'+userIsForbidden+'状态吗？', {
        btn: ['确认','返回'] //按钮
    }, function(){
        $.post(uri+"/user/setJobUser",{"id":id,"isForbidden":isForbidden},function(data){
            if(data=="ok"){
                //回调弹框
                layer.alert("操作成功！",function(){
                    layer.closeAll();
                    //加载load方法
                    load(obj);//自定义
                });
            }else{
                layer.alert(data);//弹出错误提示
            }
        });
    }, function(){
        layer.closeAll();
    });
}
//提交表单
function formSubmit(obj){
    checkRole();
    $.ajax({
        type: "POST",
        data: $("#userForm").serialize(),
        url: uri+"/user/setUser",
        success: function (data) {
            if (data == "ok") {
                layer.alert("操作成功",function(){
                    layer.closeAll();
                    //加载页面
                    load(obj);
                });
            } else {
                layer.alert(data);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}
function checkRole(){
    //选中的角色
    var array = new Array();
    var roleCheckd=$(".layui-form-checked");
    //获取选中的权限id
    for(var i=0;i<roleCheckd.length;i++){
        array.push($(roleCheckd.get(i)).prev().val());
    }
    //校验是否授权
    var roleIds = array.join(",");
    if(roleIds==null || roleIds==''){
        layer.alert("请您给该用户添加对应的角色！")
        return false;
    }
    $("#roleIds").val(roleIds);
}
//开通用户
function addUser(){
	resetForm();
    $.get(uri+"/auth/getRoles",function(data){
        if(data!=null){
            //显示角色数据
            $("#roleDiv").empty();
            $.each(data, function (index, item) {
                // <input type="checkbox" name="roleId" title="发呆" lay-skin="primary"/>
                var roleInput=$("<input type='checkbox' name='roleId' value="+item.id+" title="+item.roleName+" lay-skin='primary'/>");
                //未选中
                /*<div class="layui-unselect layui-form-checkbox" lay-skin="primary">
                    <span>发呆</span><i class="layui-icon">&#xe626;</i>
                    </div>*/
                //选中
                // <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary">
                // <span>写作</span><i class="layui-icon">&#xe627;</i></div>
                var div=$("<div class='layui-unselect layui-form-checkbox' lay-skin='primary'>" +
                    "<span>"+item.roleName+"</span><i class='layui-icon'>&#xe626;</i>" +
                    "</div>");
                $("#roleDiv").append(roleInput).append(div);
            })
            openUser(null,"开通用户");
            //重新渲染下form表单 否则复选框无效
            layui.form.render('checkbox');
            layui.form.render('radio');
        }else{
            //弹出错误提示
            layer.alert("获取角色数据有误，请您稍后再试",function () {
                layer.closeAll();
            });
        }
    });
}
function openUser(title){
    layer.open({
        type:1,
        title: title,
        fixed:false,
        resize :false,
        shadeClose: true,
        area: ['650px','550px'],
        content:$('#setUser')/*,
        end:function(){
            if(obj==null){
                window.location.href="/user/userList";
            }else{
                load(obj);
            }
        }*/
    });
}
function getUserAndRoles(obj,id) {
    //回显数据
    $.get(uri+"/user/getUserAndRoles",{"id":id},function(data){
        if(data.msg=="ok" && data.user!=null){
            var existRole='';
            if(data.user.userRoles !=null ){
                $.each(data.user.userRoles, function (index, item) {
                    existRole+=item.roleId+',';
                });
            }
            $("#id").val(data.user.id==null?'':data.user.id);
            $("#username").val(data.user.username==null?'':data.user.username);
            $("#realName").val(data.user.realName==null?'':data.user.realName);
            $("#addPhone").val(data.user.phone==null?'':data.user.phone);
            //用户类型,0为平台用户，1位HIS用户
            if(!data.user.type==0){
            	$("#hisUser").attr("checked",'true');
            }else{
            	$("#platformUser").attr("checked",'true');
            }
            /*//是否禁用,0为可使用，1为禁用
            if(data.user.isForbidden=0){
            	$("#isForbidden").attr("checked",'true')
            }else{
            	$("#isForbidden").attr("checked",'false')
            }*/
            //跳转页面,1为后端，2为前端
            if(data.user.defaultUrl==1){
            	$("#backStage").attr("checked",'true');
            }else{
            	$("#frontStage").attr("checked",'true');
            }
            $("#addDescrpt").val(data.user.description==null?'':data.user.description);
            $("#addProfessional").val(data.user.professional==null?'':data.user.professional);
            //显示角色数据
            $("#roleDiv").empty();
            $.each(data.roles, function (index, item) {
                var roleInput=$("<input type='checkbox' name='roleId' value="+item.id+" title="+item.roleName+" lay-skin='primary'/>");
                var div=$("<div class='layui-unselect layui-form-checkbox' lay-skin='primary'>" +
                    "<span>"+item.roleName+"</span><i class='layui-icon'>&#xe626;</i>" +
                    "</div>");
                if(existRole!='' && existRole.indexOf(item.id)>=0){
                     roleInput=$("<input type='checkbox' name='roleId' value="+item.id+" title="+item.roleName+" lay-skin='primary' checked='checked'/>");
                     div=$("<div class='layui-unselect layui-form-checkbox  layui-form-checked' lay-skin='primary'>" +
                        "<span>"+item.roleName+"</span><i class='layui-icon'>&#xe627;</i>" +
                        "</div>");
                }
                $("#roleDiv").append(roleInput).append(div);
            });
            openUser("设置用户");
            //重新渲染下form表单中的复选框 否则复选框选中效果无效
            // layui.form.render();
            layui.form.render('checkbox');
            layui.form.render('radio');
        }else{
            //弹出错误提示
            layer.alert(data.msg,function () {
                layer.closeAll();
            });
        }
    });
}

function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

/**
 * 重置表单内容
 */
function resetForm(){
	$('#id').val("");
	$('#username').val("");
	$('#password').val("");
	$('#realName').val("");
	$('#addPhone').val("");
	$('#platformUser').attr("checked",'false');
	$('#hisUser').attr("checked",'false');
	$('#backStage').attr("checked",'false');
	$('#frontStage').attr("checked",'false');
	$('#addDescrpt').val("");
	$('#addProfessional').val("");
}
