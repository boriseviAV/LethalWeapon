package logic.controllers;

import logic.DAO.SearchDAO;
import logic.models.Weapon;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/")
public class IndexServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String phrase = (String)request.getSession().getAttribute("phrase");

        if (phrase != null) {
            SearchDAO searchDAO = new SearchDAO();
            List<Weapon> result = searchDAO.getResults(phrase);

            if (result.isEmpty())
                request.setAttribute("weaponsList", null);
            else
                request.setAttribute("weaponsList", result);

            request.setAttribute("addToCol", false);
            request.setAttribute("pageName", "pages/search_results/index.jsp");
        }
        else
            request.setAttribute("pageName", "home.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
