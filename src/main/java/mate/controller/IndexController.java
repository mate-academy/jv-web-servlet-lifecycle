package mate.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {

    private static final String CURRENT_DATE = "/WEB-INF/views/date.jsp";

    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("myCoolResource", myResource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Method write is ready ..");
        myResource.write("Current date and time: " + CURRENT_DATE);
        req.getRequestDispatcher(CURRENT_DATE).forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }
}
