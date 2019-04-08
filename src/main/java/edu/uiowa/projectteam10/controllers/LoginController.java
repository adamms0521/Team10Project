package edu.uiowa.projectteam10.controllers;

import javax.validation.Valid;

import edu.uiowa.projectteam10.forms.LoginForm;
import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.Ride;
import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.RouteService;
import edu.uiowa.projectteam10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Controller
public class LoginController extends WebMvcConfigurerAdapter {
    @Autowired
    private UserService userService;
    private User currentUser;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
    }

    @RequestMapping({"/", "/homePage"})
    public String homePage(){return "homePage";}

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors() || !userService.userExistsPasswordCorrect(loginForm)){
            return "login";
        }
        return "home";
    }

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors() || userService.userExists(registerForm) || !userService.passwordsMatch(registerForm)){
            return "registration";
        }
        currentUser = userService.saveForm(registerForm);
        return "home";
    }

    @GetMapping("/home")
    public String goHome(Model model, Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        System.out.println(loginedUser);
        return "home";
    }


}