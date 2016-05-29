package logic.controllers.weaponCollections;

import logic.DAO.CollectionsDAO;
import logic.models.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/show_weapon_collection")
public class ShowWeaponCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int collectionId = Integer.parseInt(request.getParameter("id"));

        CollectionsDAO  collectionsDAO = new CollectionsDAO();
        List<Weapon> weaponsList = collectionsDAO.getWeaponsByCollectionId(collectionId);

        request.setAttribute("collectionId", collectionId);
        request.setAttribute("action", "/add_weapons");
        request.setAttribute("anchor", "Назад к Сборникам");
        request.setAttribute("back", "/weapon_collections");
        request.setAttribute("addToCol", false);
        request.setAttribute("weaponsList", weaponsList);
        request.setAttribute("weaponsListSize", weaponsList.size());
        request.setAttribute("pageName", "pages/weapon_collections/show.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

