package logic.controllers.weapons;

import logic.DAO.WeaponsDAO;
import logic.models.Weapon;
import logic.upload.FileUploading;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 25,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet(value = "/new_weapon")
public class NewWeaponServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String modelName = request.getParameter("model_name");
        String holdingWay = request.getParameter("holding_way");
        String country = request.getParameter("country");
        String range = request.getParameter("range");
        String caliber = request.getParameter("caliber");

        int categoryId = Integer.parseInt(request.getParameter("to"));

        int ammoNumber = 0;
        String ammoString = request.getParameter("ammo_number");
        try {
            if (!ammoString.equals(""))
                ammoNumber = Integer.parseInt(ammoString);
        }
        catch (NumberFormatException e) {
            ammoNumber = 0;
        }

        Boolean optics = Boolean.parseBoolean(request.getParameter("optics"));
        String stuff = request.getParameter("stuff");

        String pathToImage = "";
        try {
            pathToImage = FileUploading.loadFile(request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        Weapon weapon = new Weapon(modelName, holdingWay, country, range, caliber, ammoNumber, optics, stuff, pathToImage);
        weapon.setCategoryId(categoryId);

        WeaponsDAO weaponsDAO = new WeaponsDAO();
        int id = weaponsDAO.insert(weapon);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении оружия!");

        response.sendRedirect("/show_category?id=" + categoryId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "pages/weapons/new.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
