<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>index page</title>    <!--name of page in browser-->
</head>
<body>
<h1>Hello world!</h1>

<ul>
    <li>
        <%= request.getAttribute("date") %>
    </li>
</ul>

</body>
</html>
