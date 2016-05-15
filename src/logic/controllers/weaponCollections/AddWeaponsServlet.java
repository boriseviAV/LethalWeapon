package logic.controllers.weaponCollections;

import logic.DAO.CategoriesDAO;
import logic.DAO.WeaponsAndCollectionsDAO;
import logic.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/add_weapons")
public class AddWeaponsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int collectionId = Integer.parseInt(request.getParameter("to"));

            String[] ids = request.getParameterValues("weaponId");

            WeaponsAndCollectionsDAO weaponsAndCollectionsDAO = new WeaponsAndCollectionsDAO();
            for (String id : ids) {
                weaponsAndCollectionsDAO.insert(Integer.parseInt(id), collectionId);
            }
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        response.sendRedirect("/weapon_collections");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsInPortion = 6;

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        List<Category> categoriesList = categoriesDAO.getAllCategories();

        request.setAttribute("addToCol", true);
        request.setAttribute("back", "/categories");
        request.setAttribute("categoriesList", categoriesList);
        request.setAttribute("categoriesListSize", categoriesList.size());
        request.setAttribute("categoriesListPortionsNumber", categoriesList.size() / itemsInPortion);
        request.setAttribute("categoriesListRestNumber", categoriesList.size() % itemsInPortion);
        request.setAttribute("itemsInPortion", itemsInPortion);

        request.setAttribute("pageName", "pages/weapon_collections/add_weapons.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
