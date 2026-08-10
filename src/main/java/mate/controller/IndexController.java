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

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() {
        System.out.println("init");
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doGet");
        myResource.write(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("d MMM yyyy | HH:mm:ss")));
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").include(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        myResource.close();
    }
}
