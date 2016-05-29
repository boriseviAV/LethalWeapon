package logic.controllers.weapons;

import logic.DAO.CollectionsDAO;
import logic.DAO.WeaponsDAO;
import logic.controllers.InitServlet;
import logic.models.Weapon;
import logic.models.WeaponCollection;
import logic.upload.FileCopying;
import logic.upload.FileWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/show_weapon")
public class ShowWeaponServlet extends InitServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        WeaponsDAO weaponsDAO = new WeaponsDAO();
        Weapon weapon = weaponsDAO.getWeaponById(id);

        FileCopying.cache(weapon.getPictureURL());

        CollectionsDAO collectionsDAO = new CollectionsDAO();
        List<WeaponCollection> weaponCollectionsList = collectionsDAO.getCollectionsByWeaponId(id);

        for (WeaponCollection collection : weaponCollectionsList)
            FileCopying.cache(collection.getPictureURL());

        String prevPageURL = request.getHeader("Referer");

        request.setAttribute("pageTitle", "Параметры оружия");
        request.setAttribute("cacheDir", FileWork.cacheDir);
        request.setAttribute("back", prevPageURL);
        request.setAttribute("pageName", "pages/weapons/show.jsp");
        request.setAttribute("weapon", weapon);
        request.setAttribute("weaponCollectionsList", weaponCollectionsList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
