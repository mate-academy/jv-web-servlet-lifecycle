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

@WebServlet(urlPatterns = {"/", "/index"})
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/web-res/res/index.jsp").forward(req, resp);
        myResource.write(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm")));
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }
}
