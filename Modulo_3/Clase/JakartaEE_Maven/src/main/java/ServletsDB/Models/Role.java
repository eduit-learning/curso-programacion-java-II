package ServletsDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`Role`")
public class Role {
    @Id
    @Column(name = "roleID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonIgnoreProperties({"role", "handler", "hibernateLazyInitializer"})
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<UserDB> users;

    public Role() {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //public List<UserDB> getUsers() {
        //return users;
    //}

    //public void setUsers(List<UserDB> users) {
        //this.users = users;
    //}
}