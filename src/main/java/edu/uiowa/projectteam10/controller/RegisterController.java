package edu.uiowa.projectteam10.controller;

import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("login", new User());
        return "login.html";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute User user) {
        return "result.html";
    }
}
