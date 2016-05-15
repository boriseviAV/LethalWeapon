package logic.controllers.accessories;

import logic.DAO.AccessoriesDAO;
import logic.models.Accessory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/show_accessory")
public class ShowAccessoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
        Accessory accessory = accessoriesDAO.getAccessoryById(id);

        request.setAttribute("pageName", "pages/accessories/show.jsp");
        request.setAttribute("accessory", accessory);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}