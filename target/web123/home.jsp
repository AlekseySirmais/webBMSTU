
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>

    <link href="common.css" rel="stylesheet">
</head>
<body>
<h1 align="center" >Ваше имя: <%= request.getParameter("name")%> </h1>
<h1 align="center">
 Это ваш ID:   <%= request.getParameter("id")%>
</h1>
<h1 align="center">
    Это ваша почта:   <%= request.getParameter("user_email")%>
</h1>

<h3 align="center" > <a href="addemail.jsp">Добавить почту(если уже добавили, то можете обновить)</a>  </h3>
<h2 align="center" > <a href="table.html">Новости</a>  </h2>

<h2 align="center" > <a href="dicrionary.jsp?id=3">Словарь</a>  </h2>
<form action="exit" method="POST" role="form" align="center">

    <button type="submit"> Выход </button>
</form>
</body>
</html>
