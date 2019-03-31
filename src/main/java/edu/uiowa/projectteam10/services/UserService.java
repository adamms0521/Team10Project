package edu.uiowa.projectteam10.services;


import edu.uiowa.projectteam10.forms.LoginForm;
import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.User;


public interface UserService {

    User save(User user);


    User saveForm(RegisterForm registerForm);

    boolean userExistsPasswordCorrect(LoginForm loginForm);

    boolean userExists(RegisterForm registerForm);

    boolean passwordsMatch(RegisterForm registerForm);

}
