package ServletsDB.Servlets;

import ServletsDB.Business.LoginBusiness;
import ServletsDB.Business.UserBusiness;
import ServletsDB.Models.ServletResponse;
import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
        var sessions = req.getSession();
        sessions.setAttribute("", new Object());

        try {
            var cookies = req.getCookies();
            if (req.getCookies() != null && req.getCookies().length > 0 &&
                    Arrays.stream(req.getCookies()).anyMatch(c -> c.getName().equals(LoginBusiness.COOKIE_LOGIN_NAME)) == true) {
                String searchCriteria = req.getParameter("searchCriteria");

                var response = business.getUsers(searchCriteria == null ? "" : searchCriteria);
                resp.setStatus(response.getStatusCode());
                out.print(gson.toJson(response));
            } else {
                out.print(gson.toJson(new ServletResponse<List<User>>("Debes iniciar sesión antes de continuar", null, HttpServletResponse.SC_UNAUTHORIZED)));
            }

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
            var cookies = req.getCookies();
            if (req.getCookies() != null &&
                    req.getCookies().length > 0 &&
                    Arrays.stream(req.getCookies()).anyMatch(c -> c.getName().equals(LoginBusiness.COOKIE_LOGIN_NAME)) == true) {

                BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String result = null;
                while ((result = br.readLine()) != null) {
                    sb.append(result + "\n");
                }
                br.close();

                User userSave = gson.fromJson(sb.toString(), User.class);
                if (sb.toString().contains("\"isCancel\":true") == true) {
                    Cookie cancelCookie = new Cookie("tempSave", userSave.getName());
                    cancelCookie.setMaxAge(3600);
                    resp.addCookie(cancelCookie);
                } else {
                    userSave.setUserID(rnd.nextInt(1, 999999999));
                    var response = business.saveUser(userSave);
                    resp.setStatus(response.getStatusCode());
                    out.print(gson.toJson(response));
                }
            } else {
                out.print(gson.toJson(new ServletResponse<List<User>>("Debes iniciar sesión antes de continuar", null, HttpServletResponse.SC_UNAUTHORIZED)));
            }
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
            var cookies = req.getCookies();
            if (req.getCookies() != null && req.getCookies().length > 0 &&
                    Arrays.stream(req.getCookies()).anyMatch(c -> c.getName().equals(LoginBusiness.COOKIE_LOGIN_NAME)) == true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String result = null;
                while ((result = br.readLine()) != null) {
                    sb.append(result + "\n");
                }
                br.close();

                User userSave = gson.fromJson(sb.toString(), User.class);

                var response = business.saveUser(userSave);
                resp.setStatus(response.getStatusCode());
                out.print(gson.toJson(response));
            } else {
                out.print(gson.toJson(new ServletResponse<List<User>>("Debes iniciar sesión antes de continuar", null, HttpServletResponse.SC_UNAUTHORIZED)));
            }
        } catch (
                Exception ex) {
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
            var cookies = req.getCookies();
            if (req.getCookies() != null && req.getCookies().length > 0 &&
                    Arrays.stream(req.getCookies()).anyMatch(c -> c.getName().equals(LoginBusiness.COOKIE_LOGIN_NAME)) == true) {
                String userID = req.getParameter("userID");

                var response = business.deleteUser(userID);
                resp.setStatus(response.getStatusCode());
                out.print(gson.toJson(response));
            } else {
                out.print(gson.toJson(new ServletResponse<List<User>>("Debes iniciar sesión antes de continuar", null, HttpServletResponse.SC_UNAUTHORIZED)));
            }
        } catch (Exception ex) {
            out.print(gson.toJson(new ServletResponse<User>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR)));
        } finally {
            out.flush();
            out.close();
        }
    }
}