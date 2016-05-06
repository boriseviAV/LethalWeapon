package logic.controllers;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/index")
public class IndexServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //Weapon weapon = new Weapon(1, "sdfsdf", "dfsdf", "sdfsdf", "dfsdfds", "sdfsdfsd", 12, "dfsdfsd", true, "dfsdf", 13, "dsfsd");

        //WeaponDAO.insert(weapon);

        request.setAttribute("pageName", "home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
