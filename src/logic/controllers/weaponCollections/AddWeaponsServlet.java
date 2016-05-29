package logic.controllers.weaponCollections;

import logic.DAO.CategoriesDAO;
import logic.DAO.WeaponsAndCollectionsDAO;
import logic.controllers.InitServlet;
import logic.models.Category;
import logic.upload.FileCopying;
import logic.upload.FileWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/add_weapons")
public class AddWeaponsServlet extends InitServlet {

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
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        List<Category> categoriesList = categoriesDAO.getAllCategories();

        int collectionId = Integer.parseInt(request.getParameter("to"));

        for (Category category : categoriesList)
            FileCopying.cache(category.getPictureURL());

        request.setAttribute("pageTitle", "Добавить в сборник");
        request.setAttribute("cacheDir", FileWork.cacheDir);
        request.setAttribute("collectionId", collectionId);
        request.setAttribute("addToCol", true);
        request.setAttribute("back", "/categories");
        request.setAttribute("categoriesList", categoriesList);
        request.setAttribute("pageName", "pages/weapon_collections/add_weapons.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
