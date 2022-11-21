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

    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        myResource.write(localDateTime.toString());
        req.setAttribute("message", localDateTime);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    public void destroy() {
        myResource.close();
    }
}
