<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/10
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<div class="layui-body">
    <form class="layui-form" method="post" action="../adduser/add">
        <div class="layui-form-item form_finance_texts form_finances">
            <div class="layui-input-block">
                <ul>
                    <li style="float: left;"><label class="layui-form-label">用户名称:</label></li>
                    <li style="float: left;"><input type="text" name="userName" id="userNames" required  lay-verify="required" placeholder="支持模糊查询" autocomplete="off" class="layui-input"></li>
                    <li style="float: left;"><label class="layui-form-label">角色:</label></li>
                    <li style="float: left;" >
                        <span id="roleIdsing">
                        <select id="roleIds" >
                        <option value="">-请选择-</option>
                            <c:forEach items="${as_users}" var="as_users">
                                <option value="${as_users.id}">${as_users.roleName}</option>
                            </c:forEach>
                    </select></span></li>

                    <li style="float: left;"><label class="layui-form-label">是否启用:</label></li>
                    <li style="float: left;">
                        <select id="isStarts" lay-verify="required">
                            <option value="1">启用</option>
                            <option value="2">不启用</option>
                        </select>
                    </li>
                    <li style="float: left;">
                        <button class="layui-btn" type="button" id="checkInfo" data-type="reload">查询</button>
<%--                        <button class="layui-btn" lay-submit="" lay-filter="demo1"></button></li>--%>
                </ul>
            </div>
        </div>
    </form>
        <table class="layui-hide" id="demo" lay-filter="test"></table>
        <%--<script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>--%>
    </div>
<div id="ipnut_userss" style="display:none;">
    <div class="layui-form-item ipnut_users">
        <div class="layui-inline">
            <label class="layui-form-label">角色:</label>
            <div class="layui-input-inline ipnut_user">
                <select name="roleId" id="roleIding" lay-verify="required" lay-search="" class="selectedasy">
                    <option value="">-请选择-</option>
                    <c:forEach items="${as_users}" var="as_users">
                        <option value="${as_users.id}">${as_users.roleName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
</div>
<div id="show_user_add" style="display:none;">
    <br>
    <br>
    <form class="layui-form" action="../adduser/add" >
        <div class="layui-form-item form_finance">
            <label class="layui-form-label">登录账号:</label>
            <div class="layui-input-block">
                <input type="hidden" value="${sessionScope.user}" name="createdBy" id="createdBys">
                <input type="text" name="userCode" id="userCodes" value='' lay-verify="required" autocomplete="off" placeholder="" class="layui-input" style="width: 200px">
                <label></label>
            </div>
        </div>
        <div class="layui-form-item form_finance">
            <label class="layui-form-label">用户名称:</label>
            <div class="layui-input-block">
                <input type="text" name="userName" id="userNameing" value='' lay-verify="required"  autocomplete="off" placeholder="" class="layui-input" style="width: 200px">
                <label></label>
            </div>
        </div>
        <div class="layui-form-item form_finance">
            <label class="layui-form-label">登录密码:</label>
            <div class="layui-input-block">
                <input type="password" name="userPassword" value='' id="userPasswords" lay-verify="required" autocomplete="off" placeholder="" class="layui-input" style="width: 200px">
                <label></label>
            </div>
        </div>
        <div class="layui-form-item ipnut_users">
            <div class="layui-inline">
                <label class="layui-form-label">角色:</label>
                <div class="layui-input-inline ipnut_user">
                    <select name="roleId" id="roleId" lay-verify="required" lay-search="" class="selectedasy">
                        <option value="">-请选择-</option>
                        <c:forEach items="${as_users}" var="as_users">
                            <option value="${as_users.id}">${as_users.roleName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">是否启用:</label>
                <div class="layui-input-inline ipnut_user">
                    <select name="isStart" id="isStarting" lay-verify="required" lay-search="" class="selectedasy">
                        <option value="1">启用</option>
                        <option value="2">不启用</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
            </div>
        </div>
    </form>
</div>
    <script type="text/html" id="isStart">
        {{#  if(d.isStart==1){ }}
        <div>启用</div>
        {{#  }else{ }}
        <div>不启用</div>
        {{# } }}
    </script>
    <script src="${pageContext.request.contextPath }/statics/js/UserManage.js"></script>
    <%@include file="/jsp/foot.jsp" %>
