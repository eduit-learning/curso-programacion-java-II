package ServletsDB.Business;

import ServletsDB.Models.ErrorKeyValuePair;
import ServletsDB.Models.ServletResponse;
import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.List;

public class LoginBusiness {

    public static final String COOKIE_LOGIN_NAME = "userEmail";
    public static final String COOKIE_USER_NAME = "userName";
    private StaticContext context;

    public LoginBusiness(StaticContext context) {
        this.context = context;
    }

    public ServletResponse<Boolean> Login(User userLogin, HttpServletResponse resp, Cookie[] cookies) {
        ServletResponse<Boolean> response = new ServletResponse<>();

        try {
            if (cookies != null && cookies.length > 0 && Arrays.stream(cookies).anyMatch(c -> c.getName().equals(COOKIE_LOGIN_NAME) == true)) {
                return new ServletResponse<Boolean>("Bienvenido de nuevo " + Arrays.stream(cookies).filter(c -> c.getName().equals(COOKIE_USER_NAME)).map(Cookie::getValue).findFirst().get(), false, HttpServletResponse.SC_OK);
            }

            if (userLogin.getEmail() == null || userLogin.getEmail().contains("@") == false || userLogin.getEmail().isBlank() == true || userLogin.getEmail().isEmpty() == true) {
                response.getErrors().add(new ErrorKeyValuePair("email", "El campo 'Correo electrónico' es requerido y debe tener un formato de correo."));
            }

            if (userLogin.getPassword() == null || userLogin.getPassword().isBlank() == true || userLogin.getPassword().isEmpty() == true) {
                response.getErrors().add(new ErrorKeyValuePair("password", "El campo 'Contraseña' es requerido!"));
            }

            if (response.getErrors().size() > 0) {
                response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
                response.setMessage("Ocurrió uno o varios errores en la validación de los datos!");
                response.setContent(false);
                return response;
            }

            var result = context.users.stream().filter(usr -> (usr.getEmail().equals(userLogin.getUserName()) || userLogin.getEmail().equals(userLogin.getEmail())) && userLogin.getPassword().equals("Admin123")).toList();
            if (result.isEmpty() == true) {
                return new ServletResponse<Boolean>("El nombre de usuario y/o contraseña no son válidos", false, HttpServletResponse.SC_UNAUTHORIZED);
            }

            User user = result.stream().findFirst().get();
            Cookie loginCookie = new Cookie(COOKIE_LOGIN_NAME, user.getEmail());
            /*
                La siguiente línea indica el tiempo de vida de una cookie, si no se manda a llamar al método la cookie es permanente
                Si se pone 0 expira inmediatamanete y se elimina de forma automática
                El parámetro se indica siempre en segundos
            */
            loginCookie.setMaxAge(10800);//Espira en 1 hora
            resp.addCookie(loginCookie);

            loginCookie = new Cookie(COOKIE_USER_NAME, user.getName());
            loginCookie.setMaxAge(10800);//Espira en 1 hora
            resp.addCookie(loginCookie);

            return new ServletResponse<Boolean>("Bienvenido " + user.getName() + " " + user.getLastName(), true, HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            return new ServletResponse<Boolean>(ex.getMessage(), false, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
