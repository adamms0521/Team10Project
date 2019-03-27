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
        registerForm.setName(user.getName());
        registerForm.setUserName(user.getUserName());
        registerForm.setPassword(user.getPassword());
        registerForm.setRole(user.getRole());
        return registerForm;
    }
}
