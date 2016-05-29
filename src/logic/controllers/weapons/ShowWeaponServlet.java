package logic.controllers.weapons;

import logic.DAO.CollectionsDAO;
import logic.DAO.WeaponsDAO;
import logic.models.Weapon;
import logic.models.WeaponCollection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/show_weapon")
public class ShowWeaponServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        WeaponsDAO weaponsDAO = new WeaponsDAO();
        Weapon weapon = weaponsDAO.getWeaponById(id);

        CollectionsDAO collectionsDAO = new CollectionsDAO();
        List<WeaponCollection> weaponCollectionsList = collectionsDAO.getCollectionsByWeaponId(id);

        String prevPageURL = request.getHeader("Referer");

        request.setAttribute("back", prevPageURL);
        request.setAttribute("pageName", "pages/weapons/show.jsp");
        request.setAttribute("weapon", weapon);
        request.setAttribute("weaponCollectionsList", weaponCollectionsList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
