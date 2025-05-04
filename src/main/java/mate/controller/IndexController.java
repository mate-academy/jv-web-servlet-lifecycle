package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private final String path = "/WEB-INF/views/index.jsp";
    private MyCoolResource myResource;
    //TODO: implement

    public void init() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        init();
        myResource.write(LocalDateTime.now().toString());
        req.getRequestDispatcher(path).forward(req, resp);
        destroy();
    }

    public void destroy() {
        myResource.close();
    }
}
