package logic.controllers.weaponCollections;

import logic.DAO.CollectionsDAO;
import logic.models.WeaponCollection;
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
@WebServlet(value = "/new_weapon_collection")
public class NewWeaponCollectionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");

        String pathToImage = "";
        try {
            pathToImage = FileUploading.loadFile(request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        WeaponCollection weaponCollection = new WeaponCollection(name, pathToImage);

        CollectionsDAO collectionsDAO = new CollectionsDAO();
        int id = collectionsDAO.insert(weaponCollection);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении оружия!");

        response.sendRedirect("/weapon_collections");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "pages/weapon_collections/new.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
