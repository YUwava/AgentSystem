<%--
  Created by IntelliJ IDEA.
  User: 是梦终会醒
  Date: 2019/10/17
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<html>
<head>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>Title</title>
    <script>
        var mon=18000;
        layui.use('form',function () {
            var form=layui.form;
            form.on('select(citys)',function(){
                read()
                form.render('select');
            })

            form.on('select(agelimit)',function () {
                money()
                form.render('select');
            })

            form.on('select(protype)',function () {
                money()
                form.render('select');
            })
        })

        function protype(){
            var i=$('#protype option:selected').val();
            if (i==1)
                mon=26000
            else
                mon=18000
        }
        $.ajax({
            url : '${pageContext.request.contextPath}/controller/getcustomername',
            type : 'post',
            dataType : 'json',
            success : function(result) {
                dataload(result);
            },
            erorr : function() {
                alert("有异常！");
            }
        })

        function dataload(datas) {
            var htmls;
            $.each(datas,function (index,items) {
                htmls+="<option value="+items+">"+items+"</option>"
            })
            $('#search').html(htmls);
        }
        function read() {
            var price=$('#search option:selected').val();
            $('#name').val(price)
        }

        function money() {
            protype();
            var price=$('#agelimit option:selected').val();
            $('#price').val(price*mon)
        }
        function present() {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "${pageContext.request.contextPath}/controller/addkeywords" ,//url
                data: $('#form_ajax').serialize(),
                success: function (result) {
                    if (result>0) {
                        layer.msg("添加成功")
                    };
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
    </script>
</head>
<body>
<div class="layui-body">
    <form class="layui-form" action="${pageContext.request.contextPath}/controller/addkeywords" method="post">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">搜索选择框</label>
                <div class="layui-input-inline">
                    <select name="" lay-verify="required" lay-search="citys" id="search" lay-filter="citys">
                        <option value="">--请选择--</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">客户名称</label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="customName" lay-verify="pass" placeholder="" autocomplete="off" class="layui-input"
                       readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">关键词</label>
            <div class="layui-input-inline">
                <input type="text" name="keywords" lay-verify="pass" placeholder="请输入关键词" autocomplete="off"
                       class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">服务类别</label>
                <div class="layui-input-inline">
                    <select name="productType" id="protype" lay-verify="required" lay-filter="protype" lay-search="" name="productType">
                        <option value="">--请选择--</option>
                        <option value="1">上传苹果商城</option>
                        <option value="2" selected="selected">不上传苹果商城</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">服务年限</label>
                <div class="layui-input-inline">
                    <select name="serviceYears" lay-verify="required" lay-search="" lay-filter="agelimit" name="serviceYears" id="agelimit">
                        <option value="">--请选择--</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">金额</label>
            <div class="layui-input-inline">
                <input type="text" id="price" name="price" lay-verify="pass" placeholder="" autocomplete="off" class="layui-input" readonly="readonly">
            </div>
            <div class="layui-form-mid layui-word-aux">价格根据选择的服务类别和服务年限，自动算出，不可填写。</div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<%@include file="/jsp/foot.jsp" %>