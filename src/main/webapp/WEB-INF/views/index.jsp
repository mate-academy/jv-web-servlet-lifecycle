<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%!
    public LocalDate getDate() {
        return LocalDate.now();
    }

    public String getTime() {
        LocalTime now = LocalTime.now();
       return now.getHour() + ":" + now.getMinute() + ":" + now.getSecond();
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index page</title>
</head>
<body>
<h1>
    <div style="text-align: center;">"<%=getDate()%>" : "<%=getTime()%>"</div>
</h1>
</body>
</html>
