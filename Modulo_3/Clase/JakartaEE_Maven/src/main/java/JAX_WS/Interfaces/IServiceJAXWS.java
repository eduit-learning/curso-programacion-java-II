package JAX_WS.Interfaces;

import ServletsDB.Models.User;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService
public interface IServiceJAXWS {
    String grettings(String name);

    ArrayList<User> getUsers();
}
