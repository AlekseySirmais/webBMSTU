
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successeful_login!!</title>


    <link href="common.css" rel="stylesheet">
</head>
<body>
<h1 align="center">Удачно</h1>
<h1 align="center">You (<%= request.getParameter("name")%>) have entered on the site!</h1>
<h1 align="center"> ID in DB:<%= request.getParameter("id")%>  </h1>

<h4  align="center" > <a  href="home.jsp" >Моя страница</a>  </h4>
</body>
</html>
