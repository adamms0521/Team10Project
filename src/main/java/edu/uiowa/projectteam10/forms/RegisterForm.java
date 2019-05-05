package edu.uiowa.projectteam10.forms;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

//registration form
public class RegisterForm {

    @NotBlank(message = "Need a Name")
    private String name;
    @NotBlank(message = "Need a UserName")
    private String userName;
    @NotBlank(message = "Enter a Password")
    private String password;

    @NotBlank(message = "Re-enter a Password")
    private String reenterpassword;
    private String role;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReenterpassword(String reenterpassword) {
        this.reenterpassword = reenterpassword;
    }

    public String getReenterpassword() {
        return reenterpassword;
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
