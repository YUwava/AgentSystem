<%--
  Created by IntelliJ IDEA.
  User: 是梦终会醒
  Date: 2019/10/13
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<html>
<head>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="layui-body">
    <div style="background-color: #A0DAF4;">
        <div class="layui-row" style="padding: 15px 0;">
            <div>系统管理\关键词审核</div>
        </div>
        <div class="layui-row" style="background-color: #ffffff;">
                <div class="layui-row">
                    <div class="layui-input-inline">
                        <input type="text" name="keywords" id="keywords" required lay-verify="required" placeholder="请输入关键词" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                        <button type="button" id="select_keywords" class="layui-btn"><i class="layui-icon">&#xe615;</i>&nbsp;&nbsp;&nbsp;查&nbsp;询</button>
                    </div>
                    <div class="layui-input-inline">
                    </div>
                </div>
                <div class="layui-row">
                    <table id="demo" lay-filter="test"></table>
                </div>
        </div>
    </div>
    <div>&nbsp;</div>
</div>

<script>
    layui.use(['table'], function() {
        var table = layui.table,
            $ = layui.jquery;

        //第一个实例
        var tableIns = table.render({
            elem: '#demo',
            height: 312,
            url: '../key/selectKeywords',
            //分页
            page: true,
            limit: 4,
            limits: [4, 8, 10],
            cols: [
                [
                    {
                    field: 'id',
                    title: 'ID',
                    hide: 'true'
                }, {
                    field: 'keywords',
                    title: '关键词',
                    align: 'center',
                    unresize: true
                }, {
                    field: 'customName',
                    title: '客户名称',
                    align: 'center',
                    unresize: true
                }, {
                    field: 'agentName',
                    title: '代理商',
                    align: 'center',
                    unresize: true
                }, {
                    field: 'serviceYears',
                    title: '申请年限',
                    align: 'center',
                    unresize: true
                }, {
                    field: 'regDatetime',
                    title: '申请日期',
                    align: 'center',
                    unresize: true
                }, {
                    field: 'regPassDatetime',
                    title: '到期日期',
                    align: 'center',
                    unresize: true
                }, {
                    field: 'isPass',
                    title: '申请到期状态',
                    align: 'center',
                    templet: function (d) {
                        if (d.isPass == "0") {
                            return "不过期";
                        } else if (d.isPass == "1") {
                            return "预注册过期";
                        } else {
                            return "正式注册过期";
                        }
                    },
                    unresize: true
                }, {
                    field: 'checkStatus',
                    title: '审核状态',
                    align: 'center',
                    templet: function (d) {
                        if (d.checkStatus == "0") {
                            return "已申请";
                        } else if (d.checkStatus == "1") {
                            return "审核中";
                        } else if (d.checkStatus == "2") {
                            return "已通过";
                        } else {
                            return "未通过";
                        }
                    },
                    unresize: true
                }, {
                    field: 'isUse',
                    title: '使用状态',
                    align: 'center',
                    templet: function (d) {
                        if (d.isUse == "0") {
                            return "已使用";
                        } else {
                            return "未使用";
                        }
                    },
                    unresize: true
                }, {
                    field: 'sign',
                    title: '操作',
                    width: '16%',
                    toolbar: '#barDemo',
                    align: 'center',
                    unresize: true
                }
                ]
            ]
        });

        //查询关键词
        $('#select_keywords').click(function () {
            var keywords = $("#keywords").val();
            tableIns.reload({
                where: {
                    keywords: keywords
                }, page: {
                    cull: 1
                }
            })
        });
    });
</script>
</body>
</html>
<%@include file="/jsp/foot.jsp" %>
