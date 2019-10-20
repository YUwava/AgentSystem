
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'form','jquery'], function(){
        var laydate = layui.laydate //日期
            ,form = layui.form
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,carousel = layui.carousel //轮播
            ,upload = layui.upload //上传
            ,form = layui.form
            ,element = layui.element //元素操作
            ,slider = layui.slider //滑块
            ,$ = layui.jquery;


        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });


        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,url: '../usermanage/get.json' //数据接口
            ,title: '用户表'
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,cellMinWidth: 80
            ,page: true   //开启分页
            ,limit:9   //默认十条数据一页
            ,limits: [3,5,10]
            ,id: 'demo1'
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: 'ID', width:210}
                ,{field: 'userCode', title: '登录账号', width:210}
                ,{field: 'userName', title: '用户名称', width:210}
                ,{field: 'roleName', title: '角色', width:210}
                ,{field: 'creationTime', title: '创建时间', width: 210,templet: function (d) {
                        return layui.util.toDateString(d.creationTime.time, 'yyyy-MM-dd ')
                    }}
                ,{field: 'isStart', title: '是否启用', width:210,templet:'#isStart'}
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
                            ,title: '添加代理商用户信息' //不显示标题栏
                            ,area: ['30%', '60%']
                            ,shade: 0.1
                            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                            ,content: $('#show_user_add')

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
                                ,title: '修改代理商用户信息' //不显示标题栏
                                ,area: ['30%', '60%']
                                ,shade: 0.1
                                ,id: 'LAY_layuipros' //设定一个id，防止重复弹出
                                ,content: '<div id="show_user_upd" >\n' +
                                '    <br>\n' +
                                '    <br>\n' +
                                '    <form  class="layui-form"  action="../upduser/upd" >\n' +
                                '        <div class="layui-form-item form_finance">\n' +
                                '            <label class="layui-form-label">登录账号:</label>\n' +
                                '            <div class="layui-input-block">\n' +
                                '                <input type="hidden" value="${sessionScope.user}" name="createdBy" id="createdBy">\n' +
                                '                <input type="hidden" value='+checkStatus.data[0].id+' name="id" id="id">\n' +
                                '                <input type="text" name="userCode" value='+checkStatus.data[0].userCode+' id="userCode" lay-verify="required" autocomplete="off" placeholder="" class="layui-input" style="width: 200px">\n' +
                                '                <label></label>\n' +
                                '            </div>\n' +
                                '        </div>\n' +
                                '        <div class="layui-form-item form_finance">\n' +
                                '            <label class="layui-form-label">用户名称:</label>\n' +
                                '            <div class="layui-input-block">\n' +
                                '                <input type="text" name="userName" value='+checkStatus.data[0].userName+' id="userName" lay-verify="required" autocomplete="off" placeholder="" class="layui-input" style="width: 200px">\n' +
                                '                <label></label>\n' +
                                '            </div>\n' +
                                '        </div>\n' +
                                '        <div class="layui-form-item form_finance">\n' +
                                '            <label class="layui-form-label">登录密码:</label>\n' +
                                '            <div class="layui-input-block">\n' +
                                '                <input type="password" name="userPassword" value='+checkStatus.data[0].userPassword+' id="userPassword" lay-verify="required" autocomplete="off" placeholder="" class="layui-input" style="width: 200px">\n' +
                                '                <label></label>\n' +
                                '            </div>\n' +
                                '        </div>\n' +
                                $("#ipnut_userss").html()+
                                '        <div class="layui-form-item">\n' +
                                '            <div class="layui-inline">\n' +
                                '                <label class="layui-form-label">是否启用:</label>\n' +
                                '                <div class="layui-input-inline ipnut_user">\n' +
                                '                    <select name="isStart" lay-verify="required" lay-search="" class="selectedasy">\n' +
                                '                        <option value="1">启用</option>\n' +
                                '                        <option value="2">不启用</option>\n' +
                                '                    </select>\n' +
                                '                </div>\n' +
                                '            </div>\n' +
                                '        </div>\n' +
                                '        <div class="layui-form-item">\n' +
                                '            <div class="layui-input-block">\n' +
                                '                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>\n' +
                                '            </div>\n' +
                                '        </div>\n' +
                                '    </form>\n' +
                                '</div>'


                            }
                        )
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
                                    url:"../delUser/del",
                                    data:{id:checkStatus.data[0].id},
                                    dataType:"json",
                                    success:function(data){
                                        if(data.dates=="true"){
                                            layer.msg("删除成功!")
                                        }else {
                                            layer.msg("对不起，删除失败!")
                                        }
                                        window.location ='/AgentSystem/UserRole/get';
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


        var $ = layui.$, active = {
            reload: function(){
                var userName = $('#userNames').val();
                var roleId = $('#roleIds').val();
                var isStart = $('#isStarts').val();
                //执行重载
                table.reload('demo1', {
                    page: {
                        curr: 0 //重新从第 1 页开始
                    },
                    url: '../usermanages/get.json'
                    ,where: {
                        userName: userName,
                        roleId:roleId,
                        isStart:isStart
                    },
                    method: 'get',
                });
            }
        };


        $('#checkInfo').on('click', function(){
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