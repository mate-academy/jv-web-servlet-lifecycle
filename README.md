# Servlet lifecycle practice

- Create a JSP page that will be displayed when we write to the resource
- Inject `MyCoolResource` trough `init()` method
- Use `write()` method from MyCoolResource in `doGet()` method and display JSP page
- Close resource in `destroy()` method

### Typical mistake:

- Do not forget to call `init()` and `destroy()` methods from the superclass when we override them
