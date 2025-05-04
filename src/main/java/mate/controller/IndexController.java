package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/information")
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")));
        req.getRequestDispatcher("/WEB-INF/views/information.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }
}
