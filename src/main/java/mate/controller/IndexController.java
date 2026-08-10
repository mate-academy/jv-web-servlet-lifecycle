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

@WebServlet
public class IndexController extends HttpServlet {
    private static final DateTimeFormatter DATETIME = DateTimeFormatter.ISO_DATE_TIME;
    private static final String MESSAGE = "Servlet was initialized at ";
    private LocalDateTime now = LocalDateTime.now();
    private MyCoolResource myResource = MyCoolResource.openResource();

    @Override
    public void init() throws ServletException {
        myResource.write(MESSAGE + DATETIME.format(now));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(MESSAGE + DATETIME.format(now));
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.write(MESSAGE + DATETIME.format(now));
        myResource.close();
    }
}
