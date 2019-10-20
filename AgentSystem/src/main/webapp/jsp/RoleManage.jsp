<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/10
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<div id="show_role_add" style="display:none;">
    <br>
    <br>
    <form class="layui-form" action="../rolemanage/add" >
        <div class="layui-form-item form_finance">
            <label class="layui-form-label">角色名称:</label>
            <div class="layui-input-block">

                <input type="hidden" value="${sessionScope.user}" id="createdBy" name="createdBy">
                <input type="text" name="roleName" id="roleName" lay-verify="required" autocomplete="off" placeholder="" class="layui-input" style="width: 200px">
                <label></label>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">是否启用:</label>
                <div class="layui-input-inline ipnut_user">
                    <select name="isStart" lay-verify="required" lay-search="" class="selectedasy">
                        <option value="1">启用</option>
                        <option value="2">不启用</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
            </div>
        </div>
    </form>
</div>

<%--<div id="show_role_upd" style="display:none;">
    <br>
    <br>
    <form class="layui-form" action="../rolemanage/upd" >
        <div class="layui-form-item form_finance">
            <label class="layui-form-label">角色名称:</label>
            <div class="layui-input-block">
                <input type="hidden" value="" id="id" name="id">
                <input type="text" name="roleName" id="roleName01" lay-verify="roleName" autocomplete="off" placeholder="" class="layui-input" style="width: 200px">
                <label></label>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">是否启用:</label>
                <div class="layui-input-inline ipnut_user">
                    <select name="isStart" lay-verify="required" lay-search="" class="selectedasy">
                        <option value="1">启用</option>
                        <option value="2">不启用</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
            </div>
        </div>
    </form>
</div>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<div class="layui-body">
    <table class="layui-hide" id="demo" lay-filter="test"></table>

    <%--<script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>--%>
</div>
<input type="hidden" value="${sessionScope.show01}" id="showhint">
<%--<script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>--%>
<script type="text/html" id="isStart">
    {{#  if(d.isStart==1){ }}
        <div>启用</div>
    {{#  }else{ }}
    <div>不启用</div>
    {{# } }}
</script>
<script src="${pageContext.request.contextPath }/statics/js/RoleManage.js"></script>
<%@include file="/jsp/foot.jsp" %>
