package logic.controllers.categories;

import logic.DAO.CategoriesDAO;
import logic.controllers.InitServlet;
import logic.models.Category;
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
@WebServlet(value = "/new_category")
public class NewCategoryServlet extends InitServlet {

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

        Category category = new Category(name, pathToImage);

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        long id = categoriesDAO.insert(category);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении аксессуара!");

        response.sendRedirect("/categories");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageTitle", "Новая категория");
        request.setAttribute("pageName", "pages/categories/new.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
