package EJBs.Servlets;

import EJBs.Interfaces.IServiceEjbLocal;
import ServletsDB.Models.ServletResponse;
import ServletsDB.Models.User;
import com.google.gson.Gson;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demoejb")
public class EJBServlet extends HttpServlet {

    private Gson gson = new Gson();

    //@EJB //Si se inyecta con EJB el contexto en los stateful no se aplica. Para ello debemos usar @Inject
    @Inject
    private IServiceEjbLocal ejb;
    //@EJB //Si se inyecta con EJB el contexto en los stateful no se aplica. Para ello debemos usar @Inject
    @Inject
    private IServiceEjbLocal ejb2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            String[] reqEjb = new String[3];
            reqEjb[0] = this.ejb.greetings(req.getParameter("name"));
            reqEjb[1] = this.ejb2.greetings(req.getParameter("name") + " desde EJB2");
            reqEjb[2] = "El objeto ejb es igual al objeto ejb2: " + ejb.equals(ejb2);

            out.print(gson.toJson(new ServletResponse<String[]>("Peticion hacia un EJB", reqEjb, HttpServletResponse.SC_OK)));
        } catch (Exception ex) {
            out.print(gson.toJson(new ServletResponse<User>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR)));
        } finally {
            out.flush();
            out.close();
        }
    }
}
