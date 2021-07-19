package mate.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private static final String PATH_TO_THE_PAGE = "/WEB-INF/views/index.jsp";
    private MyCoolResource myResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        req.getRequestDispatcher(PATH_TO_THE_PAGE).forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }

    @Override
    public void init(ServletConfig config) {
        myResource = MyCoolResource.openResource();
    }
}
