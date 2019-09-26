<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 9/18
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user">
    <input type="hidden" name="type" value="login"/>

    <input type="text" name="username" value="${username}"/>
    <input type="text" name="password"/>
    <input type="submit" value="登录"/>


</form>
</body>
</html>
