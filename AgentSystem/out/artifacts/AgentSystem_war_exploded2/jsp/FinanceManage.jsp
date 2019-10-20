<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/9
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<div class="layui-body">
        <form class="layui-form" action="../../Finance/get/add">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">搜索用户</label>
                    <div class="layui-input-inline ipnut_user">
                        <input type="hidden" value="${sessionScope.show}" id="showhint">
                        <select name="userId" lay-verify="required" lay-search="" class="selectedasy">
                            <option value="">直接选择或搜索选择</option>
                            <c:forEach items="${as_users}" var="as_users">
                                <option value="${as_users.id}">${as_users.userCode}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="layui-form-item form_finance">
                <label class="layui-form-label">操作类型</label>
                <div class="layui-input-block">
                    <select name="detailType" lay-verify="required" id="operation">
                        <option value=""></option>
                        <c:forEach items="${as_systemconfigs}" var="as_systemconfigs">
                            <option value="${as_systemconfigs.id}">${as_systemconfigs.configTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>


            <div class="layui-form-item form_finance">
                <label class="layui-form-label">操作资金</label>
                <div class="layui-input-block">
                    <input type="text" name="accountMoney" id="accountMoney" autocomplete="off" placeholder="输入资金数" class="layui-input" lay-verify="required">
                    <label></label>
                </div>
            </div>
            <label>重要提示:输入的资金数，<span style="color: red;">正数(1000)</span>为向账户添加1000圆，<span style="color: red;">负数(-1000)</span>为向账户减少1000圆，精确到小数点两位数</label>
            <label class="layui-form-label">操作备注:</label>
            <div class="layui-form-item layui-form-text form_finance_text">
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" class="layui-textarea" id="memo" name="memo" lay-verify="required"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
                    <button onclick="window.close()" class="layui-btn" lay-submit="" lay-filter="demo1">取消</button>
                </div>
            </div>
        </form>
    </div>
<%--<script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>--%>
<%@include file="/jsp/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/FinanceManage.js"></script>
