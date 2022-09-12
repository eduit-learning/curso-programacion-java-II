package Servlets.Repository;

import Servlets.Models.User;

import java.util.ArrayList;

public class Context {
    public ArrayList<User> users;

    public Context() {
        this.users = new ArrayList<>();
        this.setUsers();
    }

    private void setUsers() {
        this.users.add(new User("Pedro", "Pérez Penas", "pedro@hotmail.com", "Admin123"));
        this.users.add(new User("Hugo", "Pérez Penas", "hugo@hotmail.com", "Admin123"));
        this.users.add(new User("Paco", "Pérez Penas", "paco@hotmail.com", "Admin123"));
        this.users.add(new User("Luis", "Pérez Penas", "luis@hotmail.com", "Admin123"));
    }
}
