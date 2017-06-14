<%@ page import="com.spring.model.Place" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spring.model.User" %>
<%@ page import="com.spring.model.Score" %>
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

<%
    User user = (User) request.getAttribute("currentUser");
%>
<% for (Place place : (ArrayList<Place>) request.getAttribute("list")) {%>
<div class = "listItem">
    <h2 style="color: #13C3FB"><%= place.getName() %></h2> <br>
    <h4 style="color: #FFCF00">Страна</h4> <h4> <%= place.getCountry() %></h4> <br>
    <h4 style="color: #FFCF00">Тип отдыха</h4> <h4> <%= place.getRestType() %></h4> <br>
    <h4 style="color: #FFCF00">Стоимость</h4> <h4> <%= place.getCost() %></h4> <br>
    <h4 style="color: #FFCF00">Рейтинг</h4> <h4> <%= place.getRate() %></h4> <br>
    <img src="<%= place.getImage() %>"> <br>
    <p><%= place.getDescription() %></p> <br><br>
    <spring:form method="post" modelAttribute="score" action="rated">
        <spring:select path="rate" id="rate-select" size="1">
            <spring:option value="1" class="selectOption">1</spring:option>
            <spring:option value="2" class="selectOption">2</spring:option>
            <spring:option value="3" class="selectOption">3</spring:option>
            <spring:option value="4" class="selectOption">4</spring:option>
            <spring:option value="5" class="selectOption">5</spring:option>
            <spring:option value="6" class="selectOption">6</spring:option>
            <spring:option value="7" class="selectOption">7</spring:option>
            <spring:option value="8" class="selectOption">8</spring:option>
            <spring:option value="9" class="selectOption">9</spring:option>
            <spring:option value="10" class="selectOption">10</spring:option>
        </spring:select>
        <spring:input path="place" type="hidden" value="<%= place.getId() %>"/>
        <spring:input path="user" type="hidden" value="<%= user.getId() %>"/>

        <spring:button id="rate-btn">Оценить</spring:button>
    </spring:form>
</div>
<% } %>

</body>
</html>
