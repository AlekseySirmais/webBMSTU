<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>authornews</title>
    <script type="text/javascript" src="/search.js"></script>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>

<h1 align="center">Новости
<%= request.getParameter("author")%>
</h1>

<form action="GoHome" method="POST" role="form" align="center">

    <button type="submit"> Home </button>
</form>


<table  border="1" cellspacing="0" align="center" >
    <tr>
        <td  width="165" height="50">Автор</td>
        <td width="165" height="50">Название</td>
        <td width="909" height="50">Текст новости</td>
    </tr>
</table>


<table border="1" cellspacing="0" align="center" width="1240">
    <colgroup>
        <col width="150">
        <col width="150">
        <col width="400">


    </colgroup>
    <tbody id="searchtable">

    </tbody>
</table>









<h2 align="center" > <a href="table.html">Вернуться к общему списку новостей</a>  </h2>
</body>
</html>