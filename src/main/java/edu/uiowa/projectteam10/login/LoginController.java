package edu.uiowa.projectteam10.login;

import javax.validation.Valid;

import edu.uiowa.projectteam10.model.User;
//import edu.uiowa.projectteam10.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class LoginController extends WebMvcConfigurerAdapter {
   // @Autowired
   // UserRepository repo;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");

    }
    @GetMapping("/")
    public String homePage(){return "homePage";}

    @GetMapping("/login")
    public String showForm(LoginForm loginForm) {
        return "login";
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
    public String register() {
        return "registration";
    }

    @PostMapping("/registration")
    public void addUser() {
        User user = new User("user", "user@mail.com", "password");
      //  repo.save(user);
    }
}