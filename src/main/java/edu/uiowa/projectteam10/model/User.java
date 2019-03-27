package edu.uiowa.projectteam10.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name = "user")
public class User {

    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String role;

    @NotNull
    private String name;

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}