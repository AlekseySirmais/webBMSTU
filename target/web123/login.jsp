
<%@ page import="main.java.ServletLogin" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>


    <link href="common.css" rel="stylesheet">
</head>
<body>
 <h4 align="center">  Добро пожаловать </h4>
 <h4 align="center">  Введите имя и пароль</h4>
<form action="/login" method="POST" role="form" align="center">
    <input type="text" name="user" placeholder="Имя пользователя">
    <input type="password" name="password" placeholder="Пароль">
    <button type="submit"> Вход </button>
</form>
 <h4 align="center">  Нет аккаунта? Создайте!</h4>


 <h4  align="center" > <a  href="createuser.jsp" >Создать аккаунт</a>  </h4>
</body>
</html>
