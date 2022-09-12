package ServletsDB.Repository;

import ServletsDB.Models.User;

import java.util.ArrayList;
import java.util.Random;

public class StaticContext {
    public ArrayList<User> users;
    private Random rnd = new Random();

    public StaticContext() {
        this.users = new ArrayList<>();
        this.setUsers();
    }

    private void setUsers() {
        this.users.add(new User(rnd.nextInt(1, 999999999), "Pedro", "Pérez Penas", "pedro@hotmail.com", "Admin123"));
        this.users.add(new User(rnd.nextInt(1, 999999999), "Hugo", "Pérez Penas", "hugo@hotmail.com", "Admin123"));
        this.users.add(new User(rnd.nextInt(1, 999999999), "Paco", "Pérez Penas", "paco@hotmail.com", "Admin123"));
        this.users.add(new User(rnd.nextInt(1, 999999999), "Luis", "Pérez Penas", "luis@hotmail.com", "Admin123"));
    }
}
