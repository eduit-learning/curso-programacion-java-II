package Servlets;

import Servlets.Models.User;
import Servlets.Repository.Context;
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

@WebServlet("/users")
public class CRUDUsersServlet extends HttpServlet {

    private Gson gson = new Gson();
    private static Context cnt = new Context();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            String name = req.getParameter("name");

            if (name != null) {
                var result = cnt.users.stream().filter(usr -> (usr.getName() + usr.getLastName()).toLowerCase().contains(name.toLowerCase())).toList();

                if (result.isEmpty() == true) {
                    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    out.print(gson.toJson("No se encontraron coincidencias con el parámetro de búsqueda proporcionado"));
                } else {
                    String results = gson.toJson(result);

                    resp.setStatus(HttpServletResponse.SC_OK);
                    out.print(results);
                }
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(gson.toJson("El parámetro de búsqueda no puede ser null"));
            }
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson(ex.getMessage()));
        } finally {
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

            List<String> errores = new ArrayList();

            if (name == null || name.isBlank() == true || name.isEmpty() == true) {
                errores.add("El campo 'Nombre' es requerido!");
            }

            if (lastName == null || lastName.isBlank() == true || lastName.isEmpty() == true) {
                errores.add("El campo 'Apellidos' es requerido!");
            }

            if (userName == null || userName.isBlank() == true || userName.isEmpty() == true) {
                errores.add("El campo 'Nombre de usuario' es requerido!");
            }

            if (email == null || email.contains("@") == false || email.isBlank() == true || email.isEmpty() == true) {
                errores.add("El campo 'Correo electrónico' es requerido y debe tener un formato de correo.");
            }

            if (password == null || password.isBlank() == true || password.isEmpty() == true) {
                errores.add("El campo 'Contraseña' es requerido!");
            }

            if (country == null || country.isEmpty() == true || country.isBlank() == true) {
                errores.add("El campo 'País' es requerido!");
            }

            if (programmingLanguages == null || programmingLanguages.length == 0) {
                errores.add("Debe seleccionar al menos un lenguaje de programación");
            }

            if (roles == null || roles.length == 0) {
                errores.add("Debe seleccionar al menos un rol!");
            }

            if (language == null) {
                errores.add("Debe seleccionar un idioma!");
            }

            if (errores.isEmpty() == false) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print("{\"message\": \"Ocurrió uno o varios errores en la validación de los datos\", \"errores\":" + gson.toJson(errores) + "}");
            } else {

                User user = new User(name, lastName, email, password);
                user.setUserName(userName);
                user.setCountry(country);
                user.setProgrammingLanguages(programmingLanguages);
                user.setRoles(roles);
                user.setLanguage(language);
                cnt.users.add(user);

                resp.setStatus(HttpServletResponse.SC_CREATED);
                out.print(gson.toJson("El usuario se creó correctamente"));
            }

        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson(ex.getMessage()));
        } finally {
            out.flush();
            out.close();
        }
    }
}