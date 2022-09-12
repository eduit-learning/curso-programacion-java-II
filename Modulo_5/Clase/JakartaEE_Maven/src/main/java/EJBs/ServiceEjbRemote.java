package EJBs;

import EJBs.Interfaces.IServiceEjbRemote;
import ServletsDB.Models.User;
import ServletsDB.Repository.StaticContext;
import jakarta.ejb.Stateless;

import java.util.ArrayList;

@Stateless
public class ServiceEjbRemote implements IServiceEjbRemote {
    private StaticContext st = new StaticContext();
    @Override
    public ArrayList<User> getUsers() {
        return st.users;
    }

    @Override
    public boolean createUser(User newUser) {
        st.users.add(newUser);
        return true;
    }
}