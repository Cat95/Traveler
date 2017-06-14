<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.06.2017
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Авторизация</title>
</head>
<body style="background-color: #25547B">
    <h1 style="color: #FFCF00">Вы вошли как ${user.login}, ID = ${user.id}</h1>
    <a style="font-size: 14pt" href="http://localhost:8080/">Вернуться на главную</a>
</body>
</html>
