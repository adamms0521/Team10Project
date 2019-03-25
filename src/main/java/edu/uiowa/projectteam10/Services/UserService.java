package edu.uiowa.projectteam10.Services;


import edu.uiowa.projectteam10.login.RegisterForm;
import edu.uiowa.projectteam10.model.User;


public interface UserService {

    User save(User user);


    User saveForm(RegisterForm registerForm);
}
