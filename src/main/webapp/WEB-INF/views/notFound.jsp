<%@ page import="com.spring.model.Place" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset = "utf-8">
  <link rel = "stylesheet" href = "resources/styles/style.css">
  <script type="text/javascript" src="resources/scripts/jquery-3.2.0.js"></script>
  <script type="text/javascript" src="resources/scripts/script.js"></script>
  <title>Traveler - список</title>
</head>
<body>
<div id = "navigator">
  <ul>
    <li>
      <a id = "main_link" href = "http://localhost:8080/"><img src = "resources/images/main_ico.png"></a>
    </li>
    <li><a class = "menu_link" href = "http://localhost:8080/list">Список</a></li>
    <li><a class = "menu_link" href = "http://localhost:8080/search">Поиск</a></li>
    <li id = "account_btn"><a class = "menu_link" href = "#sign_in_block">Вход</a></li>
  </ul>
</div>
<a href = "" class = "overlay" id = "sign_in_block"></a>
<div class = "sign_in_popup">
  <spring:form method="get" modelAttribute="user" action="reg">
    <spring:input path="login" class="sign_in_input" placeholder="Логин"/><br>
    <spring:input path="password" class="sign_in_input" placeholder="Пароль"/><br>
    <spring:button id="sign_in_btn">Вход</spring:button>
    <spring:button id="sign_up_btn">
      <a class="sign_up_link" href="#sign_up_block">Регистрация</a>
    </spring:button>
  </spring:form>
</div>
<a href = "" class = "overlay" id = "sign_up_block"></a>
<div class = "sign_up_popup">
  <spring:form method="post" modelAttribute="user" action="reg">
    <spring:input path="login" id="login" class="sign_in_input" name="login" placeholder="Логин"/><br>
    <spring:input path="password" id="password" class="sign_in_input" name="password" placeholder="Пароль"/><br>
    <spring:button id="sign_up_confirm">Зарегестрироваться</spring:button>
  </spring:form>
</div>

<div id="search-block">
  <spring:form method="get" modelAttribute="options" action="found">
    <spring:select path="searchOption" id="search-select" size="1">
      <spring:option value="name" class="selectOption">Название</spring:option>
      <spring:option value="country" class="selectOption">Страна</spring:option>
      <spring:option value="restType" class="selectOption">Тип отдыха</spring:option>
      <spring:option value="cost" class="selectOption">Стоимость</spring:option>
      <spring:option value="rate" class="selectOption">Рейтинг</spring:option>
    </spring:select>
    <spring:input path="searchValue" id="search-input" class="sign_in_input" placeholder="Поиск"/>
    <spring:button id="search-btn">Поиск</spring:button>
  </spring:form>
</div>
<br><br><br><br>
<h1 style="color: #EBEBEB">К сожалению поиск не дал результатов</h1>

</body>
</html>

