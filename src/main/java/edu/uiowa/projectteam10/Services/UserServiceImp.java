package edu.uiowa.projectteam10.Services;

import edu.uiowa.projectteam10.converter.RegisterFormtoUser;
import edu.uiowa.projectteam10.login.LoginForm;
import edu.uiowa.projectteam10.login.RegisterForm;
import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private RegisterFormtoUser registerFormToUser;


    @Autowired
    public UserServiceImp(UserRepository userRepository, RegisterFormtoUser registerFormtoUser) {
        this.userRepository = userRepository;
        this.registerFormToUser = registerFormtoUser;
    }

    public boolean userExistsPasswordCorrect(LoginForm loginForm){
        if(loginForm.getPassword().equals(userRepository.findPasswordbyName(loginForm.getuserName())) && userRepository.exists(loginForm.getuserName())){
            return true;
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
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User saveForm(RegisterForm registerForm) {
        User savedUser = save(registerFormToUser.convert(registerForm));
        System.out.println("Saved User Id: " + savedUser.getName());
        return savedUser;
    }
}


