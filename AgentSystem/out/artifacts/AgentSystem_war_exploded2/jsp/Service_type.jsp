<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019/10/12
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/HomePages.jsp"%>
<html>
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>服务类型</title>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui/layui.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://heerey525.github.io/layui-v2.4.3/layui/css/layui.css">
</head>
<body>
<div class="layui-body">
<table class="layui-table">
    <colgroup>
        <col width="200">
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
    <dvi>系统配置管理/服务类型</dvi>
    <br/>
    <br/>
    <br/>
    <button type="button" class="layui-btn" onclick="test()">添加服务类型</button>
    <br/><span style="color: #eb270f">${dlet}</span>
    <thead>
    <tr>
        <th>序号</th>
        <th>配置类型</th>
        <th>配置数值</th>
        <th>是否启用</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="biuuu_city_list">
    </tbody>
</table>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend></legend>
</fieldset>
<div id="demo3"></div>
<%--<button type="button" class="layui-btn" onclick="test()">添加账务类型</button>--%>
</div>
<%--
<script src="${pageContext.request.contextPath }/statics/js/FinanciaLtype.js"></script>--%>
<script>
    /*
  * 添加
  */
    function test(){
        layer.confirm('<div style="padding: 50px 30px;">'+'<b>您正在进行添加操作</b><hr><br>' + '<form action="${pageContext.request.contextPath}/Tyep_service/typeinserty" method="post" id="Sub">类型名称:<input type="text" name="type" id="name">' +
            '<br/><br/> 类型数值<input type="text" name="numerical_value" id="name">'+
            '<br><br>是否启用:<select  name="enabled" id="index"><option  value="1">启用' +
            '</option><option   value="2">不启用</option></select><br> <br><' +
            'input type="hidden" id="sa" name="id"></form>'+'</div>',{
            btn: ['保存', '取消']
            ,yes: function(index, layero){
                $("#Sub").submit();
            }
        }, function(index, layero){
        });
    }

    var finay;//所有客户数据
    $(function () {
        $.ajax({
            url : '${pageContext.request.contextPath}/Tyep_service/service_type',
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
                            var tht=item.isStart==1?'启用':'禁用'
                            var htmls=" <button onclick=\"updat('"+item.configTypeName+"',"+item.isStart+","+item.id+",'"+item.configValue+"')\" class=\"layui-btn\">修改</button>\n"
                            var ht="<tr>\n" +
                                "<th>"+item.id+"</th>\n" +
                                " <th>"+item.configTypeName+"</th>\n" +
                                    "<th>"+item.configValue+"\n"+
                                " <th>"+ tht +"</th>\n" +
                                "<th>"+htmls+"</th>"
                            " </tr>"
                            arr.push(ht);
                        });
                        return arr.join('');
                    }();
                }
            });
        })
    }
    /**
     *修改操作
     *  * @param names
     * @param ids
     * @param finid
     */
    function updat(names,ids,finid,configValue){
        layer.confirm('<div style="padding: 50px 30px;">'+'<b>您正在进行添加操作</b><hr><br>' + '<form action="${pageContext.request.contextPath}/Tyep_service/updat_Finas" method="post" id="Sub">类型名称:<input type="text" name="type" id="name" value='+names+'>' +  '<br/><br/> 类型数值<input type="text" name="numerical_value" id="name" value='+configValue+'>'+
            '<br><br>是否启用:<select  name="enabled" id="index"><option  value="1">启用'+'</option><option  id="index" value="2">禁用</option></select><br> <br><'+'input type="hidden" id="sa" name="finid" value='+finid+'></form>'+'</div>',{
            btn: ['修改', '取消']
            ,yes: function(index, layero){
                $("#Sub").submit();
            }
        }, function(index, layero){

        });
        if(ids==1){
            var a= $("#index").val();
            $("#index").attr("selected",true);

        }else if(ids==2){
            document.getElementById("index")[1].selected=true;
        }
    }
</script>
</body>
</html>
