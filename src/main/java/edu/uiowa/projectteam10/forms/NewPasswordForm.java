package edu.uiowa.projectteam10.forms;

import org.hibernate.validator.constraints.NotBlank;

public class NewPasswordForm {
    @NotBlank
    private String password;

    @NotBlank
    private String reenterpassword;

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
}
