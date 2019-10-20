<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/10
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<div class="layui-body" style="margin-top: -20px;">
    <ul class="layui-nav">
        <c:forEach items="${rolelist}" var="rolelist">
            <li class="layui-nav-item"><a href="#" id="a_show" onclick="onEdit('${rolelist.id}')">${rolelist.roleName}</a></li>
        </c:forEach>
    </ul>
    <table class="layui-hide" id="jurisdiction" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="upding">启用</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="updings">不启用</a>
    </script>
</div>
<script src="${pageContext.request.contextPath }/statics/js/RoleJurisdiction.js"></script>
<%@include file="/jsp/foot.jsp" %>