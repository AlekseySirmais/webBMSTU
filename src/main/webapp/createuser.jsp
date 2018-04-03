
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Createuser</title>


    <link href="common.css" rel="stylesheet">
</head>
<body>

<h1 align="center">Создание аккаунта</h1>
<form action="createuser" method="POST" role="form" align="center">
    <input type="text" name="user" placeholder="Имя пользователя">
    <input type="password" name="password" placeholder="Пароль">
    <button type="submit"> Создать </button>
</form>


</body>
</html>
