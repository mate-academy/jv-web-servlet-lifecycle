package mate.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private static final SimpleDateFormat formatter = 
            new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        myResource.write(formatter.format(new Date(System.currentTimeMillis())));
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        //next output for test
        System.out.println(myResource.toString());
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
