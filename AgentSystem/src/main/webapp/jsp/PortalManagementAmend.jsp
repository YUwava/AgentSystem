<%--
  Created by IntelliJ IDEA.
  User: 是梦终会醒
  Date: 2019/10/19
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/HomePages.jsp"%>
<html>
<head>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="layui-body">
    <div class="layui-container" style="padding: 20px; background-color: #F2F2F2;">
        <form method="post" action="${pageContext.request.contextPath}/controller/keyword/upKeywordsInfoById.html">
            <input type="hidden" name="id" value="${keywords.id}">${keywords.id}
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">注册的移动云端信息</div>
                        <div class="layui-card-body">
                            <table width="100%" style="margin-left: 10px;">
                                <tr>
                                    <td>登录账号:<input name="appUserName" value="${keywords.appUserName}" required></td>
                                    <td>登录密码:<input name="appPassword" value="${keywords.appPassword}" required></td>
                                </tr>
                                <tr>
                                    <td>关键词:<label>${keywords.keywords}</label></td>
                                    <td>登录地址:<label>${keywords.loginUrl}</label></td>
                                </tr>
                                <tr>
                                    <td>客户端下载地址(IOS):<input name="iosDownloadUrl" value="${keywords.iosDownloadUrl}" required></td>
                                    <td>二维码下载地址(IOS):<input name="codeIosUrl" value="${keywords.codeIosUrl}" required></td>
                                </tr>
                                <tr>
                                    <td>客户端下载地址(Android):<input name="androidDownloadUrl" value="${keywords.androidDownloadUrl}" required></td>
                                    <td>二维码下载地址(Android):<input name="codeAndroidUrl" value="${keywords.codeAndroidUrl}" required></td>
                                </tr>
                                <tr>
                                    <td>关键词开始日期:<label>${keywords.regDatetime}</label></td>
                                    <td>关键词结束日期:<label>${keywords.regPassDatetime}</label></td>
                                </tr>
                                <tr>
                                    <td>关键词有效年期:<label>${keywords.serviceYears}</label></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">基本信息</div>
                        <div class="layui-card-body">
                            <table width="100%" style="margin-left: 10px;">
                                <tr>
                                    <td>企业名称:<label>${custom.customName}</label></td>
                                    <td>状态:
                                        <c:if test="${custom.customStatus == 1}">
                                            <label color="green">启用</label>
                                        </c:if>
                                        <c:if test="${custom.customStatus == 0}">
                                            <label color="red">停用</label>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td>企业类型:<label>${custom.customTypeName}</label></td>
                                    <td>企业主页:<label>${custom.siteUrl}</label></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">门户信息</div>
                        <div class="layui-card-body">
                            <table width="100%" style="margin-left: 10px;">
                                <tr>
                                    <td>法人代表:<label>${custom.bossName}</label></td>
                                    <td>注册日期:<label>${custom.regDatetime}</label></td>
                                </tr>
                                <tr>
                                    <td>证件类型:<label>${custom.cardTypeName}</label></td>
                                    <td>证件号码:<label>${custom.cardNum}</label></td>
                                </tr>
                                <tr>
                                    <td>国家:<label>${custom.country}</label></td>
                                    <td>省/地区:<label><c:out value="${province}"/></label></td>
                                </tr>
                                <tr>
                                    <td>区:<label><c:out value="${area}"/></label></td>
                                    <td>城市:<label><c:out value="${city}"/></label></td>
                                </tr>
                                <tr>
                                    <td>公司电话:<label>${custom.companyTel}</label></td>
                                    <td>公司传真:<label>${custom.companyFax}</label></td>
                                </tr>
                                <tr>
                                    <td>公司地址:<label>${custom.companyAddress}</label></td>
                                    <td>备注:<label></label>${custom.memo}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">联系人信息</div>
                        <div class="layui-card-body">
                            <ul>
                                <c:if test="${contactList != null}">
                                    <c:forEach var="contactList" items="${contactList}">
                                        <li>
                                            <div>姓名：<c:out value="${contactList.contactName}"/></div>
                                            <div>电话：<c:out value="${contactList.contactTel}"/></div>
                                            <div>传真：<c:out value="${contactList.contactFax}"/></div>
                                            <div>邮箱：<c:out value="${contactList.contactEmail}"/></div>
                                            <div>职务：<c:out value="${contactList.contactRole}"/></div>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${contactList == null}">
                                    <li>没有任何联系人</li>
                                </c:if>
                            </ul>
                        </div>
                        <div style="width: 100%; text-align: center;">
                            <input type="submit" value="保存" class="layui-btn layui-btn-sm"/>
                            <a href="${pageContext.request.contextPath}/jsp/PortalManagement.jsp"
                               class="layui-btn layui-btn-sm">返回</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<%@include file="/jsp/foot.jsp" %>