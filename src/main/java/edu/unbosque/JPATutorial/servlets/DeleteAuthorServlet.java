package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteAuthorServlet", value = "/delete-author")
public class DeleteAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer authorId = Integer.parseInt(request.getParameter("authorId"));

        UserService authorService = new UserService();
        authorService.deleteAuthor(authorId);

        response.sendRedirect("./index.jsp");
    }

}
