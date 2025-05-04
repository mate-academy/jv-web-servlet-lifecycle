package mate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(String.valueOf(new java.util.Date()));
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }
}
