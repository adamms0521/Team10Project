package edu.uiowa.projectteam10.login;


import javax.validation.constraints.NotNull;

public class RegisterForm {
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String reenterpassword;
    @NotNull
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

    public String getReenterpassword() {
        return reenterpassword;
    }

    public void setReenterpassword(String reenterpassword) {
        this.reenterpassword = reenterpassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
