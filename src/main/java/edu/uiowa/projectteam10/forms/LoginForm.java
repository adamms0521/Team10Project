package edu.uiowa.projectteam10.forms;

import org.hibernate.validator.constraints.NotBlank;


public class LoginForm {
    @NotBlank(message = "Enter a UserName")
    private String userName;

    @NotBlank(message = "Enter a Password")
    private String password;

    public String getuserName() {
        return this.userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "LoginForm(UserName: " + this.userName + ", Password: " + this.password + ")";
    }
}
