<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019/10/13
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>

<html>
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>App地址</title>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://heerey525.github.io/layui-v2.4.3/layui/css/layui.css">
    <style type="text/css">
        .years{
            margin-top: 50px;
            border:1px ;
            text-align:center;
        }
    </style>
</head>
<body>
<div class="layui-body">
    <table class="layui-table">
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
        <dvi><span>系统配置管理/app地址<hr/></span></dvi>
        <br/>
        <br/>
        <br/>
        <thead>
        <div class="years">
            <h3><strong>APP URL 管理- 填写制作APP的系统的URL地址</strong></h3><br/><br/>
            <div>
                <form action="${pageContext.request.contextPath}/App/appinset">
                    <c:forEach items="${appl}" var="appl">
                   配置名称 <input type="text" value="${appl.configTypeName}" name="TyepSever" readonly="true" style="background: rgba(15,97,131,0.72); color: #fff;"><br/>
                    <br/>
                        <input type="hidden" value="${appl.id}" name="id" readonly="true" style="background: rgba(15,97,131,0.72); color: #fff;"><br/>
                    <br/>
                    配置数值 <input type="text" value="${appl.configValue}" name="year"><br/>
                    <span style="color: #1cdaf7" >${dlet}</span>
                    <br/>
                    <input type="submit" value="保存" style="background: #226ed4; color: #fff;">
                    </c:forEach>
                </form>
                <br/>
                <br/>

            </div>
        </div>
        </thead>
        <tbody id="biuuu_city_list">
        </tbody>
    </table>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend></legend>
    </fieldset>
    <div id="demo3"></div>
</div>
</body>
</html>
