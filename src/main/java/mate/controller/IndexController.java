package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        myResource = MyCoolResource.openResource();
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String pattern = "dd MMMM yyyy HH:mm:ss";
        String current = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        myResource.write(current);
        req.setAttribute("current", current);
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}

