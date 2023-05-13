package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet("/index")
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("message", "Local time: " + LocalDateTime.now());
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        myResource.write("Local time: " + LocalDateTime.now());
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }
}
