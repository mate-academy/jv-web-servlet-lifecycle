<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<u1>
    <c:forEach var="element" items="${Resource}">
        <li>${element}</li>
    </c:forEach>
</u1>
</body>
</html>
