package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("index doGet invoked...");
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);

        myResource.write(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy mm:ss", Locale.getDefault())));
    }
}
