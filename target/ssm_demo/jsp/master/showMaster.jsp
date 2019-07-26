<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/19
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <%--引入css,否则没样式--%>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <%--引入后台页面头--%>
    <jsp:include page="/jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 100px;">

            <form action="" method="post">
                <table class="layui-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>电话</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${masters}" var="obj">
                        <tr>
                            <td>${obj.id}</td>
                            <td>${obj.name}</td>
                            <td>${obj.tel}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
    <jsp:include page="/jsp/common/tail.jsp"/>
</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
