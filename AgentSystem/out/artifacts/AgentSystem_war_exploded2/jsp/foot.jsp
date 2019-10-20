<%--
  Created by IntelliJ IDEA.
  User: YU
  Date: 2019/10/9
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    var $ = layui.jquery
        ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

</script>
</body>
</html>
