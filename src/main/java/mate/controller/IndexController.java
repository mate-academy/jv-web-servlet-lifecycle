package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    //TODO: implement

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        myResource = MyCoolResource.openResource();
        myResource.write(buildLogMsg("Index controller initialization"));
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(buildLogMsg("doGet Call"));
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.write(buildLogMsg("Index controller finalization"));
        myResource.close();
    }

    private String buildLogMsg(String message) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss\t"))
                + message;
    }
}
