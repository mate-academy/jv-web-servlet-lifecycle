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
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private MyCoolResource myResource;

    @Override
    public void init() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String dateTimeNow = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        System.out.println(dateTimeNow);
        myResource.write(dateTimeNow);
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
