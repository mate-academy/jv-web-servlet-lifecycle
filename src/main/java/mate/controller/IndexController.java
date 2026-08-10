package mate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int randomNumber = new Random().nextInt();
        String text = "I just put here some random number, like this: " + randomNumber;
        myResource.write(text);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").include(req, resp);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html><body><center>");
        out.println(text);
        out.println("</center></body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("finished program");
        myResource.close();
    }
}
