package edu.uiowa.projectteam10.converter;

import edu.uiowa.projectteam10.login.RegisterForm;
import edu.uiowa.projectteam10.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RegisterFormtoUser implements Converter<RegisterForm, User> {

    @Override
    public User convert(RegisterForm registerForm) {
        User user = new User();
        user.setName(registerForm.getUserName());
        user.setPassword(registerForm.getPassword());
        user.setRole(registerForm.getRole());
        return user;
    }
}