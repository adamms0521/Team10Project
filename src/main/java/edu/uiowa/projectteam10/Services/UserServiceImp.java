package edu.uiowa.projectteam10.Services;

import edu.uiowa.projectteam10.converter.RegisterFormtoUser;
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


    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }


    @Override
    public User saveForm(RegisterForm RegisterForm) {
        User savedUser = save(registerFormToUser.convert(RegisterForm));

        System.out.println("Saved User Id: " + savedUser.getName());
        return savedUser;
    }
}


