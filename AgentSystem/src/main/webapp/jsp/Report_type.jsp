<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019/10/14
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<html>
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>报表管理</title>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://heerey525.github.io/layui-v2.4.3/layui/css/layui.css">
</head>
<body>
<div class="layui-body">
    <colgroup>
        <col width="200">
        <col width="200">
        <col width="200">
        <col>
    </colgroup>
<br/>
<br/>
<br/>
<br/>
<br/>
<dvi>系统配置管理/优惠类型</dvi>
<br/>
<br/>
<br/>
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">操作类型:</label>
        <div class="layui-input-inline">
            <br/>
            <form action="${pageContext.request.contextPath}/yyer/eamle">
            <select name="quiz">
                <optgroup label="财务报表">
                    <option value="0">代理商账户余额报表</option>
                    <option value="1">预付款流水报表</option>
                    <option value="2">代理商账户流水报表</option>
                </optgroup>
                <optgroup label="产品报表 ">
                    <option value="3">产品分类数量/金额汇总</option>
                </optgroup>
                <optgroup label="消费报表">
                    <option value="4">客户消费总汇</option>
                </optgroup>
            </select>
                <input type="submit" value="查询">
            </form>
        </div>
</div>
</div>
</div>

<%--            预付款流水报表--%>
<div style="width: 1000px;display: none" id="AdvanceChargeDiv">
    <div class="table-responsive table2excel" data-tableName="Test Table 1">
        <table class="layui-table" id="AdvanceCharge">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>代理商名称</th>
                <th>预付款</th>
                <th>账户余额</th>
                <th>备注信息</th>
                <th>时间</th>
            </tr>
            </thead>
            <tbody id="AdvanceChargeTbody">


            </tbody>
        </table>
    </div>
</div>


<%--  代理商账户余额报表--%>
<div style="width: 700px;display: none" id="AccountBalanceDiv">
    <div class="table-responsive table2excel" data-tableName="Test Table 1">
        <table class="layui-table" id="AccountBalance">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>代理商名称</th>
                <th>账号余额</th>
            </tr>
            </thead>
            <tbody id="biuuu_city_list">
            </tbody>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend></legend>
            </fieldset>
            <div id="demo3"></div>
        </table>
    </div>
</div>


<%--  产品分类信息报表--%>
<div style="width: 700px;display: none" id="ProductDiv">
    <div class="table-responsive table2excel" data-tableName="Test Table 1">
        <table class="layui-table" id="Product">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>产品分类名称</th>
                <th>数量</th>
                <th>价格</th>
            </tr>
            </thead>
            <tbody id="ProductTbody">

            </tbody>
        </table>
    </div>
</div>
<%--    <table class="layui-hide" id="test"></table>--%>
</div>
<script>
    var finay;//所有客户数据
    $(function () {
        $.ajax({
            url : '${pageContext.request.contextPath}/yyer/eamle',
            type : 'post',
            data : null,
            dataType : 'json',
            async: false,
            success : function(result) {
                console.log("数据得到的");
                finay = result;
                console.log(finay);
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
                ,count: finay.length
                ,limit:nums
                ,jump: function(obj){
                    //模拟渲染
                    document.getElementById('biuuu_city_list').innerHTML = function(){
                        var curr=obj.curr;//当前页数
                        var arr = []
                            ,thisData = finay.concat().splice(curr*nums-nums, nums);
                        console.log(thisData)
                        layui.each(thisData, function(index, item){
                            var ht="<tr>\n" +
                                "<th>"+item.id+"</th>\n" +
                                " <th>"+item.as_users.userName+"</th>\n" +
                                " <th>"+item.accountMoney+"</th>\n" +

                                " <th>"+ tht +"</th>\n" +
                            " </tr>"
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
