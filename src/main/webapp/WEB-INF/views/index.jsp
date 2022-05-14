<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 13-May-22
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<html>
<head>
    <title>test page#2</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Display Current Date & Time</h1>
</div>
<%
    Date date = new Date();
    out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
%>
</body>
</html>
