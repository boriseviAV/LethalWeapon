package logic.controllers.categories;

import logic.DAO.WeaponsDAO;
import logic.controllers.InitServlet;
import logic.models.Weapon;
import logic.upload.FileCopying;
import logic.upload.FileWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/show_category")
public class ShowCategoryServlet extends InitServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        WeaponsDAO weaponsDAO = new WeaponsDAO();
        List<Weapon> weaponsList = weaponsDAO.getWeaponsByCategoryId(id);

        for (Weapon weapon : weaponsList)
            FileCopying.cache(weapon.getPictureURL());

        String prevPageURL = request.getHeader("Referer");

        boolean addToCol = prevPageURL.contains("add_weapons");

        request.setAttribute("pageTitle", "Оружия категории");
        request.setAttribute("cacheDir", FileWork.cacheDir);
        request.setAttribute("categoryId", id);
        request.setAttribute("addToCol", addToCol);
        request.setAttribute("weaponsList", weaponsList);
        request.setAttribute("back", "/categories");
        request.setAttribute("action", "/new_weapon");
        request.setAttribute("anchor", "Назад к Категориям");
        request.setAttribute("weaponsListSize", weaponsList.size());
        request.setAttribute("pageName", "pages/categories/show.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

