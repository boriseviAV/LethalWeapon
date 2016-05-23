package logic.controllers.search;

import logic.DAO.CategoriesDAO;
import logic.DAO.SearchDAO;
import logic.models.Category;
import logic.models.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchDAO searchDAO = new SearchDAO();

        List<Weapon> result = searchDAO.getResults(request.getParameter("text"));

        request.setAttribute("weaponsList", result);
        request.setAttribute("pageName", "pages/search_results/index.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
