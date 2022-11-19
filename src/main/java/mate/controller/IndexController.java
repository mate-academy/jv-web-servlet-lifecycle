package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;
import java.io.IOException;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myResource.write("Світ надзвичайно широкий\n" +
                "має укладисті далі.\n" +
                "Від того і перші кроки\n" +
                "майже завжди невдалі.\n" +
                "Безпомічні вірші перші.\n" +
                "Нещасне перше кохання.\n" +
                "Немає жодних звершень,\n" +
                "а тільки одні поривання.\n" +
                "А потім минають роки,\n" +
                "з'являється стримана сила.\n" +
                "Поглянеш – а перші кроки\n" +
                "вже й пилом давно притрусило.\n" +
                "І смішно тобі, й сердито,\n" +
                "і ти забуваєш часто:\n" +
                "щоб добре ходити,\n" +
                "разів десять треба впасти.");

        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
