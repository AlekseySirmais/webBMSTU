
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <link href="common.css" rel="stylesheet">

    <title>addnews</title>
</head>
<body>



<h1 align="center" >Напишите название и текст новости</h1>



<form action="addnews" method="POST" role="form" align="center">
    <input type="text" name="title" placeholder="Название">
    <input size="100" type="text" name="text" placeholder="Текст новости">
    <button type="submit"> Добавить </button>
</form>
<h2 align="center" > <a href="table.html">Назад к новостям</a>  </h2>
</body>
</html>
