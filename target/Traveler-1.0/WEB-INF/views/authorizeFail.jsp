<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.06.2017
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset = "utf-8">
  <title>Неудачная авторизация</title>
</head>
<body>
<h1>Логин <${user.login}> или пароль <${user.password}> неверный</h1>
<a href="WEB-INF/views/index.jsp">Вернуться на главную</a>
</body>
</html>

