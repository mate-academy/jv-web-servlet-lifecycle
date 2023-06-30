package mate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    private int count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        count = 0;
        myResource = MyCoolResource.openResource();
        System.out.println("Init " + config.getServletName() + " finite!");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Index asked ");
        count++;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateString = dateFormat.format(date);
        myResource.write(count + " " + dateString);
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Dta Inserting TO COOL RESOURCE</h1>");
        printWriter.print("<p> " + count + " Date and time  " + dateString + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
        if (count == 5) {
            destroy();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        myResource.close();
        super.destroy();
    }
}
