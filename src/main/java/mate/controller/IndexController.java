package mate.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init(ServletConfig servletConfig) {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String timeString = String.valueOf(System.currentTimeMillis());
        myResource.write(timeString);
        req.getRequestDispatcher("WEB-INF/view/info.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
