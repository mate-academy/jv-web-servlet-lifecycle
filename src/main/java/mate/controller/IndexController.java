package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = ("/index"))
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDate.now().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
