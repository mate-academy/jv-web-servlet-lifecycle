<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>index page</title>
    </head>
    <body>
        <h1>"Information written to our resource"</h1>
        <%
            Date date = new Date();
            out.print( "<h2 align=\"left\">" +date.toString()+"</h2>");
        %>
    </body>
</html>