<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/10
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<div class="layui-body">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">关键词:</label>
            <div class="layui-input-block">
                <ul>
                    <li style="float: left"><input type="text" name="keywords" id="keywords" required  lay-verify="required" placeholder="支持模糊查询" autocomplete="off" class="layui-input" style="width: 100%"></li>
                    <li style="float: left"><button class="layui-btn" type="button" id="checkInfo" data-type="reload">查询</button></li>
                    <li style="line-height: 50px;"><label><span style="color: green;">已申请（代理商申请） --> 审核中 --> 通过 --> 开通 APP/续费</span>|<span style="color: red;">已申请（代理商申请） --> 审核中 -->不通过</span></label></li>
                </ul>
            </div>
        </div>
    </form>
    <table class="layui-hide" id="demo" lay-filter="test"></table>
</div>

<%--<script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>--%>
<script src="${pageContext.request.contextPath }/statics/js/AntistopAudit.js"></script>
<%@include file="/jsp/foot.jsp" %>
