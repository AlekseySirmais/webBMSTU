<%@ page import="main.java.Validate" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 26.03.2018
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="common.css" rel="stylesheet">
    <title>Dicrionary</title>
</head>
<body>
<h2 align="center" >Введите ваше слово! </h2>


<form action="/dicrionary" method="POST" role="form" align="center">
    <input type="text" name="word" placeholder="write your word here">

    <button type="submit"> Перевод </button>
</form>

<h2 > Русское слово(не чекать):  <%= Validate.getRuTranslation(Integer.parseInt(request.getParameter("id")))%></h2>

  <h2>  Английское слово:  <%=  Validate.getEngTranslation(Integer.parseInt(request.getParameter("id")))%>  </h2>





<h2 align="center"> Добавить слово</h2>
<form action="/addword" method="POST" role="form" align="center">
    <input type="text" name="word_end" placeholder="English">
    <input type="text" name="word_rus" placeholder="Русское">
    <button type="submit"> Добавить </button>
</form>








</body>
</html>
