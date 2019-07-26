<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/25
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/user/login" method="post">
    用户名:<input type="text" name="name"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="提交">

    <span>${msg}</span>
</form>
</body>
</html>
