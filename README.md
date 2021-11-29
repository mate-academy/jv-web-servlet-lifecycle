# Servlet lifecycle practice

- Create a JSP page that will display "Information written to our resource" when we write to the resource
- Initialize `MyCoolResource` trough `init()` method
- Use `write()` method from MyCoolResource in `doGet()` method and display JSP page. For example, pass current date and time value string representation as a parameter to method `write()`.
- Close resource in `destroy()` method

__Before submitting solution make sure you checked it first with__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-web/web-servlet-lifecycle/java-web-servlet-lifecycle)
