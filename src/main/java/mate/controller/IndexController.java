package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
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
    private MyCoolResource myResource;

    static {
        System.out.println("IndexController was loaded...");
    }

    public IndexController() {
        System.out.println("IndexController was called...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatPattern = localDateTime
                .format(DateTimeFormatter.ofPattern("dd-yyyy-MM HH:mm"));
        myResource.write(formatPattern);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
