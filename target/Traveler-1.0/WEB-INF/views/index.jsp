<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.04.2017
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <link rel = "stylesheet" href = "WEB-INF/styles/style.css">
    <script type="text/javascript" src="WEB-INF/scripts/jquery-3.2.0.js"></script>
    <script type="text/javascript" src="WEB-INF/scripts/script.js"></script>
    <title>Traveler - главная</title>
</head>
<body>
<div id = "navigator">
    <ul>
        <li>
            <a id = "main_link" href = "WEB-INF/views/index.jsp"><img src = "WEB-INF/images/main_ico.png"></a>
        </li>
        <li><a class = "menu_link" href = "">Библиотека</a></li>
        <li><a class = "menu_link" href = "">Поиск</a></li>
        <li id = "account_btn"><a class = "menu_link" href = "#sign_in_block">Вход</a></li>
    </ul>
</div>
<a href = "" class = "overlay" id = "sign_in_block"></a>
<div class = "sign_in_popup">
    <form action = "" method = "get">
        <input type = "text" placeholder = "Логин" class = "sign_in_input"><br>
        <input type = "text" placeholder = "Пароль" class = "sign_in_input"><br>
        <button id = "sign_in_btn" type = "submit">
            Вход
        </button>
        <button id = "sign_up_btn" type = "submit">
            <a class = "sign_up_link" href = "#sign_up_block">Регистрация</a>
        </button>
    </form>
</div>
<a href = "" class = "overlay" id = "sign_up_block"></a>
<div class = "sign_up_popup">
    <form action = "" method="post">
        <input id="login" type = "text" placeholder = "Логин" class = "sign_in_input" name="login"><br>
        <input id="password" type = "text" placeholder = "Пароль" class = "sign_in_input" name="password"><br>
        <input id="re_password" type = "text" placeholder = "Повторите пароль" class = "sign_in_input" name="rePassword"><br>
        <input id = "sign_up_confirm" type = "submit" formmethod="post" value="Зарегестрироваться">
        <!--     <a class = "sign_up_link" href = "#sign_in_block">Зарегестрироваться</a>-->
    </form>
</div>
<div class = "main_content">
    <ul>
        <li><a class = "links_bar" href = "#">Рекомендуемые</a></li>
        <li><a class = "links_bar" href = "#">Лучшее</a></li>
        <li><a class = "links_bar" href = "#">Новинки</a></li>
        <li><a class = "links_bar" href = "#">Подборки</a></li>
    </ul>
    <h2 id = "hat">
        Давно мечтаешь отдохнуть но никак не можешь понять где провести отпуск?
    </h2>
    <div id = "question">
        ?
    </div>
    <div id = "shoe">
        <b style = "color: #DDD8E4; font-size: 20pt;">Traveler</b> — это персональные рекомендации, основанные на ваших собственных оценках.
        Здесь вы сможете подобрать месте отдыха оптимально подходящие под ваши вкусовые пристрастия. Испытайте рекомендательную магию наших роботов!
    </div>
</div>
</body>
</html>
