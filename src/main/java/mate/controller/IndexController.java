package mate.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
        super.init();
        myResource = MyCoolResource.openResource();
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTimeMessage = dateTime.format(dateTimeFormatter);
        myResource.write(dateTimeMessage);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").include(req, resp);
        out.println(dateTimeMessage);
        out.close();
    }
    
    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
