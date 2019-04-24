package edu.uiowa.projectteam10.services;


import edu.uiowa.projectteam10.forms.LoginForm;
import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.User;

public interface UserService {

    User save(User user);

    User saveForm(RegisterForm registerForm);

    boolean userExistsPasswordCorrect(LoginForm loginForm);

    boolean userExists(RegisterForm registerForm);

    boolean passwordsMatch(String password, String reenterpassword);


    String getRoleFromUserName(LoginForm loginForm);

    Integer getRideIdFromUser(String userName);

    void setCurrentUser(User user);

    User getCurrentUser();

    User getUser(LoginForm loginForm);

    String getRole(String userName);

    void assignRideToUser(Integer id, String name);

    void deleteRideFromUser(String username, Integer RideID);

    boolean checkIfNameAndUserNameCorrect(String username, String name);

    void updatePassword(String username, String password);
}
