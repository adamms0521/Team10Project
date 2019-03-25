package edu.uiowa.projectteam10.converter;

import edu.uiowa.projectteam10.login.RegisterForm;
import edu.uiowa.projectteam10.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsertoRegisterForm implements Converter<User, RegisterForm> {
    @Override
    public RegisterForm convert(User user) {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setUserName(user.getName());
        registerForm.setPassword(user.getPassword());
        registerForm.setRole(user.getRole());
        return registerForm;
    }
}
