package edu.uiowa.projectteam10.login;

import javax.naming.Binding;
import javax.validation.Valid;

import edu.uiowa.projectteam10.Services.UserService;
import edu.uiowa.projectteam10.converter.UsertoRegisterForm;
import edu.uiowa.projectteam10.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class LoginController extends WebMvcConfigurerAdapter {

    private UserService userService;
    private UsertoRegisterForm usertoRegisterForm;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserToRegisterForm(UsertoRegisterForm usertoRegisterForm) {
        this.usertoRegisterForm = usertoRegisterForm;
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
    }

    @RequestMapping({"/", "/homePage"})
    public String homePage(){return "homePage";}

    @GetMapping("/login")
    public String showForm(LoginForm loginForm) {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login";
        }
        return "home";
    }

    @PostMapping("/")
    public String validateLoginInfo(Model model, @Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", loginForm.getuserName());
        return "home";
    }

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Model model, @Valid RegisterForm registerForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "registration";
        }
        User newUser = userService.saveForm(registerForm);
        return "home";
    }

    @GetMapping("/error")
    public String error(){
        return "homePage";
    }
}