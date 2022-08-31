package ServletsDB.Servlets;

import ServletsDB.Business.LoginBusiness;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

            var response = business.Login(gson.fromJson(sb.toString(), User.class), resp, req.getCookies());
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
