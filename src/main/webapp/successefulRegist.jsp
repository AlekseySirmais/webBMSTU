
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successeful_login!!</title>


    <link href="common.css" rel="stylesheet">
</head>
<body>
<h1 align="center">Ура</h1>
<h1 align="center">Вы (<%= request.getParameter("name")%>) зарегистрировались!</h1>
<h2  align="center"><a href="login.jsp">Войти на сайт</a> </h2>
</body>
</html>
