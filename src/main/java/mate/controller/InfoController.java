package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/info")
public class InfoController extends HttpServlet {
    private MyCoolResource myResource;
    //TODO: implement
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDateTime.now().toString());
        req.getRequestDispatcher("/WEB-INF/views/info.jsp").forward(req, resp);
    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("MyResource was initiated");
        myResource = MyCoolResource.openResource();
    }
    
    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
