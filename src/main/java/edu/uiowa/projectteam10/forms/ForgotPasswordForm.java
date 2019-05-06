package edu.uiowa.projectteam10.forms;

import org.hibernate.validator.constraints.NotBlank;

//forgor password form
public class ForgotPasswordForm {
    @NotBlank
    private String name;

    @NotBlank
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
