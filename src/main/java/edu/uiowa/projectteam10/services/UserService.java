package edu.uiowa.projectteam10.services;


import edu.uiowa.projectteam10.login.LoginForm;
import edu.uiowa.projectteam10.login.RegisterForm;
import edu.uiowa.projectteam10.model.User;


public interface UserService {

    User save(User user);


    User saveForm(RegisterForm registerForm);

    boolean userExistsPasswordCorrect(LoginForm loginForm);

    boolean userExists(RegisterForm registerForm);

    boolean passwordsMatch(RegisterForm registerForm);

}
