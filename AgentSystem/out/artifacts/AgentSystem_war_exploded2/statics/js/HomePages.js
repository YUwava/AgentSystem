layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'form','jquery'], function(){

    var laydate = layui.laydate //日期
        ,form = layui.form
        ,layer = layui.layer //弹层
        ,form = layui.form
        ,$ = layui.jquery;

    $(document).on('click','#Upd_Show_Viwe',function(){
        layer.open({
            type: 1
            ,title:"修改密码"
            ,area:['30%', '45%']
            ,shade: 0.1
            ,id: 'LAY_layuipros' //设定一个id，防止重复弹出
            ,content:"<div>\n" +
                "    <form class=\"layui-form\">\n" +
                "        <div class=\"layui-form-item form_finance\">\n" +
                "            <label class=\"layui-form-label\">旧密码</label>\n" +
                "            <div class=\"layui-input-block\">\n" +
                "                <input type=\"text\" name=\"olduserPassword\" id=\"olduserPassword\" lay-verify=\"olduserPassword\" autocomplete=\"off\" placeholder=\"旧密码\" class=\"layui-input\" style='300px'>\n" +
                "                <label id='labeloldpwd'></label>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item form_finance\">\n" +
                "            <label class=\"layui-form-label\">新密码</label>\n" +
                "            <div class=\"layui-input-block\">\n" +
                "                <input type=\"password\" name=\"newuserPassword\" id=\"newuserPassword\" lay-verify=\"newuserPassword\" autocomplete=\"off\" placeholder=\"新密码\" class=\"layui-input\" style='300px'>\n" +
                "                <label></label>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item form_finance\">\n" +
                "            <label class=\"layui-form-label\">再次输入新密码</label>\n" +
                "            <div class=\"layui-input-block\">\n" +
                "                <input type=\"password\" name=\"newPwd\" id=\"newPwd\" lay-verify=\"newPwd\" autocomplete=\"off\" placeholder=\"再次输入新密码\" class=\"layui-input\" style='300px'>\n" +
                "                <label></label>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"layui-form-item\">\n" +
                "            <div class=\"layui-input-block\">\n" +
                "                <button type=\"button\" id=\"btus\" class=\"layui-btn\" lay-submit=\"\" lay-filter=\"demo1\">提交</button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</div>"
        })
    });


    $(document).on('click','#btus',function(){
        if ($("#olduserPassword").val()!=''){
            $.ajax({
                type:"GET",//请求类型
                url:"getpwd/get",//请求的url
                data:{id:$("#userids").val(),pwd:$("#olduserPassword").val()},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    if(data.itmes="true"){
                        if ($("#newuserPassword").val()==$("#newPwd").val()){
                            $.ajax({
                                type:"GET",//请求类型
                                url:"getpwd/updPwd",//请求的url
                                data:{id:$("#userids").val(),pwd:$("#newPwd").val()},//请求参数
                                dataType:"json",//ajax接口（请求url）返回的数据类型
                                success:function(datas){//data：返回数据（json对象）
                                    if(datas.itmeing="true"){
                                        layer.msg("修改密码成功")
                                    }else if (datas.itmeing="false") {
                                        layer.msg("修改密码失败")
                                    }
                                    location.href="index.jsp";
                                },
                                error:function(data){//当访问时候，404，500 等非200的错误状态码
                                    $("#labeloldpwd").text('旧密码错误');
                                }
                            })
                        }else {
                            layer.msg("两次密码不一致")
                        }
                    }else if (data.itmes="false") {
                        layer.msg("旧密码错误")
                    }
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    layer.msg("旧密码错误")
                }
            })
        }else {
            layer.msg("密码不能为空")
        }
    })


    form.verify({
        newuserPassword: function(value){
            if(value.length < 6){
                return '密码至少得6个字符啊';
            }
        }
    });
    form.verify({
        newPwd: function(value){
            if(value.length < 6){
                return '密码至少得6个字符啊';
            }
        }
    });

});


