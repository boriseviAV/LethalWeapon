package logic.controllers.accessories;

import logic.DAO.AccessoriesDAO;
import logic.models.Accessory;
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
@WebServlet(value = "/new_accessory")
public class NewAccessoryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        String pathToImage = "";
        try {
            pathToImage = FileUploading.loadFile(request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        Accessory accessory = new Accessory(name, description, pathToImage);

        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
        int id = accessoriesDAO.insert(accessory);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении аксессуара!");

        response.sendRedirect("/accessories");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageTitle", "Новый аксессуар");
        request.setAttribute("pageName", "pages/accessories/new.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
