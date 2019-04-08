package edu.uiowa.projectteam10.controllers;

import edu.uiowa.projectteam10.forms.CreateRideForm;
import edu.uiowa.projectteam10.forms.CreateRouteForm;
import edu.uiowa.projectteam10.services.RidesService;
import edu.uiowa.projectteam10.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class AdminController extends WebMvcConfigurerAdapter {
    @Autowired
    private RidesService ridesService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/admin")
    public String adminPage(){return "admin"; }

    @GetMapping("/createride")
    public String createRide(Model model){
        model.addAttribute("createRideForm", new CreateRideForm());
        return "createride";
    }

    @PostMapping("/createride")
    public String postCreateRide(@Valid CreateRideForm rideForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createride";
        }
        ridesService.saveForm(rideForm);
        return "admin";
    }

    @GetMapping("/createroute")
    private String createRoute(Model model){
        model.addAttribute("createRouteForm", new CreateRouteForm());
        return "createroute";
    }

    @PostMapping("/createroute")
    public String postCreateRoute(@Valid CreateRouteForm routeForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createroute";
        }
        routeService.saveForm(routeForm);
        return "admin";
    }
}
