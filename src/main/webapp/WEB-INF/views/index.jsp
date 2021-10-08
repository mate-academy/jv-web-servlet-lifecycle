<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
<h1>Hallo, mates!</h1>
<h2>Information is written to our resource</h2>
<p>
    <%@ page import="java.time.LocalDateTime" %>
    <%
        LocalDateTime now = LocalDateTime.now();
        String info = "Information wrote: " + now;
    %>
    <%= info %>
</p>
</body>
</html>
