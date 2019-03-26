package edu.uiowa.projectteam10.login;


import org.hibernate.validator.constraints.NotBlank;


public class RegisterForm {
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
