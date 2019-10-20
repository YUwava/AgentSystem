layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'form'], function(){
    var form = layui.form;
    var laydate = layui.laydate //日期
        ,form = layui.form
        ,laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,table = layui.table //表格
        ,carousel = layui.carousel //轮播
        ,upload = layui.upload //上传
        ,element = layui.element //元素操作
        ,slider = layui.slider //滑块


    //监听Tab切换
    element.on('tab(demo)', function(data){
        layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
            tips: 1
        });
    });


    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,url: '../rolemanage/get' //数据接口
        ,title: '用户表'
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,cellMinWidth: 80
        ,page: true   //开启分页
        ,limit:10   //默认十条数据一页
        ,limits:[3,6,9]
        ,id: 'testReload'
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'id', title: 'ID', width:320,  fixed: 'left'}
            ,{field: 'roleName', title: '角色名称', width:320}
            ,{field: 'creationTime', title: '创建时间', width: 320,templet:'<div>{{dateToStr(d.creationTime)}}</div>'}
            ,{field: 'isStart', title: '是否启用', width:320,templet:'#isStart'}
        ]]

    });


    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.open({
                    type: 1
                    ,title: false //不显示标题栏
                    ,area: ['30%', '30%']
                    ,shade: 0.1
                    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,content: $('#show_role_add')
                    }

                )
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {

                    layer.open({
                            type: 1
                            ,title: false //不显示标题栏
                            ,area: ['30%', '30%']
                            ,shade: 0.1
                            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                            ,content: "<br>\n" +
                            "    <br>\n" +
                            "    <form action='../rolemanage/upd' >\n" +
                            "        <div class=\"layui-form-item form_finance\">\n" +
                            "            <label class=\"layui-form-label\">角色名称:</label>\n" +
                            "            <div class=\"layui-input-block\">\n" +
                            "                <input type=\"hidden\" value="+checkStatus.data[0].id+" id=\"id\" name=\"id\">\n" +
                            "                <input type=\"text\" value="+checkStatus.data[0].roleName+" name=\"roleName\" id=\"roleName01\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"\" class=\"layui-input\" style=\"width: 200px\">\n" +
                            "                <label></label>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div class=\"layui-form-item\">\n" +
                            "            <div class=\"layui-inline\">\n" +
                            "                <label class=\"layui-form-label\">是否启用:</label>\n" +
                            "                <div class=\"layui-input-inline ipnut_user\">\n" +
                            "                    <select name=\"isStart\" lay-verify=\"required\" lay-search=\"\" class=\"selectedasy\" style='height: 35px'>\n" +
                            "                        <option value='1'>启用</option>\n" +
                            "                        <option value='2'>不启用</option>\n" +
                            "                    </select>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div class=\"layui-form-item\">\n" +
                            "            <div class=\"layui-input-block\">\n" +
                            "                <button type=\"submit\" class=\"layui-btn\" lay-submit=\"\" lay-filter=\"demo1\">提交</button>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "    </form>"
                    })
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.open({
                        title:"确定要删除吗",
                        area:['215px'],
                        btn:['确定','取消'],
                        yes:function(){
                            $.ajax({
                                type:"GET",
                                url:"../rolemanage/del",
                                data:{id:checkStatus.data[0].id},
                                dataType:"json",
                                success:function(data){
                                    if(data.dates=="true"){
                                        layer.msg("删除成功!")
                                        window.location ='/AgentSystem/jsp/RoleManage.jsp';
                                    }else {
                                        layer.msg("对不起，删除失败!")
                                        window.location ='/AgentSystem/jsp/RoleManage.jsp';
                                    }
                                },
                                error:function(data){
                                    layer.msg("对不起，删除失败!")
                                }
                            });
                        },
                        btn2:function(){
                            layer.closeAll(index); //关闭当前窗口
                        }
                    })
                }
                break;
        };
    });

    laypage.render({
        elem: 'pageDemo' //分页容器的id
        ,count: 100 //总页数
        ,skin: '#1E9FFF' //自定义选中色值
        ,skip: true //开启跳页
        ,jump: function(obj, first){
            if(!first){
                layer.msg('第'+ obj.curr +'页', {offset: 'b'});
            }
        }
    });


    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});

function dateToStr(date) {
    var time = new Date(date.time);
    var y = time.getFullYear();
    var M = time.getMonth() + 1;
    M = M < 10 ? ("0" + M) : M;
    var d = time.getDate();
    d = d < 10 ? ("0" + d) : d;
    var h = time.getHours();
    h = h < 10 ? ("0" + h) : h;
    var m = time.getMinutes();
    m = m < 10 ? ("0" + m) : m;
    var s = time.getSeconds();
    s = s < 10 ? ("0" + s) : s;
    var str = y + "-" + M + "-" + d + " " + h + ":" + m + ":" + s;
    console.log(str);
    return str;
};
$(function () {
    var showhinttext=$("#showhint").val();
    if (showhinttext=="1"){
        layer.msg('恭喜你，添加成功！');
    }else if (showhinttext=="2") {
        layer.msg('对不起，添加失败！');
    }
    else if (showhinttext=="") {

    }
})