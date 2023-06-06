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
    private MyCoolResource myCoolResource;

    public void init() {
        myCoolResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String dateTimeNow = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(dateTimeNow);
        myCoolResource.write(dateTimeNow);
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myCoolResource.close();
    }
}
