<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/8
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/layui/css/layui.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" type="text/css">
    <script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-size: 20px">代理商管理系统</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">欢迎你!</li>
            <li class="layui-nav-item"><a href="javascript:;">${sessionScope.user}</a></li>
            <li class="layui-nav-item"><a id="Upd_Show_Viwe">修改密码</a></li>
            <li class="layui-nav-item"><a href="index.jsp"><input type="hidden" value="${sessionScope.userids}" id="userids" name="userids">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">代理商管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath }/jsp/KeywordAppli.jsp">关键词申请</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/CustomerManagement.jsp">代理商客户管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/AdvanceCharge.jsp">代理商预支付</a></dd>
                        <%--<dd><a href="${pageContext.request.contextPath }/jsp/Keywords.jsp">关键词申请管理</a></dd>--%>
                        <dd><a href="${pageContext.request.contextPath }/jsp/Logs.jsp">操作日志</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">门户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath }/jsp/PortalManagement.jsp">门户管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">报表管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath }/jsp/ReportFormAdministration.jsp">报表管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">系统管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath }/Finance/get/user">财务管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/RoleManage.jsp">角色管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/RoleJurisdiction/role/get">角色权限管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/UserRole/get">用户管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/AntistopAuditAll/get">关键词审核</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">系统配置管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath }/jsp/Finance.jsp">财务类型</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/Service_type.jsp">服务类型</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/Types_type.jsp">服务年限</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/App/appsele">APP地址</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/Customer_type.jsp">客户类型</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/Type_Document.jsp">证件类型</a></dd>
                        <dd><a href="${pageContext.request.contextPath }/jsp/Preferential_Type.jsp">优惠类型</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/HomePages.js"></script>
<%@include file="/jsp/foot.jsp" %>
