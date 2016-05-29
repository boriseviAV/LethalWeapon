package logic.controllers.accessories;

import logic.DAO.AccessoriesDAO;
import logic.controllers.InitServlet;
import logic.models.Accessory;
import logic.upload.FileCopying;
import logic.upload.FileUploading;
import logic.upload.FileWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/accessories")
public class AccessoriesServlet extends InitServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        String pathToImage = "";
        try {
            pathToImage = FileUploading.loadFile(request);
            System.out.println(pathToImage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        Accessory accessory = new Accessory(name, description, pathToImage);

        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
        int id = accessoriesDAO.insert(accessory);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении оружия!");

        response.sendRedirect("/weapon_collections");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");

        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
        List<Accessory> accessoriesList;

        if (methodName != null && methodName.equalsIgnoreCase("delete")) {
            accessoriesDAO.deleteAll();
            accessoriesList = new ArrayList<Accessory>();
        }
        else
            accessoriesList = accessoriesDAO.getAllAccessories();

        for (Accessory accessory : accessoriesList)
            FileCopying.cache(accessory.getPictureURL());

        request.setAttribute("cacheDir", FileWork.cacheDir);
        request.setAttribute("accessoriesList", accessoriesList);
        request.setAttribute("pageName", "pages/accessories/index.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
