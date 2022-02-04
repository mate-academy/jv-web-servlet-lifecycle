package mate.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private MyCoolResource myCoolResource;
    private String dateTimeCurrent;

    @Override
    public void init(ServletConfig config) throws ServletException {
        myCoolResource = MyCoolResource.openResource();
        dateTimeCurrent = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss")
                .format(Calendar.getInstance().getTime());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myCoolResource.write(dateTimeCurrent);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }

    public void destroy() {
        myCoolResource.close();
    }
}
