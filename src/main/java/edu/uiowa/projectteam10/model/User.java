package edu.uiowa.projectteam10.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name = "user")
public class User {

    @Id
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}