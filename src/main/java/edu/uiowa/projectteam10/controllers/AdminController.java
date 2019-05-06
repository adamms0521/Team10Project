package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.forms.CreateRouteForm;
import edu.uiowa.projectteam10.forms.RegisterForm;
import edu.uiowa.projectteam10.model.Route;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.RouteService;
import edu.uiowa.projectteam10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController extends WebMvcConfigurerAdapter {
    @Autowired
    private RidesService ridesService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin");
    }
    //return admin page if user is Admin
    @GetMapping("/admin")
    public String adminPage(){
        if(!checkAccess()){
            return "redirect:/login";
        }
        return "admin";
    }

    //return login page if user is not Admin, return createride page
    @GetMapping("/admin/createride")
    public String createRide(Model model){
        if(!checkAccess()){
            return "redirect:/login";
        }
        model.addAttribute("createRideForm", new CreateRideForm());
        List<Route> availableRoutes = this.routeService.getRoutes();
        model.addAttribute("availableRoutes", availableRoutes);
        return "createride";
    }

    //getting ride form
    @PostMapping("/admin/createride")
    public String postCreateRide(CreateRideForm rideForm, @RequestParam("Selection") String routeName, BindingResult bindingResult){
        rideForm.setRouteName(routeName);
        if(bindingResult.hasErrors()){
            return "createride";
        }
        ridesService.saveForm(rideForm);
        ridesService.setPrice(routeName);
        return "redirect:/admin";
    }

    //return login page if user is not Admin, return createroute page
    @GetMapping("/admin/createroute")
    private String createRoute(Model model){
        if(!checkAccess()){
            return "redirect:/login";
        }
        model.addAttribute("createRouteForm", new CreateRouteForm());
        return "createroute";
    }

    //getting route form
    @PostMapping("/admin/createroute")
    public String postCreateRoute(@Valid CreateRouteForm routeForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createroute";
        }
        routeService.saveForm(routeForm);
        return "redirect:/admin";
    }

    //return login page if user is not Admin, return createAdmin page
    @GetMapping("/admin/createAdmin")
    public String createAdmin(Model model){
        if(!checkAccess()){
            //return "redirect:/login";
        }
        model.addAttribute("registrationForm", new RegisterForm());
        return "createAdmin";
    }

    //getting admin form
    @PostMapping("/admin/createAdmin")
    public String postCreateAdmin(@Valid RegisterForm registerForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //return "createAdmin";
        }
        userService.saveForm(registerForm);
        return "redirect:/admin";
    }
    //check if currentUser is Admin, return False if not Admin
    private boolean checkAccess(){
        try {
            String currentUser = userService.getCurrentUser().getUserName();
            if (userService.getRole(currentUser).equals("Admin")) {
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }
}
