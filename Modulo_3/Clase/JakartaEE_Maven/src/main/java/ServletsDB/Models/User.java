package ServletsDB.Models;

import java.io.Serializable;

public class User implements Serializable {

    static final long serialVersionUID = 420989823979842L;
    private int userID;
    private String name;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String country;
    private String[] programmingLanguages;
    private String[] roles;
    private String language;

    public User() {

    }

    public User(int userID, String name, String lastName, String email, String password) {
        this.setUserID(userID);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.setPassword(password);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass().equals(this.getClass()) == false) {
            return false;
        }

        if (((User) obj).getUserID() == this.getUserID()) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.getUserID();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}