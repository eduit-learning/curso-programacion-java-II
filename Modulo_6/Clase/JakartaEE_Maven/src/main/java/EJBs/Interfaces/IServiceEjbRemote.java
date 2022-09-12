package EJBs.Interfaces;

import ServletsDB.Models.User;
import jakarta.ejb.Remote;

import java.util.ArrayList;

@Remote
public interface IServiceEjbRemote {
    ArrayList<User> getUsers();

    boolean createUser(User newUser);
}
