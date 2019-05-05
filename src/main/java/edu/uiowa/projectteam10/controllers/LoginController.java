package edu.uiowa.projectteam10.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import edu.uiowa.projectteam10.forms.ForgotPasswordForm;
import edu.uiowa.projectteam10.forms.LoginForm;
import edu.uiowa.projectteam10.forms.NewPasswordForm;
import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.User;
import edu.uiowa.projectteam10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@Controller
public class LoginController{
    @Autowired
    private UserService userService;
    private String currentUserName;

    //set current user
    @RequestMapping({"/", "/homePage"})
    public String homePage(){
        userService.setCurrentUser(null);
        currentUserName = null;
        return "homePage";}
    //login
    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        return "login";
    }

    //login as specific role, or return to home
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

    //return registration page
    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "registration";
    }

    //save registration info
    @PostMapping("/registration")
    public String addUser(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors() || userService.userExists(registerForm) || !userService.passwordsMatch(registerForm.getPassword(),registerForm.getReenterpassword())){
            return "registration";
        }
        User currentUser = userService.saveForm(registerForm);
        userService.setCurrentUser(currentUser);
        return "home";
    }

    //return home
    @GetMapping("/home")
    public String goHome(Model model, Principal principal){
        return "home";
    }

    //return forgotpassword page
    @GetMapping("/forgotpassword")
    public String forgotPassword(Model model){
        model.addAttribute("forgotPassword", new ForgotPasswordForm());
        return "forgotpassword";
    }

    //forgot password
    @PostMapping("/forgotpassword")
    public String postPassword(@Valid ForgotPasswordForm forgotPasswordForm, BindingResult bindingResult){
        if(bindingResult.hasErrors() || !userService.checkIfNameAndUserNameCorrect(forgotPasswordForm.getUsername(),forgotPasswordForm.getName())){
            return "forgotpassword";
        }
        currentUserName = forgotPasswordForm.getUsername();
        return "newpassword";
    }

    //new password
    @GetMapping("/newpassword")
    public void newPassword(Model model){
        model.addAttribute("newpassword", new NewPasswordForm());
    }
    @PostMapping("/newpassword")
    public String postNewPassword(@Valid NewPasswordForm newPasswordForm, BindingResult bindingResult){
        if(bindingResult.hasErrors() || !userService.passwordsMatch(newPasswordForm.getPassword(), newPasswordForm.getReenterpassword())){
            return "newpassword";
        }
        userService.updatePassword(currentUserName, newPasswordForm.getPassword());
        return "homePage";
    }

}