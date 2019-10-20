layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'form','jquery'], function(){
    var laydate = layui.laydate //日期
        ,form = layui.form
        ,laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,table = layui.table //表格
        ,carousel = layui.carousel //轮播
        ,upload = layui.upload //上传
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
        ,url: '../AntistopAudit/get.json' //数据接口
        ,title: '关键词申请'
        ,cellMinWidth: 80
        ,page: true   //开启分页
        ,limit:9   //默认十条数据一页
        ,limits: [3,5,10]
        ,id: 'demo1'
        ,cols: [[ //表头
            {field: 'id', title: '序号', width:80}
            ,{field: 'keywords', title: '关键词', width:160}
            ,{field: 'customName', title: '客户名称', width:150}
            ,{field: 'agentName', title: '代理商', width:100}
            ,{field: 'serviceYears', title: '申请年限', width: 60}
            ,{field: 'regDatetime', title: '申请日期', width:130}
            ,{field: 'preRegDatetime', title: '到期日期', width:130}
            ,{field: 'isPass', title: '到期到期状态', width:100, templet: function (item) {
                    if (item.isPass == '0') {
                        return "未过期";
                    } else if(item.isPass == '1'){
                        return "预注册过期";
                    }else if(item.isPass == '2'){
                        return "正式注册过期";
                    }
                }}
            ,{field: 'checkStatus', title: '审核状态', width:100, templet: function (item) {
                    if (item.checkStatus == '0') {
                        return "已申请";
                    } else if(item.checkStatus == '1'){
                        return "审核中";
                    }else if(item.checkStatus == '2'){
                        return "已通过";
                    }else if(item.checkStatus == '3'){
                        return "未通过";
                    }
                }}
            ,{field: 'isUse', title: '使用状态', width:100, templet: function (item) {
                    if (item.isUse == '0') {
                        return "未使用";
                    } else if(item.isUse == '1'){
                        return "已使用";
                    }
                }}
            ,
            ,{fixed: 'right',title: '操作', width: 215, align:'center', templet: function (item) {
                    if (item.isUse==0){
                        return " <a style='width: 200px' class=\"layui-btn layui-btn-xs\" lay-event=\"employ\">使用</a>"
                    }
                    if (item.isUse==1 && item.checkStatus==2){
                        return "<a style='width: 90px' class=\"layui-btn layui-btn-xs\" lay-event=\"renew\">续费</a>\n" +
                            "   <a style='width: 90px' class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"nonuse\">不使用</a>"
                    }
                    if (item.isUse==1 && item.checkStatus==0){
                        return "<a style='width: 90px' class=\"layui-btn layui-btn-xs\" lay-event=\"auditCentre\">审核中</a>\n" +
                            "   <a style='width: 90px' class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"nonuse\">不使用</a>"
                    }
                    if (item.isUse==1 && item.checkStatus==1){
                        return " <a style='width: 50px' class=\"layui-btn layui-btn-xs\" lay-event=\"auditGo\">审核通过</a>\n" +
                            "    <a style='width: 50px' class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"noPass\">不通过</a>\n" +
                            "    <a style='width: 50px' class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"nonuse\">不使用</a>"
                    }
                    if (item.isUse==1 && item.checkStatus==3){
                        return " <a style='width: 200px' class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"nonuse\">不使用</a>"
                    }
                }}
        ]]
    });


    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'employ'){
            layer.msg('使用');
            $.ajax({
                type:"GET",//请求类型
                url:"../updkeywordscondition/upd",//请求的url
                data:{id:data.id,prices:1},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    if(data.itmes="true"){
                        layer.msg("设置成功！")
                    }else if (data.itmes="false") {
                        layer.msg("设置失败！")
                    }
                    window.parent.location.reload();
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    layer.msg("设置失败！")
                }
            })
        } else if(layEvent === 'renew'){
            layer.msg("续费")
            layer.open({
                    type: 1
                    ,title:"当前为进"+data.keywords+"行续费操作"
                    ,area:['500px']
                    ,shade: 0.1
                    ,id: 'LAY_layuipros' //设定一个id，防止重复弹出
                    ,content:"\n" +
                    "<div>\n" +
                    "    <form  action=\"../KeyWords/date/upd\">\n" +
                    "        <label>为"+data.keywords+"续费【当前余额：￥"+data.price+"】</label>\n" +
                    "        <div class=\"layui-form-item form_finance\">\n" +
                    "            <label class=\"layui-form-label\">客户名称</label>\n" +
                    "            <input type='hidden' name='id' id='id' value="+data.id+">\n" +
                    "            <div class=\"layui-input-block\">\n" +
                    "                <input type=\"text\" name=\"customName\"value="+data.customName+" id=\"customName\" lay-verify=\"customName\" autocomplete=\"off\" disabled=\"disabled\" class=\"layui-input\">\n" +
                    "                <label></label>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"layui-form-item form_finance\">\n" +
                    "            <label class=\"layui-form-label\">关键词</label>\n" +
                    "            <div class=\"layui-input-block\">\n" +
                    "                <input type=\"text\" name=\"keywords\" value="+data.keywords+" id=\"keywords\" lay-verify=\"keywords\" autocomplete=\"off\" disabled=\"disabled\" class=\"layui-input\">\n" +
                    "                <label></label>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "\n" +
                    "        <div class=\"layui-form-item form_finance\">\n" +
                    "            <label class=\"layui-form-label\">服务类别</label>\n" +
                    "            <div class=\"layui-input-block\">\n" +
                    "                <select style='height: 35px' name=\"configTypeName\" lay-verify=\"required\"  onchange=\"gradeChange(this.options[this.options.selectedIndex].value)\">\n" +
                    "                    <option value=''>请选择</option>\n" +
                    "                    <option value=\"1\">上传苹果商城</option>\n" +
                    "                    <option value=\"2\">不上传苹果商</option>\n" +
                    "                </select>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"layui-form-item form_finance\">\n" +
                    "            <label class=\"layui-form-label\">服务年限</label>\n" +
                    "            <div class=\"layui-input-block\">\n" +
                    "                <select style='height: 35px' name=\"regPassDatetime\" id='regPassDatetime' lay-verify=\"required\" onchange=\"gradeChangeing(this.options[this.options.selectedIndex].value)\">\n" +
                    "                    <option value=''>请选择</option>\n" +
                    "                    <option value=\"1\">1年</option>\n" +
                    "                    <option value=\"2\">2年</option>\n" +
                    "                    <option value=\"3\">3年</option>\n" +
                    "                    <option value=\"4\">4年</option>\n" +
                    "                    <option value=\"5\">5年</option>\n" +
                    "                    <option value=\"6\">6年</option>\n" +
                    "                    <option value=\"7\">7年</option>\n" +
                    "                    <option value=\"8\">8年</option>\n" +
                    "                    <option value=\"9\">9年</option>\n" +
                    "                    <option value=\"10\">10年</option>\n" +
                    "                </select>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"layui-form-item form_finance\">\n" +
                    "            <label class=\"layui-form-label\">价格</label>\n" +
                    "            <div class=\"layui-input-block\">\n" +
                    "                <input type=\"text\" name=\"price\" id=\"price\" value=\"\" lay-verify=\"price\" autocomplete=\"off\" disabled=\"disabled\" class=\"layui-input\">\n" +
                    "                <label></label>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"layui-form-item\">\n" +
                    "            <div class=\"layui-input-block\">\n" +
                    "                <button type=\"submit\" class=\"layui-btn\" lay-submit=\"\" lay-filter=\"demo1\">续费提交</button>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </form>\n" +
                    "</div>"
            })
        } else if(layEvent === 'nonuse'){
            layer.msg('不使用');
            $.ajax({
                type:"GET",//请求类型
                url:"../updkeywordscondition/upd",//请求的url
                data:{id:data.id,prices:5},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    if(data.itmes="true"){
                        layer.msg("设置成功！")
                    }else if (data.itmes="false") {
                        layer.msg("设置失败！")
                    }
                    window.parent.location.reload();
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    layer.msg("设置失败！")
                }
            })
        }else if(layEvent === 'auditGo'){
            layer.msg('审核通过');
            $.ajax({
                type:"GET",//请求类型
                url:"../updkeywordscondition/upd",//请求的url
                data:{id:data.id,prices:3},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    if(data.itmes="true"){
                        layer.msg("设置成功！")
                    }else if (data.itmes="false") {
                        layer.msg("设置失败！")
                    }
                    window.parent.location.reload();
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    layer.msg("设置失败！")
                }
            })
        }else if(layEvent === 'noPass'){
            layer.msg('不通过');
            $.ajax({
                type:"GET",//请求类型
                url:"../updkeywordscondition/upd",//请求的url
                data:{id:data.id,prices:4},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    if(data.itmes="true"){
                        layer.msg("设置成功！")
                    }else if (data.itmes="false") {
                        layer.msg("设置失败！")
                    }
                    window.parent.location.reload();
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    layer.msg("设置失败！")
                }
            })
        }else if(layEvent === 'auditCentre'){
            layer.msg('审核中');
            $.ajax({
                type:"GET",//请求类型
                url:"../updkeywordscondition/upd",//请求的url
                data:{id:data.id,prices:2},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    if(data.itmes="true"){
                        layer.msg("设置成功！")
                    }else if (data.itmes="false") {
                        layer.msg("设置失败！")
                    }
                    window.parent.location.reload();
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    layer.msg("设置失败！")
                }
            })
        }

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
            var keywords = $('#keywords').val();
            //执行重载
            table.reload('demo1', {
                page: {
                    curr: 0 //重新从第 1 页开始
                },
                url: '../AntistopAudit/get.json'
                ,where: {
                    keywords: keywords,
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
var txs
function gradeChange(tx) {
    if (tx==1) {
        txs=26000;
    }else if(tx==2){
        txs=18000;
    }
}
function gradeChangeing(tx) {
    var prices=tx*txs;
    $('#price').val(prices);
}