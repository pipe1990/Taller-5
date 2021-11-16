package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.UserService;
import edu.unbosque.JPATutorial.servlets.pojos.UserPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listAuthorsServlet", value = "/list-authors")
public class ListUsersServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        UserService userService = new UserService();
        List<UserPOJO> authors =  userService.listUsers();

        String usersJsonString = new Gson().toJson(authors);

        PrintWriter out = response.getWriter();
        out.print(usersJsonString);
        out.flush();

    }

}
