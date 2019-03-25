package edu.uiowa.projectteam10.login;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String userName;

    @NotNull
    @Min(5)
    private String password;

    @NotNull
    @Min(5)
    private String reenterpassword;

    @NotNull
    private String email;

    @NotNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    @NotNull
    public String getReenterpassword() {
        return reenterpassword;
    }

    public void setReenterpassword(@NotNull String reenterpassword) {
        this.reenterpassword = reenterpassword;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }
}
