package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.LoginForm;
import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RidesService ridesService;
    private RouteService routeService;
    private User currentUser;

    @Lazy
    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, RidesService ridesService, RouteService routeService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.ridesService = ridesService;
        this.routeService = routeService;
    }

    public boolean userExistsPasswordCorrect(LoginForm loginForm){
        String encrypted = userRepository.findPasswordbyName(loginForm.getuserName());
        if(userRepository.exists(loginForm.getuserName())) {
            if(passwordEncoder.matches(loginForm.getPassword(), encrypted)){
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
    public boolean passwordsMatch(String password, String reenterpassword) {
        if(password.equals(reenterpassword)){
            return true;
        }
        return false;
    }

    @Override
    public String getRoleFromUserName(LoginForm loginForm) {
       return userRepository.findRolebyName(loginForm.getuserName());
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
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        user.setRole(registerForm.getRole());
        save(user);
        return user;
    }
    @Override
    public void setCurrentUser(User user){
        currentUser = user;
    }
    @Override
    public User getCurrentUser(){
        return currentUser;
    }

    @Override
    public User getUser(LoginForm loginForm) {
        User user = new User();
        user.setUserName(loginForm.getuserName());
        user.setPassword(passwordEncoder.encode(loginForm.getPassword()));
        return user;
    }

    @Override
    public String getRole(String userName) {
        return userRepository.findRolebyName(userName);
    }

    @Override
    public void assignRideToUser(Integer id, String name) {
        userRepository.assignUsertoRide(id, name);
    }


    @Override
    public Integer getRideIdFromUser(String userName){
        return userRepository.findRideIDbyName(userName);
    }

    @Override
    public void deleteRideFromUser(String username, Integer rideID){
        userRepository.deleteRideFromUser(username);
    }

    @Override
    public boolean checkIfNameAndUserNameCorrect(String username, String name) {
        if(userRepository.exists(username) && userRepository.getNameByUserName(username).equals(name)){
            return true;
        }
        return false;
    }

    @Override
    public void updatePassword(String username, String password) {
        userRepository.updatePassword(username, passwordEncoder.encode(password));
    }
}


