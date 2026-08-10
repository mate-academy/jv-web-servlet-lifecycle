<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Fibonacci evaluator</title></head>
<body>
<form action="#fibonacci" method="POST">
    <label for="val">Enter a value for n: </label>
    <input type="text" name="val" id="val">
    <input type="submit" value="Submit">
</form>
<%!
    int n;
    String str;

    int fibo(int n) {
        if(n<2)
            return n;
        else
            return fibo(n-1) + fibo(n-2);
    }
%>
<b>Fibonacci series: </b><br>
<div id="fibonacci">
<%
    str = request.getParameter("val");
    n = Integer.parseInt(str);

    for(int i=0; i<=n; i++) {
        System.out.print(fibo(i) + " ");
    }
%>
</div>
</body>
</html>