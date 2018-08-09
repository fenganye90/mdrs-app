/**
 * 权限列表
 */
var table;
$(function() {
    //初始化treegrid 页面表格
//    layui.config({
//    	open: '<script th:src="@{/treegrid/treeGrid.js}">',
//    	close: '</script>',
//        base: uri+'/treegrid/'
//    }).use(['laytpl', 'treegrid'], function () {
//        var laytpl = layui.laytpl,
//            treegrid = layui.treegrid;
//        treegrid.config.render = function (viewid, data) {
//            var view = document.getElementById(viewid).innerHTML;
//            return laytpl(view).render(data) || '';
//        };
//
//        var treeForm=treegrid.createNew({
//            elem: 'permTable',
//            view: 'view',
//            data: { rows: permList },
//            parentid: 'pid',
//            singleSelect: false
//        });
//        treeForm.build();
//        //折叠节点
//		$('.layui-btn').on('click', function () {
//	        var id,
//	            row = treeForm.getRow();
//	        if (row != null)
//	            id = row.id;
//	
//	        switch ($(this).attr('lay-filter')) {
//	            case 'expandAll': {
//	            	treeForm.expandAll(id)
//	            } break;
//	            case 'collapseAll': {
//	            	treeForm.collapseAll(id)
//	            } break;
//	            case 'expand': {
//	            	treeForm.expand(id)
//	            } break;
//	            case 'collapse': {
//	            	treeForm.collapse(id)
//	            } break;
//	        }
//	    });
//        
//
//    });
	//初始化treegrid
	layui.use(['element', 'layer', 'form', 'upload', 'treeGrid'], function () {
        var treeGrid = layui.treeGrid; //很重要
        var treeTable =treeGrid.render({
        	elem: '#permTable'
            ,data:  permList 
            ,cellMinWidth: 100
            ,treeId:'id'//树形id字段名称
            ,treeUpId:'pid'//树形父id字段名称
            ,treeShowName:'name'//以树形式显示的字段
            ,cols: [[
               {field:'name',width:'200', title: '权限名称'}
               ,{field:'typeStr',width:'200', title: '权限分类'}
               ,{field:'page', width:'200', title: '权限路径'}
               ,{field:'code', width:'200', title: '权限code'}
               ,{field:'zindex', width:'200', title: '优先级'}
               ,{fixed:'right',width:'200',aligin:'center',title: '操作',toolbar:'#jobTpl'}
            ]]
            ,page:false//开启分页
        });
        treeGrid.on('tool(permTable)', function (obj) {
    		var data = obj.data;
    		if (obj.event === 'edit') {
    			edit(data.id,0);
    		}else if (obj.event === 'addPerm') {
    			addPerm(data.id,1);
    		}else if(obj.event === 'del'){
    			del(data.id,data.name);
    		}
    	});
    });
	
    //操作
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(permSubmit)', function(data){
            //校验 TODO
            $.ajax({
                type: "POST",
                data: $("#permForm").serialize(),
                url: uri+"/auth/setPerm",
                success: function (data) {
                    if (data == "ok") {
                        layer.alert("操作成功",function(){
                            layer.closeAll();
                        });
                    } else {
                        layer.alert(data);
                    }
                },
                error: function (data) {
                    layer.alert("操作请求错误，请您稍后再试");
                }
            });
            return false;
        });
        form.render();
    });

});

function edit(id,type){
    if(null!=id){
        $("#type").val(type);
        $("#id").val(id);
        $.get(uri+"/auth/getPerm",{"id":id},function(data) {
            // console.log(data);
            if(null!=data){
                $("input[name='name']").val(data.name);
                $("input[name='code']").val(data.code);
                $("input[name='page']").val(data.page);
                $("input[name='zindex']").val(data.zindex);
                $("textarea[name='descpt']").text(data.descpt);
                $("#pid").val(data.pid);
                data.istype==0?$("input[name='istype']").val(0).checked:$("input[name='istype']").val(1).checked;
                layer.open({
                    type:1,
                    title: "更新权限",
                    fixed:false,
                    resize :false,
                    shadeClose: true,
                    area: ['500px', '580px'],
                    content:$('#updatePerm'),
                    end:function(){
                        location.reload();
                    }
                });
            }else{
                layer.alert("获取权限数据出错，请您稍后再试");
            }
        });
    }
}
//开通权限
function addPerm(pid,flag){
    if(null!=pid){
        //flag[0:开通权限；1：新增子节点权限]
        //type[0:编辑；1：新增]
        if(flag==0){
            $("#type").val(1);
            $("#pid").val(0);
        }else{
            //设置父id
            $("#type").val(1);
            $("#pid").val(pid);
        }
        layer.open({
            type:1,
            title: "添加权限",
            fixed:false,
            resize :false,
            shadeClose: true,
            area: ['500px', '580px'],
            content:$('#updatePerm'),  //页面自定义的div，样式自定义
            end:function(){
                location.reload();
            }
        });
    }
}

function del(id,name){
    // console.log("===删除id："+id);
    if(null!=id){
        layer.confirm('您确定要删除'+name+'权限吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post(uri+"/auth/del",{"id":id},function(data){
                if(data=="ok"){
                    //回调弹框
                    layer.alert("删除成功！",function(){
                        layer.closeAll();
                        //加载load方法
                        location.reload();;//自定义
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

//关闭弹框
function close(){
    layer.closeAll();
}