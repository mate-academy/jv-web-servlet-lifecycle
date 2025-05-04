package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() {
        List<String> stringList = new ArrayList<>();
        myResource = new MyCoolResource(stringList);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        myResource.write(String.valueOf(LocalDate.now()));
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    public void destroy(){

    }

}
