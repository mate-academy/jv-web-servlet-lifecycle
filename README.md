# Servlet lifecycle practice

- Create a JSP page that will display "Information written to our resource" when we write to the resource
- Initialize `MyCoolResource` trough `init()` method
- Use `write()` method from MyCoolResource in `doGet()` method and display JSP page
- Close resource in `destroy()` method

### Typical mistake:

- Do not forget to call `init()` and `destroy()` methods from the superclass when we override them
