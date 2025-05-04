package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    //TODO: implement

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String dateNow = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("dd-MM-yyyy HH:mm:ss"));
        myResource.write(dateNow);
        req.setAttribute("dateNow", dateNow);
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
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
