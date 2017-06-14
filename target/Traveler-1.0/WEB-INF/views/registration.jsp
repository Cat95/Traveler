<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset = "utf-8">
  <title>Регистрация</title>
</head>
<body style="background-color: #25547B">
  <h1 style="color: #FFCF00">Поздравляю, ${user.login}, вы зарегестрированы! <br>
      Ваш пароль: ${user.password} <br>
  </h1>
  <a style="font-size: 14pt" href="http://localhost:8080/">Вернуться на главную</a>
</body>
</html>
