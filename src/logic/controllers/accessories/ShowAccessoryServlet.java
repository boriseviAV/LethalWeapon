package logic.controllers.accessories;

import logic.DAO.AccessoriesDAO;
import logic.controllers.InitServlet;
import logic.models.Accessory;
import logic.upload.FileCopying;
import logic.upload.FileWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/show_accessory")
public class ShowAccessoryServlet extends InitServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
        Accessory accessory = accessoriesDAO.getAccessoryById(id);

        FileCopying.cache(accessory.getPictureURL());

        request.setAttribute("pageTitle", "Параметры");
        request.setAttribute("cacheDir", FileWork.cacheDir);
        request.setAttribute("pageName", "pages/accessories/show.jsp");
        request.setAttribute("accessory", accessory);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}