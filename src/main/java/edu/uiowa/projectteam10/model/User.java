package edu.uiowa.projectteam10.model;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.Date;

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

    private Integer ride_id;

    private Date ride_date;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;

    }
    public User(){}
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

    public Integer getRide_id() {
        return ride_id;
    }

    public void setRide_id(Integer ride_id) {
        this.ride_id = ride_id;
    }

    public Date getRideDate() {
        return ride_date;
    }

    public void setRideDate(Date rideDate) {
        this.ride_date = rideDate;
    }

    public String user(Model model, Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("username", name);
        return "user";
    }
}