
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



        element.on('tab(demo)', function(data){
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });
        var roleId;
        window.onEdit = function(iding){
            roleId=iding;
        }
        $(document).on('click','#a_show',function(){
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





            table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
                if(layEvent === 'upding'){
                    $.ajax({
                        type:"GET",//请求类型
                        url:"../../updisStart/upd",//请求的url
                        data:{id:data.id,isStart:1},//请求参数
                        dataType:"json",//ajax接口（请求url）返回的数据类型
                        success:function(data){//data：返回数据（json对象）
                            if(data.itmes="true"){
                                layer.msg("启用成功！")
                            }else if (data.itmes="false") {
                                layer.msg("启用失败1")
                            }
                            window.parent.location.reload();
                        },
                        error:function(data){//当访问时候，404，500 等非200的错误状态码
                            layer.msg("启用失败1")
                        }
                    })
                } else if(layEvent === 'updings'){
                    $.ajax({
                        type:"GET",//请求类型
                        url:"../../updisStart/upd",//请求的url
                        data:{id:data.id,isStart:2},//请求参数
                        dataType:"json",//ajax接口（请求url）返回的数据类型
                        success:function(data){//data：返回数据（json对象）
                            if(data.itmes="true"){
                                layer.msg("不启用！")
                            }else if (data.itmes="false") {
                                layer.msg("启用失败!")
                            }
                            window.parent.location.reload();
                        },
                        error:function(data){//当访问时候，404，500 等非200的错误状态码
                            layer.msg("启用失败1")
                        }
                    })
                }
            });

            table.render({
                elem: '#demo'
                ,url: '../../GetroleJurisdiction/get.json' //数据接口
                ,title: '角色权限'
                ,page: true   //开启分页
                ,limit:9   //默认十条数据一页
                ,limits: [3,5,10]
                ,id: 'jurisdiction'
                ,cols: [[ //表头
                    {field: 'id', title: 'ID', width:240}
                    ,{field: 'functionName', title: '功能名称', width:240}
                    ,{field: 'funcUrl', title: '功能url', width:240}
                    ,{field: 'creationTime', title: '创建时间', width:240}
                    ,{field: 'isStart', title: '是否启用', width:240, templet: function (item) {
                            if (item.isStart == '1') {
                                return "启用";
                            } else if(item.isStart == '2'){
                                return "不启用";
                            }
                        }}
                    ,{fixed: 'right',title: '操作',  width: 200, align:'center', toolbar: '#barDemo'}
                ]]
                ,where:{
                    roleId:roleId
                }

            });
        });
    });


