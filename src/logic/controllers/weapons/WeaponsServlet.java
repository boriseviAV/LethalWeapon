package logic.controllers.weapons;

import logic.DAO.WeaponsDAO;
import logic.models.Weapon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/weapons")
public class WeaponsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WeaponsDAO weaponsDAO = new WeaponsDAO();
        List<Weapon> weaponsList = weaponsDAO.getAllWeapons();

        request.setAttribute("action", "/new_weapon");
        request.setAttribute("anchor", "Назад к Категориям");
        request.setAttribute("back", "/categories");
        request.setAttribute("weaponsList", weaponsList);
        request.setAttribute("weaponsListSize", weaponsList.size());

        request.setAttribute("pageName", "pages/weapons/index.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

