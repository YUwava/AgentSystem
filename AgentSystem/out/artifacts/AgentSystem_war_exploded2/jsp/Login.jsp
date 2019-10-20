<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/8
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>代理商登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/layui/css/layui.css" type="text/css">
    <link href="${pageContext.request.contextPath }/statics/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
    <img src="statics\imgs\timg.jpg" id="bk">
            <form class="layui-form" action="UserLogin">
                <div class="container">
                    <div class="layui-form-mid layui-word-aux" style="margin-top: 15px;margin-bottom: 15px">
                        <span style="height: 40px;text-align: center;"><span style="font-size: 25px;">AgentSystem</span>|代理商管理系统v1.01</span>
                    </div>
                    <div class="layui-form-item" >
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="userCode" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" id="userCode">
                        </div>
                    </div>
                    <div class="layui-form-item" >
                        <label class="layui-form-label">密 &nbsp;&nbsp;码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="userPassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" id="userPassword">
                        </div>
                        <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
                    </div>
                    <!-- 			  <div class="layui-form-item">
                                        <label class="layui-form-label">记住密码</label>
                                        <div class="layui-input-block">
                                          <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                                        </div>
                                  </div> -->

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                        </div>
                    </div>
                    <a href="" class="font-set">忘记密码?</a>  <a href="pages\Register.jsp"  class="font-sets" target="_self">立即注册</a>
                </div>
            </form>
    <script type="text/javascript" src="statics/layui/layui.js"></script>
    <script>
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

            //日期
            /* laydate.render({
               elem: '#date'
             });
             laydate.render({
               elem: '#date1'
             });

             //创建一个编辑器
             var editIndex = layedit.build('LAY_demo_editor');

             //自定义验证规则
             form.verify({
               title: function(value){
                 if(value.length < 5){
                   return '标题至少得5个字符啊';
                 }
               }
               ,pass: [
                 /^[\S]{6,12}$/
                 ,'密码必须6到12位，且不能出现空格'
               ]
               ,content: function(value){
                 layedit.sync(editIndex);
               }
             });

             //监听指定开关
             form.on('switch(switchTest)', function(data){
               layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                 offset: '6px'
               });
               layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
             });*/

            //监听提交
            form.on('submit(demo1)', function(data){
                layer.alert(JSON.stringify(data.field), {
                    title: '最终的提交信息'
                })
                return false;
            });

            //表单初始赋值
            /* form.val('example', {
               "username": "贤心" // "name": "value"
               ,"password": "123456"
               ,"interest": 1
               ,"like[write]": true //复选框选中状态
               ,"close": true //开关状态
               ,"sex": "女"
               ,"desc": "我爱 layui"
             })*/


        });
    </script>
</body>
</html>
