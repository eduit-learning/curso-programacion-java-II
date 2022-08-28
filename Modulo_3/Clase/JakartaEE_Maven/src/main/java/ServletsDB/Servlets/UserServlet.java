package ServletsDB.Servlets;

import ServletsDB.Business.UserBusiness;
import ServletsDB.Models.ServletResponse;
import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/usersdb")
public class UserServlet extends HttpServlet {
    //https://mvnrepository.com/artifact/com.google.code.gson/gson/2.9.1
    private Gson gson = new Gson();
    private static StaticContext cnt;

    public UserServlet() {
        if (cnt == null) {
            cnt = new StaticContext();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBusiness business = new UserBusiness(this.cnt);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            String searchCriteria = req.getParameter("searchCriteria");

            var response = business.getUsers(searchCriteria == null ? "" : searchCriteria);
            resp.setStatus(response.getStatusCode());
            out.print(gson.toJson(response));
        } catch (Exception ex) {
            out.print(gson.toJson(new ServletResponse<User>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR)));
        } finally {
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBusiness business = new UserBusiness(this.cnt);
        Random rnd = new Random();
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            String name = req.getParameter("name");
            String lastName = req.getParameter("lastName");
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            String[] programmingLanguages = req.getParameterValues("programmingLanguages");
            String[] roles = req.getParameterValues("roles");
            String language = req.getParameter("language");

            User userSave = new User(rnd.nextInt(1, 999999999), name, lastName, email, password);
            userSave.setLanguage(language);
            userSave.setCountry(country);
            userSave.setUserName(userName);
            userSave.setProgrammingLanguages(programmingLanguages);
            userSave.setRoles(roles);

            var response = business.saveUser(userSave);
            resp.setStatus(response.getStatusCode());
            out.print(gson.toJson(response));
        } catch (Exception ex) {
            out.print(gson.toJson(new ServletResponse<User>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR)));
        } finally {
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBusiness business = new UserBusiness(this.cnt);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {

        } catch (Exception ex) {
            out.print(gson.toJson(new ServletResponse<User>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR)));
        } finally {
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBusiness business = new UserBusiness(this.cnt);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            String userID = req.getParameter("userID");

            var response = business.deleteUser(userID);
            resp.setStatus(response.getStatusCode());
            out.print(gson.toJson(response));
        } catch (Exception ex) {
            out.print(gson.toJson(new ServletResponse<User>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR)));
        } finally {
            out.flush();
            out.close();
        }
    }
}