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
        <li><a class = "menu_link" href = "">Поиск</a></li>
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

<% for (Place place : (ArrayList<Place>) request.getAttribute("list")) {%>
    <div class="list">
        <div>
            <h2><%= place.getName() %></h2><br>
            <h4>Страна - <%= place.getCountry() %></h4><br>
            <h4>Тип отдыха - <%= place.getRestType() %></h4><br>
            <h4>Стоимость - <%= place.getCost() %></h4><br>
            <h4>Рейтинг - <%= place.getRate() %></h4><br>
            <img src = "<%= place.getImage() %>"><br>
            <%= place.getDescription() %><br><br>
            <img src="../../resources/images/GoldSands.JPG"/>
        </div>
    </div>
<% } %>

</body>
</html>
