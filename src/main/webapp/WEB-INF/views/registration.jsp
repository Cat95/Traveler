<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset = "utf-8">
  <title>Регистрация</title>
</head>
<body>
  <h1>Поздравляю, ${user.login}, вы зарегестрированы! <br>
      Ваш пароль: ${user.password} <br>
  </h1>
  <a href="WEB-INF/views/index.jsp">Вернуться на главную</a>
</body>
</html>
