package edu.uiowa.projectteam10.model;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.security.Principal;


@Entity(name = "user")
public class

User {

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

    public String user(Model model, Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("username", name);
        return "user";
    }
}