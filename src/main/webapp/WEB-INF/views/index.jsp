<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charse=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Information written to our resource, JSP!</title>
</head>
<body>
<h1>Information written to our resource</h1>
<h3>Today's date: <%= (LocalDateTime.now().toString())%></h3>
</body>
</html>