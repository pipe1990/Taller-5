package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createUserServlet", value = "/create-user")
public class CreateUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        UserService userService = new UserService();
        userService.saveUser(name);

        response.sendRedirect("./index.jsp");
    }

}
