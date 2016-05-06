package logic.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by VORON on 02.05.2016.
 */
@WebServlet(value = "/accsSniperScopes")
public class AccsSniperScopes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", request.getRequestURI()+".jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
