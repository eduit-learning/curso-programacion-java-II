package JAX_WS.Interfaces;

import ServletsDB.Models.User;
import jakarta.jws.WebService;

import java.util.ArrayList;
/*Servicio SOAP Simple Object Access Protocol*/
@WebService
public interface IServiceJAXWS {
    String grettings(String name);

    ArrayList<User> getUsers();
}
