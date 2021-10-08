package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        System.out.println("Init MyCoolResource in Servlet "
                + getServletConfig().getServletName());
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void destroy() {
        System.out.println("Close MyCoolResource in Servlet "
                + getServletConfig().getServletName());
        myResource.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDateTime.now().toString());
        System.out.println("Information written to our resource");
        req.getRequestDispatcher("\\WEB-INF\\views\\index.jsp").forward(req,resp);
    }
}
