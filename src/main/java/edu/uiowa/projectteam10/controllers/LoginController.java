package edu.uiowa.projectteam10.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class LoginController{
    @Autowired
    private UserService userService;


    @RequestMapping({"/", "/homePage"})
    public String homePage(){return "homePage";}

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        String role = (String) session.getAttribute("ROLE");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login";
        }
        if(!userService.userExistsPasswordCorrect(loginForm)){
            return "login";
        }
        String role = (String) request.getAttribute("ROLE");
        request.getSession().setAttribute("ROLE", role);
        String userRole = userService.getRoleFromUserName(loginForm);
        userService.setCurrentUser(userService.getUser(loginForm));
        if(userRole.equals("Passenger")){
            return "redirect:/passenger";
        } else if(userRole.equals("Driver")){
            return "redirect:/driver";
        } else if(userRole.equals("Admin")){
            return "redirect:/admin";
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
        User currentUser = userService.saveForm(registerForm);
        userService.setCurrentUser(currentUser);
        return "home";
    }

    @GetMapping("/home")
    public String goHome(Model model, Principal principal){
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        System.out.println(loginedUser);
        return "home";
    }


}