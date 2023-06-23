package mate.controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myCoolResource;

    @Override
    public void init() throws ServletException {
        myCoolResource = MyCoolResource.openResource();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String message = new Date().toString();
        myCoolResource.write(message);
        req.setAttribute("message", message);
        String contextPath = req.getContextPath();
        req.getRequestDispatcher(contextPath + "/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
