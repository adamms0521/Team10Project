package edu.uiowa.projectteam10.converter;

import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterFormtoUser implements Converter<RegisterForm, User> {
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User convert(RegisterForm registerForm) {
        User user = new User();
        user.setName(registerForm.getName());
        user.setUserName(registerForm.getUserName());
      //  user.setPassword(registerForm.getPassword());
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        user.setRole(registerForm.getRole());
        return user;
    }
}