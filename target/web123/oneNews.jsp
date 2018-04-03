<%@ page import="main.java.Validate" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/comentsJS.js"></script>
    <title>oneNews</title>

    <link href="common.css" rel="stylesheet">
</head>
<body>


<h1 align="center">Id news: <%= request.getParameter("id")%> </h1>
<h1 align="center"> Title: <%= request.getParameter("title")%>  </h1>
<h1 align="center" >Author: <%= request.getParameter("author")%>  </h1>
<h2 align="center"> Text: <%= Validate.getNews((request.getParameter("id")))%>  </h2>


<table border="1" cellspacing="0" align="center">
    <colgroup>
        <col width="400">
        <col width="150">


    </colgroup>
    <tbody id="commentstable">

    </tbody>
</table>
<form action="addcomment" method="POST" role="form" align="center">
    <input size="300" type="text" name="textcom" placeholder="Комент">
 <input type="hidden" name="idnews" value=<%= request.getParameter("id")%>  >
    <button type="submit"> Добавить </button>
</form>

<h2 align="center" > <a href="table.html">Вернуться к списку новостей</a>  </h2>
</body>
</html>
