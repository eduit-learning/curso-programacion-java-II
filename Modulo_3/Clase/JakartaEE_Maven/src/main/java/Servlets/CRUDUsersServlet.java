package Servlets;

import Servlets.Repository.Context;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class CRUDUsersServlet extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        Context cnt = new Context();
        var result = cnt.users.stream().filter(usr -> (usr.getName() + usr.getLastName()).toLowerCase().contains(name.toLowerCase())).toList();
        String results = gson.toJson(result);

        out.print(results);
        out.flush();
        out.close();
    }
}
