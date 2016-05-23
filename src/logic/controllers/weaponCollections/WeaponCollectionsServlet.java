package logic.controllers.weaponCollections;

import logic.DAO.CollectionsDAO;
import logic.models.WeaponCollection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/weapon_collections")
public class WeaponCollectionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");

        CollectionsDAO collectionsDAO = new CollectionsDAO();
        List<WeaponCollection> weaponCollectionsList;

        if (methodName != null && methodName.equalsIgnoreCase("delete")) {
            collectionsDAO.deleteAll();
            weaponCollectionsList = new ArrayList<WeaponCollection>();
        }
        else {
            weaponCollectionsList = collectionsDAO.getAllCollections();
        }

        request.setAttribute("weaponCollectionsList", weaponCollectionsList);
        request.setAttribute("pageName", "pages/weapon_collections/index.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
