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
        int id = Integer.parseInt(request.getParameter("id"));
        int itemsInPortion = 6;

        CollectionsDAO  collectionsDAO = new CollectionsDAO();
        List<Weapon> weaponsList = collectionsDAO.getWeaponsByCollectionId(id);

        request.setAttribute("collectionId", id);
        request.setAttribute("action", "/add_weapons");
        request.setAttribute("anchor", "Назад к Сборникам");
        request.setAttribute("back", "/weapon_collections");
        request.setAttribute("addToCol", false);
        request.setAttribute("weaponsList", weaponsList);
        request.setAttribute("weaponsListSize", weaponsList.size());
        request.setAttribute("weaponsListPortionsNumber", weaponsList.size() / itemsInPortion);
        request.setAttribute("weaponsListRestNumber", weaponsList.size() % itemsInPortion);
        request.setAttribute("itemsInPortion", itemsInPortion);
        request.setAttribute("pageName", "pages/weapon_collections/show.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

