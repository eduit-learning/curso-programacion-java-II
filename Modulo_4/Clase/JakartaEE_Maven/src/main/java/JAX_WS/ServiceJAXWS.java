package JAX_WS;

import JAX_WS.Interfaces.IServiceJAXWS;
import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService(endpointInterface = "JAX_WS.Interfaces.IServiceJAXWS")
public class ServiceJAXWS implements IServiceJAXWS {
    @Override
    @WebMethod
    public String grettings(String name) {
        return "Hola " + name + " desde ServiceJAXWS";
    }

    @Override
    @WebMethod
    public ArrayList<User> getUsers() {
        return new StaticContext().users;
    }
}
