package logic.controllers.categories;

import logic.DAO.WeaponsDAO;
import logic.models.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/show_category")
public class ShowCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsInPortion = 6;

        int id = Integer.parseInt(request.getParameter("id"));

        WeaponsDAO weaponsDAO = new WeaponsDAO();
        List<Weapon> weaponsList = weaponsDAO.getWeaponsByCategoryId(id);

        String prevPageURL = request.getHeader("Referer");

        boolean addToCol = prevPageURL.contains("add_weapons");

        request.setAttribute("addToCol", addToCol);
        request.setAttribute("weaponsList", weaponsList);
        request.setAttribute("back", "/categories");
        request.setAttribute("action", "/new_weapon");
        request.setAttribute("anchor", "Назад к Категориям");
        request.setAttribute("weaponsListSize", weaponsList.size());
        request.setAttribute("weaponsListPortionsNumber", weaponsList.size() / itemsInPortion);
        request.setAttribute("weaponsListRestNumber", weaponsList.size() % itemsInPortion);
        request.setAttribute("itemsInPortion", itemsInPortion);
        request.setAttribute("pageName", "pages/categories/show.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

