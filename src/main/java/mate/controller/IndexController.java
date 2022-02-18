package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {

    static {
        System.out.println(
                "Servlet container Tomcat was loaded class IndexController to class loader");
    }

    private MyCoolResource myResource;

    public IndexController() {
        System.out.println("Instance of IndexController class was created");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Method init was called. Here we can initialize field myResource");
        super.init(config);
        myResource = new MyCoolResource(new ArrayList<>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Method doGet was called");
        LocalDateTime now = LocalDateTime.now();
        String formatDateTime = formatDateTime(now);
        myResource.write(formatDateTime);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Method destroy() was called");
        super.destroy();
    }

    public String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss")
                .withLocale(Locale.ENGLISH);
        //MMMM: Exactly 4 pattern letters will use the full form
        //(The count of pattern letters determines the format)
        //HH: 24 hour pattern, hh: 12 hour pattern
        return dateTime.format(formatter);
    }
}
