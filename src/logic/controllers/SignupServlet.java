package logic.controllers;

import logic.DAO.UsersDAO;
import logic.authentification.Hashing;
import logic.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        String repPassword = request.getParameter("rep_pass");
        String email = request.getParameter("email");
        String role = "user";

        if (password.equals(repPassword)) {
            User user = new User(login, Hashing.md5(password), email, role);
            UsersDAO usersDAO = new UsersDAO();
            usersDAO.insert(user);

            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);

            response.sendRedirect("/index");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", request.getRequestURI() + ".jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
