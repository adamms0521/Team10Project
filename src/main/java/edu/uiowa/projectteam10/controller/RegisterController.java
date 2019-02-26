package edu.uiowa.projectteam10.controller;

import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

}
