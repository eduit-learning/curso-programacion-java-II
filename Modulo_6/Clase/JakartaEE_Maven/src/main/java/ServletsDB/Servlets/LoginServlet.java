package ServletsDB.Servlets;

import ServletsDB.Business.LoginBusiness;
import ServletsDB.Business.UserBusiness;
import ServletsDB.Models.ServletResponse;
import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import com.google.gson.Gson;
import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Gson gson = new Gson();

    private static StaticContext cnt;

    public LoginServlet() {
        if (cnt == null) {
            cnt = new StaticContext();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            var sessions = req.getSession();
            var result = req.getSession().getAttribute("userLoged");
            if (result != null) {
                out.print(gson.toJson(new ServletResponse<User>("Bienvenido de nuevo " + ((User) result).getName(), (User) result, HttpServletResponse.SC_OK)));
            } else {
                out.print(gson.toJson(new ServletResponse<User>("Usuario no autenticado", null, HttpServletResponse.SC_UNAUTHORIZED)));
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
        LoginBusiness business = new LoginBusiness(cnt);
        Random rnd = new Random();
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String result = null;
            while ((result = br.readLine()) != null) {
                sb.append(result + "\n");
            }
            br.close();

            var response = business.Login(gson.fromJson(sb.toString(), User.class), resp, req.getCookies(), req.getSession());
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
