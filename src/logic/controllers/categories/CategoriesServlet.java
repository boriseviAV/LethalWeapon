package logic.controllers.categories;

import logic.DAO.CategoriesDAO;
import logic.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/categories")
public class CategoriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsInPortion = 6;

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        List<Category> categoriesList = categoriesDAO.getAllCategories();

        Object addToColValue = request.getAttribute("addToCol");
        request.setAttribute("addToCol", addToColValue == null ? false : addToColValue);
        request.setAttribute("back", "/categories");
        request.setAttribute("categoriesList", categoriesList);
        request.setAttribute("categoriesListSize", categoriesList.size());
        request.setAttribute("categoriesListPortionsNumber", categoriesList.size() / itemsInPortion);
        request.setAttribute("categoriesListRestNumber", categoriesList.size() % itemsInPortion);
        request.setAttribute("itemsInPortion", itemsInPortion);
        request.setAttribute("pageName", "pages/categories/index.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
