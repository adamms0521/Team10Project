package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.converter.RegisterFormtoUser;
import edu.uiowa.projectteam10.forms.LoginForm;
import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RegisterFormtoUser registerFormToUser;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RegisterFormtoUser registerFormtoUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.registerFormToUser = registerFormtoUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean userExistsPasswordCorrect(LoginForm loginForm){
        if(userRepository.exists(loginForm.getuserName())) {
            if(passwordEncoder.matches(loginForm.getPassword(), userRepository.findPasswordbyName(loginForm.getuserName()))){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean userExists(RegisterForm registerForm) {
        if(userRepository.exists(registerForm.getUserName())){
            return true;
        }
        return false;
    }

    @Override
    public boolean passwordsMatch(RegisterForm registerForm) {
        if(registerForm.getPassword().equals(registerForm.getReenterpassword())){
            return true;
        }
        return false;
    }

    @Override
    public String getName(User user) {
        return user.getName();
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User saveForm(RegisterForm registerForm) {
        User user = new User();
        user.setName(registerForm.getName());
        user.setUserName(registerForm.getUserName());
        //  user.setPassword(registerForm.getPassword());
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        user.setRole(registerForm.getRole());
        save(user);
        return user;
    }
}


