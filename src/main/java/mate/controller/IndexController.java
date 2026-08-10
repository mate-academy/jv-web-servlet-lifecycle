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

    @Override
    public void init() throws ServletException {
        MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String nowDateTime = dateTimeFormatter.format(localDateTime);
        myResource.write(nowDateTime);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
