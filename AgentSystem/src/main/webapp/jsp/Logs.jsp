<%--
  Created by IntelliJ IDEA.
  User: 是梦终会醒
  Date: 2019/10/11
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<html>
<head>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://heerey525.github.io/layui-v2.4.3/layui/css/layui.css">
    <title>操作日志</title>
</head>
<body>
<div class="layui-body">
    <br/>
    <br/>
    <br/>
    <table class="layui-table">
        <colgroup>
            <col width="200">
            <col width="200">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>序号</th>
            <th>用户名称</th>
            <th>操作信息</th>
            <th>操作时间</th>
        </tr>
        </thead>
        <tbody id="biuuu_city_list">
        </tbody>
    </table>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend></legend>
    </fieldset>
    <div id="demo3"></div>
</div>

<script>
    var datas;//所有客户数据
    $(function () {
        $.ajax({
            url : '${pageContext.request.contextPath}/controller/logs/getLogs.json',
            type : 'post',
            data : null,
            dataType : 'json',
            async: false,
            success : function(result) {
                datas = result;
                dataload();
            },
            erorr : function() {
                alert("有异常！");
            }
        })
    })

    //数据加载
    function dataload(){
        layui.use(['table','laypage'],function(){
            var table=layui.table;
            var laypage=layui.laypage;
            //每页显示条数
            var nums=5;
            //自定义首页、尾页、上一页、下一页文本
            laypage.render({
                first: '首页'
                ,last: '尾页'
                ,prev: '<em>←</em>'
                ,next: '<em>→</em>'
                ,elem: 'demo3'
                ,count: datas.length
                ,limit:nums
                ,jump: function(obj){
                    //模拟渲染
                    document.getElementById('biuuu_city_list').innerHTML = function(){
                        var curr=obj.curr;
                        var arr = []
                            ,thisData = datas.concat().splice(curr*nums-nums, nums);
                        layui.each(thisData, function(index, item){
                            var ht="<tr>\n" +
                                "                <th>"+item.id+"</th>\n" +
                                "                <th>"+item.userName+"</th>\n" +
                                "                <th>"+item.operateInfo+"</th>\n" +
                                "                <th>"+item.operateDatetime+"</th>\n" +
                                "            </tr>"
                            arr.push(ht);
                        });
                        return arr.join('');
                    }();
                }
            });
        })
    }
</script>
</body>
</html>
<%@include file="/jsp/foot.jsp" %>