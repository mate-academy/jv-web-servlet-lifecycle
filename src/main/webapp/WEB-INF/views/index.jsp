<%--
  Created by IntelliJ IDEA.
  User: zagor
  Date: 04.09.2023
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат записи в ресурс</title>
</head>
<body>
    <h1>Информация записана в наш ресурс</h1>
    <p>Дата и время записи: <%= request.getAttribute("currentDate") %></p>
</body>
</html>
