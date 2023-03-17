package mate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private static final String INDEX_JSP_PATH = "/WEB-INF/views/index.jsp";
    private MyCoolResource myResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(java.time.LocalDateTime.now().toString());
        req.getRequestDispatcher(INDEX_JSP_PATH).forward(req,resp);
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
