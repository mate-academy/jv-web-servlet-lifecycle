package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dao.MyCoolResource;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    private static final String DATETIME_PATTERN = "HH:mm:ss MMM dd yyyy";
    private static final String RESOURCE_WRITTEN = "src/main/webapp/WEB-INF/views/resourceWrittenOk.jsp";

    @Override
    public void init() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myResource.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
        req.getRequestDispatcher(RESOURCE_WRITTEN).forward(req, resp);
    }


}
