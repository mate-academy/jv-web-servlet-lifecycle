package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = {"/index", "/"})
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String currentTime = LocalDateTime.now().toString();
        myResource.write(currentTime);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
