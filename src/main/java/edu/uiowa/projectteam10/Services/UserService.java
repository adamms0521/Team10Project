package edu.uiowa.projectteam10.Services;


import edu.uiowa.projectteam10.login.RegisterForm;
import edu.uiowa.projectteam10.model.User;

import java.util.List;

public interface UserService {
    List<User> listAll();

    User getById(Long id);

    User saveOrUpdate(User user);

    void delete(Long id);

    User saveOrUpdateProductForm(RegisterForm registerForm);
}
