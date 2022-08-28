package ServletsDB.Business;

import ServletsDB.Models.ErrorKeyValuePair;
import ServletsDB.Models.ServletResponse;
import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import jakarta.jws.soap.SOAPBinding;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserBusiness {

    private StaticContext context;

    public UserBusiness(StaticContext context) {
        this.context = context;
    }

    public ServletResponse<List<User>> getUsers(String searchCriteria) {
        try {
            var result = context.users.stream().filter(usr -> (usr.getName() + usr.getLastName() + usr.getUserID() + usr.getUserName() + usr.getEmail()).toLowerCase().contains(searchCriteria.toLowerCase())).toList();

            if (result.isEmpty() == true) {
                return new ServletResponse<List<User>>("No se encontraron coincidencias con el parámetro de búsqueda proporcionado", null, HttpServletResponse.SC_OK);
            }

            return new ServletResponse<List<User>>("Se encontraron " + result.size() + " coincidencias", result, HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            return new ServletResponse<List<User>>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    public ServletResponse<User> saveUser(User userSave) {
        ServletResponse<User> response = new ServletResponse<>();

        try {
            if (userSave.getName() == null || userSave.getName().isBlank() == true || userSave.getName().isEmpty() == true) {
                response.getErrors().add(new ErrorKeyValuePair("name", "El campo 'Nombre' es requerido!"));
            }

            if (userSave.getLastName() == null || userSave.getLastName().isBlank() == true || userSave.getLastName().isEmpty() == true) {
                response.getErrors().add(new ErrorKeyValuePair("lastName", "El campo 'Apellidos' es requerido!"));
            }

            if (userSave.getUserName() == null || userSave.getUserName().isBlank() == true || userSave.getUserName().isEmpty() == true) {
                response.getErrors().add(new ErrorKeyValuePair("userName", "El campo 'Nombre de usuario' es requerido!"));
            }

            if (userSave.getEmail() == null || userSave.getEmail().contains("@") == false || userSave.getEmail().isBlank() == true || userSave.getEmail().isEmpty() == true) {
                response.getErrors().add(new ErrorKeyValuePair("email", "El campo 'Correo electrónico' es requerido y debe tener un formato de correo."));
            }

            if (userSave.getPassword() == null || userSave.getPassword().isBlank() == true || userSave.getPassword().isEmpty() == true) {
                response.getErrors().add(new ErrorKeyValuePair("password", "El campo 'Contraseña' es requerido!"));
            }

            if (userSave.getCountry() == null || userSave.getCountry().isEmpty() == true || userSave.getCountry().isBlank() == true) {
                response.getErrors().add(new ErrorKeyValuePair("country", "El campo 'País' es requerido!"));
            }

            if (userSave.getProgrammingLanguages() == null || userSave.getProgrammingLanguages().length == 0) {
                response.getErrors().add(new ErrorKeyValuePair("programmingLanguages", "Debe seleccionar al menos un lenguaje de programación!"));
            }

            if (userSave.getRoles() == null || userSave.getRoles().length == 0) {
                response.getErrors().add(new ErrorKeyValuePair("roles", "Debe seleccionar al menos un rol!"));
            }

            if (userSave.getLanguage() == null) {
                response.getErrors().add(new ErrorKeyValuePair("language", "Debe seleccionar un idioma!"));
            }

            if (response.getErrors().size() > 0) {
                response.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
                response.setMessage("Ocurrió uno o varios errores en la validación de los datos!");
                response.setContent(null);
                return response;
            } else {
                if (context.users.contains(userSave) == true) {
                    context.users.remove(userSave);
                    context.users.add(userSave);

                    response.setContent(userSave);
                    response.setMessage("El usuario se creó correctamente");
                    response.setStatusCode(HttpServletResponse.SC_OK);
                } else {
                    context.users.add(userSave);
                    response.setContent(userSave);
                    response.setMessage("El usuario se creó correctamente");
                    response.setStatusCode(HttpServletResponse.SC_CREATED);
                }
            }
        } catch (Exception ex) {
            response.setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setMessage(ex.getMessage());
            response.setContent(null);
        }

        return response;
    }

    public ServletResponse<User> deleteUser(String userIDString) {
        try {
            if (userIDString == null || userIDString.isEmpty() == true || userIDString.isBlank() == true) {
                return new ServletResponse<User>("Proporcione un ID de usuario válido. No puede ser nulo ni estar vacío.", null, HttpServletResponse.SC_OK);
            }

            int userID = Integer.parseInt(userIDString);
            var result = context.users.stream().filter(usr -> usr.getUserID() == userID).toList();

            if (result.isEmpty() == true) {
                return new ServletResponse<User>("No se encontraron coincidencias con los parámetros de búsqueda proporcionados", null, HttpServletResponse.SC_OK);
            } else {
                User userDelete = result.stream().findFirst().get();
                context.users.remove(userDelete);
                return new ServletResponse<User>("El usuario con ID " + userID + " se eliminó correctamente", userDelete, HttpServletResponse.SC_OK);
            }

        } catch (Exception ex) {
            return new ServletResponse<User>(ex.getMessage(), null, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}